<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

<div class="detail-content page">

	<div class="page-item-title"  style="background-color:green" >供应商信息</div>
			<div class="row">
		    	 <div class="col-sm-8">
			    	  <div class="row">
						    <div class="col-sm-6">
						        <div class="form-group">
								   <label for="name" class="col-sm-3 control-label no-padding-right">追溯码</label>
								   <div class="col-sm-9">
									   <span class="x-info text" id="userName" name ="epc">${dto.epc} }</span>
								   </div>
							   </div>
						    </div>
						    <div class="col-sm-6">
						        <div class="form-group">
								   <label for="code" class="col-sm-3 control-label no-padding-right">交易门店名称</label>
								   <div class="col-sm-9">
									   <span class="x-info text" id="store">${dto.store}</span>
								   </div>
							   </div>
						    </div>
					   </div>
					    <div class="row">
						    <div class="col-sm-6">
						        <div class="form-group">
								   <label for="name" class="col-sm-3 control-label no-padding-right">配送中心名称</label>
								   <div class="col-sm-9">
									   <span class="x-info text" id="dcName">${dto.dcName}</span>
								   </div>
							   </div>
						    </div>
						    <div class="col-sm-6">
						        <div class="form-group">
								   <label for="code" class="col-sm-3 control-label no-padding-right">加工厂名称</label>
								   <div class="col-sm-9">
									   <span class="x-info text" id="processingFac">${dto.processingFac}</span>
								   </div>
							   </div>
						    </div>
					   </div>
					   <div class="row">
						    <div class="col-sm-6">
						        <div class="form-group">
								   <label for="price" class="col-sm-3 control-label no-padding-right">养殖基地名称</label>
								   <div class="col-sm-9">
									   <span class="x-info text" id="bredingsiteName">${dto.bredingsiteName}</span>
								   </div>
							   </div>
						    </div>
						    <div class="col-sm-6">
						        <div class="form-group">
								   <label for="ComuName" class="col-sm-3 control-label no-padding-right">鱼塘名称</label>
								   <div class="col-sm-9">
									   <span class="x-info text" id=ComuName>${dto.poolName}</span>
								   </div>
							   </div>
						    </div>
					   </div>
					 <%--   <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">地址</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="orderNo">${dto.dcName}</span>
					               </div>
					           </div>
					        </div>
					   </div>
					   <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">备注</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="orderNo">${dto.dcName}</span>
					               </div>
					           </div>
					        </div>
					   </div> --%>
					   <br/>
					   <br/>
					   
		    	 </div>
		   </div>
	  	<div class="page-item-title" style="background-color:green" >水产品信息</div>
	  
	  <div class="row">
		    	 <div class="col-sm-8">
					  <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">追溯码</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="orderNo">${dto.epc}</span>
					               </div>
					           </div>
					        </div>
					   </div>
					   <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">水产品名称</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="orderNo">${dto.aquticName}</span>
					               </div>
					           </div>
					        </div>
					   </div> 
					 
					 <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">保质期(天)</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="duraPeriod">${dto.duraPeriod}</span>
					               </div>
					           </div>
					        </div>
					   </div>
					   <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">储藏环境</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="storeEnv">${dto.storeEnv}</span>
					               </div>
					           </div>
					        </div>
					   </div> 
					   
					    <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">养殖基地名称</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="bredingsiteName">${dto.bredingsiteName}</span>
					               </div>
					           </div>
					        </div>
					   </div>
					   <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">鱼塘名称</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="poolName">${dto.poolName}</span>
					               </div>
					           </div>
					        </div>
					   </div> 
					   
					   
					    <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">出塘时间</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="pondTime">${dto.pondTime}</span>
					               </div>
					           </div>
					        </div>
					   </div>
					   <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">RFID养殖批次</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="breedingBatchEpc">${dto.breedingBatchEpc}</span>
					               </div>
					           </div>
					        </div>
					   </div> 
					   
					     <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">加工厂名称</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="processingFac">${dto.processingFac}</span>
					               </div>
					           </div>
					        </div>
					   </div>
					   <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">检测人员</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="inspector">${dto.inspector}</span>
					               </div>
					           </div>
					        </div>
					   </div> 
					   
					   
					    <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">检测时间</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="detcTime">${dto.detcTime}</span>
					               </div>
					           </div>
					        </div>
					   </div>
					   <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">检测指标</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="detcIndex">${dto.detcIndex}</span>
					               </div>
					           </div>
					        </div>
					   </div> 
					   
					       <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">检测结果</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="detcResult">${dto.detcResult}</span>
					               </div>
					           </div>
					        </div>
					   </div>
					   <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">加工批次</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="processingBatch">${dto.processingBatch}</span>
					               </div>
					           </div>
					        </div>
					   </div> 
					   
					   
					   
					     <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">加工流程</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="processingFlow">${dto.processingFlow}</span>
					               </div>
					           </div>
					        </div>
					   </div>
					   <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">关键控制点</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="criticCtrPoint">${dto.criticCtrPoint}</span>
					               </div>
					           </div>
					        </div>
					   </div> 
					   
					       <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">配送时间</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="deliveryTime">${dto.deliveryTime}</span>
					               </div>
					           </div>
					        </div>
					   </div>
					   <div class="row">
						    <div class="col-sm-9">
							   <div class="form-group">
					               <label for="catalogy" class="col-sm-2 control-label no-padding-right">RFID配送批次</label>
					               <div class="col-sm-10">
					               	 <span class="x-info text" id="deliveryBatchEpc">${dto.deliveryBatchEpc}</span>
					               </div>
					           </div>
					        </div>
					   </div> 
					   
					   
					   
					   
					   
					   
		    	 </div>
		   </div>
	   

</div>
<!------end------->

