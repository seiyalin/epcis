package org.fudan.wuxi.syfw.model.hibentity;

import java.sql.Time;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Market entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.fudan.wuxi.syfw.model.hibentity.Market
 * @author MyEclipse Persistence Tools
 */
public class MarketDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MarketDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String LOGIS_NO = "logisNo";
	public static final String LOCATION = "location";
	public static final String TOP_MANAGER = "topManager";

	public void save(Market transientInstance) {
		log.debug("saving Market instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Market persistentInstance) {
		log.debug("deleting Market instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Market findById(java.lang.String id) {
		log.debug("getting Market instance with id: " + id);
		try {
			Market instance = (Market) getSession().get(
					"org.fudan.wuxi.syfw.model.hibentity.Market", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Market instance) {
		log.debug("finding Market instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"org.fudan.wuxi.syfw.model.hibentity.Market")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Market instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Market as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByLogisNo(Object logisNo) {
		return findByProperty(LOGIS_NO, logisNo);
	}

	public List findByLocation(Object location) {
		return findByProperty(LOCATION, location);
	}

	public List findByTopManager(Object topManager) {
		return findByProperty(TOP_MANAGER, topManager);
	}

	public List findAll() {
		log.debug("finding all Market instances");
		try {
			String queryString = "from Market";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Market merge(Market detachedInstance) {
		log.debug("merging Market instance");
		try {
			Market result = (Market) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Market instance) {
		log.debug("attaching dirty Market instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Market instance) {
		log.debug("attaching clean Market instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}