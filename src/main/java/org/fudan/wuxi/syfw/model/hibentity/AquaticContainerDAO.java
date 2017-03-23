package org.fudan.wuxi.syfw.model.hibentity;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * AquaticContainer entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.fudan.wuxi.syfw.model.hibentity.AquaticContainer
 * @author MyEclipse Persistence Tools
 */
public class AquaticContainerDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AquaticContainerDAO.class);

	// property constants

	public void save(AquaticContainer transientInstance) {
		log.debug("saving AquaticContainer instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AquaticContainer persistentInstance) {
		log.debug("deleting AquaticContainer instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AquaticContainer findById(
			org.fudan.wuxi.syfw.model.hibentity.AquaticContainerId id) {
		log.debug("getting AquaticContainer instance with id: " + id);
		try {
			AquaticContainer instance = (AquaticContainer) getSession().get(
					"org.fudan.wuxi.syfw.model.hibentity.AquaticContainer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AquaticContainer instance) {
		log.debug("finding AquaticContainer instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"org.fudan.wuxi.syfw.model.hibentity.AquaticContainer")
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
		log.debug("finding AquaticContainer instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AquaticContainer as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all AquaticContainer instances");
		try {
			String queryString = "from AquaticContainer";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AquaticContainer merge(AquaticContainer detachedInstance) {
		log.debug("merging AquaticContainer instance");
		try {
			AquaticContainer result = (AquaticContainer) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AquaticContainer instance) {
		log.debug("attaching dirty AquaticContainer instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AquaticContainer instance) {
		log.debug("attaching clean AquaticContainer instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}