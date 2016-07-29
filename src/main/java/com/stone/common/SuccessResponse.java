/*
 * 文 件 名:  SuccessResponse.java
 * 版    权:  ETOC 信息技术有限公司, Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  WeiXuan
 * 修改时间:  2016-1-20
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.stone.common;


/**
 * 成功与否返回对象
 * <功能详细描述>
 * 
 * @author  冯亚军
 * @version  [版本号, 2016-1-20]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class SuccessResponse extends BaseResponse
{

    /**
     * 注释内容
     */
    private static final long serialVersionUID = 1695739185240219380L;
    
    /**
     * 执行结果
     */
    private String success;

    public SuccessResponse()
    {
        super();
    }

    public SuccessResponse(String respCode, String respDesc)
    {
        super(respCode, respDesc);
    }

    public String getSuccess()
    {
        return success;
    }

    public void setSuccess(String success)
    {
        this.success = success;
    }
}
