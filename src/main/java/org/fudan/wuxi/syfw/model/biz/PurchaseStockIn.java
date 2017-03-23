package org.fudan.wuxi.syfw.model.biz;

import java.util.Date;

/**
 * 采购入库单
 * @author Administrator
 *
 */
public class PurchaseStockIn {
	
	private String purchaseStockInId;//采购入库单号
	
	private Date orderTime;//制单日期
	private Date stockIntime;//入库时间
	private String orderMaker;//制单人
	private String note;//备注
	private String provider;//供应商
	private FormDetail formDetail;//表单明细

	
	
	
	
	public String getPurchaseStockInId() {
		return purchaseStockInId;
	}



	public void setPurchaseStockInId(String purchaseStockInId) {
		this.purchaseStockInId = purchaseStockInId;
	}



	public Date getOrderTime() {
		return orderTime;
	}



	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}



	public Date getStockIntime() {
		return stockIntime;
	}



	public void setStockIntime(Date stockIntime) {
		this.stockIntime = stockIntime;
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
		return "PurchaseStockIn [purchaseStockInId=" + purchaseStockInId
				+ ", orderTime=" + orderTime + ", stockIntime=" + stockIntime
				+ ", orderMaker=" + orderMaker + ", note=" + note
				+ ", provider=" + provider + ", formDetail=" + formDetail + "]";
	}
	
	
	
	
	
	





	

}
