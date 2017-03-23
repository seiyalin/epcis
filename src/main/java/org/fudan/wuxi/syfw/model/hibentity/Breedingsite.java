package org.fudan.wuxi.syfw.model.hibentity;

/**
 * Breedingsite entity. @author MyEclipse Persistence Tools
 */

public class Breedingsite implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String responser;
	private String location;
	private Long phone;

	// Constructors

	/** default constructor */
	public Breedingsite() {
	}

	/** full constructor */
	public Breedingsite(String name, String responser, String location,
			Long phone) {
		this.name = name;
		this.responser = responser;
		this.location = location;
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

	public String getResponser() {
		return this.responser;
	}

	public void setResponser(String responser) {
		this.responser = responser;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getPhone() {
		return this.phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

}