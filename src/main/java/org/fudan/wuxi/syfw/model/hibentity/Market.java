package org.fudan.wuxi.syfw.model.hibentity;

import java.sql.Time;

/**
 * Market entity. @author MyEclipse Persistence Tools
 */

public class Market implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String logisNo;
	private String location;
	private Time startTime;
	private String topManager;
	private Time endTime;

	// Constructors

	/** default constructor */
	public Market() {
	}

	/** full constructor */
	public Market(String name, String logisNo, String location, Time startTime,
			String topManager, Time endTime) {
		this.name = name;
		this.logisNo = logisNo;
		this.location = location;
		this.startTime = startTime;
		this.topManager = topManager;
		this.endTime = endTime;
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

	public String getLogisNo() {
		return this.logisNo;
	}

	public void setLogisNo(String logisNo) {
		this.logisNo = logisNo;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Time getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public String getTopManager() {
		return this.topManager;
	}

	public void setTopManager(String topManager) {
		this.topManager = topManager;
	}

	public Time getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

}