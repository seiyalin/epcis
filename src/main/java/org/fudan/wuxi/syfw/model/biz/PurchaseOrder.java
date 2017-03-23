package org.fudan.wuxi.syfw.model.biz;

import java.util.Date;

/**
 * 采购订单用于向供应商提出采购要求，当仓库中出现货品短缺或者根据库存管理预测需要采购时配送中心将货品需求填写进采购订单，发给货品的供应商。
 *采购订单包含单据基本信息和采购产品明细，
 * 
 * 采购订单仅负责记录采购订单作为凭据，不用采集事件信息。 
 * @author Administrator
 *
 */
public class PurchaseOrder {
	private String purchaseId;//采购单号
	private Date orderTime;//制单日期
	private String orderMaker;//制单人
	private String note;//备注
	private FormDetail formDetail;//表单明细
	
	
	
	
	
	public PurchaseOrder(String purchaseId, Date orderTime, String orderMaker,
			String note, FormDetail formDetail) {
		super();
		this.purchaseId = purchaseId;
		this.orderTime = orderTime;
		this.orderMaker = orderMaker;
		this.note = note;
		this.formDetail = formDetail;
	}





	public String getPurchaseId() {
		return purchaseId;
	}





	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
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





	public FormDetail getFormDetail() {
		return formDetail;
	}





	public void setFormDetail(FormDetail formDetail) {
		this.formDetail = formDetail;
	}





	@Override
	public String toString() {
		return "PurchaseOrder [purchaseId=" + purchaseId + ", orderTime="
				+ orderTime + ", orderMaker=" + orderMaker + ", note=" + note
				+ ", formDetail=" + formDetail + "]";
	}
	
	
	
	
}
