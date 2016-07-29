/**
 * Project Name:dsp
 * File Name:LoginInterceptor.java
 * Package Name:com.etoc.dsp.web.filter
 * Date:Jul 2, 2013 5:09:34 PM
 * Copyright (c) 2013, yumingtao@etoc.com All Rights Reserved.
 *
 */

package com.stone.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.stone.util.StringUtil;



/**
 * ClassName:LoginInterceptor <br/>
 * 

 * Date: Jul 2, 2013 5:09:34 PM <br/>
 * 
 * @author 于明涛
 * @version
 * @since JDK 1.7
 * @see
 */
@Repository
public class LoginInterceptor extends HandlerInterceptorAdapter {
	private final Log logger = LogFactory.getLog(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		boolean isFromMobile=false;
		String requestType = request.getHeader("X-Requested-With");// ajax请求头
		String userAgent = request.getHeader("user-agent").toLowerCase(); //获取请求头判断是pc还是移动端
		isFromMobile=CheckMobile.check(userAgent); 
		Object obj = request.getSession().getAttribute("userInfo");
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/login";
		if (obj == null) {
			logger.info("http session is null: ");
			logger.info("request url is " + request.getRequestURI());
			//判断是否为移动端
			if(isFromMobile){
				logger.info("request come from mobile.");
				response.sendRedirect(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()  + request.getContextPath() + "/statisticsManage/login");
				return false;
			}
			if (StringUtil.isNotBlank(requestType) && requestType.equals("XMLHttpRequest")) {
				logger.info("request come from browser ajax.");
				response.setHeader("contextpath", request.getContextPath());
				response.setHeader("sessionstatus", "timeout");
				response.sendError(518, "session timeout.");
				return false;
			} else {
				logger.info("request come from browser hyperlink.");
				response.sendRedirect(basePath);
				return false;
			}
		} else {
			return super.preHandle(request, response, handler);
		}
	}
}
