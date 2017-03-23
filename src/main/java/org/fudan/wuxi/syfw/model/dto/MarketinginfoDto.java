package org.fudan.wuxi.syfw.model.dto;


import org.fudan.wuxi.syfw.model.hibentity.Marketinginfo;

import com.merchant.common.utils.CommonUtils;
import com.merchant.common.utils.CopyUtils;
import com.merchant.common.utils.DateUtils;

public class MarketinginfoDto {
	private String id;
	private String name;
	private String clerkNum;
	private String tranNum;
	private String epc;
	private String aquaticName;
	private Float price;
	private Float weight;
	private String payStyle;
	private String finishTime;
	private String catalog;

	
	
	
	
	public static MarketinginfoDto convert(Marketinginfo po) throws Exception{
//		//订单完成时间又后台生成
//		if( po != null){
//			if(po.getFinishTime()!=null){//之前没有
//				po.setFinishTime(new Date());
//			}
//			
//		}
//		
		MarketinginfoDto dto = new MarketinginfoDto();
    	CopyUtils.copyProperty(dto, po);
    	if(CommonUtils.isNotEmpty(po.getFinishTime())){
    		dto.setFinishTime(DateUtils.date2String(po.getFinishTime(),DateUtils.YYYY_MM_DD_HH_MM_SS_PATTERN));
    	}
    	
    	return dto;
    }





	public String getId() {
		return id;
	}





	public void setId(String id) {
		this.id = id;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getClerkNum() {
		return clerkNum;
	}





	public void setClerkNum(String clerkNum) {
		this.clerkNum = clerkNum;
	}





	public String getTranNum() {
		return tranNum;
	}





	public void setTranNum(String tranNum) {
		this.tranNum = tranNum;
	}





	public String getEpc() {
		return epc;
	}





	public void setEpc(String epc) {
		this.epc = epc;
	}





	public String getAquaticName() {
		return aquaticName;
	}





	public void setAquaticName(String aquaticName) {
		this.aquaticName = aquaticName;
	}





	public Float getPrice() {
		return price;
	}





	public void setPrice(Float price) {
		this.price = price;
	}





	public Float getWeight() {
		return weight;
	}





	public void setWeight(Float weight) {
		this.weight = weight;
	}





	public String getPayStyle() {
		return payStyle;
	}





	public void setPayStyle(String payStyle) {
		this.payStyle = payStyle;
	}





	public String getFinishTime() {
		return finishTime;
	}





	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}





	public String getCatalog() {
		return catalog;
	}





	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	
	
	
}
