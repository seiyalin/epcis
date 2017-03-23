<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Page Sidebar -->

  <div class="page-sidebar" id="sidebar">
    <!-- Page Sidebar Header-->
  <div class="sidebar-header-wrapper">
      <input type="text" class="searchinput" />
      <i class="searchicon fa fa-search"></i>
      <div class="searchhelper">Search Reports, Charts, Emails or Notifications</div>
  </div>
  <!-- /Page Sidebar Header -->
  <!-- Sidebar Menu -->
  <ul class="nav sidebar-menu">
      <!--Dashboard-->
  
      
       <li style="display:flex;z-index:999">
       <a href="productCategory.jsp" style="width:85%">
             <i style="z-index:999" class="menu-icon glyphicon glyphicon-tasks"></i>
              
              <span class="menu-text" > 水产品分类管理 </span> 
          </a>
           <i style="z-index: 999;line-height:38px;cursor:pointer"class="glyphicon glyphicon-chevron-down show-hide1"></i>
      </li>
    <li style="z-index:999;text-align:center;display:none"class="menu-children1">
         
             <a >饲料管路</a> 
              <a style="border-top:none">疾病管理 </a> 
              
      </li>
     <li style="display:flex;z-index:999">
       <a  href="feedUI.jsp" style="width:85%">
             <i style="z-index:999" class="menu-icon glyphicon glyphicon-tasks"></i>
              
              <span class="menu-text" > 水产品管理 </span> 
          </a>
           <i style="z-index: 999;line-height:38px;cursor:pointer"class="glyphicon glyphicon-chevron-down show-hide2"></i>
      </li>
    <li style="z-index:999;text-align:center;display:none"class="menu-children2">
         
             <a >饲料管路</a> 
              <a style="border-top:none">疾病管理 </a> 
              
      </li>
      
       <li style="display:flex;z-index:999">
       <a href="orderInfo.jsp" style="width:85%">
             <i style="z-index:999" class="menu-icon glyphicon glyphicon-tasks"></i>
              
              <span class="menu-text" > 水产品订单管理 </span> 
          </a>
           <i style="z-index: 999;line-height:38px;cursor:pointer"class="glyphicon glyphicon-chevron-down show-hide3"></i>
      </li>
    <li style="z-index:999;text-align:center;display:none"class="menu-children3">
         
             <a >饲料管路</a> 
              <a style="border-top:none">疾病管理 </a> 
              
      </li>
      
       <li style="display:flex;z-index:999">
       <a href="orderInfo.jsp" style="width:85%">
             <i style="z-index:999" class="menu-icon glyphicon glyphicon-tasks"></i>
              
              <span class="menu-text" > 水产品加工管理 </span> 
          </a>
           <i style="z-index: 999;line-height:38px;cursor:pointer"class="glyphicon glyphicon-chevron-down show-hide4"></i>
      </li>
    <li style="z-index:999;text-align:center;display:none"class="menu-children4">
         
             <a >饲料管路</a> 
              <a style="border-top:none">疾病管理 </a> 
              
      </li>
       <li style="display:flex;z-index:999">
       <a href="orderInfo.jsp" style="width:85%">
             <i style="z-index:999" class="menu-icon glyphicon glyphicon-tasks"></i>
              
              <span class="menu-text" > 水产品配送管理 </span> 
          </a>
           <i style="z-index: 999;line-height:38px;cursor:pointer"class="glyphicon glyphicon-chevron-down show-hide5"></i>
      </li>
    <li style="z-index:999;text-align:center;display:none"class="menu-children5">
         
             <a >饲料管路</a> 
              <a style="border-top:none">疾病管理 </a> 
              
      </li>
       <li style="display:flex;z-index:999">
       <a href="saleInfo.jsp" style="width:85%">
             <i style="z-index:999" class="menu-icon glyphicon glyphicon-tasks"></i>
              
              <span class="menu-text" > 水产品销售管理 </span> 
          </a>
           <i style="z-index: 999;line-height:38px;cursor:pointer"class="glyphicon glyphicon-chevron-down show-hide6"></i>
      </li>
    <li style="z-index:999;text-align:center;display:none"class="menu-children6">
         
             <a >饲料管路</a> 
              <a style="border-top:none">疾病管理 </a> 
              
      </li>
       <li style="display:flex;z-index:999">
       <a href="traceability.jsp" style="width:85%">
             <i style="z-index:999" class="menu-icon glyphicon glyphicon-tasks"></i>
              
              <span class="menu-text" > 消费者追溯管理 </span> 
          </a>
           <i style="z-index: 999;line-height:38px;cursor:pointer"class="glyphicon glyphicon-chevron-down show-hide7"></i>
      </li>
    <li style="z-index:999;text-align:center;display:none"class="menu-children7">
         
             <a >饲料管路</a> 
              <a style="border-top:none">疾病管理 </a> 
              
      </li>
       <li style="display:flex;z-index:999">
       <a href="complain.jsp" style="width:85%">
             <i style="z-index:999" class="menu-icon glyphicon glyphicon-tasks"></i>
              
              <span class="menu-text" > 监管者平台</span> 
          </a>
           <i style="z-index: 999;line-height:38px;cursor:pointer"class="glyphicon glyphicon-chevron-down show-hide8"></i>
      </li>
    <li style="z-index:999;text-align:center;display:none"class="menu-children8">
         
             <a >饲料管路</a> 
              <a style="border-top:none">疾病管理 </a> 
              
      </li>
     <!-- <li>
      <div class="dropdown" style="z-index:999;border:none">
  <button style="border:none;width:100%;text-align:start;padding-left:16px"class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
   <i class="menu-icon glyphicon glyphicon-tasks"style="margin-right:12px"></i>水产品分类管理
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    <li><a href="#">水产品养殖子系统</a></li>
    <li><a href="#">水产品加工子系统</a></li>
    <li><a href="#">水产品销售子系统</a></li>
    <li role="separator" class="divider"></li>
    <li><a href="#">水产品配送子系统</a></li>
    <li><a href="#">水产品查询与监管子系统</a></li>
  </ul>
</div>
</li> -->
      
    
    
    <!-- 
       <li>
          <a href="feedUI.jsp">
              <i class="menu-icon glyphicon glyphicon-tasks"></i>
              <span class="menu-text"> 水产品管理 </span>
          </a>
      </li>
      
       <li>
          <a href="orderInfo.jsp">
              <i class="menu-icon glyphicon glyphicon-tasks"></i>
              <span class="menu-text"> 水产品订单管理 </span>
          </a>
      </li>
      
        <li>
          <a href="orderInfo.jsp">
              <i class="menu-icon glyphicon glyphicon-tasks"></i>
              <span class="menu-text"> 水产品加工管理 </span>
          </a>
      </li>
      
      
        <li>
          <a href="orderInfo.jsp">
              <i class="menu-icon glyphicon glyphicon-tasks"></i>
              <span class="menu-text"> 水产品配送管理 </span>
          </a>
      </li>
      
      
          <li>
          <a href="saleInfo.jsp">
              <i class="menu-icon glyphicon glyphicon-tasks"></i>
              <span class="menu-text"> 水产品销售管理 </span>
          </a>
      </li>
      
        <li>
          <a href="traceability.jsp">
              <i class="menu-icon glyphicon glyphicon-tasks"></i>
              <span class="menu-text"> 消费者追溯管理 </span>
          </a>
      </li>
      
      
         <li>
          <a href="complain.jsp">
              <i class="menu-icon glyphicon glyphicon-tasks"></i>
              <span class="menu-text"> 监管者平台 </span>
          </a>
      </li> -->
      
  </ul>
  <!-- /Sidebar Menu -->
</div>
<!-- /Page Sidebar -->
<script src="assets/js/jquery-2.0.3.min.js"></script>
<script src="assets/js/menu/menu.js"  type="text/javascript"></script>
