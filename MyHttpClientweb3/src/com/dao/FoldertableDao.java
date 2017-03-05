package com.dao;

import java.util.List;

import com.entity.Foldertable;

public interface FoldertableDao {

	public abstract void save(Foldertable transientInstance);

	public abstract void delete(Foldertable persistentInstance);

	public abstract Foldertable findById(java.lang.Integer id);

	public abstract List findByExample(Foldertable instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUserid(Object userid);

	public abstract List findByFileid(Object fileid);

	public abstract List findByFoldername(Object foldername);

	public abstract List findByFatherfolderid(Object fatherfolderid);

	public abstract List findAll();

	public abstract Foldertable merge(Foldertable detachedInstance);

	public abstract void attachDirty(Foldertable instance);

	public abstract void attachClean(Foldertable instance);

	List showfloder(String id);

	List showchildfloder(String fatherid);

	List showfatherfloder(String folderid);

	void updatefol(Foldertable foldertable);

}