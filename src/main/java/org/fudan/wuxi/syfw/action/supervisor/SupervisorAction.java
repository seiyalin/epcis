package org.fudan.wuxi.syfw.action.supervisor;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fudan.wuxi.syfw.model.dto.AquaticProductInfoDto;
import org.fudan.wuxi.syfw.model.feed.AquaticProductCategory;
import org.fudan.wuxi.syfw.model.feed.AquaticProductInfo;
import org.fudan.wuxi.syfw.model.feed.FeedCompInfo;
import org.fudan.wuxi.syfw.model.hibentity.Complaint;
import org.fudan.wuxi.syfw.model.hibentity.Qanda;
import org.fudan.wuxi.syfw.service.FeedService;
import org.fudan.wuxi.syfw.service.feed.IAquaticProductInfoService;
import org.fudan.wuxi.syfw.service.supervisor.IsupervisorService;
import org.fudan.wuxi.utils.FileUtils2;
import org.fudan.wuxi.utils.JsonUtils;

import com.google.gson.JsonObject;
import com.merchant.bean.ProductCategory;
import com.merchant.common.utils.CommonUtils;
import com.merchant.common.utils.DateUtils;
import com.merchant.common.utils.GeneralUtils;
import com.merchant.common.utils.log.LogUtils;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SupervisorAction extends ActionSupport {
	
	
        private	 IsupervisorService	supervisorService;  //业务逻辑组件
        private  Complaint 			complaintInfo;		//complaint类
        private  Qanda				qandaInfo;			//qanda类
        private  String				compId;				
        private  String 			questionId;
        private  String				content;
      /*  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") */
        private	 Date				comp_time;
        private  String 			status;				//投诉状态
        private  JSONArray			answersList;            //回复list
        private  JSONObject			isInsertSuccess;
        private	 JSONObject			isDeleteSuccess;
        private	 JSONObject			isUpdateSuccess;
        private  JSONObject			update_obj;   
        private  JSONObject			complaintInfoList;
        
        private int 		iDisplayStart;//千万注意set和get方法的写法，默认将收集不到参数
        private int 		iDisplayLength =5;
        private Integer 	sEcho =1;
        
        
        
		public String insertComplaint() {
			
        	complaintInfo.setStatus("处理中");
        	comp_time = new Date();
        	complaintInfo.setCompTime(comp_time);
        	supervisorService.save(complaintInfo);
        	setIsInsertSuccess(JsonUtils.toJSONResult(true));
        	return SUCCESS;
		}
        
        public String insertQandA(){
        	supervisorService.saveQandA(qandaInfo);
        	setIsInsertSuccess(JsonUtils.toJSONResult(true));
        	return SUCCESS;
        }
      

        public String delete()
        {
        	if(compId != null){
        		String[] idss = compId.split(",");
        		for(String id: idss){
        			supervisorService.delete(id);
        		}
        		
        	}
        	setIsDeleteSuccess(JsonUtils.toJSONResult(true));
        	return SUCCESS;
        }
        
        public String deleteAnswer(){
        	
        	if(questionId != null){
        		String[] idss = questionId.split(",");
        		for(String id: idss){
        			supervisorService.deleteAnswer(id);
        		}
        		
        	}
        	setIsDeleteSuccess(JsonUtils.toJSONResult(true));
        	return SUCCESS;
        }
        
        public String findAnswerByComp(){
        	List<Qanda> list = supervisorService.getAnswers(compId);
        	answersList = JsonUtils.toJSONArrayResult(list);
        	return SUCCESS;
        }
        
        public String getComplaintList(){
        	try{
        		/*Map<String, Object> param = new HashMap<String, Object>();
        		if (CommonUtils.isNotEmpty(compId)) {
    				param.put("compId", compId);
    			}
        		if (CommonUtils.isNotEmpty(content)) {
    				param.put("content", content);
    			}
        		if (CommonUtils.isNotEmpty(comp_time)) {
    				param.put("comp_time", comp_time);
    			}
        		if (CommonUtils.isNotEmpty(status)) {
    				param.put("status", status);
    			}
        		*/
        		List<Complaint> list = supervisorService.getList(iDisplayStart, iDisplayLength);
        		/*List<Complaint> data = new ArrayList<Complaint>();
        		for(Complaint po:list)
        		{
        			po.setCompTime(DateUtils.date2String(po.getCompTime(),
        					DateUtils.YYYY_MM_DD_HH_MM_SS_PATTERN));
        		}*/
        		int count = supervisorService.getCount();
        		System.out.println("the count of items:"+count);
        		complaintInfoList = JsonUtils.toJSONResult(count, list, sEcho);
        		return SUCCESS;
        	}
        	catch (Exception e){
        		return ERROR;
        	}
        	
        }
        
        public String loadForUpdate(){
        	
			complaintInfo = supervisorService.findObjectById(compId);
			this.setUpdate_obj(JsonUtils.toJSONResult(true, complaintInfo));
			
			return SUCCESS;
		}

        
        public String updateComplaint(){
        	if(supervisorService.findObjectById(complaintInfo.getCompId()) != null){
        		setComplaintInfo(complaintInfo);
        		supervisorService.update(complaintInfo);
        		isUpdateSuccess = JsonUtils.toJSONResult(true);
        		return SUCCESS;           	
        	}
        	addActionMessage(getText("error.message.not.exist"));
        	return INPUT;
        	
        }
        
        
        
        
        
        
        
		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}



		public IsupervisorService getSupervisorService() {
			return supervisorService;
		}

		@Resource
		public void setSupervisorService(IsupervisorService supervisorService) {
			this.supervisorService = supervisorService;
		}




		public Complaint getComplaintInfo() {
			return complaintInfo;
		}




		public void setComplaintInfo(Complaint complaintInfo) {
			this.complaintInfo = complaintInfo;
		}




		public Qanda getQandaInfo() {
			return qandaInfo;
		}




		public void setQandaInfo(Qanda qandaInfo) {
			this.qandaInfo = qandaInfo;
		}




		public String getQuestionId() {
			return questionId;
		}




		public void setQuestionId(String questionId) {
			this.questionId = questionId;
		}




		public String getCompId() {
			return compId;
		}




		public void setCompId(String compId) {
			this.compId = compId;
		}




		public JSONArray getAnswersList() {
			return answersList;
		}




		public void setAnswers(JSONArray answers) {
			this.answersList = answers;
		}

		public JSONObject getIsInsertSuccess() {
			return isInsertSuccess;
		}

		public void setIsInsertSuccess(JSONObject isInsertSuccess) {
			this.isInsertSuccess = isInsertSuccess;
		}

		public JSONObject getIsDeleteSuccess() {
			return isDeleteSuccess;
		}

		public void setIsDeleteSuccess(JSONObject isDeleteSuccess) {
			this.isDeleteSuccess = isDeleteSuccess;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Date getComp_time() {
			return comp_time;
		}

		public void setComp_time(Date comp_time) {
			this.comp_time = comp_time;
		}

		public JSONObject getComplaintInfoList() {
			return complaintInfoList;
		}

		public void setComplaintInfoList(JSONObject complaintInfoList) {
			this.complaintInfoList = complaintInfoList;
		}

		public JSONObject getIsUpdateSuccess() {
			return isUpdateSuccess;
		}

		public void setIsUpdateSuccess(JSONObject isUpdateSuccess) {
			this.isUpdateSuccess = isUpdateSuccess;
		}

		public JSONObject getUpdate_obj() {
			return update_obj;
		}

		public void setUpdate_obj(JSONObject update_obj) {
			this.update_obj = update_obj;
		}
		
		public int getiDisplayStart() {
				return iDisplayStart;
		}

		public void setiDisplayStart(int iDisplayStart) {
				this.iDisplayStart = iDisplayStart;
		}

		public int getiDisplayLength() {
				return iDisplayLength;
		}

		public void setiDisplayLength(int iDisplayLength) {
				this.iDisplayLength = iDisplayLength;
		}

		public Integer getsEcho() {
			return sEcho;
		}

		public void setsEcho(Integer sEcho) {
			this.sEcho = sEcho;
		}

}
