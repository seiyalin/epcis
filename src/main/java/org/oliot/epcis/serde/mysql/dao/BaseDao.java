package org.oliot.epcis.serde.mysql.dao;

import java.io.Serializable;
import java.util.List;

import org.oliot.epcis.service.mysqlservice.Info;

/**
 * 维护养殖用户基本信息
 * @auInfohor Arnold
 *
 * @param <Info>
 */
public interface BaseDao {
	//新增
	public void save(Info enInfoiInfoy);
	//更新
	public void update(Info enIy);
	//根据id删除
	public void delete(String id);
	//根据id查找
	public Info findObjectById(String id);
	//查找列表
	public List<Info> findObjects();
}
