/**
 * 
 */
package com.stone.dao.Impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.stone.common.xsqlbuilder.XsqlBuilder;
import com.stone.common.xsqlbuilder.XsqlBuilder.XsqlFilterResult;
import com.stone.dao.LoginDao;
import com.stone.dao.hibernate.NoTypeDaoImpl;
import com.stone.pojo.User;

/**
 * @author  冯亚军
 * @version  [版本号, 2016-6-10]
 */
@Service("LoginDao")
public class LoginDaoImpl extends NoTypeDaoImpl implements LoginDao {

	@Override
	public User login(User user) {
		
		String hql = "select u from User u where "
				+ "/~ u.userName = {userName} ~/"
				+ "/~ and u.password = {password} ~/";
		@SuppressWarnings("rawtypes")
		Map values = convert2Map(user);
		XsqlFilterResult result = new XsqlBuilder().generateHql(hql, values);
		User currenUser = aggregate(result.getXsql(), result.getAcceptedFilters());
		return currenUser;
	}

}
