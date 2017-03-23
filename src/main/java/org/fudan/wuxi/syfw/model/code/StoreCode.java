package org.fudan.wuxi.syfw.model.code;

public class StoreCode {
	
	private String epc;
	private String storecode;//门店代码
	private String lat;//纬度
	private String lon;//经度
	private String starttime;//送货起始时间
	private String endtime;//送货截止时间
	public String getEpc() {
		return epc;
	}
	public void setEpc(String epc) {
		this.epc = epc;
	}
	public String getStorecode() {
		return storecode;
	}
	public void setStorecode(String storecode) {
		this.storecode = storecode;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	@Override
	public String toString() {
		return "StoreCode [epc=" + epc + ", storecode=" + storecode + ", lat="
				+ lat + ", lon=" + lon + ", starttime=" + starttime
				+ ", endtime=" + endtime + "]";
	}
	

}
