/*
 * 文 件 名:  BaseQueryParam.java
 * 版    权:  ETOC 信息技术有限公司, Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  WeiXuan
 * 修改时间:  2016-1-21
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.stone.common;

import java.io.Serializable;

/**
 * 查询参数基类（分页查询使用）
 * 
 * @author  冯亚军
 * @version  [版本号, 2016-1-21]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public abstract class BaseQueryParam implements Serializable
{
    private static final long serialVersionUID = 7466651601785384228L;

    /**
     * 页码
     */
    private Integer pageNo = 1;
    
    /**
     * 每页条数
     */
    private Integer pageSize = 10;

    public Integer getPageNo()
    {
        return pageNo;
    }

    public void setPageNo(Integer pageNo)
    {
        this.pageNo = pageNo;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }
    
}
