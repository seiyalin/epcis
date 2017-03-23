package org.oliot.epcis.serde.mysql.dao.role.impl;

import org.hibernate.Query;
import org.oliot.epcis.serde.mysql.dao.base.BaseDao;
import org.oliot.epcis.serde.mysql.dao.role.IRoleDao;
import org.oliot.model.mysqlservice.role.Role;

public class RoleDao extends BaseDao<Role> implements IRoleDao {

	@Override
	public void deleteRolePrivilegeByRoleId(String roleId) {
		Query query = getSession().createQuery("DELETE FROM RolePrivilege WHERE id.role.roleId=?");
		query.setParameter(0, roleId);
		query.executeUpdate();
	}
	
}
