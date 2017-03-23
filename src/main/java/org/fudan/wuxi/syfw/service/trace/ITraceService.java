package org.fudan.wuxi.syfw.service.trace;

import java.util.List;
import java.util.Map;

import org.fudan.wuxi.syfw.model.hibentity.TraceInfo;
import org.hibernate.Query;
import org.oliot.epcis.service.mysqlservice.base.IBaseService;

import com.merchant.bean.OrderInfo;


public interface ITraceService extends IBaseService<TraceInfo> {

	List<TraceInfo> getList(int iDisplayStart, int iDisplayLength);

	int getCount();

	
	public List<TraceInfo> getTraceInfoByEPC(String epc);
		

}
