package org.fudan.wuxi.syfw.dao.trace;

import java.util.List;

import org.fudan.wuxi.syfw.model.hibentity.TraceInfo;
import org.oliot.epcis.serde.mysql.dao.base.IBaseDao;

public interface ITraceDao extends IBaseDao<TraceInfo>{
	/**
	 * 根据epc返回相应的追溯信息
	 * @param epc
	 * @return
	 */
	public List<TraceInfo> getTraceInfoByEPC(String epc);
}
