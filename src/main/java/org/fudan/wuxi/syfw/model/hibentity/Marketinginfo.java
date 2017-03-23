package org.fudan.wuxi.syfw.model.hibentity;

import java.util.Date;

/**
 * Marketinginfo entity. @author MyEclipse Persistence Tools
 */

public class Marketinginfo implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String clerkNum;
	private String tranNum;
	private String epc;
	private String aquaticName;
	private Float price;
	private Float weight;
	private String payStyle;
	private Date finishTime;
	private String catalog;

	// Constructors

	/** default constructor */
	public Marketinginfo() {
	}

	/** full constructor */
	public Marketinginfo(String name, String clerkNum, String tranNum,
			String epc, String aquaticName, Float price, Float weight,
			String payStyle, Date finishTime, String catalog) {
		this.name = name;
		this.clerkNum = clerkNum;
		this.tranNum = tranNum;
		this.epc = epc;
		this.aquaticName = aquaticName;
		this.price = price;
		this.weight = weight;
		this.payStyle = payStyle;
		this.finishTime = finishTime;
		this.catalog = catalog;
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

	public String getClerkNum() {
		return this.clerkNum;
	}

	public void setClerkNum(String clerkNum) {
		this.clerkNum = clerkNum;
	}

	public String getTranNum() {
		return this.tranNum;
	}

	public void setTranNum(String tranNum) {
		this.tranNum = tranNum;
	}

	public String getEpc() {
		return this.epc;
	}

	public void setEpc(String epc) {
		this.epc = epc;
	}

	public String getAquaticName() {
		return this.aquaticName;
	}

	public void setAquaticName(String aquaticName) {
		this.aquaticName = aquaticName;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getWeight() {
		return this.weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getPayStyle() {
		return this.payStyle;
	}

	public void setPayStyle(String payStyle) {
		this.payStyle = payStyle;
	}

	public Date getFinishTime() {
		return this.finishTime;
	}

	public void setFinishTime(Date date) {
		this.finishTime = date;
	}

	public String getCatalog() {
		return this.catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

}