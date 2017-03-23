package org.fudan.wuxi.syfw.model.hibentity;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Breedingsite entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.fudan.wuxi.syfw.model.hibentity.Breedingsite
 * @author MyEclipse Persistence Tools
 */
public class BreedingsiteDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BreedingsiteDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String RESPONSER = "responser";
	public static final String LOCATION = "location";
	public static final String PHONE = "phone";

	public void save(Breedingsite transientInstance) {
		log.debug("saving Breedingsite instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Breedingsite persistentInstance) {
		log.debug("deleting Breedingsite instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Breedingsite findById(java.lang.String id) {
		log.debug("getting Breedingsite instance with id: " + id);
		try {
			Breedingsite instance = (Breedingsite) getSession().get(
					"org.fudan.wuxi.syfw.model.hibentity.Breedingsite", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Breedingsite instance) {
		log.debug("finding Breedingsite instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"org.fudan.wuxi.syfw.model.hibentity.Breedingsite")
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
		log.debug("finding Breedingsite instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Breedingsite as model where model."
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

	public List findByResponser(Object responser) {
		return findByProperty(RESPONSER, responser);
	}

	public List findByLocation(Object location) {
		return findByProperty(LOCATION, location);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findAll() {
		log.debug("finding all Breedingsite instances");
		try {
			String queryString = "from Breedingsite";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Breedingsite merge(Breedingsite detachedInstance) {
		log.debug("merging Breedingsite instance");
		try {
			Breedingsite result = (Breedingsite) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Breedingsite instance) {
		log.debug("attaching dirty Breedingsite instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Breedingsite instance) {
		log.debug("attaching clean Breedingsite instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}