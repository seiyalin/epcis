package org.oliot.epcis.service.mysqlservice.user;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.fudan.wuxi.common.PageResult;
import org.fudan.wuxi.utils.QueryHelper;
import org.oliot.model.mysqlservice.User;
import org.oliot.model.mysqlservice.UserRole;
/**
 * 此类中的所有方法用于发布出去，其本身依赖于UserService  而userService的服务寄托在userDao的基础上完成，这样一来，epcis服务器这端的可以继续分层
 * 开发，而无需受到cxf框架对实现Serilable接口的限制，而hibernate框架却某些场合必须实现Serilizable接口。 通过这种方式，尝试着解决他们之间的冲突
 * @author Administrator
 * 
 * 
 * 此处是否需要运用适配器模式，是对外发布的接口是满足cxf框架的，而对内满足hibernate的数据库访问要求
 *
 */

@WebService(endpointInterface = "org.oliot.epcis.service.mysqlservice.user.IUserService")
public class SoapUserService implements IUserService {
	
	
	UserService userService;
	@Resource
	public void setUserService(UserService userService) {
		System.out.println("进入了setUserService(UserService userService)");
		this.userService = userService;
		System.out.println("退出了setUserService(UserService userService)");

	}

	public SoapUserService() {
		System.out.println("创建了SoapUserService实例----------"+this.hashCode());
	}

	@Override
	public void save(User entity) {
		
		userService.save(entity);
	}

	@Override
	public void update(User entity) {
		userService.update(entity);

	}

	@Override
	public void delete(String id) {
		userService.delete(id);

	}

	@Override
	public User findObjectById(String id) {
		return userService.findObjectById(id);
	}

	@Override
	public List<User> findObjects() {
		return userService.findObjects();
	}

	@Override
	public List<User> findUserByAccountAndId(String id, String account) {
		return userService.findUserByAccountAndId(id, account);
	}

	@Override
	public void saveUserAndRole(User user, String... roleIds) {
		userService.saveUserAndRole(user, roleIds);
	}

	@Override
	public void updateUserAndRole(User user, String... roleIds) {
		userService.updateUserAndRole(user, roleIds);
	}

	@Override
	public List<UserRole> getUserRolesByUserId(String id) {
		return userService.getUserRolesByUserId(id);
	}

	@Override
	public List<User> findUserByAccountAndPass(String account, String password) {
		System.out.println("进入了SoapUserService的findUserByAccountAndPass");
		return userService.findUserByAccountAndPass(account, password);
	}

	@Override
	public List<User> findObjects(String hql, List<Object> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findObjects(QueryHelper queryHelper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
