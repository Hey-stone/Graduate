/**
 * 
 */
package com.stone.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.stone.dao.AreaInfoDao;
import com.stone.dao.hibernate.NoTypeDaoImpl;
import com.stone.pojo.AreaInfo;
import com.stone.pojo.ScenicAreaInfo;

/**
 * @author  冯亚军
 * @version  [版本号, 2016-4-26]
 */
@Service("AreaInfoDao")
public class AreaInfoDaoImpl extends NoTypeDaoImpl implements AreaInfoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<AreaInfo> queryAreaInfo() {
		String hql = "select a from AreaInfo a";
		Session session = this.getSession();
		Query query = session.createQuery(hql.toString());
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ScenicAreaInfo> queryScenicAreaInfo() {
		String hql = "select s from ScenicAreaInfo s";
		Session session = this.getSession();
		Query query = session.createQuery(hql.toString());
		return query.list();
	}

}
