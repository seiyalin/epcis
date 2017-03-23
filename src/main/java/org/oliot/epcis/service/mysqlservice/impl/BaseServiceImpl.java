package org.oliot.epcis.service.mysqlservice.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.oliot.epcis.serde.mysql.dao.BaseDao;
import org.oliot.epcis.service.mysqlservice.BaseService;
import org.oliot.epcis.service.mysqlservice.Info;
import org.springframework.stereotype.Service;

@WebService(endpointInterface = "org.oliot.epcis.service.mysqlservice.BaseService")
@Service("teacherService")
public class BaseServiceImpl implements BaseService {
	
	public BaseServiceImpl(){
		System.out.println("创建了BaseServiceImpl实例 ：" + this.hashCode());
	}
	//暂时自己管理
//	private BaseDao baseDao = new BaseDaoImpl() ;
//	private static ApplicationContext at =new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private BaseDao baseDao; //= (BaseDao) at.getBean("baseDao");//主要是cxf中注入dao有问题  ，不知道后续能否解决  20160628
	
	@Resource
	public void setBaseDao(BaseDao baseDao) {
		System.out.println("进入了setBaseDao()方法");
		this.baseDao = baseDao;
		System.out.println("退出了setBaseDao()方法");
	}

	@Override
	public void save(Info entity) {
		// TODO Auto-generated method stub
		baseDao.save(entity);
	}

	@Override
	public void update(Info entity) {
		baseDao.update(entity);
	}
	//经测试发现参数不能带为Serializable 否则报错，提示为Error creating bean with name 'MySql': Invocation of init
	//method failed; nested exception 
	//is javax.xml.ws.WebServiceException: org.apache.cxf.service.factory.ServiceConstructionException
	@Override
	public void delete(String id) {
		baseDao.delete(id);
		
	}

	@Override
	public Info findObjectById(String id) {
		
		return baseDao.findObjectById(id);
	}

	@Override
	public List<Info> findObjects() {
		return baseDao.findObjects();
	}

	
	
//	public static void main(String[] args) {
//		Employee emp = new Employee();
//		emp.setEmpName("屈岳 qq群");
//		emp.setWorkDate(new Date());
//		BaseServiceImpl<Employee> baseServiceImpl = new BaseServiceImpl<Employee>();
//		baseServiceImpl.save(emp);
//	}

}
