package com.dao;

import java.util.List;

import com.entity.Sharefiletable;

public interface SharefiletableDao {

	public abstract void save(Sharefiletable transientInstance);

	public abstract void delete(Sharefiletable persistentInstance);

	public abstract Sharefiletable findById(java.lang.Integer id);

	public abstract List findByExample(Sharefiletable instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByHashnumber(Object hashnumber);

	public abstract List findByFilepswd(Object filepswd);

	public abstract List findAll();

	public abstract Sharefiletable merge(Sharefiletable detachedInstance);

	public abstract void attachDirty(Sharefiletable instance);

	public abstract void attachClean(Sharefiletable instance);

}