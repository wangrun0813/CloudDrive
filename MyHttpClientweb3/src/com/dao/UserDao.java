package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {

	public abstract void save(User transientInstance);

	public abstract void delete(User persistentInstance);

	public abstract User findById(java.lang.Integer id);

	public abstract List findByExample(User instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByPassword(Object password);

	public abstract List findByUsermane(Object usermane);

	public abstract List findByContant(Object contant);

	public abstract List findByUserphoto(Object userphoto);

	public abstract List findAll();

	public abstract User merge(User detachedInstance);

	public abstract void attachDirty(User instance);

	public abstract void attachClean(User instance);

}