/**
 * 
 */
package com.stone.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stone.dao.LoginDao;
import com.stone.pojo.User;
import com.stone.service.LoginService;

/**
 * @author  冯亚军
 * @version  [版本号, 2016-6-10]
 */
@Service("LoginService")
public class LoginServiceImpl implements LoginService {
	
	@Resource(name="LoginDao")
	private LoginDao loginDao;

	@Override
	public User login(User user) {
		return loginDao.login(user);
	}

}
