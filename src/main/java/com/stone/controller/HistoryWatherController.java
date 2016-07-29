/**
 * 
 */
package com.stone.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stone.pojo.HistoryWather;
import com.stone.service.HistoryWatherService;
import com.stone.util.JsonUtil;

/**
 * @author  冯亚军
 * @version  [版本号, 2016-5-5]
 */
@Controller
@RequestMapping("historyWather")
public class HistoryWatherController {
	
	private static final Log log = LogFactory.getLog(HistoryWatherController.class);
	
	@Resource(name="HistoryWatherService")
	private HistoryWatherService historyWatherService;
	
	@RequestMapping(value="/query")
	private @ResponseBody String query(HttpServletRequest request,HttpServletResponse response,HistoryWather historyWather){
		log.info("the method query request param HistoryWather : "+historyWather.toString());
		List<HistoryWather> list = historyWatherService.query(historyWather);
		String result = JsonUtil.BeanToJson(list);
		log.info("query method response param "+result);
		return result;
	}

}
