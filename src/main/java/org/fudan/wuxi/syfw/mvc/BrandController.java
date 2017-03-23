package org.fudan.wuxi.syfw.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.fudan.wuxi.syfw.mvc.base.BaseController;
import org.fudan.wuxi.utils.log.LogUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@RequestMapping("/jsp/syfw/feed/brand")
@Controller
public class BrandController extends BaseController {

//	@Resource
//	private IBrandService service;

	@RequestMapping("/getAll.mvc")
	public @ResponseBody
	JSONObject getProvince(HttpServletRequest request) {

		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("start", -1);
		param.put("limit", -1);
		
		try {
//			List<Brand> list = service.getList(param);

			JSONArray result = new JSONArray();
//			for (Brand po : list) {
				JSONObject ob = new JSONObject();
				ob.put("id", 2);
				ob.put("name", "光明");
				result.add(ob);
//			}
			return this.toJSONResult(true, result);
		}catch (Exception e) {
			LogUtils.getInstance().errorSystem(LogUtils.MODULE_CONTROLLER, e);
			return this.toJSONResult(false, "发生未知错误");
		}
	}
}
