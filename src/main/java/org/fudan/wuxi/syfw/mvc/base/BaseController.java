package org.fudan.wuxi.syfw.mvc.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.fudan.wuxi.utils.GeneralUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;

//import com.merchant.common.base.dao.page.SearchBean;
//import com.merchant.common.exception.CommonException;
//import com.merchant.common.messagecode.MsgDescription;
//import com.merchant.common.utils.ConfigFileUtil;
//import com.merchant.common.utils.DateUtils;
//import com.merchant.common.utils.GeneralUtils;
//import com.merchant.common.utils.UUIDGenerator;

/**
 * Controller基类，所有的Controller必须要继承此类
 */
public class BaseController {

	public static final String DEFAULT_JSON_DATA = "aaData";

	public static final String DEFAULT_JSON_TOTAL_PROPERTY = "iTotalRecords";

	public static final String DEFAULT_JSON_SECHO = "sEcho";

	public static final String DEFAULT_JSON_RECORDSFILTERED = "iTotalDisplayRecords";

	public static final String DEFAULT_JSON_MESSAGE = "message";

	public static final String DEFAULT_JSON_SUCCESS = "success";
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(
				dateFormat, true));
	}
	





	protected JSONObject toJSONResult(long count, List data) {
		JSONObject result = new JSONObject();
		result.put(DEFAULT_JSON_TOTAL_PROPERTY, count);
		result.put(DEFAULT_JSON_DATA, data);
		return result;
	}

	protected JSONObject toJSONResult(long count, List data, int sEcho) {
		JSONObject result = new JSONObject();
		result.put(DEFAULT_JSON_TOTAL_PROPERTY, count);
		result.put(DEFAULT_JSON_RECORDSFILTERED, count);
		result.put(DEFAULT_JSON_DATA, data);
		result.put(DEFAULT_JSON_SECHO, sEcho);
		return result;
	}

	protected JSONObject toJSONResult(boolean success, String message) {
		JSONObject result = new JSONObject();
		result.put(DEFAULT_JSON_SUCCESS, success);
		if (!GeneralUtils.isNullOrZeroLenght(message)) {
			result.put(DEFAULT_JSON_MESSAGE, message);
		}
		return result;
	}

	protected JSONObject toJSONResult(boolean success) {
		JSONObject result = new JSONObject();
		result.put(DEFAULT_JSON_SUCCESS, success);
		return result;
	}

	protected JSONObject toJSONResult(boolean success, Object data) {
		JSONObject result = new JSONObject();
		result.put(DEFAULT_JSON_SUCCESS, success);
		result.put(DEFAULT_JSON_DATA, data);
		return result;
	}

	protected Map<String, Object> toJSONResultMap(boolean success, Object data) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(DEFAULT_JSON_SUCCESS, success);
		result.put(DEFAULT_JSON_DATA, data);
		return result;
	}

	protected Map<String, Object> toJSONResultMap(boolean success, String msg) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(DEFAULT_JSON_SUCCESS, success);
		result.put(DEFAULT_JSON_MESSAGE, msg);
		return result;
	}

	protected JSONArray toJSONArrayResult(List data) {
		return JSONArray.fromObject(data);
	}

	protected Pageable convert2Pageable(int start, int limit) {
		if (limit == 0) {
			limit = Integer.MAX_VALUE;
		}
		Pageable pageable = new PageRequest(start / limit, limit);
		return pageable;
	}

//	/**
//	 * 根据前台的param参数，返回searchbean对象
//	 * <p/>
//	 */
//	protected SearchBean[] convert2SearchBean(String param) {
//		if (GeneralUtils.isNullOrZeroLenght(param)) {
//			return new SearchBean[] {};
//		}
//
//		String[] paramStrs = param.split(",");
//
//		List<SearchBean> list = new ArrayList<SearchBean>();
//		for (String paramStr : paramStrs) {
//			String[] search = paramStr.split(":");
//			// 如果没有填写值，则不生成searchbean
//			if (search.length < 3 || GeneralUtils.isNullOrZeroLenght(search[1])) {
//				continue;
//			}
//
//			SearchBean searchBean = new SearchBean(search[0], search[1],
//					search[2]);
//			list.add(searchBean);
//		}
//		return list.toArray(new SearchBean[] {});
//	}
//
//	// 保存图片
//	protected String saveFile(MultipartFile file, HttpServletRequest req)
//			throws IllegalStateException, IOException {
//		String fileName = file.getOriginalFilename();
//		String finalFileName = UUIDGenerator.get32UUID() + "." + fileName.substring(fileName.indexOf(".") + 1);
//		String basePath = ConfigFileUtil.ABSOLUTE_FILEPATH + "/" + ConfigFileUtil.SUB_FILEPATH;
//    	File baseFile = new File(basePath);
//    	if(!baseFile.exists()){
//    		baseFile.mkdirs();
//    	}
//		File targetFile = new File(ConfigFileUtil.ABSOLUTE_FILEPATH + "/"
//				+ ConfigFileUtil.SUB_FILEPATH, finalFileName);
//
//		file.transferTo(targetFile);
//		if (GeneralUtils.isNotNullOrZeroLenght(fileName)) {
//			return "/"+ConfigFileUtil.SUB_FILEPATH+"/" + finalFileName;
//		}
//		return null;
//	}
}
