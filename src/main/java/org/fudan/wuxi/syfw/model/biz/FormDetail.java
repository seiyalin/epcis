package org.fudan.wuxi.syfw.model.biz;
/**
 * 表单明细
 * @author Administrator
 *
 */


public class FormDetail {
	
	private String epc;//类型编码，见物品编码表
	private String serialCode;//系列码，只有物品作为单品管理时才记录
	private String productName;//具体的水产品名字
	private String spec;//规格
	private String unit;//单位
	private Integer num;//数量
	private String provider;//供应商
	
	private String shelf;//物品货位，仅入库单需要填写该字段
	
	
	public String getShelf() {
		return shelf;
	}


	public void setShelf(String shelf) {
		this.shelf = shelf;
	}


	public FormDetail(String epc, String serialCode, String productName,
			String spec, String unit, Integer num, String provider) {
		super();
		this.epc = epc;
		this.serialCode = serialCode;
		this.productName = productName;
		this.spec = spec;
		this.unit = unit;
		this.num = num;
		this.provider = provider;
	}


	public String getEpc() {
		return epc;
	}


	public void setEpc(String epc) {
		this.epc = epc;
	}


	public String getSerialCode() {
		return serialCode;
	}


	public void setSerialCode(String serialCode) {
		this.serialCode = serialCode;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getSpec() {
		return spec;
	}


	public void setSpec(String spec) {
		this.spec = spec;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public Integer getNum() {
		return num;
	}


	public void setNum(Integer num) {
		this.num = num;
	}


	public String getProvider() {
		return provider;
	}


	public void setProvider(String provider) {
		this.provider = provider;
	}


	@Override
	public String toString() {
		return "FormDetail [epc=" + epc + ", serialCode=" + serialCode
				+ ", productName=" + productName + ", spec=" + spec + ", unit="
				+ unit + ", num=" + num + ", provider=" + provider + "]";
	}
	
	
	 
	
}
