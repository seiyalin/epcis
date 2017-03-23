package org.fudan.wuxi.syfw.model.hibentity;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Warehouse entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.fudan.wuxi.syfw.model.hibentity.Warehouse
 * @author MyEclipse Persistence Tools
 */
public class WarehouseDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(WarehouseDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String MAKET_NAME = "maketName";

	public void save(Warehouse transientInstance) {
		log.debug("saving Warehouse instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Warehouse persistentInstance) {
		log.debug("deleting Warehouse instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Warehouse findById(org.fudan.wuxi.syfw.model.hibentity.WarehouseId id) {
		log.debug("getting Warehouse instance with id: " + id);
		try {
			Warehouse instance = (Warehouse) getSession().get(
					"org.fudan.wuxi.syfw.model.hibentity.Warehouse", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Warehouse instance) {
		log.debug("finding Warehouse instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"org.fudan.wuxi.syfw.model.hibentity.Warehouse")
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
		log.debug("finding Warehouse instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Warehouse as model where model."
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

	public List findByMaketName(Object maketName) {
		return findByProperty(MAKET_NAME, maketName);
	}

	public List findAll() {
		log.debug("finding all Warehouse instances");
		try {
			String queryString = "from Warehouse";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Warehouse merge(Warehouse detachedInstance) {
		log.debug("merging Warehouse instance");
		try {
			Warehouse result = (Warehouse) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Warehouse instance) {
		log.debug("attaching dirty Warehouse instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Warehouse instance) {
		log.debug("attaching clean Warehouse instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}