package org.fudan.wuxi.syfw.model.feed;

import java.util.HashSet;
import java.util.Set;

import org.fudan.wuxi.syfw.model.base.IdEntity;

/**
 * 水产品种类表 entity. @author MyEclipse Persistence Tools
 */

public class AquaticProductCategory extends IdEntity  {

	// Fields
	private String name;
	private Integer parentId;
	private int orderNo;

	// 项目下的多个员工
     private Set<AquaticProductInfo> productInfos = new HashSet<AquaticProductInfo>();
	
	
	// Constructors

	public Set<AquaticProductInfo> getProductInfos() {
		return productInfos;
	}

	public void setProductInfos(Set<AquaticProductInfo> productInfos) {
		this.productInfos = productInfos;
	}

	/** default constructor */
	public AquaticProductCategory() {
	}

	/** full constructor */
	public AquaticProductCategory(String id, String name, Integer parentId) {
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}

	// Property accessors


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AquaticProductCategory))
			return false;
		AquaticProductCategory castOther = (AquaticProductCategory) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getParentId() == castOther.getParentId()) || (this
						.getParentId() != null
						&& castOther.getParentId() != null && this
						.getParentId().equals(castOther.getParentId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getParentId() == null ? 0 : this.getParentId().hashCode());
		return result;
	}

}