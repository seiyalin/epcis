package org.fudan.wuxi.syfw.model.biz.delivery;

import org.fudan.wuxi.syfw.model.biz.FormDetail;
/**
 * 新增配送单
 * @author Administrator
 *
 */
public class DeliveryOrder extends BaseDeliveryOrder {
	private FormDetail  formDetail;

	public FormDetail getFormDetail() {
		return formDetail;
	}

	public void setFormDetail(FormDetail formDetail) {
		this.formDetail = formDetail;
	}
	
	

}
