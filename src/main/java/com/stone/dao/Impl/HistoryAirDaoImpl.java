/**
 * 
 */
package com.stone.dao.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.stone.common.xsqlbuilder.XsqlBuilder;
import com.stone.common.xsqlbuilder.XsqlBuilder.XsqlFilterResult;
import com.stone.dao.HistoryAirDao;
import com.stone.dao.hibernate.NoTypeDaoImpl;
import com.stone.pojo.AQI_24H;
import com.stone.pojo.HistoryAir;

/**
 * @author  冯亚军
 * @version  [版本号, 2016-4-16]
 */
@Service("HistoryAirDao")
public class HistoryAirDaoImpl extends NoTypeDaoImpl implements HistoryAirDao {


	@Override
	public List<HistoryAir> query(HistoryAir dto) {
		//List<HistoryAir> list = (List<HistoryAir>) this.getAllObject(HistoryAir.class);数据太多。
		String hql = "select h from HistoryAir h where 1=1 "
				+ "/~ and h.date = {date} ~/"
				+ "/~ and h.monthofyear = {monthofyear} ~/"
				+ "/~ and h.dayofmonth = {dayofmonth} ~/"
				+ "/~ and h.air_quality = {air_quality} ~/"
				+ "/~ and h.city_name = {city_name} ~/";
		@SuppressWarnings("rawtypes")
		Map values = convert2Map(dto);
		XsqlFilterResult result = new XsqlBuilder().generateHql(hql, values);
		List<HistoryAir> modelList = list(result.getXsql(),0,Integer.MAX_VALUE, result.getAcceptedFilters());
		return modelList;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<AQI_24H> queryAqi_24h(AQI_24H aqi_24h) {
		String sql = "select h.aqi,h.area from t_24h_aqi h where 1=1 "
				+ " and h.time_point BETWEEN CONCAT( CURDATE() - INTERVAL 1 DAY, ' ', HOUR (NOW()), ':00:00' ) AND NOW() "
				+ " and h.area = :area"
				+ " order by h.time_point asc ";
		Query query = this.getSession().createSQLQuery(sql);
		query.setParameter("area", aqi_24h.getArea());
		List list =  query.list();
		List<AQI_24H> resultList = new ArrayList<AQI_24H>();
		 for (Iterator iterator = list.iterator(); iterator.hasNext();)
	        {
	            Object[] item = (Object[])iterator.next();
	            AQI_24H model = new AQI_24H();
	            model.setAqi(Integer.valueOf(item[0].toString()));
	            model.setArea(item[0].toString());
	            resultList.add(model);
	        }
		return resultList;
	}

}
