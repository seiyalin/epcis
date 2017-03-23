package org.oliot.epcis.service.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.oliot.epcis.serde.mysql.dao.user.impl.UserDao;
import org.oliot.epcis.service.mysqlservice.Info;
import org.oliot.epcis.service.mysqlservice.user.IUserService;
import org.oliot.model.mysqlservice.User;
import org.oliot.model.mysqlservice.UserRole;
import org.oliot.model.mysqlservice.UserRoleId;
import org.oliot.model.mysqlservice.role.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestWebService {
	
	//测试UserService
	@Test
	public void testUserDaoSave(){
		ApplicationContext at =new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserService userService = (IUserService) at.getBean("userService");
		User user = new User();
		user.setPassWord("afsdhifsdhifhio");
		user.setUserName("齐曼玉hahdshhs ");
//		userService.save(user);
//		List<User> users = userService.findObjects();
		List<User> users = userService.findUserByAccountAndPass("屈岳", "root");
		System.out.println(users);
		
		
//		List<UserRole> userRoles = new ArrayList<UserRole>();
//		UserRole userRole = new UserRole();
//		UserRoleId id = new UserRoleId(null, null);
//		
//		Role role = new Role("10", "消费者") ;
//		id.setRole(role );
//		id.setUserId("4028f8e655ec71a10155ec71a2e60000");
//		userRole.setId(id );
//		userRoles.add(userRole );
//		user.setUserRoles(userRoles);
//		userDao.save(user);
	}
		
//	//测试UserDao
//	@Test
//	public void testUserDaoSave(){
//		ApplicationContext at =new ClassPathXmlApplicationContext("applicationContext.xml");
//		UserDao userDao = (UserDao) at.getBean("userDao");
//		User user = new User();
//		user.setPassWord("afsdhifsdhifhio");
//		user.setUserName("齐曼玉 ");
//		List<UserRole> userRoles = new ArrayList<UserRole>();
//		UserRole userRole = new UserRole();
//		UserRoleId id = new UserRoleId(null, null);
//		
//		Role role = new Role("10", "消费者") ;
//		id.setRole(role );
//		id.setUserId("4028f8e655ec71a10155ec71a2e60000");
//		userRole.setId(id );
//		userRoles.add(userRole );
//		user.setUserRoles(userRoles);
//		userDao.save(user);
//	}
//	
	
	
	
//	
//	
//	@Test
//	public void testFindObjectsDao(){
//		ApplicationContext at =new ClassPathXmlApplicationContext("applicationContext.xml");
//		BaseDao baseDao = (BaseDao) at.getBean("baseDao");
//		List<Info> infos = baseDao.findObjects();
//		System.out.println(infos);
//		
//	}
//	@Test
//	public void testSaveDao(){
//		ApplicationContext at =new ClassPathXmlApplicationContext("applicationContext.xml");
//		BaseDao baseDao = (BaseDao) at.getBean("baseDao");
//		Info info = new Info();
////		Info info = new Info();
//		info.setInfoId("0001");
//		info.setContent("jaj");
//		info.setTitle("hskghkdssfjdljsld");
//		info.setCreator("wasww");
//		baseDao.save(info);
//	}
//	
//	@Test
//	public void testUpdateDao(){
//		ApplicationContext at =new ClassPathXmlApplicationContext("applicationContext.xml");
//		BaseDao baseDao = (BaseDao) at.getBean("baseDao");
//		Info info = new Info();
//		info.setInfoId("402880e9559cac7b01559cac875c0000");
////		Info info = new Info();
//		info.setInfoId("0001");
//		info.setContent("jaj");
//		info.setTitle("HellUpate");
//		info.setCreator("wasww");
//		baseDao.update(info);
//	}
//	
//	@Test
//	public void testFindByidDao(){
//		ApplicationContext at =new ClassPathXmlApplicationContext("applicationContext.xml");
//		BaseDao baseDao = (BaseDao) at.getBean("baseDao");
////		BaseDao	baseDao = new BaseDaoImpl();
//		Info findObjectById = baseDao.findObjectById("402880e9559cac7b01559cac875c0000");
//		System.out.println(findObjectById);
//	}
//	@Test
//	public void testDeleteDao(){
//		ApplicationContext at =new ClassPathXmlApplicationContext("applicationContext.xml");
//		BaseDao baseDao = (BaseDao) at.getBean("baseDao");
//		Info info = new Info();
//		info.setInfoId("402880e9559cac7b01559cac875c0000");
////		Info info = new Info();
//		info.setInfoId("0001");
//		info.setContent("jaj");
//		info.setTitle("HellUpate");
//		info.setCreator("wasww");
//		baseDao.update(info);
//	}
//	
	
}


