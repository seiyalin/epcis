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
 * Vehicle entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.fudan.wuxi.syfw.model.hibentity.Vehicle
 * @author MyEclipse Persistence Tools
 */
public class VehicleDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(VehicleDAO.class);
	// property constants
	public static final String DRIVER = "driver";
	public static final String PHONE = "phone";
	public static final String ORIGIN = "origin";
	public static final String DEST = "dest";
	public static final String TEMPER = "temper";

	public void save(Vehicle transientInstance) {
		log.debug("saving Vehicle instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Vehicle persistentInstance) {
		log.debug("deleting Vehicle instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vehicle findById(java.lang.String id) {
		log.debug("getting Vehicle instance with id: " + id);
		try {
			Vehicle instance = (Vehicle) getSession().get(
					"org.fudan.wuxi.syfw.model.hibentity.Vehicle", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Vehicle instance) {
		log.debug("finding Vehicle instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"org.fudan.wuxi.syfw.model.hibentity.Vehicle")
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
		log.debug("finding Vehicle instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Vehicle as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDriver(Object driver) {
		return findByProperty(DRIVER, driver);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByOrigin(Object origin) {
		return findByProperty(ORIGIN, origin);
	}

	public List findByDest(Object dest) {
		return findByProperty(DEST, dest);
	}

	public List findByTemper(Object temper) {
		return findByProperty(TEMPER, temper);
	}

	public List findAll() {
		log.debug("finding all Vehicle instances");
		try {
			String queryString = "from Vehicle";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Vehicle merge(Vehicle detachedInstance) {
		log.debug("merging Vehicle instance");
		try {
			Vehicle result = (Vehicle) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Vehicle instance) {
		log.debug("attaching dirty Vehicle instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vehicle instance) {
		log.debug("attaching clean Vehicle instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}