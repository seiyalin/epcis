package org.fudan.wuxi.syfw.dao.supervisor;

import java.io.Serializable;
import java.util.List;

import org.fudan.wuxi.syfw.model.hibentity.Qanda;
import org.oliot.epcis.serde.mysql.dao.base.IBaseDao;

public interface IQandADao extends IBaseDao<Qanda>{

 List<Qanda> findAnswer(Serializable comp_id); 
}
