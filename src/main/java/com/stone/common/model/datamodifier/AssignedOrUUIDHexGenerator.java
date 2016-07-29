package com.stone.common.model.datamodifier;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.UUIDHexGenerator;
import org.hibernate.type.Type;

/**
 * 自定义或UUID生成主键策略
 * <p>
 * 原理:
 * <li>Entity实体对象id有值则使用该值作id
 * <li>Entity实体对象id为空则使用UUID策略生成作id
 * </p>
 * 
 * @author WeiXuan
 */
public final class AssignedOrUUIDHexGenerator extends UUIDHexGenerator
{
    private String entityName;

    public Serializable generate(SessionImplementor session, Object obj) throws HibernateException {
        Serializable id = session.getEntityPersister( entityName, obj ).getIdentifier( obj, session );
        if ( id == null ) {
            id = super.generate(session, obj);
        }
        return id;
    }

    public void configure(Type type, Properties params, Dialect d) throws MappingException {
        entityName = params.getProperty(ENTITY_NAME);
        if ( entityName == null ) {
            throw new MappingException("no entity name");
        }
        super.configure(type, params, d);
    }
	
}