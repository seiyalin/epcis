package org.fudan.wuxi.syfw.model.hibentity;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Container entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.fudan.wuxi.syfw.model.hibentity.Container
 * @author MyEclipse Persistence Tools
 */
public class ContainerDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ContainerDAO.class);
	// property constants
	public static final String VEHICLE_NO = "vehicleNo";

	public void save(Container transientInstance) {
		log.debug("saving Container instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Container persistentInstance) {
		log.debug("deleting Container instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Container findById(java.lang.String id) {
		log.debug("getting Container instance with id: " + id);
		try {
			Container instance = (Container) getSession().get(
					"org.fudan.wuxi.syfw.model.hibentity.Container", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Container instance) {
		log.debug("finding Container instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"org.fudan.wuxi.syfw.model.hibentity.Container")
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
		log.debug("finding Container instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Container as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByVehicleNo(Object vehicleNo) {
		return findByProperty(VEHICLE_NO, vehicleNo);
	}

	public List findAll() {
		log.debug("finding all Container instances");
		try {
			String queryString = "from Container";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Container merge(Container detachedInstance) {
		log.debug("merging Container instance");
		try {
			Container result = (Container) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Container instance) {
		log.debug("attaching dirty Container instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Container instance) {
		log.debug("attaching clean Container instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}