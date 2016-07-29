package com.stone.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成BSS流水号
 * @author 王智
 *
 */
public class RequestNoUtil {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	
	private static int REQUEST_NO = 0;
	
	private static int REQUEST_NO_1 = 0;
    
    private static int REQUEST_NO_2 = 0;
    
    private static int REQUEST_NO_3 = 0;
    
    private static int REQUEST_NO_4 = 0;
    
    private static int REQUEST_NO_5 = 0;
	/**
	 * 
	 * @param machineId  机器ID
	 * @return
	 */
	public static synchronized String getNewRequestNo(String machineId){
		if(machineId == null || "".equals(machineId.trim()) || machineId.length() > 1){
			return null;
		}
		
		if(REQUEST_NO > 9999){
			REQUEST_NO = 0;
		}
		
		String requestNoPrefix = machineId + dateFormat.format(new Date()).substring(3);
		
		String strRequestNo = REQUEST_NO + "";
		StringBuffer tempSb = new StringBuffer();
		
		for(int i=0;i<4-strRequestNo.length();i++){
			tempSb.append("0");
		}
		
		String newRequestNo = requestNoPrefix + tempSb.toString() + REQUEST_NO;
		
		REQUEST_NO = REQUEST_NO + 1;
		
		return newRequestNo;
		
	}
	
	/**
     * 
     * @param machineId  机器ID,订购业务id
     * @return
     */
    public static synchronized String getNewRequestNo(String machineId,String orderWayId){
        if(machineId == null || "".equals(machineId.trim()) || machineId.length() > 1
                || orderWayId == null || "".equals(orderWayId.trim()) || orderWayId.length() > 1){
            return null;
        }
        
        if(REQUEST_NO_1 > 99){
            REQUEST_NO_1 = 0;
        }
        
        String requestNoPrefix = orderWayId + machineId + dateFormat.format(new Date()).substring(2);
        
        String strRequestNo = REQUEST_NO_1 + "";
        StringBuffer tempSb = new StringBuffer();
        
        for(int i=0;i<2-strRequestNo.length();i++){
            tempSb.append("0");
        }
        
        String newRequestNo = requestNoPrefix + tempSb.toString() + REQUEST_NO_1;
        
        REQUEST_NO_1 = REQUEST_NO_1 + 1;
        
        return newRequestNo;
        
    }
    
    /**
     * 获取6位自增长数据
     * @param 
     * @return
     */
    public static synchronized String getNewRequestNo(){
        
        if(REQUEST_NO_2 > 999999){
            REQUEST_NO_2 = 0;
        }
                
        String strRequestNo = REQUEST_NO_2 + "";
        StringBuffer tempSb = new StringBuffer();
        
        for(int i=0;i<6-strRequestNo.length();i++){
            tempSb.append("0");
        }
        
        String newRequestNo = tempSb.toString() + REQUEST_NO_2;
        
        REQUEST_NO_2 = REQUEST_NO_2 + 1;
        
        return newRequestNo;
        
    }
    
    /**
     * 机器id+12位时间+3位自增长
     * @param 
     * @return
     */
    public static synchronized String getNewBatchOrderId(String machineId){
        if(machineId == null || "".equals(machineId.trim()) || machineId.length() > 1){
            return null;
        }
        
        if(REQUEST_NO_3 > 999){
            REQUEST_NO_3 = 0;
        }
        
        String requestNoPrefix = machineId + dateFormat.format(new Date()).substring(2);
        String strRequestNo = REQUEST_NO_3 + "";
        StringBuffer tempSb = new StringBuffer();
        
        for(int i=0;i<3-strRequestNo.length();i++){
            tempSb.append("0");
        }
        
        String newRequestNo = requestNoPrefix + tempSb.toString() + REQUEST_NO_3;
        
        REQUEST_NO_3 = REQUEST_NO_3 + 1;
        
        return newRequestNo;
        
    }
    
    /**
     * 获取5位自增长数据
     * @param 
     * @return
     */
    public static synchronized String getFiveGrowth(){
        
        if(REQUEST_NO_4 > 99999){
            REQUEST_NO_4 = 0;
        }
                
        String strRequestNo = REQUEST_NO_4 + "";
        StringBuffer tempSb = new StringBuffer();
        
        for(int i=0;i<5-strRequestNo.length();i++){
            tempSb.append("0");
        }
        
        String newRequestNo = tempSb.toString() + REQUEST_NO_4;
        
        REQUEST_NO_4 = REQUEST_NO_4 + 1;
        
        return newRequestNo;
        
    }
    
    /**
     * 获取两位自增长
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static synchronized String getTwoGrowth(){
        
        if(REQUEST_NO_5 > 99){
            REQUEST_NO_5 = 0;
        }
                
        String strRequestNo = REQUEST_NO_5 + "";
        StringBuffer tempSb = new StringBuffer();
        
        for(int i=0;i<2-strRequestNo.length();i++){
            tempSb.append("0");
        }
        
        String newRequestNo = tempSb.toString() + REQUEST_NO_5;
        
        REQUEST_NO_5 = REQUEST_NO_5 + 1;
        
        return newRequestNo;
        
    }
    
}
