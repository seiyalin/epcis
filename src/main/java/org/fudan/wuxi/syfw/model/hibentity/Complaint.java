package org.fudan.wuxi.syfw.model.hibentity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Complaint entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
public class Complaint implements java.io.Serializable {

	// Constructors

	/** default constructor */
/*	public Complaint() {
	}

	*//** minimal constructor *//*
	public Complaint(String status, String beComp, String content,
			Timestamp compTime) {
		super(status, beComp, content, compTime);
	}

	*//** full constructor *//*
	public Complaint(String status, String beComp, String content,
			Timestamp compTime, String complainant, Long tele, String result,
			Timestamp resTime, Set qandas) {
		super(status, beComp, content, compTime, complainant, tele, result,
				resTime, qandas);
	}*/
	
	private String compId;
	private String status;
	private String beComp;
	private String cmp_content;

	private Date compTime;
	private String complainant;
	private Long tele;
	private String result;
	private Timestamp resTime;
	private Set qandas = new HashSet(0);

	// Constructors

	/** default constructor */
	public Complaint() {
	}

	/** minimal constructor */
	public Complaint(String status, String beComp, String content,
			Timestamp compTime) {
		this.status = status;
		this.beComp = beComp;
		this.cmp_content = content;
		this.compTime = compTime;
	}

	/** full constructor */
	public Complaint(String status, String beComp, String content,
			Date compTime, String complainant, Long tele, String result,
			Timestamp resTime, Set qandas) {
		this.status = status;
		this.beComp = beComp;
		this.cmp_content = content;
		this.compTime = compTime;
		this.complainant = complainant;
		this.tele = tele;
		this.result = result;
		this.resTime = resTime;
		this.qandas = qandas;
	}

	// Property accessors

	public String getCompId() {
		return this.compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBeComp() {
		return this.beComp;
	}

	public void setBeComp(String beComp) {
		this.beComp = beComp;
	}

/*	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
*/
	/*@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai") */ 

	public Date getCompTime() {
	
		/*Timestamp t = new Timestamp(System.currentTimeMillis());
		return t;*/
		return this.compTime;
	}

	public void setCompTime(Date compTime) {
		
		this.compTime = compTime;
	}

	public String getComplainant() {
		return this.complainant;
	}

	public void setComplainant(String complainant) {
		this.complainant = complainant;
	}

	public Long getTele() {
		return this.tele;
	}

	public void setTele(Long tele) {
		this.tele = tele;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Timestamp getResTime() {
		return this.resTime;
	}

	public void setResTime(Timestamp resTime) {
		this.resTime = resTime;
	}

	public Set getQandas() {
		return this.qandas;
	}

	public void setQandas(Set qandas) {
		this.qandas = qandas;
	}

	public String getCmp_content() {
		return cmp_content;
	}

	public void setCmp_content(String cmp_content) {
		this.cmp_content = cmp_content;
	}


}
