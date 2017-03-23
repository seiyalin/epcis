package org.fudan.wuxi.syfw.service.sale;



import java.util.List;

import javax.annotation.Resource;

import org.fudan.wuxi.common.PageResult;
import org.fudan.wuxi.syfw.dao.sale.ISaleDao;
import org.fudan.wuxi.syfw.model.hibentity.Marketinginfo;
import org.fudan.wuxi.utils.QueryHelper;
import org.oliot.epcis.service.mysqlservice.base.BaseService;
import org.springframework.stereotype.Service;




@Service("saleService")
public class SaleService extends BaseService<Marketinginfo> implements ISaleService {

	private ISaleDao saleDao;
	PageResult pageResult;

	public ISaleDao getsaleDao() {
		return saleDao;
	}

	@Resource
	public void setsaleDao(
			ISaleDao saleDao) {
//		System.out.println("spring注入saleDao");
		super.setBaseDao(saleDao);
		this.saleDao = saleDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Marketinginfo> getList(Integer start, Integer limit
			) {
		
		QueryHelper queryHelper = new QueryHelper(Marketinginfo.class, "a");
		//start/limit + 1       起始页从第一页开始的
		pageResult = saleDao.getPageResult(queryHelper, start/limit + 1, limit);
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
}
