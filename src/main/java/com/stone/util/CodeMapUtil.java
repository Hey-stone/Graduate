package com.stone.util;

import java.util.TreeMap;

public class CodeMapUtil {

	// 使用treemap实现对ispResp : largessResp的map的自然排序
	TreeMap<String, String> codeMap;

	@SuppressWarnings("unchecked")
	public CodeMapUtil(String codeMapJson) {
		super();
		codeMap = (TreeMap<String, String>) JsonUtil.jsonToBean(codeMapJson, TreeMap.class,null);
	}

	public String generateMapCode(String code) {
		if(code == null){
			return null;
		}
		
		if (codeMap != null && codeMap.size() > 0) {
			// 对排序后的key值进行判断
			for (String k : codeMap.keySet()) {
				if (code.equals(k)) {
					return codeMap.get(k);
				}
			}
		}
		return null;
	}

}
