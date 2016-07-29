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

import com.stone.pojo.AQI_24H;
import com.stone.pojo.HistoryAir;
import com.stone.service.HistoryAirService;
import com.stone.util.JsonUtil;



/**
 * @author  冯亚军
 * @version  [版本号, 2016-4-16]
 */
@Controller
@RequestMapping("/historyair")
public class HistoryAirController {
	
	private static final Log log = LogFactory.getLog(HistoryAirController.class);
	
	@Resource(name="HistoryAirService")
	private HistoryAirService historyAirService;
	
	@RequestMapping(value="/query")
	private @ResponseBody String query(HttpServletRequest request,HttpServletResponse response,HistoryAir historyAir){
		log.info("the method query request param HistoryAir : "+historyAir.toString());
		List<HistoryAir> list = historyAirService.query(historyAir);
		String result = JsonUtil.BeanToJson(list);
		log.info("query method response param "+result);
		return result;
	}
	
	@RequestMapping(value="/queryAqi_24h")
	private @ResponseBody String queryAqi_24h(HttpServletRequest request,HttpServletResponse response,AQI_24H aqi_24h){
		log.info("the method queryAqi_24h request param AQI_24H : "+aqi_24h.toString());
		List<AQI_24H> list = historyAirService.queryAqi_24h(aqi_24h);
		String result = JsonUtil.BeanToJson(list);
		log.info("queryAqi_24h method response param "+result);
		return result;
	}

}
