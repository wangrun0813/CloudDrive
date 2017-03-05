package com.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import com.dao.FiletableDao;
import com.entity.Filetable;
import com.entity.Foldertable;

/**
 * A data access object (DAO) providing persistence and search support for
 * Filetable entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.entity.Filetable
 * @author MyEclipse Persistence Tools
 */
@Repository
public class FiletableDAOimpl extends BaseHibernateDAOimpl implements FiletableDao {
	private static final Log log = LogFactory.getLog(FiletableDAOimpl.class);
	// property constants
	public static final String FILENAME = "filename";
	public static final String HASHUMBER = "hashumber";
	public static final String FILESIZE = "filesize";
	public static final String FILETYPE = "filetype";
	public static final String UPLOADTIME = "uploadtime";

	/* (non-Javadoc)
	 * @see com.dao.impl.FiletableDao#save(com.entity.Filetable)
	 */
	@Override
	public void save(Filetable transientInstance) {
		log.debug("saving Filetable instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FiletableDao#delete(com.entity.Filetable)
	 */
	@Override
	public void delete(Filetable persistentInstance) {
		log.debug("deleting Filetable instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FiletableDao#findById(java.lang.Integer)
	 */
	@Override
	public Filetable findById(java.lang.Integer id) {
		log.debug("getting Filetable instance with id: " + id);
		try {
			Filetable instance = (Filetable) getSession().get(
					"com.entity.Filetable", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FiletableDao#findByExample(com.entity.Filetable)
	 */
	@Override
	public List findByExample(Filetable instance) {
		log.debug("finding Filetable instance by example");
		try {
			List results = getSession().createCriteria("com.entity.Filetable")
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
	 * @see com.dao.impl.FiletableDao#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Filetable instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Filetable as model where model."
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
	 * @see com.dao.impl.FiletableDao#findByFilename(java.lang.Object)
	 */
	@Override
	public List findByFilename(Object filename) {
		return findByProperty(FILENAME, filename);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FiletableDao#findByHashumber(java.lang.Object)
	 */
	@Override
	public List findByHashumber(Object hashumber) {
		return findByProperty(HASHUMBER, hashumber);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FiletableDao#findByFilesize(java.lang.Object)
	 */
	@Override
	public List findByFilesize(Object filesize) {
		return findByProperty(FILESIZE, filesize);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FiletableDao#findByFiletype(java.lang.Object)
	 */
	@Override
	public List findByFiletype(Object filetype) {
		return findByProperty(FILETYPE, filetype);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FiletableDao#findByUploadtime(java.lang.Object)
	 */
	@Override
	public List findByUploadtime(Object uploadtime) {
		return findByProperty(UPLOADTIME, uploadtime);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FiletableDao#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Filetable instances");
		try {
			String queryString = "from Filetable";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FiletableDao#merge(com.entity.Filetable)
	 */
	@Override
	public Filetable merge(Filetable detachedInstance) {
		log.debug("merging Filetable instance");
		try {
			Filetable result = (Filetable) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FiletableDao#attachDirty(com.entity.Filetable)
	 */
	@Override
	public void attachDirty(Filetable instance) {
		log.debug("attaching dirty Filetable instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FiletableDao#attachClean(com.entity.Filetable)
	 */
	@Override
	public void attachClean(Filetable instance) {
		log.debug("attaching clean Filetable instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	@Override
	public void updatefile(Filetable filetable){
		if(filetable!=null){
			getSession().update(filetable);
		}
	}
}