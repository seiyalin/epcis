package org.fudan.wuxi.syfw.model.hibentity;

import java.sql.Timestamp;

/**
 * Waterquality entity. @author MyEclipse Persistence Tools
 */

public class Waterquality implements java.io.Serializable {

	// Fields

	private String id;
	private Byte ph;
	private Short temper;
	private String oxgen;
	private Timestamp testtime;

	// Constructors

	/** default constructor */
	public Waterquality() {
	}

	/** full constructor */
	public Waterquality(Byte ph, Short temper, String oxgen, Timestamp testtime) {
		this.ph = ph;
		this.temper = temper;
		this.oxgen = oxgen;
		this.testtime = testtime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Byte getPh() {
		return this.ph;
	}

	public void setPh(Byte ph) {
		this.ph = ph;
	}

	public Short getTemper() {
		return this.temper;
	}

	public void setTemper(Short temper) {
		this.temper = temper;
	}

	public String getOxgen() {
		return this.oxgen;
	}

	public void setOxgen(String oxgen) {
		this.oxgen = oxgen;
	}

	public Timestamp getTesttime() {
		return this.testtime;
	}

	public void setTesttime(Timestamp testtime) {
		this.testtime = testtime;
	}

}