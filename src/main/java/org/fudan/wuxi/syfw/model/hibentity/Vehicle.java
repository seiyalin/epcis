package org.fudan.wuxi.syfw.model.hibentity;

import java.sql.Timestamp;

/**
 * Vehicle entity. @author MyEclipse Persistence Tools
 */

public class Vehicle implements java.io.Serializable {

	// Fields

	private String vehicleNo;
	private String driver;
	private Long phone;
	private Timestamp startTime;
	private Timestamp endTime;
	private String origin;
	private String dest;
	private Short temper;

	// Constructors

	/** default constructor */
	public Vehicle() {
	}

	/** full constructor */
	public Vehicle(String driver, Long phone, Timestamp startTime,
			Timestamp endTime, String origin, String dest, Short temper) {
		this.driver = driver;
		this.phone = phone;
		this.startTime = startTime;
		this.endTime = endTime;
		this.origin = origin;
		this.dest = dest;
		this.temper = temper;
	}

	// Property accessors

	public String getVehicleNo() {
		return this.vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getDriver() {
		return this.driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public Long getPhone() {
		return this.phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDest() {
		return this.dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public Short getTemper() {
		return this.temper;
	}

	public void setTemper(Short temper) {
		this.temper = temper;
	}

}