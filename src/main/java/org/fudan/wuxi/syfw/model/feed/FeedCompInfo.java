package org.fudan.wuxi.syfw.model.feed;

/**
 * 养殖企业信息
 * @author Administrator
 *
 */
public class FeedCompInfo {
	private String baseAddr;
	private String represent;
	private String addr;
	private String tel;
	private String bizLicense;//营业执照
	
	
	public FeedCompInfo() {
		super();
	}
	public FeedCompInfo(String baseAddr, String represent, String addr,
			String tel, String bizLicense) {
		super();
		this.baseAddr = baseAddr;
		this.represent = represent;
		this.addr = addr;
		this.tel = tel;
		this.bizLicense = bizLicense;
	}
	public String getBaseAddr() {
		return baseAddr;
	}
	public void setBaseAddr(String baseAddr) {
		this.baseAddr = baseAddr;
	}
	public String getRepresent() {
		return represent;
	}
	public void setRepresent(String represent) {
		this.represent = represent;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBizLicense() {
		return bizLicense;
	}
	public void setBizLicense(String bizLicense) {
		this.bizLicense = bizLicense;
	}
	@Override
	public String toString() {
		return "FeedCompInfo [baseAddr=" + baseAddr + ", represent="
				+ represent + ", addr=" + addr + ", tel=" + tel
				+ ", bizLicense=" + bizLicense + "]";
	}
	
	
}
