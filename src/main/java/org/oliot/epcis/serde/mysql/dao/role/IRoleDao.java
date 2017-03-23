package org.oliot.epcis.serde.mysql.dao.role;

import org.oliot.epcis.serde.mysql.dao.base.IBaseDao;
import org.oliot.model.mysqlservice.role.Role;

public interface IRoleDao extends IBaseDao<Role>{
	//删除该角色对于的所有权限
	public void deleteRolePrivilegeByRoleId(String roleId);
}
