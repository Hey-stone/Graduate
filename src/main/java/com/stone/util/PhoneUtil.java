package com.stone.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;

public class PhoneUtil {
    
    private static final Logger logger = Logger.getLogger(PhoneUtil.class);
	
	//TODO 需完善: 暂时只接受联通号码为合法号码
	private static final String[] VALID_UNI_PHONE_PREFIX = new String[] { 
	    "130", "131", "132", "145", "155", "156", "170", "176", "186", "185" ,
	    "180","181","189","133","153","177",
	    "139","138","137","136","135","134","159","150","151","158","157","188","187","152","182","147","178","183","184"};

	private final static String[] CU = new String[] { "130", "131", "132", "145", "155", "156", "170", "176", "186", "185"};
	private final static String[] CN = new String[] { "180","181","189","133","153","177"};
	private final static String[] CM = new String[] { "139","138","137","136","135","134","159","150","151","158","157","188","187","152","182","147","178","183","184"};
    
	/**
	 * return the phone number or "0"
	 * */
	public static String parsePhoneNum(String phoneInRequest) {
		String phoneNum = decodeBase64(phoneInRequest);
		// if the decode result not right, use the original phone num
		if (phoneNum != null && phoneNum.length() != 11) {
			phoneNum = phoneInRequest;
		}
		// if phone num's format is incorrect, set it as "0"
		if (phoneNum == null || "".equals(phoneNum) || phoneNum.length() != 11) {
			phoneNum = "0";
		}
		return phoneNum;
	}
	
	public static String decodeBase64(String s) {
		String rstString = null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			rstString = new String(b);
		} catch (Exception e) {
			rstString = s;
		}
		return rstString;
	}
	
	public static boolean validPhoneNum(String phone) {
		if (phone == null || phone.length() != 11) {
			return false;
		}
		for (String x : VALID_UNI_PHONE_PREFIX) {
			if (phone.substring(0, 3).equals(x)) {
				return true;
			}
		}
		return false;
	}

	public static boolean validPhoneNum(String phone,String mobileOperator) {
		if (phone == null || phone.length() != 11) {
			return false;
		}
		if("CU".equals(mobileOperator)){
			for (String x : CU) {
				if (phone.substring(0, 3).equals(x)) {
					return true;
				}
			}
		}else if("CN".equals(mobileOperator)){
			for (String x : CN) {
				if (phone.substring(0, 3).equals(x)) {
					return true;
				}
			}
		}else if("CM".equals(mobileOperator)){
			for (String x : CM) {
				if (phone.substring(0, 3).equals(x)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	

	/**
	 * 国际化手机号，截取后11位
	 * <功能详细描述>
	 * @param phone
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static String subStringPhone(String phone)
	{
	    if (phone != null && phone.length() == 13) {
            return phone.substring(2);
        }
	    return phone;	    
	}
	
	/**
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param filePath
	 * @param mobileOperator
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static List<String> analyticalTXT(String filePath)
	{
	    List<String> phoneList = new ArrayList<String>();
        
        FileInputStream inputStream = null;
        InputStreamReader streamReader = null;
        BufferedReader reader = null;
        try
        {   
            //request.setFilePath("c:/Java/mobile.txt");
            if(!new File(filePath).exists()){
                return phoneList;
            }
                
            inputStream = new FileInputStream(filePath);
            streamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(streamReader);
            
            String line = "";
            while((line = reader.readLine()) != null)
            {                
                // 如果号码不为空，并且长度是手机号类型
                if (StringUtil.isNotBlank(line))
                {
                    String phone = line.trim();
                    phoneList.add(phone);
                }
            }
            logger.info("ReadFileHandle readFile success");
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            e.printStackTrace();
        } 
        finally
        {
            try
            { if (reader != null)reader.close(); }
            catch (IOException e){}
            try
            { if (streamReader != null) streamReader.close(); }
            catch (IOException e) {}
            try
            { if (inputStream != null) inputStream.close(); }
            catch (IOException e) {}
        }  

        return phoneList;
	}

	public static void main(String[] args){
		System.out.println(validPhoneNum("18391478242"));
	}
}
