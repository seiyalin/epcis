package org.oliot.model.mysqlservice;



public class UserRole {
	private UserRoleId id;
	public UserRole() {
	}

	public UserRole(UserRoleId id) {
		this.id = id;
	}

	public UserRoleId getId() {
		return id;
	}

	public void setId(UserRoleId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + "]";
	}
	
	

}
