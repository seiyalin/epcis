package org.fudan.wuxi.syfw.service.supervisor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.fudan.wuxi.syfw.model.hibentity.Complaint;
import org.fudan.wuxi.syfw.model.hibentity.Qanda;
import org.oliot.epcis.service.mysqlservice.base.IBaseService;


public interface IsupervisorService extends IBaseService<Complaint> {
	
    void saveQandA(Qanda qanda);
	
	void deleteAnswer(String question_id);
	
  /*分页显示投诉信息*/
	List<Complaint> getList(Integer start, Integer limit,
			Map<String, Object> param);
	
	List<Complaint> getList(Integer start, Integer limit);
	 /*item数量*/
	int getCount(Map<String, Object> param);
	int getCount();

	 /*显示投诉回答*/
	List<Qanda> getAnswers(Serializable compId, Integer start, Integer limit,
				Map<String, Object> param);
	
	List<Qanda> getAnswers(Serializable compId);

	//分页显示所有回答
	List<Qanda> getAnswers(Integer start, Integer limit,
			Map<String, Object> param);

}
