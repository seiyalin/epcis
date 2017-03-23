package org.fudan.wuxi.syfw.model.hibentity;

/**
 * Logisticscompany entity. @author MyEclipse Persistence Tools
 */

public class Logisticscompany implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String address;
	private Long phone;

	// Constructors

	/** default constructor */
	public Logisticscompany() {
	}

	/** full constructor */
	public Logisticscompany(String name, String address, Long phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhone() {
		return this.phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

}