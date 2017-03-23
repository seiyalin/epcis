package org.fudan.wuxi.syfw.model.biz.delivery;

import java.util.Date;

import org.fudan.wuxi.syfw.model.biz.FormDetail;

/**
 * 配载单
 * @author Administrator
 *
 */
public class StowageOrder extends BaseDeliveryOrder {
	private Date stowageTime;//配载时间
	
	private String deliveryOrderNum;//配送单号，与配载单相对应的配送单号
	private String storeCode;//门店代码
	private FormDetail formDetail;
	public Date getStowageTime() {
		return stowageTime;
	}
	public void setStowageTime(Date stowageTime) {
		this.stowageTime = stowageTime;
	}
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
		return "StowageOrder [stowageTime=" + stowageTime
				+ ", deliveryOrderNum=" + deliveryOrderNum + ", storeCode="
				+ storeCode + ", formDetail=" + formDetail + "]";
	}
	
	
}
