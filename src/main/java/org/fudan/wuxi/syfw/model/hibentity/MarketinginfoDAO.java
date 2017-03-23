package org.fudan.wuxi.syfw.model.hibentity;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Marketinginfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.fudan.wuxi.syfw.model.hibentity.Marketinginfo
 * @author MyEclipse Persistence Tools
 */
public class MarketinginfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MarketinginfoDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String CLERK_NUM = "clerkNum";
	public static final String TRAN_NUM = "tranNum";
	public static final String EPC = "epc";
	public static final String AQUATIC_NAME = "aquaticName";
	public static final String PRICE = "price";
	public static final String WEIGHT = "weight";
	public static final String PAY_STYLE = "payStyle";
	public static final String CATALOG = "catalog";

	public void save(Marketinginfo transientInstance) {
		log.debug("saving Marketinginfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Marketinginfo persistentInstance) {
		log.debug("deleting Marketinginfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Marketinginfo findById(java.lang.String id) {
		log.debug("getting Marketinginfo instance with id: " + id);
		try {
			Marketinginfo instance = (Marketinginfo) getSession().get(
					"org.fudan.wuxi.syfw.model.hibentity.Marketinginfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Marketinginfo instance) {
		log.debug("finding Marketinginfo instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"org.fudan.wuxi.syfw.model.hibentity.Marketinginfo")
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
		log.debug("finding Marketinginfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Marketinginfo as model where model."
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

	public List findByClerkNum(Object clerkNum) {
		return findByProperty(CLERK_NUM, clerkNum);
	}

	public List findByTranNum(Object tranNum) {
		return findByProperty(TRAN_NUM, tranNum);
	}

	public List findByEpc(Object epc) {
		return findByProperty(EPC, epc);
	}

	public List findByAquaticName(Object aquaticName) {
		return findByProperty(AQUATIC_NAME, aquaticName);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findByWeight(Object weight) {
		return findByProperty(WEIGHT, weight);
	}

	public List findByPayStyle(Object payStyle) {
		return findByProperty(PAY_STYLE, payStyle);
	}

	public List findByCatalog(Object catalog) {
		return findByProperty(CATALOG, catalog);
	}

	public List findAll() {
		log.debug("finding all Marketinginfo instances");
		try {
			String queryString = "from Marketinginfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Marketinginfo merge(Marketinginfo detachedInstance) {
		log.debug("merging Marketinginfo instance");
		try {
			Marketinginfo result = (Marketinginfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Marketinginfo instance) {
		log.debug("attaching dirty Marketinginfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Marketinginfo instance) {
		log.debug("attaching clean Marketinginfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}