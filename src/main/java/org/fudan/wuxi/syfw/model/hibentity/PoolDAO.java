package org.fudan.wuxi.syfw.model.hibentity;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Pool
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see org.fudan.wuxi.syfw.model.hibentity.Pool
 * @author MyEclipse Persistence Tools
 */
public class PoolDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(PoolDAO.class);
	// property constants
	public static final String BRE_ID = "breId";
	public static final String WAT_ID = "watId";
	public static final String NAME = "name";
	public static final String AREA = "area";
	public static final String RESPONSER = "responser";
	public static final String PHONE = "phone";
	public static final String ADDRESS = "address";

	public void save(Pool transientInstance) {
		log.debug("saving Pool instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Pool persistentInstance) {
		log.debug("deleting Pool instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pool findById(java.lang.String id) {
		log.debug("getting Pool instance with id: " + id);
		try {
			Pool instance = (Pool) getSession().get(
					"org.fudan.wuxi.syfw.model.hibentity.Pool", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Pool instance) {
		log.debug("finding Pool instance by example");
		try {
			List results = getSession()
					.createCriteria("org.fudan.wuxi.syfw.model.hibentity.Pool")
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
		log.debug("finding Pool instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Pool as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBreId(Object breId) {
		return findByProperty(BRE_ID, breId);
	}

	public List findByWatId(Object watId) {
		return findByProperty(WAT_ID, watId);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByArea(Object area) {
		return findByProperty(AREA, area);
	}

	public List findByResponser(Object responser) {
		return findByProperty(RESPONSER, responser);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findAll() {
		log.debug("finding all Pool instances");
		try {
			String queryString = "from Pool";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Pool merge(Pool detachedInstance) {
		log.debug("merging Pool instance");
		try {
			Pool result = (Pool) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Pool instance) {
		log.debug("attaching dirty Pool instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pool instance) {
		log.debug("attaching clean Pool instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}