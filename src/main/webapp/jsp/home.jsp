<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>养殖信息</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css\dist\css/bootstrap.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js\jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<style type="text/css">
#nav a{color:black;}
#nav li{margin-right:110px; }
#header{
			margin-bottom: 0px;
			padding:20px ;
			position: relative;
   }

  #main{

  	padding:10px;
  	margin-top: 3px;
  }


 img{


 	width:100%;
 	height:150px;
 }


</style>

</head>

<body class="bg-info">
<div class="container-fluid ">
   <!--导航部分-->

	<div id="navbar">
	

	
<%-- 	<img src="${basePath }upload/<s:property value='#session.SYS_USER.headImg'/>" width="1000" height="1000"/> --%>
		<div id="header" class="bg-warning"><h2>欢迎 访问水产品溯源系统</h2>

 
		<div id="linknav">
   		<ul id="nav"class="nav nav-pills bg-primary nav-justified">
   		
   		
   			<li><a href="${basePath }home.action" >主页</a></li>	<!-- 默认执行excute方法 -->
   		<%-- 	<li><a href="${basePath }syfw/user_listUI.action" >用户管理</a></li>	<!-- 默认执行excute方法 -->
   			<li><a href="${basePath }syfw/role_listUI.action" >角色管理</a></li>	<!-- 默认执行excute方法 --> --%>
   			<li><a href="${basePath }jsp/feedUI.jsp" >养殖阶段</a></li><!-- 默认执行excute方法 -->
   			<li><a href="${pageContext.request.contextPath}/jsp/transportUI.jsp">运输阶段</a></li>
  		    <li><a href="${pageContext.request.contextPath}/jsp/factoryUI.jsp">加工阶段</a></li>
  		    <li><a href="${pageContext.request.contextPath}/jsp/marketUI.jsp">销售阶段</a></li>

        </ul>
      </div>

   </div>



      <div id="main" class="row bg-info">

    <!--左边栏-->
      	<div id="intro" class="bg-danger  col-md-3">
      		<h4>系统简介</h4>
      		&#8195随着人们的生活水平越来越来提高，水产品的质量安全也越来越重要，水产品质量安全问题不仅关系到公众的身体健康,而且对农业发展、农民增收、农业贸易和农业现代化建设具有重大影响,成为新时期我国农产品生产和供给急需解决的一个重要课题。另外，我国水产品质量安全事件层出不穷，受到国内外的广泛关注,这些事件对水产行业造成了不小的冲击.因此,加强水产品质量安全管理工作是保证水产养殖业可持续发展的关键,而水产品质量可追溯制度的建立是水产品质量安全的重要保障措施之一,其中实现生产记录可查询、产品流向可跟踪、产品质量可追溯显得尤为重要. <br>
				&#8195而通过本系统对水产的育苗、养殖、加工、物流、销售的全过程进行信息化管理，实现了对水产品整个生命周期信息的快速识别与溯源管理。根据企业自身在水产品养殖、加工流程的质量安全公共追溯要素特点，有效满足企业对水产品生产加工环节的质量安全信息的控制、信息的跟踪和追溯总体需求，帮助企业动态掌握产品质量信息，同时也方便消费者了解产品质量管理信息，放心消费。 					
      	</div>


<!--右边栏图片轮播部分-->
         
         <div id="myCarousel" class="carousel col-md-9 " >
   <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
      <li data-target="#myCarousel" data-slide-to="4"></li>
   </ol>   
   <!-- 轮播（Carousel）项目 -->
   <div class="carousel-inner">
      <div class="item active">
         <img src="${pageContext.request.contextPath}/image/1.jpg" alt="First slide"class="img-rounded">
      </div>
      <div class="item">
         <img src="${pageContext.request.contextPath}/image/2.jpg" alt="Second slide" class="img-rounded">
      </div>
      <div class="item">
         <img src="${pageContext.request.contextPath}/image/3.jpg" alt="Third slide" class="img-rounded">
      </div>
      <div class="item">
         <img src="${pageContext.request.contextPath}/image/4.jpg" alt="Fourth slide" class="img-rounded">
      </div>
      <div class="item">
         <img src="${pageContext.request.contextPath}/image/5.jpg" alt="Fourth slide" class="img-rounded">
      </div>
   </div>
   <!-- 轮播（Carousel）导航 -->
   <a class="carousel-control left" href="#myCarousel" 
      data-slide="prev">&lsaquo;</a>
   <a class="carousel-control right" href="#myCarousel" 
      data-slide="next">&rsaquo;</a>
</div>


        
      </div>
      <!--底部部分-->

      <div id="footer" class="row bg-primary">

      
        <div class="center-block"style="width:500px;padding:20px">

      	 版权所有：复旦大学无锡研究院 CopyRight &copy; 2016<br />
        咨询电话：86-510-85622268  传真号码：86-510-85623633

       
            
            </div>

      </div>

</div>
</body>
</html>