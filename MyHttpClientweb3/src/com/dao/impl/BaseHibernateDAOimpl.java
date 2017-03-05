package com.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.BaseHibernateDao;
import com.entity.HibernateSessionFactory;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAOimpl implements IBaseHibernateDAOimpl, BaseHibernateDao {
	
	/* (non-Javadoc)
	 * @see com.dao.impl.BaseHibernateDao#getSession()
	 */
	@Resource
	SessionFactory sessionFactory;
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}