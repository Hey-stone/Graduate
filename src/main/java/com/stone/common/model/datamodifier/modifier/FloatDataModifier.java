package com.stone.common.model.datamodifier.modifier;

import com.stone.common.model.datamodifier.DataModifier;


/**
 * @author badqiu
 */
public class FloatDataModifier implements DataModifier{
	public Object modify(Object value, String modifierArgument) {
		if(value == null) return null;
		if(value instanceof Float) return value;
		return new Float(value.toString());
	}
}
