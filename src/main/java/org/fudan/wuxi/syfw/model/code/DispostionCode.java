package org.fudan.wuxi.syfw.model.code;
/**
 * 物品状态编码       物品状态是指与EPC相关联的对象的业务情况。物品状态直到随后的EPCIS事件发生之前都保持不变。
 * @author Administrator
 *
 */
public class DispostionCode {
	private String epc;//http://www.tsinghua.edu.cn/demo/disposition/received 
	private String status;//已收货 ,库存中 ,已锁定,已拣货,已配载 ,已到门店 
	private String bizTransaction;//所属业务
	
	
	public DispostionCode(String epc, String status, String bizTransaction) {
		super();
		this.epc = epc;
		this.status = status;
		this.bizTransaction = bizTransaction;
	}
	
	public String getEpc() {
		return epc;
	}
	public void setEpc(String epc) {
		this.epc = epc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBizTransaction() {
		return bizTransaction;
	}
	public void setBizTransaction(String bizTransaction) {
		this.bizTransaction = bizTransaction;
	}
	@Override
	public String toString() {
		return "DispostionCode [epc=" + epc + ", status=" + status
				+ ", bizTransaction=" + bizTransaction + "]";
	}
	
	

}
