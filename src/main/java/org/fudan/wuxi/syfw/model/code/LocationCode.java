package org.fudan.wuxi.syfw.model.code;
/**
 * 仓库中水产品的位置编码或者是所假设的供应链区域位置编码
 * @author Administrator
 *
 */

public class LocationCode {
     private String epc;//http://www.tsinghua.edu.cn/demo/loc/unloadzone 
     private String locDesc;//位置描述  比如卸载区，或养殖企业A的B区5号池塘
	public String getEpc() {
		return epc;
	}
	public void setEpc(String epc) {
		this.epc = epc;
	}
	public String getLocDesc() {
		return locDesc;
	}
	public void setLocDesc(String locDesc) {
		this.locDesc = locDesc;
	}
	@Override
	public String toString() {
		return "LocationCode [epc=" + epc + ", locDesc=" + locDesc + "]";
	}
     
     
}
