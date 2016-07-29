/**
 * 
 */
package com.stone.service;

import java.util.List;

import com.stone.pojo.AQI_24H;
import com.stone.pojo.HistoryAir;


/**
 * @author  冯亚军
 * @version  [版本号, 2016-4-16]
 */
public interface HistoryAirService {
	
	/**
	 * 
	 * @param dto
	 * <p>
	 * <Li>查询所有的数据
	 * <Li>可以带条件
	 */
	List<HistoryAir> query(HistoryAir dto);
	
	/**
	 * <查询24小时内的aqi情况>
	 * @param aqi_24h
	 * @return
	 */
	List<AQI_24H> queryAqi_24h(AQI_24H aqi_24h);

}
