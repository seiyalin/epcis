package org.fudan.wuxi.syfw.model.hibentity;

import java.sql.Time;

/**
 * Materialpurchase entity. @author MyEclipse Persistence Tools
 */

public class Materialpurchase implements java.io.Serializable {

	// Fields

	private String materialId;
	private String name;
	private String number;
	private String materialSource;
	private Time date;

	// Constructors

	/** default constructor */
	public Materialpurchase() {
	}

	/** minimal constructor */
	public Materialpurchase(String name, String number) {
		this.name = name;
		this.number = number;
	}

	/** full constructor */
	public Materialpurchase(String name, String number, String materialSource,
			Time date) {
		this.name = name;
		this.number = number;
		this.materialSource = materialSource;
		this.date = date;
	}

	// Property accessors

	public String getMaterialId() {
		return this.materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMaterialSource() {
		return this.materialSource;
	}

	public void setMaterialSource(String materialSource) {
		this.materialSource = materialSource;
	}

	public Time getDate() {
		return this.date;
	}

	public void setDate(Time date) {
		this.date = date;
	}

}