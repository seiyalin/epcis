package org.fudan.wuxi.syfw.model.code;
/**
 * 业务类型编码，本研究中开发的原型系统包括采购业务和配送业务以及销售业务
 * 具体业务也采用 HTTP  URL 的方式进行编码。具体业务的编码结构为：
 *“http://www.tsinghua.edu.cn/demo/biztransactionid/”+订单编号。 
 *
 * @author Administrator
 *
 */
public class BizTransactionTypeCode {
	private String epc;//http://www.tsinghua.edu.cn/demo/biztransactiontype/po 
	
	private String transactiontypeName;//业务类型名称  比如采购业务
	
	

	public BizTransactionTypeCode(String epc, String transactiontypeName) {
		super();
		this.epc = epc;
		this.transactiontypeName = transactiontypeName;
	}


	public String getEpc() {
		return epc;
	}


	public void setEpc(String epc) {
		this.epc = epc;
	}


	public String getTransactiontypeName() {
		return transactiontypeName;
	}


	public void setTransactiontypeName(String transactiontypeName) {
		this.transactiontypeName = transactiontypeName;
	}


	@Override
	public String toString() {
		return "BizTransactionTypeCode [epc=" + epc + ", transactiontypeName="
				+ transactiontypeName + "]";
	}

	
	
}
