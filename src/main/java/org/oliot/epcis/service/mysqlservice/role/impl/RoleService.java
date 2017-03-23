package org.oliot.epcis.service.mysqlservice.role.impl;

import javax.annotation.Resource;



import org.oliot.epcis.serde.mysql.dao.role.IRoleDao;
import org.oliot.epcis.service.mysqlservice.base.BaseService;
import org.oliot.epcis.service.mysqlservice.role.IRoleService;
import org.oliot.model.mysqlservice.role.Role;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleService extends BaseService<Role> implements IRoleService{
	
	private IRoleDao roleDao;
	@Resource
	public void setRoleDao(IRoleDao roleDao) {
		super.setBaseDao(roleDao);
		this.roleDao = roleDao;
	}
	

	@Override
	public void update(Role role) {
		//1、删除该角色对于的所有权限
		roleDao.deleteRolePrivilegeByRoleId(role.getRoleId());
		//2、更新角色及其权限
		roleDao.update(role);
	}
	
	
//	 public static void main(String[] args){  
//	        //执行方法初始化数据  
//	        ApplicationContext aContext = new ClassPathXmlApplicationContext("applicationContext.xml");  
//	        IRoleService roleService = (RoleService) aContext.getBean("roleService");  
//	        Role role = new Role("100","管理员");
//	        
//	        Privilege p = new Privilege("查询", "/find3333");
//	        Privilege p2 = new Privilege("查询2", "/find2333");
//	        role.getPrivileges().add(p);
//	        role.getPrivileges().add(p2);
//	        
//	        roleService.save(role);
//	    }  
//	
	
}
