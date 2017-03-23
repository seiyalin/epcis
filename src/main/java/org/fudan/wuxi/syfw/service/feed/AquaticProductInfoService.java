package org.fudan.wuxi.syfw.service.feed;

import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.fudan.wuxi.common.PageResult;
import org.fudan.wuxi.syfw.dao.feed.IAquaticProductInfoDao;
import org.fudan.wuxi.syfw.model.feed.AquaticProductInfo;
import org.fudan.wuxi.utils.QueryHelper;
import org.oliot.epcis.serde.mysql.dao.user.IUserDao;
import org.oliot.epcis.service.mysqlservice.base.BaseService;
import org.springframework.stereotype.Service;



@Service("proService")
public class AquaticProductInfoService extends BaseService<AquaticProductInfo> implements IAquaticProductInfoService{
	private IAquaticProductInfoDao aquaticProductInfoDao;
	PageResult pageResult;

	public IAquaticProductInfoDao getAquaticProductInfoDao() {
		return aquaticProductInfoDao;
	}

	@Resource
	public void setAquaticProductInfoDao(
			IAquaticProductInfoDao aquaticProductInfoDao) {
//		System.out.println("spring注入aquaticProductInfoDao");
		super.setBaseDao(aquaticProductInfoDao);
		this.aquaticProductInfoDao = aquaticProductInfoDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AquaticProductInfo> getList(Integer start, Integer limit,
			Map<String, Object> param) {
		
		QueryHelper queryHelper = new QueryHelper(AquaticProductInfo.class, "a");
		//start/limit + 1       起始页从第一页开始的
		pageResult = aquaticProductInfoDao.getPageResult(queryHelper, start/limit + 1, limit);
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
	
}
