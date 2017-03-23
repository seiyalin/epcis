package org.fudan.wuxi.syfw.model.hibentity;

import java.sql.Date;


/**
 * TraceInfo entity. @author MyEclipse Persistence Tools
 */

public class TraceInfo  implements java.io.Serializable {


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
     private Date pondTime;
     private String breedingBatchEpc;
     private String inspector;
     private Date detcTime;
     private String detcIndex;
     private String detcResult;
     private String processingBatch;
     private String processingFlow;
     private String criticCtrPoint;
     private Date deliveryTime;
     private String deliveryBatchEpc;


    // Constructors

    /** default constructor */
    public TraceInfo() {
    }

	/** minimal constructor */
    public TraceInfo(String epc) {
        this.epc = epc;
    }
    
    /** full constructor */
    public TraceInfo(String epc, String store, String dcName, String processingFac, String bredingsiteName, String poolName, String aquticName, Integer duraPeriod, String storeEnv, Date pondTime, String breedingBatchEpc, String inspector, Date detcTime, String detcIndex, String detcResult, String processingBatch, String processingFlow, String criticCtrPoint, Date deliveryTime, String deliveryBatchEpc) {
        this.epc = epc;
        this.store = store;
        this.dcName = dcName;
        this.processingFac = processingFac;
        this.bredingsiteName = bredingsiteName;
        this.poolName = poolName;
        this.aquticName = aquticName;
        this.duraPeriod = duraPeriod;
        this.storeEnv = storeEnv;
        this.pondTime = pondTime;
        this.breedingBatchEpc = breedingBatchEpc;
        this.inspector = inspector;
        this.detcTime = detcTime;
        this.detcIndex = detcIndex;
        this.detcResult = detcResult;
        this.processingBatch = processingBatch;
        this.processingFlow = processingFlow;
        this.criticCtrPoint = criticCtrPoint;
        this.deliveryTime = deliveryTime;
        this.deliveryBatchEpc = deliveryBatchEpc;
    }

   
    // Property accessors

    public String getEpc() {
        return this.epc;
    }
    
    public void setEpc(String epc) {
        this.epc = epc;
    }

    public String getStore() {
        return this.store;
    }
    
    public void setStore(String store) {
        this.store = store;
    }

    public String getDcName() {
        return this.dcName;
    }
    
    public void setDcName(String dcName) {
        this.dcName = dcName;
    }

    public String getProcessingFac() {
        return this.processingFac;
    }
    
    public void setProcessingFac(String processingFac) {
        this.processingFac = processingFac;
    }

    public String getBredingsiteName() {
        return this.bredingsiteName;
    }
    
    public void setBredingsiteName(String bredingsiteName) {
        this.bredingsiteName = bredingsiteName;
    }

    public String getPoolName() {
        return this.poolName;
    }
    
    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public String getAquticName() {
        return this.aquticName;
    }
    
    public void setAquticName(String aquticName) {
        this.aquticName = aquticName;
    }

    public Integer getDuraPeriod() {
        return this.duraPeriod;
    }
    
    public void setDuraPeriod(Integer duraPeriod) {
        this.duraPeriod = duraPeriod;
    }

    public String getStoreEnv() {
        return this.storeEnv;
    }
    
    public void setStoreEnv(String storeEnv) {
        this.storeEnv = storeEnv;
    }

    public Date getPondTime() {
        return this.pondTime;
    }
    
    public void setPondTime(Date pondTime) {
        this.pondTime = pondTime;
    }

    public String getBreedingBatchEpc() {
        return this.breedingBatchEpc;
    }
    
    public void setBreedingBatchEpc(String breedingBatchEpc) {
        this.breedingBatchEpc = breedingBatchEpc;
    }

    public String getInspector() {
        return this.inspector;
    }
    
    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public Date getDetcTime() {
        return this.detcTime;
    }
    
    public void setDetcTime(Date detcTime) {
        this.detcTime = detcTime;
    }

    public String getDetcIndex() {
        return this.detcIndex;
    }
    
    public void setDetcIndex(String detcIndex) {
        this.detcIndex = detcIndex;
    }

    public String getDetcResult() {
        return this.detcResult;
    }
    
    public void setDetcResult(String detcResult) {
        this.detcResult = detcResult;
    }

    public String getProcessingBatch() {
        return this.processingBatch;
    }
    
    public void setProcessingBatch(String processingBatch) {
        this.processingBatch = processingBatch;
    }

    public String getProcessingFlow() {
        return this.processingFlow;
    }
    
    public void setProcessingFlow(String processingFlow) {
        this.processingFlow = processingFlow;
    }

    public String getCriticCtrPoint() {
        return this.criticCtrPoint;
    }
    
    public void setCriticCtrPoint(String criticCtrPoint) {
        this.criticCtrPoint = criticCtrPoint;
    }

    public Date getDeliveryTime() {
        return this.deliveryTime;
    }
    
    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryBatchEpc() {
        return this.deliveryBatchEpc;
    }
    
    public void setDeliveryBatchEpc(String deliveryBatchEpc) {
        this.deliveryBatchEpc = deliveryBatchEpc;
    }


   








}