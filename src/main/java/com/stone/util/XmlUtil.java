package com.stone.util;

import java.io.File;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlUtil {

	/**
	 * 将对象转换为xml格式字符串,变更根标签为resp
	 * @param obj
	 * @param type
	 * @return
	 */
	public static String beanToXml(Object obj, @SuppressWarnings("rawtypes") Class type)
	{	
		String xml = "<?xml version='1.0' encoding='utf-8' ?>\n";
		XStream xs = new XStream(new DomDriver());
        xs.processAnnotations(type);
		xml += xs.toXML(obj);
		return xml;
	}
	
	public static String beanToXmlNoTitle(Object obj, @SuppressWarnings("rawtypes") Class type)
	{
        XStream xs = new XStream(new DomDriver());
        xs.processAnnotations(type);
        return xs.toXML(obj);
	}
	
	/**
     * 将对象转换为xml格式字符串,变更根标签为resp
	 * @param <T>
     * @param obj
     * @param type
     * @return
     */
    public static <T> Object xmlToBean(String xml, Class<T> type)
    {
    	XStream xs = new XStream(new DomDriver());
        xs.processAnnotations(type);
        Object obj = xs.fromXML(xml);
        return obj;
    }
    
    /**
     * 将对象转换为xml格式字符串,变更根标签为resp
     * @param <T>
     * @param obj
     * @param type
     * @return
     */
    public static <T> Object xmlToBean(InputStream xml, Class<T> type)
    {
    	 XStream xs = new XStream(new DomDriver());
         xs.processAnnotations(type);
         Object obj = xs.fromXML(xml);
         return obj;
    }
    
    /**
     * 将对象转换为xml格式字符串,变更根标签为resp
     * @param <T>
     * @param obj
     * @param type
     * @return
     */
    public static <T> Object xmlToBean(File xml, Map<String, Class> aliasTypes, Class<T> type)
    {
        XStream xs = new XStream(new DomDriver());
        if (aliasTypes != null && !aliasTypes.isEmpty())
        {
            Set<String> keys = aliasTypes.keySet();
            for (String key : keys)
            {
                xs.alias(key, aliasTypes.get(key));
            }
        }
        Object obj = xs.fromXML(xml);
        return obj;
    }
    
    public static <T> Object xmlToBean(String xml, Class<T> type,Map<String,Class>aliasTypes )
    {
        XStream xs = new XStream(new DomDriver());
        xs.processAnnotations(type);
        if (aliasTypes != null && !aliasTypes.isEmpty())
        {
            Set<String> keys = aliasTypes.keySet();
            for (String key : keys)
            {
                xs.useAttributeFor(key, aliasTypes.get(key));
            }
        }
        Object obj = xs.fromXML(xml);
        return obj;
    }
    
    /**
     * 将对象转换为xml格式字符串,变更根标签为resp
     * @param <T>
     * @param obj
     * @param type
     * @return
     */
    public static <T> Object xmlToBean(File xml, Class<T> type)
    {
        XStream xs = new XStream(new DomDriver());
        xs.processAnnotations(type);
        Object obj = xs.fromXML(xml);
        return obj;
    }
    
   
    
}
