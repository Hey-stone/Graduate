package com.stone.common.model.datamodifier.modifier;

import com.stone.common.model.datamodifier.DataModifier;


/**
 * @author badqiu
 */
public class IntegerDataModifier implements DataModifier{
	public Object modify(Object value, String modifierArgument) {
		if(value == null) return null;
		if(value instanceof Integer) return value;
		return new Integer(value.toString());
	}
}
