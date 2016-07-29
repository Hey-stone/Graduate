package com.stone.util;

import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GeneralTools {

    /**
     * 正者表达式匹配
     * @param str
     * @param pattern
     * @return
     */
    public static boolean match(String str,String pattern){
    	if(str == null || pattern == null){
    		return false;
    	}
    	
    	try {
    		Pattern p = Pattern.compile(pattern); 
        	Matcher m = p.matcher(str);
        	return m.matches();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
    	
    }
    
	public static boolean match(String str,List<String> patternList){
		boolean isMatch = false;
		if(str == null || patternList == null){
			return false;
		}
		
		for(String temp:patternList){
			if(GeneralTools.match(str, temp)){
				isMatch = true;
				break;
			}
		}
		return isMatch;
	}
	
	/**
	 * 获取系统当前时间
	 * @param format
	 * @return
	 */
	public static String getSystemTime(String format){
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.format(new Date());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static List<String> split(String str,String split){
		List<String> list = new ArrayList<String>();
		
		if(StringUtil.isEmpty(str) || StringUtil.isEmpty(split)){
			return list;
		}
		
		String[] s = str.split(split);
		for(String temp:s){
			list.add(temp);
		}
		
		return list;
	}
	
	
	/**
	 * 
	 * @param className
	 *            类路劲的名字
	 * @return 返回根据className指明的类信息
	 */
	public static Class getclass(String className) {
		Class c = null;
		try {
			c = Class.forName(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	/** 
     *  
     * @param name 类路劲 
     * @param classParas Class类信息参数列表 
     *  如果是基本数据类型是可以使用其Tpye类型，如果用class字段是无效的 
     *  如果是非数据类型可以使用的class字段来创建其Class类信息对象，这些都要遵守。 
     * @param paras      实际参数列表数据 
     * @return           返回Object引用的对象，实际实际创建出来的对象，如果要使用可以强制转换为自己想要的对象 
     *  
     * 带参数的反射创建对象 
     */  
	public static Object getInstance(String name, Class classParas[],Object paras[]) {
		Object o = null;
		try {
			Class c = getclass(name);
			Constructor<Object> con = c.getConstructor(classParas);// 获取使用当前构造方法来创建对象的Constructor对象，用它来获取构造函数的一些
			// 信息
			o = con.newInstance(paras);// 传入当前构造函数要的参数列表
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return o;// 返回这个用Object引用的对象
	}
}
