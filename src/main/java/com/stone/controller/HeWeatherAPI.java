/**
 * 
 */
package com.stone.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stone.util.FileUtilToJson;


/**
 * @author  冯亚军
 * @version  [版本号, 2016-4-22]
 * <Li>基于API接口获取实时数据
 * 
 */
@Controller
@RequestMapping("api")
public class HeWeatherAPI {
	
	private static int count = 0 ; //记录访问的次数
	
	private static final Log log = LogFactory.getLog(HeWeatherAPI.class);
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param cityid
	 * @return
	 * <Li>返回个格式为json
	 * <Li>aqi 空气质量
	 * <Li>basic 城市基本信息
	 * <Li>daily_forecast 一周的天气预报
	 * <Li>hourly_forecast 每小时天气预报
	 * <Li>now 实况天气
	 */
	@RequestMapping(value="/queryApi")
	public @ResponseBody String QueryApi(HttpServletRequest request,HttpServletResponse response,String cityid){
		String  httpUrl = "##";
		httpUrl = httpUrl.replace("CITYID", cityid);
		log.info("The method QueryApi httpUrl:"+httpUrl);
		String jsonResult = GetAPI(httpUrl);
		return jsonResult;
	}
	
	
	/**
	 * <实时查询全部城市的aqi>
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/queryAqi")
	public @ResponseBody String QueryAqi(HttpServletRequest request,HttpServletResponse response){
		String  httpUrl = "##";
		String jsonResult = "";
		System.out.println(count);
		if(count++ > 0){  //已经访问过了 ，  使用本地的数据(仅供本地测试时使用)
			log.info("The method request local:D:/aqi.json");
			jsonResult = TestData("D:/aqi.json");
		}else{
			log.info("The method request net path :"+httpUrl);
			jsonResult = GetAqi(httpUrl,"D:/aqi.json");
		}
		return jsonResult;
	}
	
	/**
	 * <实时查询根据城市名>
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/queryAqiByCityName")
	public @ResponseBody String QueryAqiByCityName(HttpServletRequest request,HttpServletResponse response,String cityName){
		String  httpUrl = "##";
		httpUrl = httpUrl.replace("CITYNAME", cityName);
		log.info("The method QueryAqi httpUrl:"+httpUrl+",CITYNAME:"+cityName);
		String jsonResult = GetAqi(httpUrl,"D:/"+cityName+".json");
		return jsonResult;
	}
	
	protected String GetAPI(String httpUrl) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		try {
			URL url = new URL(httpUrl);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead); 
				sbf.append("\r\n");
			}
			reader.close();
			sbf.replace(2, 28, "data");
			result = sbf.toString();
		} catch (Exception e) { 
			e.printStackTrace(); 
			log.error(String.format("查询API异常: %s", e.getMessage()),e);
			result = "";
		}
		return result;
	}
	
	private String GetAqi(String httpUrl,String path){
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		try {
			
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead); 
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();  //获取到数据了
			if(result.length() < 50 || result == null){ //说明请求的次数用完了 
				log.info("请求的次数用完了读取 "+path+"里面的数据");
				result = FileUtilToJson.readJson(path);
			}
			else{
				FileUtilToJson.writeJson(path, sbf,"");
				log.info("The method Write to "+path+" success");
			}
		}
		catch(UnknownHostException e){
			log.info("The net bad connect "+e.getMessage());
			result = FileUtilToJson.readJson(path);
		}
		catch (IOException e) {
			log.info("The method Write to "+path+" unsuccess "+e.getMessage());
			result = FileUtilToJson.readJson(path);
		}
	//	result = FileUtilToJson.readJson(path);
		return result;
	}
	
	private String TestData(String path){
		String result = "";
		result = FileUtilToJson.readJson(path);
		return result;
	}

}
