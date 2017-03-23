package org.fudan.wuxi.syfw.model.hibentity;

/**
 * Pool entity. @author MyEclipse Persistence Tools
 */

public class Pool implements java.io.Serializable {

	// Fields

	private String id;
	private String breId;
	private String watId;
	private String name;
	private String area;
	private String responser;
	private Long phone;
	private String address;

	// Constructors

	/** default constructor */
	public Pool() {
	}

	/** minimal constructor */
	public Pool(String breId) {
		this.breId = breId;
	}

	/** full constructor */
	public Pool(String breId, String watId, String name, String area,
			String responser, Long phone, String address) {
		this.breId = breId;
		this.watId = watId;
		this.name = name;
		this.area = area;
		this.responser = responser;
		this.phone = phone;
		this.address = address;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBreId() {
		return this.breId;
	}

	public void setBreId(String breId) {
		this.breId = breId;
	}

	public String getWatId() {
		return this.watId;
	}

	public void setWatId(String watId) {
		this.watId = watId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getResponser() {
		return this.responser;
	}

	public void setResponser(String responser) {
		this.responser = responser;
	}

	public Long getPhone() {
		return this.phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}