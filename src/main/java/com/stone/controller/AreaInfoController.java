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

import com.stone.pojo.AreaInfo;
import com.stone.pojo.ScenicAreaInfo;
import com.stone.service.AreaInfoService;
import com.stone.util.JsonUtil;

/**
 * @author  冯亚军
 * @version  [版本号, 2016-4-26]
 * <地区编码查询>
 */

@Controller
@RequestMapping("area_info")
public class AreaInfoController {
	
	private static final Log log = LogFactory.getLog(AreaInfoController.class);
	
	@Resource
	private AreaInfoService areaInfoService;
	
	/**
	 * <查询所有的城市>
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="queryAreaInfo")
	public @ResponseBody String queryAreaInfo(HttpServletRequest request,HttpServletResponse response){
		List<AreaInfo> list = areaInfoService.queryAreaInfo();
		String result = JsonUtil.BeanToJson(list);
		return result;
	}
	
	/**
	 * <查询所有的景点>
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="queryScenicAreaInfo")
	public @ResponseBody String queryScenicAreaInfo(HttpServletRequest request,HttpServletResponse response){
		List<ScenicAreaInfo> list = areaInfoService.queryScenicAreaInfo();
		String result = JsonUtil.BeanToJson(list);
		return result;
	}
	
	/**
	 * <查询重点省份>
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="queryProvinceAreaInfo")
	public @ResponseBody String queryProvinceAreaInfo(HttpServletRequest request,HttpServletResponse response){
		List<ScenicAreaInfo> list = areaInfoService.queryScenicAreaInfo();
		String result = JsonUtil.BeanToJson(list);
		return result;
	}

}
