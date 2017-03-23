package org.fudan.wuxi.syfw.action.sensor;




import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;



import org.apache.struts2.json.JSONException;
import org.fudan.wuxi.syfw.dao.sensor.SensorDao;
import org.fudan.wuxi.utils.DateUtils;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 该Action负责动态刷新传感器数据
 * @author Administrator
 *
 */
public class SensorAction extends ActionSupport implements ServletRequestAware/*,ServletResponseAware*/ {
	
	 // 用户Ajax返回数据  
    private String result; 
    private String phValue;//代表下位机查询ph的时间和相应的ph值
    
    public String getPhValue() {
		return phValue;
	}

	public void setPhValue(String phValue) {
		this.phValue = phValue;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private HttpServletRequest request;
    private String loginName;  
    private String password;  
  
    public String test() throws ClassNotFoundException, SQLException {  
  
        // 用一个Map做例子  
        Map<String, String> map = new HashMap<String, String>();  
        map.put("name", "屈岳");
        // 为map添加一条数据，记录一下页面传过来loginName  
//        map.put("name", this.loginName);  
  
        // 将要返回的map对象进行json处理  
        JSONObject jo = JSONObject.fromObject(map);  
  
        // 调用json对象的toString方法转换为字符串然后赋值给result  
//        this.result = jo.toString();  
        //this.result = "[{\"data\":64,\"categories\":\"PH\"},{\"data\":45,\"categories\":\"温度\"},{\"data\":6,\"categories\":\"含氧量 \"}]";
  
        this.result = new SensorDao().findPhValues();
        // 可以测试一下result  
        System.out.println(this.result);  
  
        return SUCCESS;  
  
    }  
    
    public String ph(){
    	  Map<String, String> map = new HashMap<String, String>();  
    	  String date = DateUtils.date2String(new Date(), DateUtils.YYYY_MM_DD_HH_MM_SS_PATTERN);
          map.put("x", date);
          map.put("y", "6");
          JSONObject jo = JSONObject.fromObject(map);  
          this.phValue = jo.toString();
          
    	   // 可以测试一下result  
        System.out.println(this.phValue);  
  
        return SUCCESS;  
    }
    
   
//	/** Logger used by this class. Available to subclasses. */
//	protected final Log logger = LogFactory.getLog(getClass());
//	
//	
//	
//	private HttpServletRequest request;
//	private HttpServletResponse response;
//	
//	
//	
//	public SensorAction() {
//		System.out.println("进入了SensorAction");
//	}
//
//
//	public String test() throws IOException, JSONException {
//		System.out.println("test()");
//		
//		String json="{[{\"data\":24,\"categories\":\"狗\"},{\"data\":45,\"categories\":\"猫\"},{\"data\":6,\"categories\":\"老虎 \"}]}";
//		printWriter(json);
//		return "success";
//	}
//	
//	
//	/**
//	 * 喷出json数据
//	 * @throws IOException 
//	 */
//	public void printWriter(String json) throws IOException{
//		response.setContentType("application/json;charset=UTF-8");
//	    PrintWriter writer = response.getWriter();
//		writer.write(json);
//		writer.close();
//	}
//	
//	
//	
//	public HttpServletRequest getRequest() {
//		return request;
//	}
//
//	public void setRequest(HttpServletRequest request) {
//		this.request = request;
//	}
//
//	public HttpServletResponse getResponse() {
//		return response;
//	}
//
//	public void setResponse(HttpServletResponse response) {
//		this.response = response;
//	}
//
//
//	public void setServletResponse(HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	public void setServletRequest(HttpServletRequest request) {
//		// TODO Auto-generated method stub
//		
//	}

	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	
}
