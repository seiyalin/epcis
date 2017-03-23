package org.fudan.wuxi.syfw.model.feed;

import org.fudan.wuxi.syfw.model.base.IdEntity;

/**
 * ProductCategoryRelationId entity. @author MyEclipse Persistence Tools
 */

public class AquaticProductCategoryRelation  {

	// Fields
	private Integer productId;
	private Integer categoryId;
	
	//冗余字段
	private String categoryName;

	// Constructors

	/** default constructor */
	public AquaticProductCategoryRelation() {
	}

	/** full constructor */
//	public AquaticProductCategoryRelation(Integer id, Integer productId,
//			Integer categoryId) {
//		this.id = id;
//		this.productId = productId;
//		this.categoryId = categoryId;
//	}

	// Property accessors
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}