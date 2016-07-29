/**
 * 
 */
package com.stone.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stone.dao.HistoryWatherDao;
import com.stone.pojo.HistoryWather;
import com.stone.service.HistoryWatherService;

/**
 * @author  冯亚军
 * @version  [版本号, 2016-5-5]
 */
@Service("HistoryWatherService")
public class HistoryWatherServiceImpl implements HistoryWatherService {
	
	@Resource(name="HistoryWatherDao")
	private HistoryWatherDao historyWatherDao;

	@Override
	public List<HistoryWather> query(HistoryWather historyWather) {
		return historyWatherDao.query(historyWather);
	}

}
