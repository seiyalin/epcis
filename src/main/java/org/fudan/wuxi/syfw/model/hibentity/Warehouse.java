package org.fudan.wuxi.syfw.model.hibentity;

/**
 * Warehouse entity. @author MyEclipse Persistence Tools
 */

public class Warehouse implements java.io.Serializable {

	// Fields

	private WarehouseId id;
	private String name;
	private String maketName;

	// Constructors

	/** default constructor */
	public Warehouse() {
	}

	/** minimal constructor */
	public Warehouse(WarehouseId id) {
		this.id = id;
	}

	/** full constructor */
	public Warehouse(WarehouseId id, String name, String maketName) {
		this.id = id;
		this.name = name;
		this.maketName = maketName;
	}

	// Property accessors

	public WarehouseId getId() {
		return this.id;
	}

	public void setId(WarehouseId id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaketName() {
		return this.maketName;
	}

	public void setMaketName(String maketName) {
		this.maketName = maketName;
	}

}