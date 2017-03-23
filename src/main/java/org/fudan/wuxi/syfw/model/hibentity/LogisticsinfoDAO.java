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
 * Logisticsinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.fudan.wuxi.syfw.model.hibentity.Logisticsinfo
 * @author MyEclipse Persistence Tools
 */
public class LogisticsinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(LogisticsinfoDAO.class);
	// property constants
	public static final String NO = "no";
	public static final String CATALOG = "catalog";
	public static final String WEIGHT = "weight";
	public static final String BUYER = "buyer";
	public static final String SELLER = "seller";
	public static final String VEHICLE_NO = "vehicleNo";
	public static final String CMPNY_NAME = "cmpnyName";

	public void save(Logisticsinfo transientInstance) {
		log.debug("saving Logisticsinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Logisticsinfo persistentInstance) {
		log.debug("deleting Logisticsinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Logisticsinfo findById(java.lang.String id) {
		log.debug("getting Logisticsinfo instance with id: " + id);
		try {
			Logisticsinfo instance = (Logisticsinfo) getSession().get(
					"org.fudan.wuxi.syfw.model.hibentity.Logisticsinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Logisticsinfo instance) {
		log.debug("finding Logisticsinfo instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"org.fudan.wuxi.syfw.model.hibentity.Logisticsinfo")
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
		log.debug("finding Logisticsinfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Logisticsinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNo(Object no) {
		return findByProperty(NO, no);
	}

	public List findByCatalog(Object catalog) {
		return findByProperty(CATALOG, catalog);
	}

	public List findByWeight(Object weight) {
		return findByProperty(WEIGHT, weight);
	}

	public List findByBuyer(Object buyer) {
		return findByProperty(BUYER, buyer);
	}

	public List findBySeller(Object seller) {
		return findByProperty(SELLER, seller);
	}

	public List findByVehicleNo(Object vehicleNo) {
		return findByProperty(VEHICLE_NO, vehicleNo);
	}

	public List findByCmpnyName(Object cmpnyName) {
		return findByProperty(CMPNY_NAME, cmpnyName);
	}

	public List findAll() {
		log.debug("finding all Logisticsinfo instances");
		try {
			String queryString = "from Logisticsinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Logisticsinfo merge(Logisticsinfo detachedInstance) {
		log.debug("merging Logisticsinfo instance");
		try {
			Logisticsinfo result = (Logisticsinfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Logisticsinfo instance) {
		log.debug("attaching dirty Logisticsinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Logisticsinfo instance) {
		log.debug("attaching clean Logisticsinfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}