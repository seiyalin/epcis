package org.oliot.epcis.service.mysqlservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface BaseService {
	//新增
	@WebMethod(operationName = "save")
	public void save(Info entity);
	//更新
	@WebMethod(operationName = "update")
	public void update(Info entity);
	//根据id删除
	public void delete(String id);
	//根据id查找
	public Info findObjectById(String id);
	//查找列表
	public List<Info> findObjects();

}
