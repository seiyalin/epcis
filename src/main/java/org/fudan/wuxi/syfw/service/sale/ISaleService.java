package org.fudan.wuxi.syfw.service.sale;

import java.util.List;
import java.util.Map;

import org.fudan.wuxi.syfw.model.hibentity.Marketinginfo;
import org.oliot.epcis.service.mysqlservice.base.IBaseService;


public interface ISaleService extends IBaseService<Marketinginfo>{

	


	List<Marketinginfo> getList(Integer start, Integer limit);

	int getCount();

}
