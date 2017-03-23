package org.fudan.wuxi.syfw.action.sale;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.fudan.wuxi.syfw.model.dto.MarketinginfoDto;
import org.fudan.wuxi.syfw.model.hibentity.Marketinginfo;
import org.fudan.wuxi.syfw.service.sale.ISaleService;
import org.fudan.wuxi.utils.CommonUtils;
import org.fudan.wuxi.utils.JsonUtils;

import com.merchant.common.utils.log.LogUtils;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 管理销售阶段的相关业务
 * @author Administrator
 *
 */
public class SaleAction extends ActionSupport {
	
	@Resource(name="saleService")
	private ISaleService saleService;
	
	private Marketinginfo mrkInfo;
    private JSONObject isInsertSuccess;//插入水产品基本信息是否成功的json标志
    private JSONObject isDeleteSuccess;//插入水产品基本信息是否成功的json标志
    private JSONObject productInfoList;//返回 infolist
    private int iDisplayStart;//千万注意set和get方法的写法，默认将收集不到参数
    private int iDisplayLength;
    private Integer sEcho;
    private JSONObject brand;
    
    
    private String ids;
    
    public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}



	public String delete(){
		try {
			System.out.println("ids:======================   "+ids);
	    	if(CommonUtils.isNotEmpty(ids)){
	    		String[] idss = ids.split(",");
	    		for(String id:idss){
	    			saleService.delete(id);
	    		}
	    		
	    		isDeleteSuccess = JsonUtils.toJSONResult(true);
	    		return SUCCESS;
	    	}
			
		} catch (Exception e) {
			LogUtils.getInstance().errorSystem(LogUtils.MODULE_CONTROLLER, e);
			isInsertSuccess = JsonUtils.toJSONResult(false, "发生未知错误");
			return ERROR;
		}
    	
    	return ERROR;
    }
    
	
	
	public String getMrkingInfoList() {
		try {
		
			System.out.println("iDisplayStart-->  "+iDisplayStart);
			System.out.println("iDisplayLength-->  "+iDisplayLength);
			
			List<Marketinginfo> list = saleService.getList(iDisplayStart, iDisplayLength);

			List<MarketinginfoDto> data = new ArrayList<MarketinginfoDto>();
			for (Marketinginfo po : list) {
				data.add(MarketinginfoDto.convert(po));
			}
			
			int count = saleService.getCount();
			
			//暂时将sEcho的大小设为和count等值
//			sEcho = 3;
			
			productInfoList = JsonUtils.toJSONResult(count, data, sEcho);
			return SUCCESS;
		} catch (Exception e) {
			productInfoList =  JsonUtils.toJSONResult(false, e.getMessage());
			return ERROR;
		}

	}
	

    
    
	public String insert() {
		try {
			//后台保存交易完成时间
			if(CommonUtils.isNotEmpty(mrkInfo)){
				mrkInfo.setFinishTime(new Date());
			}
			saleService.save(mrkInfo);
			isInsertSuccess = JsonUtils.toJSONResult(true);
			return SUCCESS;
		} catch (Exception e) {
			LogUtils.getInstance().errorSystem(LogUtils.MODULE_CONTROLLER, e);
			isInsertSuccess = JsonUtils.toJSONResult(false, "发生未知错误");
			return ERROR;
		}
	}
	
	 public String getAll(){

   	    JSONArray result = new JSONArray();
			JSONObject ob = new JSONObject();
			ob.put("id", 2);
			ob.put("name", "光明");
			result.add(ob);
         
   	   // 可以测试一下result  
           System.out.println(result);  
           brand = JsonUtils.toJSONResult(true, result);
           
           System.out.println("brand: "+ brand);
 
       return SUCCESS;  
   }
	
	

	public Marketinginfo getMrkInfo() {
		return mrkInfo;
	}

	public void setMrkInfo(Marketinginfo mrkInfo) {
		this.mrkInfo = mrkInfo;
	}





	public JSONObject getIsInsertSuccess() {
		return isInsertSuccess;
	}





	public void setIsInsertSuccess(JSONObject isInsertSuccess) {
		this.isInsertSuccess = isInsertSuccess;
	}





	public JSONObject getProductInfoList() {
		return productInfoList;
	}





	public void setProductInfoList(JSONObject productInfoList) {
		this.productInfoList = productInfoList;
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



	public Integer getSEcho() {
		return sEcho;
	}


	public void setSEcho(Integer sEcho) {
		this.sEcho = sEcho;
	}




	public JSONObject getBrand() {
		return brand;
	}




	public void setBrand(JSONObject brand) {
		this.brand = brand;
	}

	public JSONObject getIsDeleteSuccess() {
		return isDeleteSuccess;
	}

	public void setIsDeleteSuccess(JSONObject isDeleteSuccess) {
		this.isDeleteSuccess = isDeleteSuccess;
	}
	
	

}
