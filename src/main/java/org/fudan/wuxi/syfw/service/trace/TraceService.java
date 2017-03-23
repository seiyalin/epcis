package org.fudan.wuxi.syfw.service.trace;

import java.util.List;

import javax.annotation.Resource;

import org.fudan.wuxi.common.PageResult;
import org.fudan.wuxi.syfw.dao.trace.ITraceDao;
import org.fudan.wuxi.syfw.model.hibentity.TraceInfo;
import org.fudan.wuxi.utils.QueryHelper;
import org.oliot.epcis.service.mysqlservice.base.BaseService;
import org.springframework.stereotype.Service;

/**
 * 封装消费者追溯基本操作
 * @author Administrator
 *
 */
@Service("traceService")
public class TraceService extends BaseService<TraceInfo>  implements ITraceService{
	
	PageResult pageResult;
	
	private ITraceDao traceDao;
	public ITraceDao getTraceDao() {
		return traceDao;
	}


	@Resource
	public void setTraceDao(ITraceDao traceDao) {
		System.out.println("进入setTraceDao");
		super.setBaseDao(traceDao);
		this.traceDao = traceDao;
	}







	@Override
	public List<TraceInfo> getList(int start, int limit) {
		QueryHelper queryHelper = new QueryHelper(TraceInfo.class, "t");
		//start/limit + 1       起始页从第一页开始的
		pageResult = traceDao.getPageResult(queryHelper, start/limit + 1, limit);
		return pageResult.getItems();
	}


	@Override
	public int getCount() {
		if(pageResult != null){
			return (int) pageResult.getTotalCount();
		}else{
			return 0;
		}
	}


	@Override
	public List<TraceInfo> getTraceInfoByEPC(String epc) {
		
		return traceDao.getTraceInfoByEPC(epc);
		
	}
	

}
