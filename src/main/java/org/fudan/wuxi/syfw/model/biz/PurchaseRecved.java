package org.fudan.wuxi.syfw.model.biz;

import java.util.Date;

/**
 * 采购到货单
 * @author Administrator
 *
 */
public class PurchaseRecved {
	
	private String purchaseRecvId;//采购到货单号
	
	private String purchaseId;//采购单号（发货单所属的采购单编号 ）
	private Date orderTime;//制单日期
	private String orderMaker;//制单人
	private String note;//备注
	private String provider;//供应商
	
	private FormDetail formDetail;//表单明细
	
	
	
	

	public String getPurchaseRecvId() {
		return purchaseRecvId;
	}





	public void setPurchaseRecvId(String purchaseRecvId) {
		this.purchaseRecvId = purchaseRecvId;
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





	public String getProvider() {
		return provider;
	}





	public void setProvider(String provider) {
		this.provider = provider;
	}





	public FormDetail getFormDetail() {
		return formDetail;
	}





	public void setFormDetail(FormDetail formDetail) {
		this.formDetail = formDetail;
	}





	@Override
	public String toString() {
		return "PurchaseRecved [purchaseRecvId=" + purchaseRecvId
				+ ", purchaseId=" + purchaseId + ", orderTime=" + orderTime
				+ ", orderMaker=" + orderMaker + ", note=" + note
				+ ", provider=" + provider + ", formDetail=" + formDetail + "]";
	}
	
	

}
