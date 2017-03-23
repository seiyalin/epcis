package org.fudan.wuxi.syfw.dao.supervisor;


import java.io.Serializable;
import java.util.List;

import org.fudan.wuxi.syfw.model.hibentity.Qanda;
import org.oliot.epcis.serde.mysql.dao.base.BaseDao;

public class QandADao extends BaseDao<Qanda> implements IQandADao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Qanda> findAnswer(Serializable comp_id) {
		// TODO Auto-generated method stub
		String queryString = "select new Qanda(q.answer, q.answerTime) from Qanda q where q.complaint.compId=?";
		
		List<Qanda> list = this.getHibernateTemplate().find(queryString, comp_id);
		
		return list;
	} 

}
