/**
 * 
 */
package com.stone.service;

import java.util.List;

import com.stone.pojo.HistoryWather;

/**
 * @author  冯亚军
 * @version  [版本号, 2016-5-5]
 */
public interface HistoryWatherService {
	
	/**
	 * <按条件查询天气数据>
	 * @param historyWather
	 * @return
	 */
	List<HistoryWather> query(HistoryWather historyWather);

}
