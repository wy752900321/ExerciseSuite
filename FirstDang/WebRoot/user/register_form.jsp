<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix = "s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript"
    src="<%=request.getContextPath() %>/js/my.js">
   </script>
  <script type="text/javascript" 
			src="../js/jquery-1.4.3.js">
		</script>
		<script type="text/javascript">
		var flag = {"email":false,"nickname":false,
		            "password":false,"password1":false,"number":false};
		      //    邮箱验证
				  $(function(){
				  $("#txtEmail").blur(function(){
				   flag.email = false;
		      $("#email\\.info").html("");
		      var emailTxt = $("#txtEmail").val();
		      if(emailTxt.trim() == "") {
		        $("#email\\.info").html("<img src=../images/wrong.gif />Email地址不能为空");
		        return;
		        }
		         var pattern=/\b(^['_A-Za-z0-9-]+(\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\.[A-Za-z0-9-]+)*((\.[A-Za-z0-9]{2,})|(\.[A-Za-z0-9]{2,}\.[A-Za-z0-9]{2,}))$)\b/;
		      if(!pattern.test(emailTxt)) {
		        $("#email\\.info").html("<img src=../images/wrong.gif />Email格式不正确");
		        return;
		      }
		        $("#email\\.info").html("<img src=../images/window_loading.gif />正在检测中...");
		      $.post(
		      "validEmail",
		      {"email":emailTxt},
		      function(data){
		      if(data){
		       $("#email\\.info").html("<img src=../images/label3.gif />用户可以使用");
		       flag.email=true;
		      }else{
		      $("#email\\.info").html("<img src=../images/wrong.gif />用户已被使用");
		      }
		      }
		      );
				  });
				  });
				  
				  
				  //昵称
				 $(function(){
				 $("#txtNickName").blur(function(){
				 $("#name\\.info").html("");
				var nickName=$(this).val();
				var size=nickName.length;
				if(nickName==""){
				$("#name\\.info").html("<img src=../images/wrong.gif />昵称不能为空");
				return;
				}else if(size<4 || size>20){
				$("#name\\.info").html("<img src=../images/wrong.gif />昵称不符合要求");
				}else{
				$("#name\\.info").html("<img src=../images/label3.gif />昵称正确");
				flag.nickname=true;
				}
				 });
				 });
				  //密码
				   $(function(){
				  
				  $("#txtPassword").blur(function(){
				  
				   flag.password = false;
		      $("#password\\.info").html("");
		      var pwdTxt = $(this).val();
		      var size=pwdTxt.length;
		      if(pwdTxt.trim() == "") {
		        $("#password\\.info").html("<img src=../images/wrong.gif />密码为必填项");
		        return;
		        }else if(size<6 || size>20){
		        $("#password\\.info").html("<img src=../images/wrong.gif />密码不符合要求");
		        return;
		        }
		        
		        flag.password=true;
				  });
				  });
				  //检查两次密码
				  $(function(){
				  $("#txtRepeatPass").blur(function(){
				  $("#password1\\.info").html("");
				 var pwdTxt=$("#txtPassword").val();
				  var rePwdTxt=$(this).val();
				  if(pwdTxt==""){
				  return;
				 }else if(pwdTxt==rePwdTxt){
				
				  $("#password1\\.info").html("<img src=../images/label3.gif />");
				  flag.password1=true;
				  }else{
				  $("#password1\\.info").html("<img src=../images/wrong.gif />输入的确认密码不正确");
				  }
				  });
				  });
				  //验证码
				  $(function(){
				$("#txtVerifyCode").blur(function(){
				flag.number=false;
				$("#number\\.info").html("");
				 var code= $("#txtVerifyCode").val();
				 if(code==""){
				 $("#number\\.info").html("<img src=../images/wrong.gif />验证码为空");
				 return;
				 }
				  $("#number\\.info").html("<img src=../images/window_loading.gif />正在检测中...");
				   $.post(
		        "validImage",
		        {"usercode":code},
		        function(data) {
		          if(data) {
		            $("#number\\.info").html("<img src=../images/label3.gif />验证码正确");
		            flag.number=true;
		          } else {
		            $("#number\\.info").html("<img src=../images/wrong.gif />验证码错误");
		          }
		          }
		          );
				});
				  });
				    //切换验证码
				  $(function(){
				  $("#changeImage").click(function(){
				  $("#imgVcode").attr("src","image.action?dt="+new Date().getTime());
				  return false;
				  });
				  $("#imgVcode").click(function(){
				  $("#changeImage").click();
				  });
				  });
				  //判断是否提交
				  $(function(){
				  $("#f").submit(
				  function(){
				 if(flag.email && flag.nickname && flag.password && flag.password1 && flag.number){
				 return true;
				 }else{
				 alert("表单数据为通过检查");
				 return false;
				 }
				  }
				  );
				  });
				
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post" action="register.action" id="f">
				<h2>
					以下均为必填项
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="user.email" type="text" id="txtEmail"  class="text_input"/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
									<span id="email.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="user.nickname" type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="name.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="user.password" type="password" id="txtPassword"
								class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="password.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" type="password" id="txtRepeatPass"
								class="text_input"/>
							<div class="text_left" id="repeatPassValidMsg">
							<span id="password1.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id="imgVcode" src="image.action" />
							<input name="number" type="text" id="txtVerifyCode"
								class="yzm_input" />
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									<a href="#" id="changeImage">看不清楚？换个图片</a>
								</p>
									<span id="number.info" style="color:red"></span>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
					<s:debug></s:debug>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	
	</body>
</html>

