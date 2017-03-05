package com.dao.impl;

import com.dao.SharefiletableDao;
import com.entity.Sharefiletable;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * Sharefiletable entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.entity.Sharefiletable
 * @author MyEclipse Persistence Tools
 */
@Repository
public class SharefiletableDAOimpl extends BaseHibernateDAOimpl implements SharefiletableDao {
	private static final Log log = LogFactory.getLog(SharefiletableDAOimpl.class);
	// property constants
	public static final String HASHNUMBER = "hashnumber";
	public static final String FILEPSWD = "filepswd";

	/* (non-Javadoc)
	 * @see com.dao.impl.SharefiletableDao#save(com.entity.Sharefiletable)
	 */
	@Override
	public void save(Sharefiletable transientInstance) {
		log.debug("saving Sharefiletable instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.SharefiletableDao#delete(com.entity.Sharefiletable)
	 */
	@Override
	public void delete(Sharefiletable persistentInstance) {
		log.debug("deleting Sharefiletable instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.SharefiletableDao#findById(java.lang.Integer)
	 */
	@Override
	public Sharefiletable findById(java.lang.Integer id) {
		log.debug("getting Sharefiletable instance with id: " + id);
		try {
			Sharefiletable instance = (Sharefiletable) getSession().get(
					"com.entity.Sharefiletable", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.SharefiletableDao#findByExample(com.entity.Sharefiletable)
	 */
	@Override
	public List findByExample(Sharefiletable instance) {
		log.debug("finding Sharefiletable instance by example");
		try {
			List results = getSession()
					.createCriteria("com.entity.Sharefiletable")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.SharefiletableDao#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Sharefiletable instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Sharefiletable as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.SharefiletableDao#findByHashnumber(java.lang.Object)
	 */
	@Override
	public List findByHashnumber(Object hashnumber) {
		return findByProperty(HASHNUMBER, hashnumber);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.SharefiletableDao#findByFilepswd(java.lang.Object)
	 */
	@Override
	public List findByFilepswd(Object filepswd) {
		return findByProperty(FILEPSWD, filepswd);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.SharefiletableDao#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Sharefiletable instances");
		try {
			String queryString = "from Sharefiletable";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.SharefiletableDao#merge(com.entity.Sharefiletable)
	 */
	@Override
	public Sharefiletable merge(Sharefiletable detachedInstance) {
		log.debug("merging Sharefiletable instance");
		try {
			Sharefiletable result = (Sharefiletable) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.SharefiletableDao#attachDirty(com.entity.Sharefiletable)
	 */
	@Override
	public void attachDirty(Sharefiletable instance) {
		log.debug("attaching dirty Sharefiletable instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.SharefiletableDao#attachClean(com.entity.Sharefiletable)
	 */
	@Override
	public void attachClean(Sharefiletable instance) {
		log.debug("attaching clean Sharefiletable instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}