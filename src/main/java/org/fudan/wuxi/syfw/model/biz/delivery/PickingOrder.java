package org.fudan.wuxi.syfw.model.biz.delivery;

import org.fudan.wuxi.syfw.model.biz.FormDetail;

/**
 * 拣货单
 * @author Administrator
 * 操作人员根据配送单中标示的产品明细和锁定的产品的货位，将货品拣出，
 *	运送到配载区，等待配载。
 */
public class PickingOrder extends BaseDeliveryOrder {
	private String deliveryOrderNum;//配送单号，与配载单相对应的配送单号
	private String storeCode;//门店代码
	private FormDetail formDetail;
	
	
	public String getDeliveryOrderNum() {
		return deliveryOrderNum;
	}
	public void setDeliveryOrderNum(String deliveryOrderNum) {
		this.deliveryOrderNum = deliveryOrderNum;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public FormDetail getFormDetail() {
		return formDetail;
	}
	public void setFormDetail(FormDetail formDetail) {
		this.formDetail = formDetail;
	}
	@Override
	public String toString() {
		return "PickingOrder [deliveryOrderNum=" + deliveryOrderNum
				+ ", storeCode=" + storeCode + ", formDetail=" + formDetail
				+ "]";
	}
	
	
	
	
	
}
