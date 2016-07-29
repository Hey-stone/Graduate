package com.stone.common.model.datamodifier.modifier;

import com.stone.common.model.datamodifier.DataModifier;


/**
 * @author badqiu
 */
public class StringDataModifier implements DataModifier{
	public Object modify(Object value, String modifierArgument) {
		if(value == null) return null;
		if(value instanceof String) return value;
		return value.toString();
	}
}
