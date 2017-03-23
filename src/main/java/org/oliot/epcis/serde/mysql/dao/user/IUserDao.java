package org.oliot.epcis.serde.mysql.dao.user;

import java.io.Serializable;
import java.util.List;

import org.oliot.epcis.serde.mysql.dao.base.IBaseDao;
import org.oliot.model.mysqlservice.User;
import org.oliot.model.mysqlservice.UserRole;


public interface IUserDao extends IBaseDao<User>{
	
	public List<User> findUserByAccountAndId(String id, String account);

	//保存用户角色
	public void saveUserRole(UserRole userRole);

	//根据用户id删除该用户的所有用户角色
	public void deleteUserRoleByUserId(Serializable id);
	//根据用户id获取该用户对应的所有用户角色
	public List<UserRole> getUserRolesByUserId(String id);
	//根据用户的帐号和密码查询用户列表
	public List<User> findUsersByAcccountAndPass(String account, String password);
	

}
