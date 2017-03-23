package org.oliot.model.mysqlservice;

import java.io.Serializable;

import org.oliot.model.mysqlservice.role.Role;


/**
 * 联合主键必须重写equals和hashcode以及实现serializable接口
 * @author Administrator
 *
 */
public class UserRoleId implements  Serializable{
	
	public UserRoleId(Role role,String userId) {
		this.role = role;
		this.userId = userId;
	}
	
	private Role role;//因为业务场景的需要,所以没有用roleid
	private String userId;//因为不需要查询一个角色所对应的用户数，故没有用实体类user作为属性
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoleId other = (UserRoleId) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserRoleId [role=" + role + ", userId=" + userId + "]";
	}
	
	
}
