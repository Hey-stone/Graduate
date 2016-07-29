/**
 * 
 */
package com.stone.pojo.trans;

import java.io.Serializable;
import java.util.List;

import com.stone.common.BaseQueryResult;
import com.stone.pojo.AreaInfo;


/**
 * @author  冯亚军
 * @version  [版本号, 2016-4-26]
 */
public class AreaInfoResult extends BaseQueryResult implements Serializable {

	private static final long serialVersionUID = 6850196906998947937L;
	
	private List<AreaInfo> list;

	/**
	 * @return the list
	 */
	public List<AreaInfo> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<AreaInfo> list) {
		this.list = list;
	}
	

}
