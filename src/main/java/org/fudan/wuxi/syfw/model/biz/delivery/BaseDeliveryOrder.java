package org.fudan.wuxi.syfw.model.biz.delivery;

import java.util.Date;

/**
 * 
 * 配送流程基础订单  ，封装配送流程的基本信息
 * @author Administrator
 *
 */
public class BaseDeliveryOrder {
	
	private String orderNum;//单号
	private Date orderTime;//制单日期
	private String orderMaker;//制单人
	private String note;//备注
	
	
	
	
	
	public String getOrderNum() {
		return orderNum;
	}





	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}





	public Date getOrderTime() {
		return orderTime;
	}





	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}





	public String getOrderMaker() {
		return orderMaker;
	}





	public void setOrderMaker(String orderMaker) {
		this.orderMaker = orderMaker;
	}





	public String getNote() {
		return note;
	}





	public void setNote(String note) {
		this.note = note;
	}





	@Override
	public String toString() {
		return "BaseDeliveryOrder [orderNum=" + orderNum + ", orderTime="
				+ orderTime + ", orderMaker=" + orderMaker + ", note=" + note
				+ "]";
	}
	
	
	
	
}
