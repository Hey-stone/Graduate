/*
 * 文 件 名:  BaseResponse.java
 * 版    权:  ETOC 信息技术有限公司, Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  WeiXuan
 * 修改时间:  2016-1-20
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.stone.common;

import java.io.Serializable;

/**
 * 返回对象基类
 * <功能详细描述>
 * 
 * @author  冯亚军
 * @version  [版本号, 2016-1-20]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public abstract class BaseResponse implements Serializable
{

    /**
     * 注释内容
     */
    private static final long serialVersionUID = -1636103463333051834L;
    
    private String respCode;
    
    private String respDesc;

    public BaseResponse()
    {
        super();
    }

    public BaseResponse(String respCode, String respDesc)
    {
        super();
        this.respCode = respCode;
        this.respDesc = respDesc;
    }

    public String getRespCode()
    {
        return respCode;
    }

    public void setRespCode(String respCode)
    {
        this.respCode = respCode;
    }

    public String getRespDesc()
    {
        return respDesc;
    }

    public void setRespDesc(String respDesc)
    {
        this.respDesc = respDesc;
    }
    
}
