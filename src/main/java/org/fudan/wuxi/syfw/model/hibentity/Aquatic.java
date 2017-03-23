package org.fudan.wuxi.syfw.model.hibentity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Aquatic entity. @author MyEclipse Persistence Tools
 */

public class Aquatic implements java.io.Serializable {

	// Fields

	private String id;
	private String aquId;
	private String epc;
	private Float weight;
	private Timestamp saletime;
	private Timestamp fishtime;
	private String sellstyle;
	private String name;
	private Integer status;
	private String nameEn;
	private String thumbnail;
	private String picture;
	private String brief;
	private String description;
	private String sourceArea;
	private Float price;
	private String priceUnit;
	private Set aquaticContainers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Aquatic() {
	}

	/** minimal constructor */
	public Aquatic(String aquId, String epc) {
		this.aquId = aquId;
		this.epc = epc;
	}

	/** full constructor */
	public Aquatic(String aquId, String epc, Float weight, Timestamp saletime,
			Timestamp fishtime, String sellstyle, String name, Integer status,
			String nameEn, String thumbnail, String picture, String brief,
			String description, String sourceArea, Float price,
			String priceUnit, Set aquaticContainers) {
		this.aquId = aquId;
		this.epc = epc;
		this.weight = weight;
		this.saletime = saletime;
		this.fishtime = fishtime;
		this.sellstyle = sellstyle;
		this.name = name;
		this.status = status;
		this.nameEn = nameEn;
		this.thumbnail = thumbnail;
		this.picture = picture;
		this.brief = brief;
		this.description = description;
		this.sourceArea = sourceArea;
		this.price = price;
		this.priceUnit = priceUnit;
		this.aquaticContainers = aquaticContainers;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAquId() {
		return this.aquId;
	}

	public void setAquId(String aquId) {
		this.aquId = aquId;
	}

	public String getEpc() {
		return this.epc;
	}

	public void setEpc(String epc) {
		this.epc = epc;
	}

	public Float getWeight() {
		return this.weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Timestamp getSaletime() {
		return this.saletime;
	}

	public void setSaletime(Timestamp saletime) {
		this.saletime = saletime;
	}

	public Timestamp getFishtime() {
		return this.fishtime;
	}

	public void setFishtime(Timestamp fishtime) {
		this.fishtime = fishtime;
	}

	public String getSellstyle() {
		return this.sellstyle;
	}

	public void setSellstyle(String sellstyle) {
		this.sellstyle = sellstyle;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getThumbnail() {
		return this.thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSourceArea() {
		return this.sourceArea;
	}

	public void setSourceArea(String sourceArea) {
		this.sourceArea = sourceArea;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getPriceUnit() {
		return this.priceUnit;
	}

	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}

	public Set getAquaticContainers() {
		return this.aquaticContainers;
	}

	public void setAquaticContainers(Set aquaticContainers) {
		this.aquaticContainers = aquaticContainers;
	}

}