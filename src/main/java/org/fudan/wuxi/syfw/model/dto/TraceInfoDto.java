package org.fudan.wuxi.syfw.model.dto;

import java.util.List;

import org.fudan.wuxi.syfw.model.base.IdEntity;
import org.fudan.wuxi.syfw.model.hibentity.TraceInfo;

import com.merchant.common.utils.CommonUtils;
import com.merchant.common.utils.CopyUtils;
import com.merchant.common.utils.DateUtils;

public class TraceInfoDto  extends IdEntity{

	  // Fields    

    private String epc;
    private String store;
    private String dcName;
    private String processingFac;
    private String bredingsiteName;
    private String poolName;
    private String aquticName;
    private Integer duraPeriod;
    private String storeEnv;
    private String pondTime;
    private String breedingBatchEpc;
    private String inspector;
    private String detcTime;
    private String detcIndex;
    private String detcResult;
    private String processingBatch;
    private String processingFlow;
    private String criticCtrPoint;
    private String deliveryTime;
    private String deliveryBatchEpc;

	
	public static TraceInfoDto convert(TraceInfo po) throws Exception{
		TraceInfoDto dto = new TraceInfoDto();
    	CopyUtils.copyProperty(dto, po);
    	
    	if(CommonUtils.isNotEmpty(po.getDetcTime())){
    		dto.setDetcTime(DateUtils.date2String(po.getDetcTime(),DateUtils.YYYY_MM_DD_HH_MM_SS_PATTERN));
    	}
    	if(CommonUtils.isNotEmpty(po.getPondTime())){
    		dto.setPondTime(DateUtils.date2String(po.getPondTime(),DateUtils.YYYY_MM_DD_HH_MM_SS_PATTERN));
    	}
    	if(CommonUtils.isNotEmpty(po.getDeliveryTime())){
    		dto.setDeliveryTime(DateUtils.date2String(po.getDeliveryTime(),DateUtils.YYYY_MM_DD_HH_MM_SS_PATTERN));
    	}
    	
    	return dto;
    }


	public String getEpc() {
		return epc;
	}


	public void setEpc(String epc) {
		this.epc = epc;
	}


	public String getStore() {
		return store;
	}


	public void setStore(String store) {
		this.store = store;
	}


	public String getDcName() {
		return dcName;
	}


	public void setDcName(String dcName) {
		this.dcName = dcName;
	}


	public String getProcessingFac() {
		return processingFac;
	}


	public void setProcessingFac(String processingFac) {
		this.processingFac = processingFac;
	}


	public String getBredingsiteName() {
		return bredingsiteName;
	}


	public void setBredingsiteName(String bredingsiteName) {
		this.bredingsiteName = bredingsiteName;
	}


	public String getPoolName() {
		return poolName;
	}


	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}


	public String getAquticName() {
		return aquticName;
	}


	public void setAquticName(String aquticName) {
		this.aquticName = aquticName;
	}


	public Integer getDuraPeriod() {
		return duraPeriod;
	}


	public void setDuraPeriod(Integer duraPeriod) {
		this.duraPeriod = duraPeriod;
	}


	public String getStoreEnv() {
		return storeEnv;
	}


	public void setStoreEnv(String storeEnv) {
		this.storeEnv = storeEnv;
	}


	public String getPondTime() {
		return pondTime;
	}


	public void setPondTime(String pondTime) {
		this.pondTime = pondTime;
	}


	public String getBreedingBatchEpc() {
		return breedingBatchEpc;
	}


	public void setBreedingBatchEpc(String breedingBatchEpc) {
		this.breedingBatchEpc = breedingBatchEpc;
	}


	public String getInspector() {
		return inspector;
	}


	public void setInspector(String inspector) {
		this.inspector = inspector;
	}


	public String getDetcTime() {
		return detcTime;
	}


	public void setDetcTime(String detcTime) {
		this.detcTime = detcTime;
	}


	public String getDetcIndex() {
		return detcIndex;
	}


	public void setDetcIndex(String detcIndex) {
		this.detcIndex = detcIndex;
	}


	public String getDetcResult() {
		return detcResult;
	}


	public void setDetcResult(String detcResult) {
		this.detcResult = detcResult;
	}


	public String getProcessingBatch() {
		return processingBatch;
	}


	public void setProcessingBatch(String processingBatch) {
		this.processingBatch = processingBatch;
	}


	public String getProcessingFlow() {
		return processingFlow;
	}


	public void setProcessingFlow(String processingFlow) {
		this.processingFlow = processingFlow;
	}


	public String getCriticCtrPoint() {
		return criticCtrPoint;
	}


	public void setCriticCtrPoint(String criticCtrPoint) {
		this.criticCtrPoint = criticCtrPoint;
	}


	public String getDeliveryTime() {
		return deliveryTime;
	}


	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}


	public String getDeliveryBatchEpc() {
		return deliveryBatchEpc;
	}


	public void setDeliveryBatchEpc(String deliveryBatchEpc) {
		this.deliveryBatchEpc = deliveryBatchEpc;
	}

	
	


	
}
