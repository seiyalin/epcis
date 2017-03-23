package org.fudan.wuxi.syfw.action.trace;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.fudan.wuxi.syfw.model.dto.TraceInfoDto;
import org.fudan.wuxi.syfw.model.hibentity.TraceInfo;
import org.fudan.wuxi.syfw.service.trace.ITraceService;
import org.fudan.wuxi.utils.JsonUtils;




import com.opensymphony.xwork2.ActionSupport;
/**
 * 管理消费者的追溯信息
 * @author Administrator
 *
 */
public class TraceAction extends ActionSupport {
	
	@Resource(name="traceService")
	private ITraceService traceService;

    private int iDisplayStart;//千万注意set和get方法的写法，默认将收集不到参数
    private int iDisplayLength;
    private Integer sEcho;
    private JSONObject traceInfoList;//返回infolist
    private String orderNo;//代表前端提交过来的epc水产品追溯码
    private TraceInfoDto dto;
	
	public String getList() {
		try {

			List<TraceInfo> list = traceService.getList(iDisplayStart,iDisplayLength);
			List<TraceInfoDto> data = new ArrayList<TraceInfoDto>();
			for (TraceInfo dto : list) {
				
				data.add(TraceInfoDto.convert(dto));
			}
		
			int count = traceService.getCount();
			traceInfoList = JsonUtils.toJSONResult(count, data, sEcho);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			traceInfoList = JsonUtils.toJSONResult(false, e.getMessage());
			return ERROR;
		}
	}
	
	
	/**
	 * 由epc获取追溯的水产品信息
	 * @return
	 */
	
	public String getListByEpc() {
		try {

			if(orderNo!=null){
				orderNo = orderNo.trim();
			}
			
			List<TraceInfo> list = traceService.getTraceInfoByEPC(orderNo);
			List<TraceInfoDto> data = new ArrayList<TraceInfoDto>();
			for (TraceInfo dto : list) {
				data.add(TraceInfoDto.convert(dto));
			}
//			int count = traceService.getCount();
//			traceInfoList = JsonUtils.toJSONResult(count, data, sEcho);
			
			//为dto赋值，方便前端使用
			dto = data.get(0);
			
			traceInfoList = JsonUtils.toJSONResult(1, data, 1);//两个参数1只是为了不抛异常

			return "traceresult";
		} catch (Exception e) {
			e.printStackTrace();
			traceInfoList = JsonUtils.toJSONResult(false, e.getMessage());
			return "traceresult";
		}
	}

	public TraceInfoDto getDto() {
		return dto;
	}


	public void setDto(TraceInfoDto dto) {
		this.dto = dto;
	}


	public String getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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




	public JSONObject getTraceInfoList() {
		return traceInfoList;
	}




	public void setTraceInfoList(JSONObject traceInfoList) {
		this.traceInfoList = traceInfoList;
	}
	
	
	
	
}
