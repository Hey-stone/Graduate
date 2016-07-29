/**
 * 
 */
package com.stone.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stone.dao.HistoryAirDao;
import com.stone.pojo.AQI_24H;
import com.stone.pojo.HistoryAir;
import com.stone.service.HistoryAirService;

/**
 * @author  冯亚军
 * @version  [版本号, 2016-4-16]
 */
@Service("HistoryAirService")
public class HistoryAirServiceImpl implements HistoryAirService {
	
	@Resource(name="HistoryAirDao")
	private HistoryAirDao historyAirDao;

	@Override
	public List<HistoryAir> query(HistoryAir dto) {
		return historyAirDao.query(dto);
	}

	@Override
	public List<AQI_24H> queryAqi_24h(AQI_24H aqi_24h) {
		return historyAirDao.queryAqi_24h(aqi_24h);
	}

}
