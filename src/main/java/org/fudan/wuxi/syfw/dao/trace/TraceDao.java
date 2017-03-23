package org.fudan.wuxi.syfw.dao.trace;

import java.util.List;

import org.fudan.wuxi.syfw.model.hibentity.TraceInfo;
import org.hibernate.Query;
import org.oliot.epcis.serde.mysql.dao.base.BaseDao;

public class TraceDao extends BaseDao<TraceInfo> implements ITraceDao {

	@Override
	public List<TraceInfo> getTraceInfoByEPC(String epc) {
		Query query = getSession().createQuery("FROM TraceInfo WHERE epc.epc=?");
		query.setParameter(0, epc);
		return query.list();
	} 

}
