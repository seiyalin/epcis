package org.oliot.epcis.service.mysqlservice.base;

import java.io.Serializable;
import java.util.List;

import org.fudan.wuxi.common.PageResult;
import org.fudan.wuxi.utils.QueryHelper;
import org.oliot.epcis.serde.mysql.dao.base.IBaseDao;


public class BaseService<T> implements IBaseService<T> {
	
	private IBaseDao<T> baseDao;
	
	public void setBaseDao(IBaseDao<T> baseDao) {//该方法提供给子Service调用，设置BaseDao对象，在BaseSevice便可
		//实现对baseDao对象基本方法的调用
		System.out.println("进入了BaseService<T>的setBaseDao(IBaseDao<T> baseDao)");
		
		this.baseDao = baseDao;
		
		System.out.println("进入了BaseService<T>的setBaseDao(IBaseDao<T> baseDao)");
	}

	@Override
	public void save(T entity) {
		System.out.println("进入BaseService 的save方法");
		baseDao.save(entity);
		System.out.println("退出BaseService 的save方法");

	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		System.out.println("进入BaseService 的update方法");
		baseDao.update(entity);
		System.out.println("退出BaseService 的update方法");
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		baseDao.delete(id);
	}

	@Override
	public T findObjectById(String id) {
		// TODO Auto-generated method stub
		return baseDao.findObjectById(id);
	}



	@Override
	public List<T> findObjects() {
		return baseDao.findObjects();
	}

	@Override
	public List<T> findObjects(String hql, List<Object> parameters) {
		return baseDao.findObjects(hql, parameters);
	}

	@Override
	public List<T> findObjects(QueryHelper queryHelper) {
		return baseDao.findObjects(queryHelper);
	}

	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize) {
		return baseDao.getPageResult(queryHelper, pageNo, pageSize);
	}

}
