package com.dao;

import java.util.List;

import com.entity.Filetable;

public interface FiletableDao {

	public abstract void save(Filetable transientInstance);

	public abstract void delete(Filetable persistentInstance);

	public abstract Filetable findById(java.lang.Integer id);

	public abstract List findByExample(Filetable instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByFilename(Object filename);

	public abstract List findByHashumber(Object hashumber);

	public abstract List findByFilesize(Object filesize);

	public abstract List findByFiletype(Object filetype);

	public abstract List findByUploadtime(Object uploadtime);

	public abstract List findAll();

	public abstract Filetable merge(Filetable detachedInstance);

	public abstract void attachDirty(Filetable instance);

	public abstract void attachClean(Filetable instance);

	void updatefile(Filetable filetable);

}