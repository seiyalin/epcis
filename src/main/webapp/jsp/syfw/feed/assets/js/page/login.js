$(document).ready(function () {
	checkCode();
});
function checkCode(){
	$("#code").attr("src",CONTEXT_PATH + "/portal/mkRandCodePic.do?code=" + (new Date()).getTime());
}

function login(){
	var userName = $('#userName').val();
	var passWord = $('#passWord').val();
	var randCode = $('#randCode').val();
	if(userName == ''){
		$.fn.bdmp.message.error("用户名不可为空!");
		return;
	}
	if(passWord == ''){
		$.fn.bdmp.message.error('密码不可为空!');
		return;
	}
	if(randCode == ''){
		$.fn.bdmp.message.error('验证码不可为空!');
		return;
	}
	$("#loginSubmitBt").attr("disabled",true);
	$("#loginSubmitBt").val('登录中...');
	
	$.post(CONTEXT_PATH + "portal/login.do",{
			userName : userName,
			password : passWord,
			randCode : randCode
		},function(data) {
			var flag = data.flag;
			if(flag == 0){
				$.fn.bdmp.message.success("登录成功!");
				window.location.href = data.homePage;
		   	}else{
		   		if(flag == -2){
					$.fn.bdmp.message.error("验证码错误!");
					$('#randCode').val('');
					$("#loginSubmitBt").attr("disabled",false);
					$("#loginSubmitBt").val('立即登录');
				}
				if(flag == -1){
					$.fn.bdmp.message.error("用户名密码错误!");
					$('#userName').val('');
					$('#passWord').val('');
					$('#randCode').val('');
					$("#loginSubmitBt").attr("disabled",false);
					$("#loginSubmitBt").val('立即登录');
				}
				checkCode();
			}
	}, 'json');
};

document.onkeydown = function(evt){
  　 var evt = window.event?window.event:evt;
   　if (evt.keyCode==13) {
	   login();
   　}
}
