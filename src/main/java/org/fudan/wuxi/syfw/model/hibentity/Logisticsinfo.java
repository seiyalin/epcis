package org.fudan.wuxi.syfw.model.hibentity;

import java.sql.Timestamp;

/**
 * Logisticsinfo entity. @author MyEclipse Persistence Tools
 */

public class Logisticsinfo implements java.io.Serializable {

	// Fields

	private String id;
	private String no;
	private Timestamp time;
	private String catalog;
	private Float weight;
	private String buyer;
	private String seller;
	private String vehicleNo;
	private String cmpnyName;

	// Constructors

	/** default constructor */
	public Logisticsinfo() {
	}

	/** full constructor */
	public Logisticsinfo(String no, Timestamp time, String catalog,
			Float weight, String buyer, String seller, String vehicleNo,
			String cmpnyName) {
		this.no = no;
		this.time = time;
		this.catalog = catalog;
		this.weight = weight;
		this.buyer = buyer;
		this.seller = seller;
		this.vehicleNo = vehicleNo;
		this.cmpnyName = cmpnyName;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNo() {
		return this.no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getCatalog() {
		return this.catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public Float getWeight() {
		return this.weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getBuyer() {
		return this.buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getSeller() {
		return this.seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getVehicleNo() {
		return this.vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getCmpnyName() {
		return this.cmpnyName;
	}

	public void setCmpnyName(String cmpnyName) {
		this.cmpnyName = cmpnyName;
	}

}