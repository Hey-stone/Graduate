/*
 * 文 件 名:  ResultResponse.java
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
 * 详细数据返回对象
 * 
 * @author  冯亚军
 * @version  [版本号, 2016-1-20]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ResultResponse<T> extends BaseResponse
{

    /**
     * 注释内容
     */
    private static final long serialVersionUID = -4717222227900626520L;
    
    /**
     * 详细数据对象
     */
    private T result;

    public ResultResponse()
    {
        super();
    }

    public ResultResponse(String respCode, String respDesc)
    {
        super(respCode, respDesc);
    }

    public T getResult()
    {
        return result;
    }

    public void setResult(T result)
    {
        this.result = result;
    }
}
