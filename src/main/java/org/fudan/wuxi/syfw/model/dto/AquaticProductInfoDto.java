package org.fudan.wuxi.syfw.model.dto;

import java.util.Arrays;

import org.fudan.wuxi.syfw.model.base.IdEntity;
import org.fudan.wuxi.syfw.model.feed.AquaticProductInfo;

import com.merchant.common.utils.CommonUtils;
import com.merchant.common.utils.CopyUtils;
import com.merchant.common.utils.DateUtils;

public class AquaticProductInfoDto extends IdEntity{
	// Fields

	private String name;
	private String thumbnail;
	private String brief;
	private String description;
	private String no;
	private Integer storage;

	private int status; // 1.未上架,2.上架,3.删除
	private String createdTime;
	// Constructors

	// add by gavin:整合字段
	private String proNumber;// 项目编号(无)
	private String nameEn; // 产品英文名，输入框
	private String pitcure;// 产品大图,图片控件
	private String specification; // 产品规格，输入框
	private int brand; // 品牌，下拉框，外键关联
	private double price;// 产品价格，输入框
	private int pirceUnit;// 价格单位，默认为1，人民币
	private int expiration; // 保质期
	private int expirationUnit;// 保质期单位，下拉框:1.年，2.月，3.日，4.小时
	private String sourceArea;// 原产地，输入框
	// end
	private String expirationUnitStr;

	// 冗余字段
	private String[] catalogies;
	private String[] catalogiesName;


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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
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

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brand;
		result = prime * result + ((brief == null) ? 0 : brief.hashCode());
		result = prime * result + Arrays.hashCode(catalogies);
		result = prime * result + Arrays.hashCode(catalogiesName);
		result = prime * result
				+ ((createdTime == null) ? 0 : createdTime.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + expiration;
		result = prime * result + expirationUnit;
		result = prime
				* result
				+ ((expirationUnitStr == null) ? 0 : expirationUnitStr
						.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nameEn == null) ? 0 : nameEn.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + pirceUnit;
		result = prime * result + ((pitcure == null) ? 0 : pitcure.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((proNumber == null) ? 0 : proNumber.hashCode());
		result = prime * result
				+ ((sourceArea == null) ? 0 : sourceArea.hashCode());
		result = prime * result
				+ ((specification == null) ? 0 : specification.hashCode());
		result = prime * result + status;
		result = prime * result + ((storage == null) ? 0 : storage.hashCode());
		result = prime * result
				+ ((thumbnail == null) ? 0 : thumbnail.hashCode());
		return result;
	}

	public static AquaticProductInfoDto convert(AquaticProductInfo po) throws Exception {
		AquaticProductInfoDto dto = new AquaticProductInfoDto();
		CopyUtils.copyProperty(dto, po);

		if (CommonUtils.isNotEmpty(po.getCreatedTime())) {
			dto.setCreatedTime(DateUtils.date2String(po.getCreatedTime(),
					DateUtils.YYYY_MM_DD_HH_MM_SS_PATTERN));
		}

		switch (po.getExpirationUnit()) {
		case 1:
			dto.setExpirationUnitStr("年");
			break;
		case 2:
			dto.setExpirationUnitStr("月");
			break;
		case 3:
			dto.setExpirationUnitStr("日");
			break;
		case 4:
			dto.setExpirationUnitStr("小时");
			break;
		default:
			dto.setExpirationUnitStr("小时");
			break;
		}
		return dto;
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

	public int getBrand() {
		return brand;
	}

	public void setBrand(int brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPirceUnit() {
		return pirceUnit;
	}

	public void setPirceUnit(int pirceUnit) {
		this.pirceUnit = pirceUnit;
	}

	public int getExpiration() {
		return expiration;
	}

	public void setExpiration(int expiration) {
		this.expiration = expiration;
	}

	public int getExpirationUnit() {
		return expirationUnit;
	}

	public void setExpirationUnit(int expirationUnit) {
		this.expirationUnit = expirationUnit;
	}

	public String getSourceArea() {
		return sourceArea;
	}

	public void setSourceArea(String sourceArea) {
		this.sourceArea = sourceArea;
	}

	public String getExpirationUnitStr() {
		return expirationUnitStr;
	}

	public void setExpirationUnitStr(String expirationUnitStr) {
		this.expirationUnitStr = expirationUnitStr;
	}

	
	
	@Override
	public String toString() {
		return "AquaticProductInfoDto [name=" + name + ", thumbnail="
				+ thumbnail + ", brief=" + brief + ", description="
				+ description + ", no=" + no + ", storage=" + storage
				+ ", status=" + status + ", createdTime=" + createdTime
				+ ", proNumber=" + proNumber + ", nameEn=" + nameEn
				+ ", pitcure=" + pitcure + ", specification=" + specification
				+ ", brand=" + brand + ", price=" + price + ", pirceUnit="
				+ pirceUnit + ", expiration=" + expiration
				+ ", expirationUnit=" + expirationUnit + ", sourceArea="
				+ sourceArea + ", expirationUnitStr=" + expirationUnitStr
				+ ", catalogies=" + Arrays.toString(catalogies)
				+ ", catalogiesName=" + Arrays.toString(catalogiesName) + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AquaticProductInfoDto other = (AquaticProductInfoDto) obj;
		if (brand != other.brand)
			return false;
		if (brief == null) {
			if (other.brief != null)
				return false;
		} else if (!brief.equals(other.brief))
			return false;
		if (!Arrays.equals(catalogies, other.catalogies))
			return false;
		if (!Arrays.equals(catalogiesName, other.catalogiesName))
			return false;
		if (createdTime == null) {
			if (other.createdTime != null)
				return false;
		} else if (!createdTime.equals(other.createdTime))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (expiration != other.expiration)
			return false;
		if (expirationUnit != other.expirationUnit)
			return false;
		if (expirationUnitStr == null) {
			if (other.expirationUnitStr != null)
				return false;
		} else if (!expirationUnitStr.equals(other.expirationUnitStr))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nameEn == null) {
			if (other.nameEn != null)
				return false;
		} else if (!nameEn.equals(other.nameEn))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (pirceUnit != other.pirceUnit)
			return false;
		if (pitcure == null) {
			if (other.pitcure != null)
				return false;
		} else if (!pitcure.equals(other.pitcure))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (proNumber == null) {
			if (other.proNumber != null)
				return false;
		} else if (!proNumber.equals(other.proNumber))
			return false;
		if (sourceArea == null) {
			if (other.sourceArea != null)
				return false;
		} else if (!sourceArea.equals(other.sourceArea))
			return false;
		if (specification == null) {
			if (other.specification != null)
				return false;
		} else if (!specification.equals(other.specification))
			return false;
		if (status != other.status)
			return false;
		if (storage == null) {
			if (other.storage != null)
				return false;
		} else if (!storage.equals(other.storage))
			return false;
		if (thumbnail == null) {
			if (other.thumbnail != null)
				return false;
		} else if (!thumbnail.equals(other.thumbnail))
			return false;
		return true;
	}

	
	
}