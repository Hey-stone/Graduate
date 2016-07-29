/**
 * 
 */
package com.stone.dao;

import java.util.List;

import com.stone.pojo.AreaInfo;
import com.stone.pojo.ScenicAreaInfo;


/**
 * @author  冯亚军
 * @version  [版本号, 2016-4-26]
 */
public interface AreaInfoDao extends NoTypeDao{
	
	/**
	 * <查询所有的城市>
	 * @return
	 */
	List<AreaInfo> queryAreaInfo();
	
	/**
	 * <查询所有的景点>
	 * @return
	 */
	List<ScenicAreaInfo> queryScenicAreaInfo();

}
