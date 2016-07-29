package com.stone.common.model.datamodifier;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.PersistentIdentifierGenerator;
import org.hibernate.id.SequenceGenerator;
import org.hibernate.type.Type;

import com.stone.util.StringUtil;


/**
 * Hibernate high performence id generator extend IncrementGenerator.<br>
 * This generator use ’select max(column) from table ’ to get id’s init value in
 * first time.Then generate increment id in memory .
 * <p>
 * 原理:
 * <li>使用long[]数组在内存中存储每个表的最大值，使用Map存储表名在数组中对应的索引值。
 * <li>第一次访问某个表的id的最大值时会从数据库中取出并存放到long数组中， 同时在Map中保存索引值
 * <li>第二次以后访问会首先从Map中读出索引值，根据索引值把long数组对应的值 加上递增步长并返回
 * </p>
 * 
 * @author fenghm
 * @version $Revision$
 */
public final class AssignedSequenceGenerator extends SequenceGenerator
		implements PersistentIdentifierGenerator, Configurable {

	private static final Log log = LogFactory.getLog(AssignedSequenceGenerator.class); 
    
    //存储最大值的数组的容量 
    private static final int MAX_CAPACITY = 200; 
     
    /**同步锁*/ 
    private static final Object lock = new Object(); 

    //存储表存储在数组中的索引值 
    private static Map map = new HashMap(); 
     
    //递增步长，默认加1 
    private int step = 1; 
     
    //最大值数组 
    private static long[] seqs = new long[MAX_CAPACITY]; 
     
    //最大值数组已经使用的容量 
    private static int lastIndex; 
     
    private String key; 
    private String sql; 
    private Connection connection; 
    private Class returnClass; 
     
    /** 
     * (none java doc) 
     * @see net.sf.hibernate.id.IdentifierGenerator# 
     * generate(net.sf.hibernate.engine.SessionImplementor, java.lang.Object) 
     */ 
    public Serializable generate(SessionImplementor session, Object object) { 
        connection = session.connection(); 
         
        long seq = -1; 
         
        //找到索引值 
        int index = findIndex(); 
         
        //把最大值加1 
        seqs[index] = seqs[index] + step; 
         
        seq = seqs[index]; 
        
        String retVal = String.valueOf(seq);
        // 前端用0补齐,使用8位整型表示
        while (retVal.length() < 6)
        {
        	retVal = "0" + retVal;     		
        }
        return retVal; 
    } 

    /** 
     * 找到表中自动增长字段存储在数组中的索引值 
     * @return 索引值 
     */ 
    private int findIndex(){ 
        int index = 0; 
         
        //首先中缓存中取出索引值 
        Integer integer = (Integer)map.get(key); 
         
        //如果没有找到就从数据库中读出最大值并进行cache 
        if(null == integer){ 
            //double check lock 
            synchronized(lock){ 
                integer = (Integer)map.get(key); 
                if(null == integer){ 
                    long maxvalue = 1; 
                    try{ 
                        maxvalue = getMaxvalue(); 
                    }catch(SQLException e){ 
                        log.error(e); 
                    } 
                    integer = new Integer(lastIndex++); 
                    seqs[integer.intValue()] = maxvalue; 
                    map.put(key,integer);                 
                } 
            } 
        } 
         
        index = integer.intValue(); 
        return index; 
    }     
     
    /** 
     * (none java doc) 
     * @see net.sf.hibernate.id.Configurable#configure(net.sf.hibernate.type.Type, 
     * java.util.Properties, net.sf.hibernate.dialect.Dialect) 
     */ 
    public void configure(Type type, Properties params, Dialect d) 
    throws MappingException { 
         
        //取出table参数 
        String table = params.getProperty("table"); 
        if (table == null){ 
            table = params.getProperty(PersistentIdentifierGenerator.TABLE); 
        } 
        //取出column参数 
        String column = params.getProperty("column"); 
        if (column == null){
            column = params.getProperty(PersistentIdentifierGenerator.PK); 
        } 
         
        //表的sehcma参数 
        String schema = params.getProperty(PersistentIdentifierGenerator.SCHEMA); 
         
        returnClass = type.getReturnedClass(); 
         
        //取出step参数 
        String stepvalue = params.getProperty("step"); 
        if(null != stepvalue && !"".equals(stepvalue.trim())){ 
            try{ 
                step = Integer.parseInt(stepvalue); 
            }catch(Exception e){ 
                log.error(e); 
            } 
        } 
         

        //构造存储在Map中的索引值的key name 
        key = table + "_$_" + column; 
         
        //根据参数构造取最大值的SQL 
        sql = "select max(" + column + ") from "; 
        if(null != schema){ 
            sql += schema + "."; 
        } 
        sql += table; 
    } 
     
    /** 
     * 取指定表中id字段的最大值，不存在记录返回0 
     * @return 最大值 
     * @throws SQLException if sql error occurs. 
     */ 
    private long getMaxvalue() throws SQLException { 
        String maxvalue = "0"; 
        long retVal;
        
        PreparedStatement st = connection.prepareStatement(sql); 
        ResultSet rs = null; 
        try { 
            rs = st.executeQuery(); 
            if(rs.next()) { 
            	maxvalue = rs.getString(1); 
            } 
            sql = null; 
        }finally { 
            if (rs != null){ 
                rs.close(); 
            } 
            st.close(); 
        } 
        if (StringUtil.isEmpty(maxvalue))
        {
        	retVal = 1;
        }
        else
        {
        	retVal = Long.parseLong(maxvalue);
        }
        return retVal; 
	
    }
	
	
}