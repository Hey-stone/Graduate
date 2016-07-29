package com.stone.util;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * jdbc结果集转换工具
 * <p>可以自动使用目标类的set方法获取resutlset中的值，可以自动匹配两种情况，
 * 例如:ResultSetConvert<T> convert =  
 * 				new ResultSetConvert<T>(T.class);
 * convert.Convert2Obj(resutlset);
 * 一种是set方法的去掉set方法名与列名全文匹配，不区分大小写  例如：setMarketName匹配marketname
 * 一种是set方法的去掉"set"方法名按照驼峰规则，替换成下划线列名 例如：setMarketName匹配market_name
 * 目前只支持Integer BigDecimal String Double</p>
 * 
 * @author  张明
 * @version  [1.0, 2015-05-26]
 */
public class ResultSetConvert<T>{
	private Class<T> c=null;
	private List<String> columns = new ArrayList<String>();
	private List<String> lineColumns = new ArrayList<String>();
	private List<Method> setMethods= new ArrayList<Method>();
	public ResultSetConvert(Class<T> clazz){
		c=clazz;
		fetchSetMethods(c);
		Class superClass=c.getSuperclass();
		if(!superClass.equals(Object.class)){
			fetchSetMethods(superClass);
		}
	}
	private void fetchSetMethods(Class c){
		Method[] ms = c.getDeclaredMethods();
		for(Method method : ms){
			if(method.getName().indexOf("set")>=0){
				Class[] classTmp = method.getParameterTypes();
				String columnName=method.getName().replace("set", "");
				columns.add(columnName.toLowerCase());
				lineColumns.add(Tools.camel4underline(columnName).toLowerCase());
				setMethods.add(method);
			}
		}
	}
	public T Convert2Obj(ResultSet rs){
		T o = null;
		try {
			o = c.newInstance();
			for(int i = 0;i<setMethods.size();i++){
				Class[] c = setMethods.get(i).getParameterTypes();
				if(c[0].equals(Integer.class)){
					try {
						setMethods.get(i).invoke(o, rs.getInt(columns.get(i)));
					} catch (Exception e) {
						try {
							setMethods.get(i).invoke(o, rs.getInt(lineColumns.get(i)));
						} catch (Exception e2) {
						}
					}
				}else if(c[0].equals(BigDecimal.class)){
					try {
						setMethods.get(i).invoke(o, rs.getBigDecimal(columns.get(i)));
					} catch (Exception e) {
						try {
							setMethods.get(i).invoke(o, rs.getBigDecimal(lineColumns.get(i)));
						} catch (Exception e2) {
						}
					}
				}else if(c[0].equals(String.class)){
					try {
						setMethods.get(i).invoke(o, rs.getString(columns.get(i)));
					} catch (Exception e) {
						try {
							setMethods.get(i).invoke(o, rs.getString(lineColumns.get(i)));
						} catch (Exception e2) {
						}
					}
				}else if(c[0].equals(Double.class)){
					try {
						setMethods.get(i).invoke(o, rs.getDouble(columns.get(i)));
					} catch (Exception e) {
						try {
							setMethods.get(i).invoke(o, rs.getDouble(lineColumns.get(i)));
						} catch (Exception e2) {
						}
					}
				}
				
			}
			
		} catch (Exception e) {
			
		}
		return o;
	}
}
