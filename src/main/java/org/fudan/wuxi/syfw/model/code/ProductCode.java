package org.fudan.wuxi.syfw.model.code;
/**
 * 商品编码表实体类
 * @author Administrator
 *
 */
public class ProductCode  {
	private String epc;//产品编码，用来作为产品编码表的主键    urn:epc:idpat:sgtin:0614144.001145.*
	private String name;//产品名称
	private String provider;//供应商
	private String uom;//单位
	public String getEpc() {
		return epc;
	}
	public void setEpc(String epc) {
		this.epc = epc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	@Override
	public String toString() {
		return "ProductCode [epc=" + epc + ", name=" + name + ", provider="
				+ provider + ", uom=" + uom + "]";
	}
	
}
