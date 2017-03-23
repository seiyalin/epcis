package org.fudan.wuxi.syfw.model.hibentity;

/**
 * AquaticCatagary entity. @author MyEclipse Persistence Tools
 */

public class AquaticCatagary implements java.io.Serializable {

	// Fields

	private String id;
	private String name;

	// Constructors

	/** default constructor */
	public AquaticCatagary() {
	}

	/** full constructor */
	public AquaticCatagary(String name) {
		this.name = name;
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

}