package com.dao.impl;

import com.dao.FoldertableDao;
import com.entity.Foldertable;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * Foldertable entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.entity.Foldertable
 * @author MyEclipse Persistence Tools
 */
@Repository
public class FoldertableDAOimpl extends BaseHibernateDAOimpl implements FoldertableDao {
	private static final Log log = LogFactory.getLog(FoldertableDAOimpl.class);
	// property constants
	public static final String USERID = "userid";
	public static final String FILEID = "fileid";
	public static final String FOLDERNAME = "foldername";
	public static final String FATHERFOLDERID = "fatherfolderid";

	/* (non-Javadoc)
	 * @see com.dao.impl.FoldertableDao#save(com.entity.Foldertable)
	 */
	@Override
	public void save(Foldertable transientInstance) {
		log.debug("saving Foldertable instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FoldertableDao#delete(com.entity.Foldertable)
	 */
	@Override
	public void delete(Foldertable persistentInstance) {
		log.debug("deleting Foldertable instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FoldertableDao#findById(java.lang.Integer)
	 */
	@Override
	public Foldertable findById(java.lang.Integer id) {
		log.debug("getting Foldertable instance with id: " + id);
		try {
			Foldertable instance = (Foldertable) getSession().get(
					"com.entity.Foldertable", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FoldertableDao#findByExample(com.entity.Foldertable)
	 */
	@Override
	public List findByExample(Foldertable instance) {
		log.debug("finding Foldertable instance by example");
		try {
			List results = getSession()
					.createCriteria("com.entity.Foldertable")
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
	 * @see com.dao.impl.FoldertableDao#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Foldertable instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Foldertable as model where model."
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
	 * @see com.dao.impl.FoldertableDao#findByUserid(java.lang.Object)
	 */
	@Override
	public List findByUserid(Object userid) {
		return findByProperty(USERID, userid);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FoldertableDao#findByFileid(java.lang.Object)
	 */
	@Override
	public List findByFileid(Object fileid) {
		return findByProperty(FILEID, fileid);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FoldertableDao#findByFoldername(java.lang.Object)
	 */
	@Override
	public List findByFoldername(Object foldername) {
		return findByProperty(FOLDERNAME, foldername);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FoldertableDao#findByFatherfolderid(java.lang.Object)
	 */
	@Override
	public List findByFatherfolderid(Object fatherfolderid) {
		return findByProperty(FATHERFOLDERID, fatherfolderid);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FoldertableDao#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Foldertable instances");
		try {
			String queryString = "from Foldertable";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FoldertableDao#merge(com.entity.Foldertable)
	 */
	@Override
	public Foldertable merge(Foldertable detachedInstance) {
		log.debug("merging Foldertable instance");
		try {
			Foldertable result = (Foldertable) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FoldertableDao#attachDirty(com.entity.Foldertable)
	 */
	@Override
	public void attachDirty(Foldertable instance) {
		log.debug("attaching dirty Foldertable instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.FoldertableDao#attachClean(com.entity.Foldertable)
	 */
	@Override
	public void attachClean(Foldertable instance) {
		log.debug("attaching clean Foldertable instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	//显示文件夹
	@Override
	public List showfloder(String id){
		int id3=Integer.parseInt(id);
     	String fatherid="0";
		String hql = "from Foldertable q where q.userid=? and q.fatherfolderid=?";
		Query foldertable = getSession().createQuery(hql);
		foldertable.setParameter(0, id3);
		foldertable.setParameter(1, fatherid);
		System.out.println("Dao*********"+foldertable.list().size());
		return foldertable.list();
	}
	
	//显示子文件夹
	@Override
	public List showchildfloder(String fatherid){	
		String hql = "from Foldertable q where q.fatherfolderid=?";
		Query folderchildtable = getSession().createQuery(hql);
		folderchildtable.setParameter(0, fatherid);
		return folderchildtable.list();
	}
	
	//显示父文件夹
		@Override
		public List showfatherfloder(String folderid){
			//QuestionTable questionTable=(QuestionTable)getSession().get();
			System.out.println("id+++++"+folderid);
			int id=Integer.parseInt(folderid);
			String hql = "from Foldertable q where q.folderid=?";
			Query folderchildtable = getSession().createQuery(hql);
			folderchildtable.setParameter(0, id);
			System.out.println("长度"+folderchildtable.list().size());
			return folderchildtable.list();
		}
		
	//更新folderytable
		@Override
		public void updatefol(Foldertable foldertable){
			if(foldertable!=null){
				getSession().update(foldertable);
			}
		}
		
}