package com.stone.common.model.datamodifier.modifier;

import com.stone.common.model.datamodifier.DataModifier;


/**
 * @author badqiu
 */
public class ShortDataModifier implements DataModifier{
	public Object modify(Object value, String modifierArgument) {
		if(value == null) return null;
		if(value instanceof Short) return value;
		return new Short(value.toString());
	}
}
