/**
 * 
 */
package com.stone.dao.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.stone.common.xsqlbuilder.XsqlBuilder;
import com.stone.common.xsqlbuilder.XsqlBuilder.XsqlFilterResult;
import com.stone.dao.HistoryWatherDao;
import com.stone.dao.hibernate.NoTypeDaoImpl;
import com.stone.pojo.HistoryWather;

/**
 * @author  冯亚军
 * @version  [版本号, 2016-5-5]
 */
@Service("HistoryWatherDao")
public class HistoryWatherDaoImpl extends NoTypeDaoImpl implements HistoryWatherDao {

	@Override
	public List<HistoryWather> query(HistoryWather historyWather) {
		String hql = "select h from HistoryWather h where 1=1 "
				+ "/~ and h.city_name = {city_name} ~/"
				//+ "/~ and h.wather = {wather} ~/"
				+ "/~ and h.date like {date} ~/"
				+ " order by h.date asc ";
		@SuppressWarnings("rawtypes")
		Map values = convert2Map(historyWather);
		XsqlFilterResult result = new XsqlBuilder().generateHql(hql, values);
		List<HistoryWather> modelList = list(result.getXsql(),0,Integer.MAX_VALUE, result.getAcceptedFilters());
		return modelList;
	}

}
