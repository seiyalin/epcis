package org.fudan.wuxi.syfw.action.role;






import org.fudan.wuxi.common.Constant;
import org.oliot.model.mysqlservice.role.Role;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport {

	private Role role;
	private String[] privilegeIds;
	private String strName;
	
	//列表页面
	public String listUI() throws Exception{
		//加载权限集合
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		return "listUI";
	}
	//跳转到新增页面
	public String addUI(){
		//加载权限集合
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		
		return "addUI";
	}
	//保存新增
	public String add(){
		
		return "list";
	}
	//跳转到编辑页面
	public String editUI(){
		//加载权限集合
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		
		return "editUI";
	}
	//保存编辑
	public String edit(){
		
		return "list";
	}
	//删除
	public String delete(){
		
		return "list";
	}
	//批量删除
	public String deleteSelected(){
		
		return "list";
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String[] getPrivilegeIds() {
		return privilegeIds;
	}
	public void setPrivilegeIds(String[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}
}
