package org.oliot.epcis.serde.mysql.dao.user.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.oliot.epcis.serde.mysql.dao.base.BaseDao;
import org.oliot.epcis.serde.mysql.dao.user.IUserDao;
import org.oliot.epcis.service.mysqlservice.Info;
import org.oliot.model.mysqlservice.User;
import org.oliot.model.mysqlservice.UserRole;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDao extends BaseDao<User> implements IUserDao {
	
	public UserDao(){
		System.out.println("创建了UserDao实例------------"+this.hashCode());
	}


	@Override
	public List<User> findUserByAccountAndId(String id, String account) {
		String hql = "FROM User WHERE userName = ?";
		if(StringUtils.isNotBlank(id)){
			hql += " AND id!=?";
		}
		Query query = getSession().createQuery(hql);
		query.setParameter(0, account);
		if(StringUtils.isNotBlank(id)){
			query.setParameter(1, id);
		}
		
		return query.list();
	}

	@Override
	public void saveUserRole(UserRole userRole) {
		getHibernateTemplate().save(userRole);
	}

	@Override
	public void deleteUserRoleByUserId(Serializable id) {
		Query query = getSession().createQuery("DELETE FROM UserRole WHERE id.userId=?");
		query.setParameter(0, id);
		query.executeUpdate();
	}

	@Override
	public List<UserRole> getUserRolesByUserId(String id) {
		Query query = getSession().createQuery("FROM UserRole WHERE id.userId=?");
		query.setParameter(0, id);
		return query.list();
	}

	@Override
	public List<User> findUsersByAcccountAndPass(String userName, String passWord) {
//		Query query = getSession().createQuery("FROM User WHERE account=? AND password=?");
		Query query = getSession().createQuery("FROM User WHERE userName=? AND passWord=?");//改成相应的userName 和密码即可
		query.setParameter(0, userName);
		query.setParameter(1, passWord);
		return query.list();
	}


}
