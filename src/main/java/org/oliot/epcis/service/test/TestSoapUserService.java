package org.oliot.epcis.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.oliot.epcis.serde.mysql.dao.user.IUserDao;
import org.oliot.epcis.serde.mysql.dao.user.impl.UserDao;
import org.oliot.model.mysqlservice.User;
import org.oliot.model.mysqlservice.UserRole;
import org.oliot.model.mysqlservice.UserRoleId;
import org.oliot.model.mysqlservice.role.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSoapUserService {
	//测试UserDao
	@Test
	public void testUserDaoSave(){
		ApplicationContext at =new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao userDao = (UserDao) at.getBean("userDao");
		User user = new User();
		user.setPassWord("afsdhifsdhifhio");
		user.setUserName("quyue ");
		List<UserRole> userRoles = new ArrayList<UserRole>();
		UserRole userRole = new UserRole();
		UserRoleId id = new UserRoleId(null, null);
		
		Role role = new Role("10", "消费者") ;
		id.setRole(role );
		id.setUserId("4028f8e655ec71a10155ec71a2e60000");
		userRole.setId(id );
		userRoles.add(userRole );
		user.setUserRoles(userRoles);
		userDao.save(user);
	}
		
}
