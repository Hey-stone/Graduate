package com.stone.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stone.dao.NoTypeDao;


/**
 * 
 * @author  冯亚军
 * @version  [版本号, 2016-4-16]
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class NoTypeDaoImpl implements NoTypeDao
{
    @Resource
    protected SessionFactory sessionFactory;

    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public <T> T getObject(Class<T> objClass, Serializable key)
    {
        return (T)this.getSession().get(objClass, key);
    }
    
    @SuppressWarnings("deprecation")
    public <T> T getObject(Class<T> objClass, Serializable key, LockMode lockMode)
    {
        return (T)this.getSession().get(objClass, key, lockMode);
    }
    
    public Serializable saveObject(Object obj)
    {
        return this.getSession().save(obj);
    }
    
    public void updateObject(Object obj)
    {
        this.getSession().update(obj);
    }
    
    public void deleteObject(Object obj)
    {
        this.getSession().delete(obj);
    }
    
    public void deleteAllObject(Collection col)
    {
        Object entity = null;
        for(Iterator itr = col.iterator(); itr.hasNext(); this.getSession().delete(entity))
            entity = itr.next();
    }
    
    public Collection getAllObject(Class objClass)
    {
        String hqlListAll = String.format("from %s ", objClass.getSimpleName());
        Query query = this.getSession().createQuery(hqlListAll);
        return query.list();
    }
    
    public void saveOrUpdate(Object obj)
    {
        this.getSession().saveOrUpdate(obj);
    }
    
    public void merge(Object obj)
    {
        this.getSession().merge(obj);
    }
    
    public void flush()
    {
        this.getSession().flush();
    }
    
    public void refesh(Object obj)
    {
        this.getSession().refresh(obj);
    }
    
    @SuppressWarnings("deprecation")
    public void refesh(Object obj, LockMode lockMode)
    {
        this.getSession().refresh(obj, lockMode);
    }
    
    public void clear()
    {
        this.getSession().clear();
    }
    
    protected <T> T aggregate(final String hql, final Map paramMap)
    {
        Query query = this.getSession().createQuery(hql);
        if (paramMap != null)
        {
            query.setProperties(paramMap);
        }
        return (T)query.uniqueResult();
    }
    
    protected <T> List<T> list(final String hql, final int pageNo, final int pageSize, final Map parammap)
    {
        Query query = this.getSession().createQuery(hql);
        query.setProperties(parammap);
        
        if (pageNo > -1 && pageSize > -1)
        {
            query.setMaxResults(pageSize);
            int start = (pageNo - 1) * pageSize;
            if (start != 0)
            {
                query.setFirstResult(start);
            }
        }
        if (pageNo < 0)
        {
            query.setFirstResult(0);
        }
        
        List<T> results = query.list();
        return results;
    }
    
    protected <T> T aggregateBySql(final String sql, final Map paramMap)
    {
        Query query = this.getSession().createSQLQuery(sql);
        if (paramMap != null)
        {
            query.setProperties(paramMap);
        }
        return (T)query.uniqueResult();
    }
    
    protected <T> List<T> listBySql(final String sql, final int pageNo, final int pageSize, final Map parammap)
    {
        Query query = this.getSession().createSQLQuery(sql);
        query.setProperties(parammap);
        
        if (pageNo > -1 && pageSize > -1)
        {
            query.setMaxResults(pageSize);
            int start = (pageNo - 1) * pageSize;
            if (start != 0)
            {
                query.setFirstResult(start);
            }
        }
        if (pageNo < 0)
        {
            query.setFirstResult(0);
        }
        
        List<T> results = query.list();
        return results;
    }
    
    protected Map convert2Map(Object bean)
    {
        Map values = null;
        try
        {
            values = PropertyUtils.describe(bean);
        }
        catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e1)
        {
            e1.printStackTrace();
        };
        return values;
    }
}
