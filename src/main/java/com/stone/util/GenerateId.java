package com.stone.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.stone.util.DateUtil;



/**
 * 订单生成规则
 * 暂时定为16位，12位时间戳编号(yyMMddHHmmss) + 1位机器编号 + 3位编号
 * 20140211000001
 * 内部存储
 * @author wangzhi
 *
 */
public class GenerateId {
	private static Logger logger = Logger.getLogger(GenerateId.class);
	
	private static Map<String, FlowCommAuditDTO> flowCommAuditMap = new HashMap<String, FlowCommAuditDTO>();
	private static Long orderSeqMaxVal;
	
	private static final String KEY = "orderNum";
	
	static
	{
		// 订单编号中序列的在最大值
		orderSeqMaxVal = 999l;
	}
	
	/**
	 * 得到序列最大值的长度
	 * @return
	 */
	public static int getLength(){
		return String.valueOf(orderSeqMaxVal).length();
	}
	
	/**
	 * 根据订单编号，计算订单
	 * @return
	 */
	public synchronized static String getNextOrderNum(String machineId)
	{
		FlowCommAuditDTO flowCommDTO = flowCommAuditMap.get(KEY);
		String date = DateUtil.convertDate2String(new Date(), "yyMMddHHmmss");
		
		if (flowCommDTO == null)
		{
			flowCommDTO = new FlowCommAuditDTO(); 
			flowCommDTO.setSeq(1);
			flowCommDTO.setDate(DateUtil.convertDate2String(new Date(), "yyMMddHHmmss"));
			flowCommDTO.setMachineId(machineId);
		}
		else
		{
			Integer tmpSeq = flowCommDTO.getSeq() + 1;
			String tmpDate = flowCommDTO.getDate();
			// 时间戳相同
			if (date.equals(tmpDate))
			{				
				// 序列到达额定值
				if (tmpSeq > orderSeqMaxVal)
				{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						logger.error(e.getMessage());
					}
					tmpDate = DateUtil.convertDate2String(new Date(), "yyMMddHHmmss");
					tmpSeq = 1;
				}
			}
			else
			{
				// 时间戳不相同，时间戳为新的时间，序列为1
				tmpDate = date;
				tmpSeq = 1;
			}
			
			flowCommDTO.setSeq(tmpSeq);
			flowCommDTO.setDate(tmpDate);
		}		
		
		flowCommAuditMap.put(KEY, flowCommDTO);
		
		return flowCommDTO.toString();
	}
	
	public static void main(String[] args)
	{
//		for (int i="12".length(); i<"1234".length(); i++)
//		{
//			System.out.println("========");
//		}
//		String date = DateUtil.convertDate2String(new Date(), "yyMMddHHmmss");
//		date += "1234";
//		System.out.println("1234".length());
		
		for(int i=0;i<1010;i++){
			System.out.println(getNextOrderNum("1"));;
		}
	}
	
}

class FlowCommAuditDTO
{
	private String date;
	private Integer seq;
	//private String customerFlag;
	private String machineId;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
//	public String getCustomerFlag() {
//		return customerFlag;
//	}
//	public void setCustomerFlag(String customerFlag) {
//		this.customerFlag = customerFlag;
//	}
	public String getMachineId() {
		return machineId;
	}
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	public String toString()
	{
		String seqTep = seq + "";
		String tempSetTep = seqTep;
		for(int i=seqTep.length();i<GenerateId.getLength();i++){
			tempSetTep = "0" + tempSetTep;
		}
			
		return date + machineId + tempSetTep;
	}
}
