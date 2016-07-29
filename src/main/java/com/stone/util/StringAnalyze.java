package com.stone.util;

import java.util.ArrayList;
import java.util.List;

public class StringAnalyze {

	/**
	 * @param args
	 */
	
	//private static final String SPLIT = "|";
	//private static final int AGENT_LENGTH = 17;
	//private static final int FLOW_SERVICE_LENGTH = 11;
	//private static final int DSP_SERVICE_LENGTH = 16;
	//private static final int ISP_ADAPTER_LENGTH = 10;
	//private static final int ISP_LENGTH =16;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 
		String s = "isp|4|aa0965ced97f448fb28f6342f8a3b0ee|chkOrder|flowService_prod|18661250812|20141023235427|0000|688|null||4G全'国组合'套餐|2000|0141023235427114|0000|";

		String diyAgent="diyAgent|1|d9ec50794df343109c03a0e75eecafd0|4aea47a64768af3b014768c1afec0000|orderPkg|4aea47a6477c1bd00147810ffc5c0026|000501|null|13030999214|350000|201410230254546334812_fjunicom|20141023025505|183.232.118.24|20141023025441|1410230254410601|0001|";
		String flowAgent="flowAgent|1|95353af8cd8d4e6794d274900831cf04|4aea47a64768af3b014768c1afec0000|queryOrder|4aea47a6477c1bd00147d28979560397|002001||18649716261|350000||20141023010156|211.144.145.1|20141023010033|1410230100080901|0000|";
		String flowService="flowService|2|5c9e623d47f1467389d43c8a81cdcf40|null|5c7ac0923f7b89d6013f7e4653390006|4aea47a64768af3b014768c1afec0000|20141023010316|1410230102560901|0000|00000|";
		String dspService="dspService|1|b94749905a57404e9155698cf3ead4a0|4aea47a64768af3b014768c1afec0000|4aea47a6465e3de901465e68c8100000|000501||44aa9654f0c0458c9bcbb46b7656c5eb|5c7ac0923f7b89d6013f7e4653390006|13007108296|420000|20141023151237|20141023151456|0000|00000|";
		String ispAdapter="ispAdapter|3|7dd437c00bd54e98bbbd098d89e2ce2e|chkOrder|flowService_prod|15699222028|000000003edf2a1a013ee3024c5a0030|20141023044612|0000|";
		String isp="isp|4|b14135f644034aef875b22892843bacd|pkg_chkOrder|flowService_prod|13027582792|20141023005702|8888|2040|null|null|null|20005|2014102300570106|8888|[INDETERMINATE]CheckAllInfoNodeParser.cpp:5859,CRMException-8888: TradeCheck_SvcstateTradeLimit:用户'具有不'能办理该业'务的服务状态[GSM语音主服务(2gOCS).充值期]！";
		

		// s = "||s|";

		List diyAgentList = splitString(diyAgent, SPLIT, AGENT_LENGTH);
		System.out.println("diyAgentList:"+diyAgentList);
		List flowAgentList = splitString(flowAgent, SPLIT, AGENT_LENGTH);
		System.out.println("flowAgentList:"+flowAgentList);
		List flowServiceList = splitString(flowService, SPLIT, FLOW_SERVICE_LENGTH);
		System.out.println("flowServiceList:"+flowServiceList);
		List dspServiceList = splitString(dspService, SPLIT, DSP_SERVICE_LENGTH);
		System.out.println("dspServiceList:"+dspServiceList);
		List ispAdapterList = splitString(ispAdapter, SPLIT, ISP_ADAPTER_LENGTH);
		System.out.println("ispAdapterList:"+ispAdapterList);
		List ispList = splitString(isp, SPLIT, ISP_LENGTH);
		System.out.println("ispList:"+ispList);
		//System.out.println(list);
		//System.out.println(list.size());
		 */
	}

	/**
	 * 
	 * @param str
	 *            分割的字符串
	 * @param split
	 *            分隔符
	 * @param objectNum
	 *            分割出多少个对象
	 * @return
	 */
	public static final List<String> splitString(String str, String split,
			int objectNum) {
		List<String> list = null;
		if (str == null || str.length() == 0 || split == null
				|| "".equals(split) || objectNum < 1) {
			return list;
		}

		try {
			StringBuffer sbTemp = new StringBuffer("");
			int lastIndex = 0;
			list = new ArrayList<String>();
			for (int i = 0; i < str.length(); i++) {
				if (!split.equals(String.valueOf(str.charAt(i)))) {
					sbTemp.append(str.charAt(i));
				} else {
					list.add(trimNull(sbTemp.toString()));
					sbTemp = new StringBuffer("");

					if (list.size() == objectNum - 1 || objectNum == 1) {
						lastIndex = i + 1;
						break;
					}
				}

			}

			if (list.size() == objectNum) {
				return list;
			} else {
				if (lastIndex >= str.length()) {
					list.add("");
				} else {
					list.add(trimNull(str.substring(lastIndex)));
				}

				return list;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}

	}

	/**
	 * 去空，NULL
	 * 
	 * @param str
	 * @return
	 */
	private static String trimNull(String str) {
		// 如果为null,则转为空字符串
		if (str == null || "null".equals(str)) {
			return "";
		}
		// 将单引号替换成全角
		return str;
	}
}
