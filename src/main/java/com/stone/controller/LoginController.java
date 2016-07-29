/**
 * 
 */
package com.stone.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stone.pojo.LoginResult;
import com.stone.pojo.User;
import com.stone.service.LoginService;
import com.stone.util.JsonUtil;

/**
 * @author  冯亚军
 * @version  [版本号, 2016-4-25]
 */
@Controller
@RequestMapping("login")
public class LoginController {
	
	private static final Log log = LogFactory.getLog(LoginController.class);
	
	@Resource(name="LoginService")
	private LoginService loginService;
	
	@RequestMapping(value="/login")
	private @ResponseBody String login(HttpServletRequest request,HttpServletResponse response,User user){
		log.info("The Method login param User:"+user.toString());
		User currentUser = null;
		currentUser = loginService.login(user);
		LoginResult loginResult= new LoginResult();
		if(currentUser != null){
			loginResult.setCode("0000");
			loginResult.setMessage("登录成功！");
		}else{
			loginResult.setCode("0001");
			loginResult.setMessage("登录失败！");
		}
		log.info("The Method login response User:"+currentUser.toString());
		String result = JsonUtil.BeanToJson(loginResult);
		return result;
	}

}
