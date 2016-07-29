package com.stone.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import sun.misc.BASE64Decoder;


/**
 * 参数验证工具类
 * <功能详细描述>
 * 
 * @author  陈智
 * @version  [版本号, 2013-11-6]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class MsgUtil {

	final static int BUFFER_SIZE = 4096;
	/*
	 * 存放区域和对应省份的表名和字段名之间映射
	 */
	public final static Map<String, String> AREA_TABLECOL_MAP = new HashMap<String, String>();
	
	public final static Map<String, Map<String, String>> AREA_CODE_MSG_MAP = new HashMap<String, Map<String, String>>();
	
	static{
		// 初始化map
		AREA_TABLECOL_MAP.put("110000", "cu_beifen_order_info,error_code");
		AREA_TABLECOL_MAP.put("420000", "cuhubei_user_gain_package_info,respcode");
		AREA_TABLECOL_MAP.put("310000", "cu_shanghai_order_info,pay");
		AREA_TABLECOL_MAP.put("330000", "cu_zhejiang_order_info,error_code");
		
		//北京
		Map<String, String> map = new HashMap<String, String>();
		map.put("0", "余额不足。");
		map.put("-2", "赠送流量产品订购受限!");
		map.put("-1", "此号码无可订购产品!");
		map.put("30002", "用户已经办理/或不需要取消服务");
		map.put("30004", "套餐内必选产品，业务无法继续!");
		map.put("30026", "特殊限制判断:用户当前存在组合业务关系");
		map.put("30029", "用户具有不能办理该业务的服务状态。");
		map.put("30037", "用户有未完工的业务限制!");
		map.put("60010", "根据号码获取网别无数据或者该号码已销号!");
		map.put("1000", "系统错误");
		map.put("00000", "订购成功");
		map.put("00002", "订购失败");
		AREA_CODE_MSG_MAP.put("110000", map);
		//湖北
		map = new HashMap<String, String>();
		map.put("0", "订购成功");
		map.put("-1", "业务正在受理中");
		map.put("2", "与已订购的其他产品冲突");
		map.put("99", "其他原因：原因有：用户资费变更状态、用户为OCS用户、用户已停机。");
		map.put("2008", "IP未被授权");
		map.put("5002", "参数错误");
		map.put("9002", "可赠送量不足");
		map.put("1000", "系统错误");
		map.put("00001", "订购接受");
		map.put("00002", "订购失败");
		AREA_CODE_MSG_MAP.put("420000", map);
		//上海
		map = new HashMap<String, String>();
		map.put("0", "订购成功");
		map.put("1", "订购失败");
		map.put("2", "已订购");
		map.put("3", "主套餐不能订购该业务");
		map.put("1000", "系统错误");
		AREA_CODE_MSG_MAP.put("310000", map);
		//浙江
		map = new HashMap<String, String>();
		map.put("00", "订购成功");
		map.put("01", "浙江订购系统故障");
		map.put("02", "缴费账户不存在");
		map.put("1000", "系统错误");
		map.put("00000", "订购成功");
		map.put("00002", "订购失败");
		AREA_CODE_MSG_MAP.put("330000", map);
		//全网
		map = new HashMap<String, String>();
		map.put("0001", "没有权限");
		map.put("0102", "落地结点:发送请求至落地机构IO异常");
		map.put("0115", "一级路由出错");
		map.put("1009", "报文异常");
		map.put("300041", "必选业务包：(OCS)后向国内流量包没有选择，业务无法继续！");
		map.put("8888", "没有订购产品的权限");
		AREA_CODE_MSG_MAP.put("", map);
	}

	public static String InputStreamToString(InputStream in) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		int count = -1;
		while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
			outStream.write(data, 0, count);
		data = null;
		return new String(outStream.toByteArray(), "UTF-8");
	}

	public static String decodeBase64(String s) {
		String rstString = null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			rstString = new String(b);
		} catch (Exception e) {
			rstString = s;
		}
		return rstString;
	}

	public static String parseMd5Pwd(String md5Pwd) {
		String parsedPwd = null;
		try {
			parsedPwd = getMD5Str(md5Pwd);
			return parsedPwd == null ? md5Pwd : parsedPwd.toUpperCase();
		} catch (Exception ignore) {
			return md5Pwd;
		}
	}

	private static String getMD5Str(String str) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();

			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}

		return md5StrBuff.toString();
	}

	

	public static boolean validIp(String ip, Set<String> ipSet) {
		if (ipSet == null || ipSet.isEmpty()) {
			return true;
		}
		if (ip == null || "".equals(ip.trim())) {
			return false;
		}
		for (String x : ipSet) {
			if(ipSet.size()==1 && "".equals(x.trim())){
				return true;
			}
			if (ip.equals(x)) {
				return true;
			}
			if (x != null && x.contains("*") && ip.contains(x.substring(0, x.length() - 1))) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 用户有效性验证
	 * CUID=IMSI
	 * DEV_ID=IMEI
	 * 判断用户的 IMSI 和 IMEI 不为空，并且都不为0
	 * @param cuid
	 * @param devId
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean isEffectiveUser(String cuid, String devId)
	{
	    /*
	     * 如果 cuid 或  devId 为空，则返回用户无效
	     */
	    if (StringUtils.isBlank(cuid) || StringUtils.isBlank(devId))
	    {
	        return false;
	    }
	    /*
	     * 如果 cuid 或 devId 等于 0，则返回用户无效
	     */
	    if ("0".equals(cuid.trim()) || "0".equals(devId.trim()))
	    {
	        return false;
	    }
	    // 用户基本验证通过
	    return true;
	}
	
	public static void main(String[] args) {
		// System.out.println("18627831033 unicom valid:"+validPhoneNum("18627831033"));
		// System.out.println("18127831033 unicom valid:"+validPhoneNum("18127831033"));
		// System.out.println("18227831033 unicom valid:"+validPhoneNum("18227831033"));
		// System.out.println("18327831033 unicom valid:"+validPhoneNum("18327831033"));
		// System.out.println("18427831033 unicom valid:"+validPhoneNum("18427831033"));
		// System.out.println("18527831033 unicom valid:"+validPhoneNum("18527831033"));
		/*
		Set<String> ipSet = new HashSet<String>() {
			{
				add("66.66.66.66");
				add("66.66.65.*");
				add("66.66.64.23 - 66.66.64.66");
				add("66.66.66.67");
			}
		};

		String ip1 = "66.66.65.66";
		String ip2 = "66.66.66.66";
		String ip3 = "66.66.67.66";
		String ip4 = "66.66.64.66";

		System.out.println(ip1 + " validation:" + validIp(ip1, ipSet));
		System.out.println(ip2 + " validation:" + validIp(ip2, ipSet));
		System.out.println(ip3 + " validation:" + validIp(ip3, ipSet));
		System.out.println(ip4 + " validation:" + validIp(ip4, ipSet));
		*/
	}
}
