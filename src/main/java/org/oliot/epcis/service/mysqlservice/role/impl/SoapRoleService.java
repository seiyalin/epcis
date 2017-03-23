package org.oliot.epcis.service.mysqlservice.role.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.fudan.wuxi.common.PageResult;
import org.fudan.wuxi.utils.QueryHelper;
import org.oliot.epcis.service.mysqlservice.role.IRoleService;
import org.oliot.model.mysqlservice.role.Role;


//@WebService(endpointInterface = "org.oliot.epcis.service.mysqlservice.role.impl.IRoleService")
//上面地址写错了造成发布不成功  Caused by: javax.xml.ws.WebServiceException: Could not load Webservice SEI
//Caused by: java.lang.ClassNotFoundException: org.oliot.epcis.service.mysqlservice.role.impl.IRoleService
@WebService(endpointInterface = "org.oliot.epcis.service.mysqlservice.role.IRoleService")
public class SoapRoleService implements IRoleService {
	

	RoleService roleService;
	@Resource
	public void setRoleService(RoleService roleService) {
		System.out.println("进入了setRoleService(RoleService RoleService)");
		this.roleService = roleService;
		System.out.println("退出了setRoleService(RoleService RoleService)");

	}
	
	public IRoleService getRoleService() {
		return roleService;
	}



	@Override
	public void save(Role entity) {
		roleService.save(entity);
	}

	@Override
	public void update(Role entity) {
		// TODO Auto-generated method stub
		roleService.update(entity);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		roleService.delete(id);
	}

	@Override
	public Role findObjectById(String id) {
		// TODO Auto-generated method stub
		return roleService.findObjectById(id);
	}

	@Override
	public List<Role> findObjects() {
		// TODO Auto-generated method stub
		return roleService.findObjects();
	}

	@Override
	public List<Role> findObjects(String hql, List<Object> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findObjects(QueryHelper queryHelper) {
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
