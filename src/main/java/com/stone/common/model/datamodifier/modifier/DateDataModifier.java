package com.stone.common.model.datamodifier.modifier;

import java.text.DateFormat;
import java.util.Date;

import com.stone.common.model.datamodifier.DataModifier;
import com.stone.common.model.datamodifier.DefaultUtils;


/**
 * @author badqiu
 */
public class DateDataModifier implements DataModifier{
	
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private String dateFormat = DEFAULT_DATE_FORMAT;
	
	public DateDataModifier(){}
	
	public DateDataModifier(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	
	public Object modify(Object value, String modifierArgument)throws Exception {
		if(value == null) return null;
		if(value instanceof Date) return value;
		DateFormat df = DefaultUtils.defaultDateFormat(modifierArgument,dateFormat);
		return df.parse(value.toString());
	}
}
