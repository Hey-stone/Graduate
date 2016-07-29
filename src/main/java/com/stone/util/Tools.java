package com.stone.util;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Tools
{
	public static String ifNull(String txt,String defaultStr)
	{
		return txt==null?defaultStr:txt;
	}
	
	public static Double ifNull(Double d,Double defaultNum)
	{
		return d==null?defaultNum:d;
	}
	
	public static Integer ifNull(Integer i,Integer defaultNum)
	{
		return i==null?defaultNum:i;
	}

	public static BigDecimal ifNull(BigDecimal b,
			BigDecimal defaultNum) {
		return b==null?defaultNum:b;
	}
	/**
	 * 驼峰转下划线
	 * @param param
	 * @return
	 */
	public static String camel4underline(String param){
		Pattern  p=Pattern.compile("[A-Z]");
		if(param==null ||param.equals("")){
			return "";
		}
		StringBuilder builder=new StringBuilder(param);
		Matcher mc=p.matcher(param);
		int i=0;
		while(mc.find()){
			builder.replace(mc.start()+i, mc.end()+i, "_"+mc.group().toLowerCase());
			i++;
		}

		if('_' == builder.charAt(0)){
			builder.deleteCharAt(0);
		}
		return builder.toString();
	}
}
