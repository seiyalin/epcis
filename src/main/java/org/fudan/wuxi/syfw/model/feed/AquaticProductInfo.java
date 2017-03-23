package org.fudan.wuxi.syfw.model.feed;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.fudan.wuxi.syfw.model.base.IdEntity;


/**
 * 
 * 水产品基本信息：用来描述水产品的基本属性的静态信息，包括水产品
 *种类、产地、名称等。
 * ProductInfoId entity. @author MyEclipse Persistence Tools
 */

public class AquaticProductInfo extends IdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields
	private String name;//水产品名称
	private String sourceArea;//原产地，输入框
	private String epc;//此种水产品对应的产品编码，假设用养殖主用户自己录入
	
	
	public String getEpc() {
		return epc;
	}

	public void setEpc(String epc) {
		this.epc = epc;
	}

	// 项目下的多个员工
	private Set<AquaticProductCategory> catalogiesset = new HashSet<AquaticProductCategory>();
	
	@Override
	public String toString() {
		return "AquaticProductInfo [name=" + name + ", sourceArea="
				+ sourceArea + ", catalogiesset=" + catalogiesset
				+ ", catalogies=" + Arrays.toString(catalogies)
				+ ", catalogiesName=" + Arrays.toString(catalogiesName)
				+ ", thumbnail=" + thumbnail + ", brief=" + brief
				+ ", description=" + description + ", no=" + no + ", storage="
				+ storage + ", status=" + status + ", createdTime="
				+ createdTime + ", proNumber=" + proNumber + ", nameEn="
				+ nameEn + ", pitcure=" + pitcure + ", specification="
				+ specification + ", brand=" + brand + ", price=" + price
				+ ", pirceUnit=" + pirceUnit + ", expiration=" + expiration
				+ ", expirationUnit=" + expirationUnit + ", brandName="
				+ brandName + ", isDelete=" + isDelete + "]";
	}

	public Set<AquaticProductCategory> getCatalogiesset() {
		return catalogiesset;
	}

	public void setCatalogiesset(Set<AquaticProductCategory> catalogiesset) {
		this.catalogiesset = catalogiesset;
	}

	// 冗余字段
	private String[] catalogies;//水产品种类
	private String[] catalogiesName;
	
	
	
	private String thumbnail;//缩略图
	private String brief;   //简介
	private String description; //详情
	private String no;  
	private Integer storage;  

	private Integer status; // 1.未上架,2.上架,3.删除
	private Date createdTime;

	// add by gavin:整合字段
	private String proNumber;// 项目编号(无)
	private String nameEn; // 产品英文名，输入框
	private String pitcure;// 产品大图,图片控件
	private String specification; // 产品规格，输入框
	private Integer brand; // 品牌，下拉框，外键关联
	private Double price;// 产品价格，输入框
	private Integer pirceUnit;// 价格单位，默认为1，人民币
	private Integer expiration; // 保质期
	private Integer expirationUnit;// 保质期单位，下拉框:1.年，2.月，3.日，4.小时

	private String brandName;//品牌名称
	// end


	private Integer isDelete;

	/** default constructor */
	public AquaticProductInfo() {
	}

	/** full constructor */
	public AquaticProductInfo(String id, String name, String thumbnail, String brief,
			String detail, String no, Integer storage) {
		this.id = id;
		this.name = name;
		this.thumbnail = thumbnail;
		this.brief = brief;
		this.no = no;
		this.storage = storage;
	}

	// Property accessors
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnail() {
		return this.thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNo() {
		return this.no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Integer getStorage() {
		return this.storage;
	}

	public void setStorage(Integer storage) {
		this.storage = storage;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String[] getCatalogies() {
		return catalogies;
	}

	public void setCatalogies(String[] catalogies) {
		this.catalogies = catalogies;
	}

	public String[] getCatalogiesName() {
		return catalogiesName;
	}

	public void setCatalogiesName(String[] catalogiesName) {
		this.catalogiesName = catalogiesName;
	}

	public String getProNumber() {
		return proNumber;
	}

	public void setProNumber(String proNumber) {
		this.proNumber = proNumber;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getPitcure() {
		return pitcure;
	}

	public void setPitcure(String pitcure) {
		this.pitcure = pitcure;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Integer getBrand() {
		return brand;
	}

	public void setBrand(Integer brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getPirceUnit() {
		return pirceUnit;
	}

	public void setPirceUnit(Integer pirceUnit) {
		this.pirceUnit = pirceUnit;
	}

	public Integer getExpiration() {
		return expiration;
	}

	public void setExpiration(Integer expiration) {
		this.expiration = expiration;
	}

	public Integer getExpirationUnit() {
		return expirationUnit;
	}

	public void setExpirationUnit(Integer expirationUnit) {
		this.expirationUnit = expirationUnit;
	}

	public String getSourceArea() {
		return sourceArea;
	}

	public void setSourceArea(String sourceArea) {
		this.sourceArea = sourceArea;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AquaticProductInfo))
			return false;
		AquaticProductInfo castOther = (AquaticProductInfo) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getThumbnail() == castOther.getThumbnail()) || (this
						.getThumbnail() != null
						&& castOther.getThumbnail() != null && this
						.getThumbnail().equals(castOther.getThumbnail())))
				&& ((this.getBrief() == castOther.getBrief()) || (this
						.getBrief() != null && castOther.getBrief() != null && this
						.getBrief().equals(castOther.getBrief())))

				&& ((this.getNo() == castOther.getNo()) || (this.getNo() != null
						&& castOther.getNo() != null && this.getNo().equals(
						castOther.getNo())))
				&& ((this.getStorage() == castOther.getStorage()) || (this
						.getStorage() != null && castOther.getStorage() != null && this
						.getStorage().equals(castOther.getStorage())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getThumbnail() == null ? 0 : this.getThumbnail().hashCode());
		result = 37 * result
				+ (getBrief() == null ? 0 : this.getBrief().hashCode());

		result = 37 * result + (getNo() == null ? 0 : this.getNo().hashCode());
		result = 37 * result
				+ (getStorage() == null ? 0 : this.getStorage().hashCode());
		return result;
	}

}