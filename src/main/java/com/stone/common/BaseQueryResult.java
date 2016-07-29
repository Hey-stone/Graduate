/*
 * 文 件 名:  BaseQueryResult.java
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
 * 查询结果基类
 * 
 * @author  冯亚军
 * @version  [版本号, 2016-1-20]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public abstract class BaseQueryResult implements Serializable
{
    
    private static final long serialVersionUID = 8651594773619753494L;

    /**
     * 页码
     */
    private Integer pageNo;
    
    /**
     * 每页条数
     */
    private Integer pageSize;
    
    /**
     * 总数
     */
    private Long totalCount;

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

    public Long getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(Long totalCount)
    {
        this.totalCount = totalCount;
    }
    
    public void recordPageParam(BaseQueryParam queryParam, long totalCount)
    {
        this.pageNo = queryParam.getPageNo();
        this.pageSize = queryParam.getPageSize();
        this.totalCount = totalCount;
    }
}
