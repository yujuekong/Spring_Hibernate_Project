package com.smart.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDao<T> {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	private Class<T> entityClass;
	
	//通过反射获取子类确定的泛型类
	public BaseDao(){
		Type genType = getClass().getGenericSuperclass();
		Type[] param = ((ParameterizedType)genType).getActualTypeArguments();
		entityClass = (Class) param[0];
	}
	
	 /**
     * 根据ID加载PO实例
     *
     * @param id
     * @return 返回相应的持久化PO实例
     */
    public T load(Serializable id) {
        return (T) getHibernateTemplate().load(entityClass, id);
    }

    /**
     * 根据ID获取PO实例
     *
     * @param id
     * @return 返回相应的持久化PO实例
     */
    public T get(Serializable id) {
        return (T) getHibernateTemplate().get(entityClass, id);
    }

    /**
     * 获取PO的所有对象
     *
     * @return
     */
    public List<T> loadAll() {
        return getHibernateTemplate().loadAll(entityClass);
    }
    
    /**
     * 保存po
     * @param entity
     */
    public void save(T entity){
    	this.getHibernateTemplate().save(entity);
    }
    
    /**
     * 更改po
     * @param entity
     */
    public void update(T entity){
    	getHibernateTemplate().update(entity);
    }
    
    /**
     * 删除po
     * @param entity
     */
    public void remove(T entity){
    	getHibernateTemplate().delete(entity);
    }
    
    /**
     * 执行HQL查询
     * @param hql
     * @return
     */
    public List<T> find(String hql){
    	return getHibernateTemplate().find(hql);
    }
    
    /**
     * 执行带参的HQL查询
     */
    public List<T> find(String hql,Object... params){
    	return getHibernateTemplate().find(hql, params);
    }
	
    /**
     * 对延迟加载的实体po执行初始化
     */
    public void initialize(Object entity){
    	getHibernateTemplate().initialize(entity);
    }
    
    public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
