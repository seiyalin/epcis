package org.fudan.wuxi.syfw.model.biz.delivery;

import java.util.Date;

import org.fudan.wuxi.syfw.model.biz.FormDetail;

/**
 * 车辆回队确认
 * @author Administrator
 *
 */
public class ViechleBack extends BaseDeliveryOrder {
	private Date backTime;//车辆回队确认时间
	private String deliveryOrderNum;//配送单号，与配载单相对应的配送单号
	private String storeCode;//门店代码
	private FormDetail formDetail;
	
	
	public Date getBackTime() {
		return backTime;
	}


	public void setBackTime(Date backTime) {
		this.backTime = backTime;
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
		return "ViechleBack [backTime=" + backTime + ", deliveryOrderNum="
				+ deliveryOrderNum + ", storeCode=" + storeCode
				+ ", formDetail=" + formDetail + "]";
	}
	
	
	
}
