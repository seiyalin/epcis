package org.fudan.wuxi.syfw.service;

import java.io.File;

import javax.xml.bind.JAXB;

import org.fudan.wuxi.syfw.model.feed.FeedCompInfo;
import org.fudan.wuxi.syfw.model.feed.FeedEmp;
import org.fudan.wuxi.syfw.utils.FeedUtils;
import org.oliot.epcis.service.capture.CaptureService;
import org.oliot.epcis.service.capture.CoreCaptureService;
import org.oliot.epcis.service.query.CoreQueryService;
import org.oliot.epcis.service.query.SoapQueryService;
import org.oliot.model.epcis.EPCISMasterDataDocumentType;
import org.oliot.model.epcis.QueryParams;
import org.oliot.model.epcis.QueryResults;


/**
 * 此类专门封装养殖阶段需要mongodb调用的服务，依赖于webservice包下capture和query所提供的服务
 * @author Administrator
 *类的对象适配器（但是没有继承客户端（FeedAction）所要求的RequiredClass）,只是FeedService内部引用了capture 和 query服务
 * @param <FeedCompInfo>
 */
public class FeedService {
	private CoreCaptureService ccs = new CaptureService();
	private CoreQueryService   cqs = new SoapQueryService();
	
	/**
	 * 将符合EPCglobal规范的xml文件捕获
	 * @param xmlFile
	 */
	public void saveCompInfoByXml(File xmlFile){
		@SuppressWarnings("restriction")
		EPCISMasterDataDocumentType epcisDoc = JAXB.unmarshal(xmlFile, EPCISMasterDataDocumentType.class);
		ccs.capture(epcisDoc);
	}
	
	
	/**
	 * 将养殖企业信息保存为静态事件数据
	 */
	public void saveCompInfo(FeedCompInfo compInfo){//将model模块构建到当前项目就可以引用FeedCompInfo对象实例了
//		EPCISMasterDataDocumentType arg0;
		ccs.capture(FeedUtils.ModelToEPCISMasterDataDocumentType(compInfo));
	}
	
	public FeedCompInfo findFeedCompInfoById(String id){
		FeedCompInfo feedCmpInfo = null;
		String arg0 = null;
		QueryParams arg1 = null;
		QueryResults qr= cqs.poll(arg0, arg1);
		//此处从qr中解析出feedCmpInfo
		return feedCmpInfo;
		
	}
	
	/**
	 * 将养殖员工信息保存为静态事件数据
	 */
	public void saveEmpInfo(FeedEmp emp){
		
	}
	
	public void save(){
		
	}
	
}
