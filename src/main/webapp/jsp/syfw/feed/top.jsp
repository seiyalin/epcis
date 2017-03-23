
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<html xmlns="http://www.w3.org/1999/xhtml">
<!--Head-->
<head>
    <meta charset="utf-8" />
    <script type="text/javascript">
    	var CONTEXT_PATH = '<%=basePath %>';
    </script>
    
     <style type="text/css">
		.account-area {
	    	right: 2px;
		}
	</style>
</head>
<body>
<!-- Navbar -->
<div class="navbar">
    <div class="navbar-inner">
        <div class="navbar-container">
            <!-- Navbar Barnd -->
       <div class="navbar-header pull-left">
           <a href="#" class="navbar-brand">
               <small>
                 <!--   <img src="assets/img/logo.jpg" style="width:64px; height:70px" alt="" /> -->
                  <img src="assets/img/logo2.jpg" alt="" />
               </small>
           </a>
       </div>
       <!-- /Navbar Barnd -->
       <!-- Sidebar Collapse -->
       <div class="sidebar-collapse" id="sidebar-collapse">
           <i class="collapse-icon fa fa-bars"></i>
       </div>
       <!-- /Sidebar Collapse -->
       <!-- Account Area and Settings --->
       <div class="navbar-header pull-right">
           <div class="navbar-account">
           		<!-- div class="setting">
                   <a id="settingHref" title="Setting" href="profile.jsp">
                       <i class="icon glyphicon glyphicon-cog"></i>
                   </a>
               </div-->
               
               <ul class="account-area" style="right: 2px;">
                   <li>
                       <a class="login-area dropdown-toggle" data-toggle="dropdown">
                           <div class="avatar" title="View your public profile">
                               <img src="assets/img/avatars/default.jpg">
                           </div>
                           <section>
                               <h2><span class="profile"><span id="loginUserNameSpan"></span></span></h2>
                           </section>
                       </a>
                       <!--Login Area Dropdown-->
                       <ul class="pull-right dropdown-menu dropdown-arrow dropdown-login-area" style="min-width: 160px;">
                           <li class="username" style="display: block;"><a></a></li>
                           <%-- <li class="email"><a><%=sysUser.getEmail() %></a></li> --%>
                           <div style="display:none" id="userId">hgfh</div>
                           <!--Avatar Area-->
                           <li class="edit">
                              <!--  <a href="#" class="pull-left">信息</a>
                               <a href="#" class="pull-right">设置</a> -->
                               <a href="profile.jsp" class="pull-left">个人设置</a>
                           </li>
                           <!--Theme Selector Area-->
                           <li class="theme-area">
                               <ul class="colorpicker" id="skin-changer">
                                   <li><a class="colorpick-btn" href="#" style="background-color:#5DB2FF;" rel="assets/css/skins/blue.min.css"></a></li>
                                   <li><a class="colorpick-btn" href="#" style="background-color:#2dc3e8;" rel="assets/css/skins/azure.min.css"></a></li>
                                   <li><a class="colorpick-btn" href="#" style="background-color:#03B3B2;" rel="assets/css/skins/teal.min.css"></a></li>
                                   <li><a class="colorpick-btn" href="#" style="background-color:#53a93f;" rel="assets/css/skins/green.min.css"></a></li>
                                   <li><a class="colorpick-btn" href="#" style="background-color:#FF8F32;" rel="assets/css/skins/orange.min.css"></a></li>
                                   <li><a class="colorpick-btn" href="#" style="background-color:#cc324b;" rel="assets/css/skins/pink.min.css"></a></li>
                                   <li><a class="colorpick-btn" href="#" style="background-color:#AC193D;" rel="assets/css/skins/darkred.min.css"></a></li>
                                   <li><a class="colorpick-btn" href="#" style="background-color:#8C0095;" rel="assets/css/skins/purple.min.css"></a></li>
                                   <li><a class="colorpick-btn" href="#" style="background-color:#0072C6;" rel="assets/css/skins/darkblue.min.css"></a></li>
                                   <li><a class="colorpick-btn" href="#" style="background-color:#585858;" rel="assets/css/skins/gray.min.css"></a></li>
                                   <li><a class="colorpick-btn" href="#" style="background-color:#474544;" rel="assets/css/skins/black.min.css"></a></li>
                                   <li><a class="colorpick-btn" href="#" style="background-color:#001940;" rel="assets/css/skins/deepblue.min.css"></a></li>
                               </ul>
                           </li>
                           <!--/Theme Selector Area-->
                           <li class="dropdown-footer">
                               <a href="#" id="loginOutBtn">
                                   		注销
                               </a>
                           </li>
                       </ul>
                       <!--/Login Area Dropdown-->
                   </li>
                   <!-- /Account Area -->
                   <!--Note: notice that setting div must start right after account area list.
                   no space must be between these elements-->
                   <!-- Settings -->
               </ul>
               <!-- 
               <div class="setting">
                   <a id="btn-setting" title="Setting" href="#">
                       <i class="icon glyphicon glyphicon-cog"></i>
                   </a>
               </div>
               <div class="setting-container">
                   <label>
                       <input type="checkbox" id="checkbox_fixednavbar">
                       <span class="text">Fixed Navbar</span>
                   </label>
                   <label>
                       <input type="checkbox" id="checkbox_fixedsidebar">
                       <span class="text">Fixed SideBar</span>
                   </label>
                   <label>
                       <input type="checkbox" id="checkbox_fixedbreadcrumbs">
                       <span class="text">Fixed BreadCrumbs</span>
                   </label>
                   <label>
                       <input type="checkbox" id="checkbox_fixedheader">
                       <span class="text">Fixed Header</span>
                   </label>
               </div>
                -->
               <!-- Settings -->
           </div>
       </div>
       <!-- /Account Area and Settings -->
        </div>
    </div>
</div>
</body>
</html>