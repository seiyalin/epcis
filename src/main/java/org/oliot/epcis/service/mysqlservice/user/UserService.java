package org.oliot.epcis.service.mysqlservice.user;

import java.util.List;








import javax.annotation.Resource;

import org.junit.Test;
import org.oliot.epcis.serde.mysql.dao.user.IUserDao;
import org.oliot.epcis.serde.mysql.dao.user.impl.UserDao;
import org.oliot.epcis.service.mysqlservice.base.BaseService;
import org.oliot.model.mysqlservice.User;
import org.oliot.model.mysqlservice.UserRole;
import org.oliot.model.mysqlservice.UserRoleId;
import org.oliot.model.mysqlservice.role.Role;
import org.springframework.stereotype.Service;

/**
 * 此类用来过渡的，即epcis这边继续分层开发，而SoapUserService依赖该类
 * @author Administrator
 *
 */
@Service("userService")
public class UserService extends BaseService<User> implements IUserService {
	
	private IUserDao userDao;
//	private IUserDao userDao = new UserDao();
	
	@Resource
	public void setUserDao(IUserDao userDao) {//在UserService中，通过自动注入userDao的同时，
		//将userDao传递给BaseService转换为BaseDao
		System.out.println("Spring 注入了userDao！！");
		super.setBaseDao(userDao);
		this.userDao = userDao;
	}

	public UserService() {
		System.out.println("创建了UserService实例----------"+this.hashCode());
	}

	@Override
	public List<User> findUserByAccountAndId(String id, String account) {
		// TODO Auto-generated method stub
		return userDao.findUserByAccountAndId(id, account);
	}

	@Override
	public void saveUserAndRole(User user, String... roleIds) {//变长参数更为灵活
		// 先保存用户
		userDao.save(user);
		//再保存该用户对应的角色
		if(roleIds!=null){
			for(String roleId:roleIds){
				userDao.saveUserRole(new UserRole(new UserRoleId(new Role(roleId),user.getId())));
			//user.getId()利用了hibernate的数据回填技术	
			}
		}
	}

	@Override
	public void updateUserAndRole(User user, String... roleIds) {
		//根据用户删除该用户的所有角色
		userDao.deleteUserRoleByUserId(user.getId());
		//更新用户
		update(user);//更新user表的一条记录
		//保存用户对应的角色
		if(roleIds != null){
			for(String roleId : roleIds){
				userDao.saveUserRole(new UserRole(new UserRoleId(new Role(roleId), user.getId())));
				//对应个用户角色表的多条记录
			}
		}
		
	}

	@Override
	public List<UserRole> getUserRolesByUserId(String id) {
		return userDao.getUserRolesByUserId(id);
	}

	@Override
	public List<User> findUserByAccountAndPass(String account, String password) {
		System.out.println("ecpcis 的  findUserByAccountAndPass(String account, String password)");
		return userDao.findUsersByAcccountAndPass(account, password);
	}
	
//	@Test
//	public  void testfindUserByAccountAndPass(){
//		List<User> users = findUserByAccountAndPass("屈岳","root");
//		System.out.println(users);
//	}


}
