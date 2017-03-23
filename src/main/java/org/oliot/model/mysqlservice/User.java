package org.oliot.model.mysqlservice;

import java.util.List;

/**
 * 假设User不能动防止user基本信息过大，存到session当中的时候查询数据库效率过低
 */

/**
 * 此包下存放的全是与MySql数据库相关的entity
 * @author Arnold
 *
 */

public class User {
	
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public List<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	private String id;
	private String userName;
	private String passWord;
	private String headImg;
	private String mobile;
	private String email;
	private String companyName;//公司名称
	private String companyAddress;//公司地址
	
	private List<UserRole> userRoles;//即用户的身份   是消费者还是监管者还是养殖主呢？ 
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord="
				+ passWord + ", headImg=" + headImg + ", mobile=" + mobile
				+ ", email=" + email + ", companyName=" + companyName
				+ ", companyAddress=" + companyAddress + ", userRoles="
				+ userRoles + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public User() {
		super();
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public User(String id, String userName, String passWord) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
	}
	
	
}
