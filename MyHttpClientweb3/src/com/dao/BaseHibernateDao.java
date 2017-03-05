package com.dao;

import org.hibernate.Session;

public interface BaseHibernateDao {

	public abstract Session getSession();

}