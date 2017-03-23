package org.fudan.wuxi.syfw.model.hibentity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Aquatic entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.fudan.wuxi.syfw.model.hibentity.Aquatic
 * @author MyEclipse Persistence Tools
 */
public class AquaticDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AquaticDAO.class);
	// property constants
	public static final String AQU_ID = "aquId";
	public static final String EPC = "epc";
	public static final String WEIGHT = "weight";
	public static final String SELLSTYLE = "sellstyle";
	public static final String NAME = "name";
	public static final String STATUS = "status";
	public static final String NAME_EN = "nameEn";
	public static final String THUMBNAIL = "thumbnail";
	public static final String PICTURE = "picture";
	public static final String BRIEF = "brief";
	public static final String DESCRIPTION = "description";
	public static final String SOURCE_AREA = "sourceArea";
	public static final String PRICE = "price";
	public static final String PRICE_UNIT = "priceUnit";

	public void save(Aquatic transientInstance) {
		log.debug("saving Aquatic instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Aquatic persistentInstance) {
		log.debug("deleting Aquatic instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Aquatic findById(java.lang.String id) {
		log.debug("getting Aquatic instance with id: " + id);
		try {
			Aquatic instance = (Aquatic) getSession().get(
					"org.fudan.wuxi.syfw.model.hibentity.Aquatic", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Aquatic instance) {
		log.debug("finding Aquatic instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"org.fudan.wuxi.syfw.model.hibentity.Aquatic")
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
		log.debug("finding Aquatic instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Aquatic as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAquId(Object aquId) {
		return findByProperty(AQU_ID, aquId);
	}

	public List findByEpc(Object epc) {
		return findByProperty(EPC, epc);
	}

	public List findByWeight(Object weight) {
		return findByProperty(WEIGHT, weight);
	}

	public List findBySellstyle(Object sellstyle) {
		return findByProperty(SELLSTYLE, sellstyle);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByNameEn(Object nameEn) {
		return findByProperty(NAME_EN, nameEn);
	}

	public List findByThumbnail(Object thumbnail) {
		return findByProperty(THUMBNAIL, thumbnail);
	}

	public List findByPicture(Object picture) {
		return findByProperty(PICTURE, picture);
	}

	public List findByBrief(Object brief) {
		return findByProperty(BRIEF, brief);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findBySourceArea(Object sourceArea) {
		return findByProperty(SOURCE_AREA, sourceArea);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findByPriceUnit(Object priceUnit) {
		return findByProperty(PRICE_UNIT, priceUnit);
	}

	public List findAll() {
		log.debug("finding all Aquatic instances");
		try {
			String queryString = "from Aquatic";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Aquatic merge(Aquatic detachedInstance) {
		log.debug("merging Aquatic instance");
		try {
			Aquatic result = (Aquatic) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Aquatic instance) {
		log.debug("attaching dirty Aquatic instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Aquatic instance) {
		log.debug("attaching clean Aquatic instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}