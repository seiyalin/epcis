package org.fudan.wuxi.syfw.service.supervisor;

import java.io.Serializable;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jdt.internal.compiler.lookup.IQualifiedTypeResolutionListener;
import org.fudan.wuxi.common.PageResult;
import org.fudan.wuxi.syfw.dao.feed.IAquaticProductInfoDao;
import org.fudan.wuxi.syfw.dao.supervisor.IComplaintDao;
import org.fudan.wuxi.syfw.dao.supervisor.IQandADao;
import org.fudan.wuxi.syfw.model.feed.AquaticProductInfo;
import org.fudan.wuxi.syfw.model.hibentity.Complaint;
import org.fudan.wuxi.syfw.model.hibentity.Qanda;
import org.fudan.wuxi.utils.QueryHelper;
import org.oliot.epcis.serde.mysql.dao.base.BaseDao;
import org.oliot.epcis.serde.mysql.dao.user.IUserDao;
import org.oliot.epcis.service.mysqlservice.base.BaseService;
import org.springframework.stereotype.Service;


@Service("supervisorService")
public class SupervisorService extends BaseService<Complaint> implements IsupervisorService{
	private IComplaintDao ComplaintDao;
	private IQandADao QandADao;
	/*private BaseDao<Qanda> QandADao;*/
	
	PageResult pageResult;

	public void saveQandA(Qanda qanda){             //save answer
		if(QandADao.findObjectById(qanda.getQuestionId())==null)
			this.QandADao.save(qanda);
	}
	
	public void deleteAnswer(String question_id){
		if(QandADao.findObjectById(question_id)!=null)
			QandADao.delete(question_id);
	}
	
	//分页显示所有回复
	@SuppressWarnings("unchecked")
	public List<Qanda> getAnswers(Integer start, Integer limit,
			Map<String, Object> param){
		QueryHelper queryHelper = new QueryHelper(Qanda.class, "answer");
		pageResult = QandADao.getPageResult(queryHelper, start/limit + 1, limit);
		return pageResult.getItems();
	}
	
	//分页显示投诉
	@SuppressWarnings("unchecked")
	@Override
	public List<Complaint> getList(Integer start, Integer limit,
			Map<String, Object> param) {
		
		QueryHelper queryHelper = new QueryHelper(Complaint.class, "comp");
		//pageno=start/limit + 1       起始页从第一页开始的
		pageResult = ComplaintDao.getPageResult(queryHelper, start/limit + 1, limit);
//		return aquaticProductInfoDao.findObjects();
		return pageResult.getItems();
	}
	
	@SuppressWarnings("unchecked")
	public List<Complaint> getList(Integer start, Integer limit) {
		
		QueryHelper queryHelper = new QueryHelper(Complaint.class, "comp");
		//pageNo=start/limit + 1       起始页从第一页开始的
		pageResult = ComplaintDao.getPageResult(queryHelper, start/limit + 1, limit);
//		return aquaticProductInfoDao.findObjects();
		return pageResult.getItems();
	}

	@Override
	public int getCount(Map<String, Object> param) {
		// TODO Auto-generated method stub
//		return aquaticProductInfoDao.findObjects().size();
		if(pageResult != null){
			return (int) pageResult.getTotalCount();
		}else{
			return 0;
		}
	}
	
	public int getCount() {
		// TODO Auto-generated method stub
//		return aquaticProductInfoDao.findObjects().size();
		if(pageResult != null){
			return (int) pageResult.getTotalCount();
		}else{
			return 0;
		}
	}

	@Override
	public List<Qanda> getAnswers(Serializable compId, Integer start, Integer limit,
			Map<String, Object> param) {
		
		/*String queryString = "from Qanda q where q.complaint.compId=?";
		List<Qanda> list = QandADao.findObjects(queryString, compId);*/
		
		List<Qanda> list = QandADao.findAnswer(compId);
		// TODO Auto-generated method 
		return list;
	}

	public IComplaintDao getComplaintDao() {
		return ComplaintDao;
	}
	
	@Resource
	public void setComplaintDao(IComplaintDao complaintDao) {
		super.setBaseDao(complaintDao);
		this.ComplaintDao = complaintDao;
	}

	public IQandADao getQandADao() {
		return QandADao;
	}
	
	@Resource
	public void setQandADao(IQandADao qandADao) {
		/*super.setBaseDao(qandADao);*/
		this.QandADao = qandADao;
	}

	@Override
	public List<Qanda> getAnswers(Serializable compId) {
		
		// TODO Auto-generated method stub
		return QandADao.findAnswer(compId);
	}
	
}
