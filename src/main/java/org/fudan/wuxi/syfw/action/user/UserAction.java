package org.fudan.wuxi.syfw.action.user;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.oliot.epcis.service.mysqlservice.user.IUserService;
import org.oliot.model.mysqlservice.User;
import org.oliot.model.mysqlservice.role.Role;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	/** Logger used by this class. Available to subclasses. */
	protected final Log logger = LogFactory.getLog(getClass());
	
	private IUserService userService;
	private List<User> userList;
	
	private User user;
	
	private String[] userRoleIds;
	private List<Role> list = new ArrayList<Role>();
	
	//接收前台页面传过来的选中的要删除的id
	private String[] selectedRow;
	
	/**
	 * 处理头像上传
	 */
	
	public String[] getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}

	private File headImg;
	private String headImgContentType;
	private String headImgFileName;
	
	


	@Resource
	public void setUserService(IUserService userService) {
		if(logger.isDebugEnabled()){
			logger.debug("UserAction.setUserService(IUserService userService)");
		}
		this.userService = userService;
	}
	
	// 列表页面
		public String listUI() {
			
			userList = userService.findObjects();
			System.out.println(userList);
			
			return "listUI";

		}
		
		
		
		//跳转到新增页面
		public String addUI(){
			//加载角色列表
			
			list.add(new Role("1", "管理员"));
			list.add(new Role("2", "普通用户"));
			ActionContext.getContext().getContextMap().put("roleList", list);
			
			
//			ActionContext.getContext().getContextMap().put("roleList", roleService.findObjects());
			return "addUI";
		}
		
		
		
		//保存新增
		public String add(){
			try {
				if(user != null){
					//处理头像
					if(headImg != null){
						//1、保存头像到upload/user
						//获取保存路径的绝对地址
						String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
						String fileName = UUID.randomUUID().toString().replaceAll("-", "") + headImgFileName.substring(headImgFileName.lastIndexOf("."));
						//复制文件
						FileUtils.copyFile(headImg, new File(filePath, fileName));
						
						//2、设置用户头像路径
						user.setHeadImg("user/" + fileName);
					}
					userService.save(user);
//					userService.saveUserAndRole(user, userRoleIds);
//					userService.saveUserAndRole(user, Arrays.asList(userRoleIds));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "list";
		}
		//跳转到编辑页面
		public String editUI(){
			if(user != null &&user.getId() != null ){
				user = (User) userService.findObjectById(user.getId());
				}
	
			return "editUI";
		}
		
		//保存编辑
		public String edit(){
			try {
				if(user != null){
					//处理头像
					if(headImg != null){
						//1、保存头像到upload/user
						//获取保存路径的绝对地址
						String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
						String fileName = UUID.randomUUID().toString().replaceAll("-", "") + headImgFileName.substring(headImgFileName.lastIndexOf("."));
						//复制文件
						FileUtils.copyFile(headImg, new File(filePath, fileName));
						
						//2、设置用户头像路径
						user.setHeadImg("user/" + fileName);
					}
					userService.update(user);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "list";
		}
		
		//删除
		public String delete(){
			if(user != null && user.getId() != null){
				userService.delete(user.getId());
			}
			return "list";
		}
		
		
		//批量删除
		public String deleteSelected(){
			if(selectedRow != null){
				for(String id: selectedRow){
					userService.delete(id);
				}
			}
			return "list";
		}

		public List<User> getUserList() {
			return userList;
		}

		public void setUserList(List<User> userList) {
			this.userList = userList;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
	
		
		
		public String[] getUserRoleIds() {
			return userRoleIds;
		}

		public void setUserRoleIds(String[] userRoleIds) {
			this.userRoleIds = userRoleIds;
		}

		public List<Role> getList() {
			return list;
		}

		public void setList(List<Role> list) {
			this.list = list;
		}

		public File getHeadImg() {
			return headImg;
		}

		public void setHeadImg(File headImg) {
			this.headImg = headImg;
		}

		public String getHeadImgContentType() {
			return headImgContentType;
		}

		public void setHeadImgContentType(String headImgContentType) {
			this.headImgContentType = headImgContentType;
		}

		public String getHeadImgFileName() {
			return headImgFileName;
		}

		public void setHeadImgFileName(String headImgFileName) {
			this.headImgFileName = headImgFileName;
		}
		
		
	
	
}
