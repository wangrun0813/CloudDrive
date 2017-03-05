package com.dao;

import org.hibernate.Session;

public interface IBaseHibernateDao {

	public abstract Session getSession();

}