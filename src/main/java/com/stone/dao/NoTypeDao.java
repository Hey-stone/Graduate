package com.stone.dao;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.LockMode;

/**
 * 自定义NoTypeDao
 * 
 * @author  冯亚军
 * @version  [版本号, 2016-1-21]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@SuppressWarnings("rawtypes")
public interface NoTypeDao
{
    
    public <T> T getObject(Class<T> objClass, Serializable key);
    
    public <T> T getObject(Class<T> objClass, Serializable key, LockMode lockMode);
    
    public Serializable saveObject(Object obj);
    
    public void updateObject(Object obj);
    
    public void deleteObject(Object obj);
    
    public void deleteAllObject(Collection col);
    
    public Collection getAllObject(Class objClass);
    
    public void saveOrUpdate(Object obj);
    
    public void merge(Object obj);
    
    public void flush();
    
    public void refesh(Object obj);
    
    public void refesh(Object obj, LockMode lockMode);
    
    public void clear();
}
