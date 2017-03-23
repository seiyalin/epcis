package org.fudan.wuxi.syfw.model.hibentity;

/**
 * Container entity. @author MyEclipse Persistence Tools
 */

public class Container implements java.io.Serializable {

	// Fields

	private String id;
	private String vehicleNo;

	// Constructors

	/** default constructor */
	public Container() {
	}

	/** full constructor */
	public Container(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVehicleNo() {
		return this.vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

}