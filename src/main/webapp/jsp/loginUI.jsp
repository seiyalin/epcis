<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录界面</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dist/css/bootstrap.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js\jquery.min.js"></script>
<script>

		 $(function() {
		     $("#mlogin").click(function() {
		    //提交的参数，name和inch是和struts action中对应的接收变量
		        var params = {
		           userName : $("#musername").val(),
		           passWord : $("#mpassword").val()
		        };
		        $.ajax({
		    type: "POST",
		    url: "jsonAjax.action",
		    data: params,
		    dataType:"text", //ajax返回值设置为text（json格式也可用它返回，可打印出结果，也可设置成json）
		    success: function(json){ 
		    	//alert("json=" + json);
		    var obj = $.parseJSON(json);  //使用这个方法解析json
		    var state_value = obj.result;  //result是和action中定义的result变量的get方法对应的
		    alert(state_value);
		    },
		    error: function(json){
		     alert("json=" + json);
		     return false;
		    }
		    });
		     });
		   });	
		   
		  /* 提交登陆数据到LoginAction */
		   function doLogin(){
			document.forms[0].submit();
			alert("登陆成功！")
		}
		
</script>
<style>
#footer{

  position: absolute;
  bottom:0;
  text-align: center;
  width:100%;
}
</style>

</head>
<body  class="bg-primary">
  

                      
                    <form id="form" class="form-horizontal" name="form" action="${basePath }Login_login.action" method="post" enctype="multipart/form-data">
                       <fieldset>
                            <legend ><h2 style="color:white;">欢迎访问水产品溯源系统</h2></legend>
                                  <div class="form-group">
                                       <label for="inputEmail3" class="col-sm-4 control-label">账号</label>
                                               <div class="col-sm-4">
                                                           <input type="text" class="form-control" id="username" placeholder="请输入账号" name="userName">
                                              </div>
                                  </div>
                                 <div class="form-group">
                                         <label for="inputPassword3" class="col-sm-4 control-label">密码</label>
                                                <div class="col-sm-4">
                                                           <input type="password" class="form-control" id="password" placeholder="请输入密码"name="passWord">
                                                </div>
                                  </div>
                                  <div id="footer">

      
        <div class="center-block" style="width:100%;padding:20px">

         版权所有：复旦大学无锡研究院 CopyRight &copy; 2016<br>
        咨询电话：86-510-85622268  传真号码：86-510-85623633

       
            
            </div>

      </div><div class="form-group">
                                           <div class="col-sm-offset-4 col-sm-4">
                                                   <div class="checkbox">
                                                         <label><input type="checkbox"> 记住密码</label>
                                                   </div>
                                           </div>
                                   </div>
                                  <div class="form-group">
                                             <div class="col-sm-offset-4 col-sm-4">
                                                  <button type="button" class="btn btn-success " onclick="doLogin()" >登录</button>
                                                  <button type="button" class="btn btn-info " ><a href="${pageContext.request.contextPath}/Register_registerUI.action" style="color:white;text-decoration:none;">点击注册</a></button>
                                              </div>
                                   </div>
                      </fieldset>
                  </form>

    
          



</body>
</html>
