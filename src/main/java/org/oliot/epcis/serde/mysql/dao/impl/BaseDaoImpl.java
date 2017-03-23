package org.oliot.epcis.serde.mysql.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.oliot.epcis.serde.mysql.dao.BaseDao;
import org.oliot.epcis.service.mysqlservice.Info;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {//改成非抽象类
	
	//HibernateDaoSupport封装了Hibernate的基本功能，并且他持有一个HibernateTemplate对象，对hibernate的驱动
	//就是由这个HibernateTemplate类来实现的。
	//当然，也可以不通过DaoSupport类，而直接使用这些Template类来支持对数据库的操作
	
	///epcis/src/main/webapp/WEB-INF/lib/org.springframework.orm-3.0.2.RELEASE.jar
	
	Class<Info> clazz;
	

	public BaseDaoImpl(){
		
		System.out.println("创建了BaseDaoImpl实例: " +this.hashCode() );
//		ParameterizedType pt =  (ParameterizedType)this.getClass().getGenericSuperclass();//BaseDaoImpl<User>
//		clazz = (Class<Info>)pt.getActualTypeArguments()[0];
	}

	@Override
	public void save(Info entity) {
//		getHibernateTemplate().save(entity);
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		hibernateTemplate.save(entity);
		
//		Configuration config = new Configuration().configure();
//		SessionFactory sf = config.buildSessionFactory();
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//		session.save(entity);
//		tx.commit();
//		session.close();
//		sf.close();
	}

	@Override
	public void update(Info entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public void delete(String id) {
		getHibernateTemplate().delete(findObjectById(id));
	}

	@Override
	public Info findObjectById(String id) {
		return getHibernateTemplate().get(Info.class, id);
	}

	@Override
	public List<Info> findObjects() {
		Query query = getSession().createQuery("FROM " + "info");
		return query.list();
	}

}
