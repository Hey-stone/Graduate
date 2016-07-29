package com.stone.util;

import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

public class StringUtil
{
	public static boolean isBlank(String txt)
	{
		return StringUtils.isBlank(txt);
	}
	
	public static boolean isNotBlank(String txt)
	{
		return !isBlank(txt);
	}
	
	public static boolean isEmpty(String txt)
	{
		return StringUtils.isEmpty(txt);
	}
	
	public static boolean isNotEmpty(String txt)
	{
		return !isEmpty(txt);
	}
	
	
    /**
     * 生成唯一标示
     * @return
     */
    public static String getUUID()
    {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString().replace("-", "");
        return str;
    }
    
    public static String setToString(Set<String> set, String separator) {
		if (set == null || set.isEmpty()) {
		return "";
		}
		StringBuffer sb = new StringBuffer();
		for (Object o : set) {
		sb.append(o == null ? "null" : o.toString()).append(separator);
		}
		return sb.toString();

	}
}
