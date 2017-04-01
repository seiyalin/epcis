package org.fudan.wuxi.syfw.action.feed;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fudan.wuxi.syfw.model.dto.AquaticProductInfoDto;
import org.fudan.wuxi.syfw.model.feed.AquaticProductCategory;
import org.fudan.wuxi.syfw.model.feed.AquaticProductInfo;
import org.fudan.wuxi.syfw.model.feed.FeedCompInfo;
import org.fudan.wuxi.syfw.service.FeedService;
import org.fudan.wuxi.syfw.service.feed.IAquaticProductInfoService;
import org.fudan.wuxi.utils.FileUtils2;
import org.fudan.wuxi.utils.JsonUtils;

import com.merchant.bean.ProductCategory;
import com.merchant.common.utils.CommonUtils;
import com.merchant.common.utils.GeneralUtils;
import com.merchant.common.utils.log.LogUtils;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class FeedAction extends ActionSupport {
	
	
        private	 IAquaticProductInfoService	proService;
        private  AquaticProductInfo productInfo;
        
		private String ids;   //delete ids    
		
		private String id;  //update id
        	
        
        private JSONObject brand;
        private JSONObject jdata;
        private JSONObject update_obj;  //update info
        private AquaticProductInfo upd_info;
        private String parentId;
        private Integer sEcho;
        private JSONObject isInsertSuccess;//插入水产品基本信息是否成功的json标志
        private JSONObject productInfoList;//返回 infolist
        private JSONObject isDeleteSuccess;
        private JSONObject isUpdateSuccess;
        private String no;//货号
        private String name;//水产品名称
        private String status;//水产品状态，分为上架和下架
//        private Integer iDisplayStart;
//        private Integer iDisplayLength;
        
        
        private int iDisplayStart;//千万注意set和get方法的写法，默认将收集不到参数
        private int iDisplayLength;

     
		private  AquaticProductInfo po;//用来封装水产品基本信息
        
    	//处理头像上传，这三项对应的是headImg
    	//struts 处理文件上传，需要这三项信息
        
        //struts 处理多文件上传
    	private List<File> file;//缩略图
    	private List<String> fileContentType;
    	private List<String> fileFileName;
    	

    	
    	private String[] catalogies;
    	
    	
    	
    	
    	
    	
    	public String getAquaticProductInfoList() {
    		try {
    			Map<String, Object> param = new HashMap<String, Object>();
    			if (CommonUtils.isNotEmpty(no)) {
    				param.put("no", no);
    			}
    			if (CommonUtils.isNotEmpty(name)) {
    				param.put("name", name);
    			}
    			if (CommonUtils.isNotEmpty(status)) {
    				param.put("status", status);
    			}
    			System.out.println("iDisplayStart-->  "+iDisplayStart);
    			System.out.println("iDisplayLength-->  "+iDisplayLength);
    			
    			List<AquaticProductInfo> list = proService.getList(iDisplayStart, iDisplayLength, param);

    			List<AquaticProductInfoDto> data = new ArrayList<AquaticProductInfoDto>();
    			for (AquaticProductInfo po : list) {
    				data.add(AquaticProductInfoDto.convert(po));
    			}
    			
    			int count = proService.getCount(param);
    			
    			//暂时将sEcho的大小设为和count等值
//    			sEcho = 3;
    			
    			productInfoList = JsonUtils.toJSONResult(count, data, sEcho);
    			return SUCCESS;
    		} catch (Exception e) {
    			productInfoList =  JsonUtils.toJSONResult(false, e.getMessage());
    			return ERROR;
    		}

    	}
    	
   
    
    
    	public String insert() {
    		try {
    			// 保存缩略图
    			if (GeneralUtils.isNotNull(file.get(0))) {
    				String thumbnail = FileUtils2.saveFile(file.get(0), fileFileName.get(0));
    				System.out.println("thumbnail:  "+thumbnail);
    				
    				po.setThumbnail(thumbnail);
    				
    			}
    			// 保存图片
    			if (GeneralUtils.isNotNull(file.get(1))) {
    				String pic = FileUtils2.saveFile(file.get(1), fileFileName.get(1));	
    				
    				System.out.println("pic:  "+pic);
    				po.setPitcure(pic);
    			}
//   
//    			System.out.println(po.getDescription());
//    			System.out.println(po.getCatalogies());
    		    Set<AquaticProductCategory> catalogiesset = new HashSet<AquaticProductCategory>();
    		    AquaticProductCategory aquaticProductCategory = new AquaticProductCategory();
    		    aquaticProductCategory.setName("鱼类");
    		    catalogiesset.add(aquaticProductCategory);
    		    
    		    
    		    
				po.setCatalogiesset(catalogiesset );
    			
//    			service.insert(po, catalogies);
    			
    			proService.save(po);
    			
    			isInsertSuccess = JsonUtils.toJSONResult(true);
    			
    			return SUCCESS;
    	
    		} catch (Exception e) {
    			LogUtils.getInstance().errorSystem(LogUtils.MODULE_CONTROLLER, e);
    			isInsertSuccess = JsonUtils.toJSONResult(false, "发生未知错误");
    			return ERROR;
    		}
    	}
    	
    	
    	
    	 	
    	
    	
        
        public String getCatalogyTreeList() {
    		try {
    			List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
    			Map<String, Object> map = new HashMap<String, Object>();
    			
    			Map<String, Object> param = new HashMap<String, Object>();
    			param.put("parentId", parentId);

//    			List<ProductCategory> list = service.getList(-1, -1, param);
    			List<ProductCategory> list = new ArrayList<ProductCategory>();
    			ProductCategory productCategory = new ProductCategory();
    			productCategory.setId(1);
    			productCategory.setName("海参");
    			productCategory.setParentId(null);
    			list.add(productCategory);
    			
    			ProductCategory productCategory2 = new ProductCategory();
    			productCategory2.setId(2);
    			productCategory2.setName("鱼类");
    			productCategory2.setParentId(null);
    			list.add(productCategory2);
    			
    			
    			ProductCategory productCategory3 = new ProductCategory();
    			productCategory3.setId(3);
    			productCategory3.setName("蟹类");
    			productCategory3.setParentId(null);
    			list.add(productCategory3);
    		
    			for (ProductCategory po : list) {
    				map = new HashMap<String, Object>();
    				map.put("name",po.getName());

    				param.put("parentId", po.getId());
//    				if(list.isEmpty()){
    					map.put("type", "item");
//    				}else{
//    					map.put("type", "folder");
//    				}
    				map.put("icon-class", "blue");
    				map.put("additionalParameters", "{id:'" + po.getId() + "'}");
    				map.put("id", po.getId());
    				data.add(map);
    			}
    			
    			jdata = JsonUtils.toJSONResult(true, data);
    			return SUCCESS;
    		} catch (Exception e) {
    			e.printStackTrace();
    			jdata = JsonUtils.toJSONResult(false, e.getMessage());
    			return ERROR;
    		}
    	}
        
        
        
        public String delete() {
        	//String ids = ids;
        	if(ids != null){
        		String[] idss = ids.split(",");
        		for(String id: idss){
        			proService.delete(id);
        		}
        		
        	}
        	isDeleteSuccess = JsonUtils.toJSONResult(true);
        	return SUCCESS;
  
    	}
        
        
        
        public String loadForUpdate(){
        	
			po = proService.findObjectById(id);
			update_obj = JsonUtils.toJSONResult(true, po);
			
			return SUCCESS;
		}

        public String update(){
//        	System.out.println(id);
//        	upd_info= proService.findObjectById(id);
        	if (proService.findObjectById(po.getId())!=null)
        	{
        		setPo(po);
        		proService.update(po);
        		isUpdateSuccess = JsonUtils.toJSONResult(true);
        		return SUCCESS;           	
        	}
        	addActionMessage(getText("error.message.not.exist"));
        	return INPUT;
        }
    	

        //品种
        public String getAll(){
//        	  Map<String, String> map = new HashMap<String, String>();  
//        	  String date = DateUtils.date2String(new Date(), DateUtils.YYYY_MM_DD_HH_MM_SS_PATTERN);
//              map.put("x", date);
//              map.put("y", "6");
//              JSONObject jo = JSONObject.fromObject(map);  
//              this.brand = jo.toString();
        	    JSONArray result = new JSONArray();
				JSONObject ob = new JSONObject();
				ob.put("id", 2);
				ob.put("name", "光明");
				result.add(ob);
				
				ob.put("id", 3);
				ob.put("name", "阳澄湖");
				result.add(ob);
              
        	   // 可以测试一下result  
                System.out.println(result);  
                brand = JsonUtils.toJSONResult(true, result);
                
                
                System.out.println("brand: "+ brand);
      
            return SUCCESS;  
        }
        

		public String saveAquaticProductInfo(){
        	AquaticProductInfo productInfo = new AquaticProductInfo();
        	
        	productInfo.setName("海参");
        	
        	AquaticProductCategory aquaticProductCategory = new AquaticProductCategory();
        	aquaticProductCategory.setName("水产品");
        	Set<AquaticProductCategory> catalogiesset = new HashSet<AquaticProductCategory>();
        	catalogiesset.add(aquaticProductCategory);
			productInfo.setCatalogiesset(catalogiesset );
			proService.save(productInfo );
        	return SUCCESS;
        }
        
        public AquaticProductInfo getUpd_info() {
			return upd_info;
		}

		public void setUpd_info(AquaticProductInfo upd_info) {
			this.upd_info = upd_info;
		}

		public JSONObject getBrand() {
			return brand;
		}


        public JSONObject getUpdate_obj() {
			return update_obj;
		}

		public void setUpdate_obj(JSONObject update_obj) {
			this.update_obj = update_obj;
		}

		public JSONObject getIsUpdateSuccess() {
			return isUpdateSuccess;
		}

		public void setIsUpdateSuccess(JSONObject isUpdateSuccess) {
			this.isUpdateSuccess = isUpdateSuccess;
		}

		public JSONObject getProductInfoList() {
     			return productInfoList;
     		}

     		public void setProductInfoList(JSONObject productInfoList) {
     			this.productInfoList = productInfoList;
     		}

        

		public JSONObject getJdata() {
			return jdata;
		}




		public void setJdata(JSONObject jdata) {
			this.jdata = jdata;
		}


		public String getParentId() {
			return parentId;
		}

		public void setParentId(String parentId) {
			this.parentId = parentId;
		}




		public JSONObject getIsInsertSuccess() {
			return isInsertSuccess;
		}


		public void setIsInsertSuccess(JSONObject isInsertSuccess) {
			this.isInsertSuccess = isInsertSuccess;
		}


		public JSONObject getIsDeleteSuccess() {
			return isDeleteSuccess;
		}

		public void setIsDeleteSuccess(JSONObject isDeleteSuccess) {
			this.isDeleteSuccess = isDeleteSuccess;
		}

		public AquaticProductInfo getPo() {
			return po;
		}

		public void setPo(AquaticProductInfo po) {
			this.po = po;
		}




		public List<File> getFile() {
			return file;
		}




		public void setFile(List<File> file) {
			this.file = file;
		}




		public List<String> getFileContentType() {
			return fileContentType;
		}




		public void setFileContentType(List<String> fileContentType) {
			this.fileContentType = fileContentType;
		}





		public List<String> getFileFileName() {
			return fileFileName;
		}




		public void setFileFileName(List<String> fileFileName) {
			this.fileFileName = fileFileName;
		}




		public String[] getCatalogies() {
			return catalogies;
		}




		public void setCatalogies(String[] catalogies) {
			this.catalogies = catalogies;
		}


		public Integer getSEcho() {
			return sEcho;
		}



		public void setSEcho(Integer sEcho) {
			this.sEcho = sEcho;
		}




		public void setBrand(JSONObject brand) {
			this.brand = brand;
		}


  
		public AquaticProductInfo getProductInfo() {
			return productInfo;
		}

		public void setProductInfo(AquaticProductInfo productInfo) {
			this.productInfo = productInfo;
		}


		public IAquaticProductInfoService getProService() {
			return proService;
		}

		@Resource
		public void setProService(IAquaticProductInfoService proService) {
			System.out.println("注入proService");
			this.proService = proService;
		}

		
		
		
		public String getNo() {
			return no;
		}




		public void setNo(String no) {
			this.no = no;
		}




		public String getName() {
			return name;
		}




		public void setName(String name) {
			this.name = name;
		}




		public String getStatus() {
			return status;
		}





		public void setStatus(String status) {
			this.status = status;
		}



		public int getIDisplayStart() {
			return iDisplayStart;
		}




		public void setIDisplayStart(int iDisplayStart) {
			this.iDisplayStart = iDisplayStart;
		}






		public int getIDisplayLength() {
			return iDisplayLength;
		}





		public void setIDisplayLength(int iDisplayLength) {
			this.iDisplayLength = iDisplayLength;
		}




		private FeedService fs = new FeedService();

		/** Logger used by this class. Available to subclasses. */
		protected final Log logger = LogFactory.getLog(getClass());
		
		private File feedXml;
		private String feedXmlContentType;
		private String feedXmlFileName;

/**
 * 将上传的文件提交到epcis中mongodb服务器
 * @return
 */
		public String submitXML(){
			System.out.println(feedXmlContentType);
			System.out.println(feedXmlFileName);
//			System.out.println(feedXml);
			
			fs.saveCompInfoByXml(feedXml);
			
			return toFeedUI();
//			return null;
		}

		public FeedService getFs() {
			return fs;
		}

		public void setFs(FeedService fs) {
			this.fs = fs;
		}

		private FeedCompInfo compInfo;
		
		@Override
		public String execute() throws Exception {
			if(logger.isInfoEnabled()){
				logger.info("访问了FeedAction");
			}
//			fs.saveCompInfo(compInfo);
			return toFeedUI();
		}
		
		public FeedCompInfo getCompInfo() {
			return compInfo;
		}

		public void setCompInfo(FeedCompInfo compInfo) {
			this.compInfo = compInfo;
		}

		public String submitFeedCmpInfo(){
			fs.saveCompInfo(compInfo);
			return toFeedUI();
		}
		
		//跳转到溯源服务的水产养殖阶段
		public String toFeedUI(){
			return "feedUI";
		}
		

		public String getFeedXmlContentType() {
			return feedXmlContentType;
		}

		public void setFeedXmlContentType(String feedXmlContentType) {
			this.feedXmlContentType = feedXmlContentType;
		}

		public String getFeedXmlFileName() {
			return feedXmlFileName;
		}

		public void setFeedXmlFileName(String feedXmlFileName) {
			this.feedXmlFileName = feedXmlFileName;
		}

		public File getFeedXml() {
			return feedXml;
		}

		public void setFeedXml(File feedXml) {
			this.feedXml = feedXml;
		}
		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	
		public String getIds() {
			return ids;
		}

		public void setIds(String ids) {
			this.ids = ids;
		}
}
