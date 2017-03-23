package org.fudan.wuxi.syfw.model.code;
/**
 * 对业务步骤编码主要是用于 EPCIS 事件信息的采集，因此，只需要
 *对那些涉及到 EPCIS 事件信息采集的业务步骤进行编码。
 * @author Administrator
 *
 */
public class BizStepCode {

	private String epc;//http://www.tsinghua.edu.cn/demo/bizstep/receiving 供应商将采购商品运输到配送中
	private String bizStepName;//业务步骤名称，比如采购到货
	private String bizTypeName;//所属业务类型   如采购
	private String desc;//对于该业务步骤的描述
	
	
	public String getEpc() {
		return epc;
	}


	public void setEpc(String epc) {
		this.epc = epc;
	}


	public BizStepCode(String epc, String bizStepName, String bizTypeName,
			String desc) {
		super();
		this.epc = epc;
		this.bizStepName = bizStepName;
		this.bizTypeName = bizTypeName;
		this.desc = desc;
	}


	public String getBizStepName() {
		return bizStepName;
	}


	public void setBizStepName(String bizStepName) {
		this.bizStepName = bizStepName;
	}


	public String getBizTypeName() {
		return bizTypeName;
	}


	public void setBizTypeName(String bizTypeName) {
		this.bizTypeName = bizTypeName;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	@Override
	public String toString() {
		return "BizStepCode [epc=" + epc + ", bizStepName=" + bizStepName
				+ ", bizTypeName=" + bizTypeName + ", desc=" + desc + "]";
	}
	
	
	
}
