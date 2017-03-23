package org.oliot.model.mysqlservice.role;

import java.util.HashSet;
import java.util.Set;

import org.oliot.model.mysqlservice.privilege.Privilege;


public class Role {
	public Role(String roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	
	public Role(String roleId) {
		super();
		this.roleId = roleId;
	}

	private String roleId;
	private String roleName;//角色名称  管理员  消费者，监管者...
	
	private Set<Privilege> privileges = new HashSet<Privilege>();  
	
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName
				+ ", privileges=" + privileges + "]";
	}
	

}
