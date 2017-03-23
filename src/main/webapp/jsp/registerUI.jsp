<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册界面</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css\dist\css/bootstrap.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js\jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){

		

		$("select ").change(function(){
			//alert($(this).val());
             if($(this).val()==1){
             	$("#other").hide();

             	$("#custom").show(1000);
             }
            if($(this).val()==2){
                $("#custom").hide();
            	$("#other").show(1000);
            }
         }

			)



	})
	
		//提交表单
    	function doSubmit(){
        		
	    		document.forms[0].submit();
	    		alert("注册成功");
    	
    	}
	
	
	



</script>

<style type="text/css">

#footer{

  position:absolute;
  bottom:0;
  text-align:center;
  width:100%;
}


</style>

</head>


<body>
<body class="bg-primary">

   <div id="reg" class="container">

<form id="form" class="form-horizontal" name="form" action="${basePath }Register_register.action" method="post" enctype="multipart/form-data">
<!-- <form class="form-horizontal"> -->
  <fieldset>
    <legend >请填写注册信息</legend>


  <div class="form-group">
    <label for="inputEmail3" class="col-sm-4 control-label">头像</label>
    
    <s:if test="%{user.headImg != null && user.headImg != ''}">
       <img src="${basePath }upload/<s:property value='user.headImg'/>" width="100" height="100"/>
       
           <s:hidden name="user.headImg"/>	<!-- 防止编辑图像以外的时候将图像置空 -->
        </s:if>
    
    <div class="col-sm-4">
      <input type="file" class="form-control" name="headImg">
    </div>
  </div>


<%--  <td>
                <s:if test="%{user.headImg != null && user.headImg != ''}">
                    <img src="${basePath }upload/<s:property value='user.headImg'/>" width="100" height="100"/>
                    <s:hidden name="user.headImg"/>
                </s:if>
                <input type="file" name="headImg"/>
            </td>
 --%>





  <div class="form-group">
    <label for="inputEmail3" class="col-sm-4 control-label">用户名</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="userName" name="user.userName">
    </div>
  </div>
  
  <div class="form-group">
   <label for="inputEmail3" class="col-sm-4 control-label">注册身份</label>
   <div class="col-sm-4">
  	<s:checkboxlist list="#roleList" name="userRoleIds" listKey="roleId" listValue="roleName"></s:checkboxlist>
 	</div>
 </div>
 

  <div class="form-group">
    <label for="inputPassword3" class="col-sm-4 control-label">密码</label>
    <div class="col-sm-4">
      <input type="password" class="form-control" id="passWord2" name="">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-4 control-label">确认密码</label>
    <div class="col-sm-4">
      <input type="password" class="form-control" id="passWord" name="user.passWord" >
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-4 control-label"name='x-realName'>邮箱 </label>
    <div class="col-sm-4">
      <input type="email" class="form-control" id="email" name = "user.email" >
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-4 control-label"name="factoryName">企业名称</label>
    <div class="col-sm-4">
      <input type="text" class="companyName" id="user.companyName" >
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-4 control-label"name="telNumber">手机号码</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="mobile" name = "user.mobile">
    </div>
  </div>
   <div class="form-group">
    <div class="col-sm-offset-4 col-sm-10 col-md-2">
    <input id="register" class="btn btn-success "  type="button" value="立即注册" onclick="doSubmit()">
    </div>
  </div>

</div>

</form>




 <div id="footer">

      
        <div class="center-block"style="width:500px;padding:20px">

      	 版权所有：复旦大学无锡研究院 CopyRight &copy; 2016<br />
        咨询电话：86-510-85622268  传真号码：86-510-85623633

       
            
            </div>

      </div>


</body>
</html>