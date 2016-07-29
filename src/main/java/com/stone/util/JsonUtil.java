package com.stone.util;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	@SuppressWarnings("rawtypes")
	public static <T> T jsonToBean(String jsonString, Class<T> pojoCalss, Map classMap) {
		T pojo = null;
		try
        {
            ObjectMapper objMapper = new ObjectMapper();
            objMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            return objMapper.readValue(jsonString, pojoCalss);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
		return pojo;
	}
	
	@SuppressWarnings("rawtypes")
	public static <T> T jsonToBean(String jsonString, JavaType javaType, Map classMap) {
		T pojo = null;
		try
        {
            ObjectMapper objMapper = new ObjectMapper();
            objMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            return objMapper.readValue(jsonString, javaType);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
		return pojo;
	}
	
	@SuppressWarnings("rawtypes")
	public static <T> T jsonToBean(String jsonString, TypeReference<T> javaType, Map classMap) {
		T pojo = null;
		ObjectMapper objMapper = new ObjectMapper();
		try
        {
            objMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            // 在转换时，Json字符串中有而Java对象没有的属性，屏蔽报异常
            objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            return objMapper.readValue(jsonString, javaType);
        }
        catch (Exception e)
        {
        	objMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        	try {
				return objMapper.readValue(jsonString, javaType);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        }
		return pojo;
	}
	
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {   
		ObjectMapper mapper = new ObjectMapper();
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
	} 

	/**
	 * 将baen对象转换为json 字符串
	 * @param obj
	 * @return
	 */
	public static String BeanToJson(Object obj)
	{
		String ret = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			ret = mapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	@SuppressWarnings("rawtypes")
	public static String listToJson(List list, int count) {
		
		ExtJsonAdapter eja = new ExtJsonAdapter();
		eja.setTotalCount(count);
		eja.setResults(list);
		
		String json = null;
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			json = mapper.writeValueAsString(eja);
		}
		catch (Exception e)
		{}
		return json;
	}
	
	
}
