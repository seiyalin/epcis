package org.fudan.wuxi.syfw.service.feed;

import java.util.List;
import java.util.Map;

import org.fudan.wuxi.syfw.dao.feed.IAquaticProductInfoDao;
import org.fudan.wuxi.syfw.model.feed.AquaticProductInfo;
import org.oliot.epcis.service.mysqlservice.base.IBaseService;

import com.merchant.bean.ProductInfo;

public interface IAquaticProductInfoService extends IBaseService<AquaticProductInfo> {
	
	
	

	List<AquaticProductInfo> getList(Integer start, Integer limit,
			Map<String, Object> param);

	int getCount(Map<String, Object> param);




}
