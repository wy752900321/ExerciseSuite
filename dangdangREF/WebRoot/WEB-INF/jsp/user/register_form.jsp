<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${pageContext.request.contextPath }/css/login.css"
			rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/css/page_bottom.css"
			rel="stylesheet" type="text/css" />
		<style>
.name {
	width: 170px;
	height: 17px;
	padding: 3px 2px 0 1px;
	border: solid 1px #a8a6ab;
	margin-left: 20px;
	float: left
}

.error {
	color: red;
	font-style: italic;
}
</style>
		<script language="javascript" src="../js/prototype-1.6.0.3.js"></script>
		<script>
		   //邮箱验证
	function checkUserName() {
		//获取邮箱
		var username = $("txtEmail");
		//获取错误消息
		var msg = $("msg");
		username.className = "";
		var xingque = $("xingque");
		xingque.innerHTML="";
		msg.innerHTML = "";
		var reg = /^[\w]+(@)[\w]+(\.com)$/;
		if (!reg.test(username.value.strip())) {
			msg.innerHTML = "邮箱不正确";
			username.className = "name";
			return false;
		}
		return true;
	}
//您的昵称可以由小写英文字母、中文、数字组成，长度4－20个字符，一个汉字为两个字符。

	//昵称验证
	function checkNickName() {
		//获取邮箱
		var username = $("txtNickName");
		//获取错误消息
		var msg = $("nick");
		username.className = "";
		msg.innerHTML = "";
		var reg = /^[\w\d]{4,20}$/;
		if (!reg.test(username.value.strip())) {
			msg.innerHTML = "昵称不正确";
			username.className = "name";
			return false;
		}
		return true;
	}
	//您的密码可以由大小写英文字母、数字组成，长度6－20位。
	//密码验证
	function checkPwd() {
		//获取密码
		var pwd = document.getElementById("txtPassword");
		//获取错误消息
		var msg = document.getElementById("pwd");
		msg.innerHTML = "";
		pwd.className = "";
		//定义正则表达式
		var reg = /^[\d\w]{6,20}$/;//正则不要带引号
		if (!reg.test(pwd.value.strip())) {
			msg.innerHTML = "密码输入不正确";
			pwd.className = "name";
			return false;
		}
		return true;
	}
	//密码确认验证

	function checkRePwd() {
		//获取密码
		var pwd = $("txtPassword");
		//获取密码确认的内容
		var repwd = $("txtRepeatPass");
		//获取错误消息
		var errorMsg = $("repwdError");
		repwd.className = "";
		errorMsg.innerHTML = "";
		if (pwd.value != repwd.value) {
			errorMsg.innerHTML = "密码确认不正确！";
			repwd.className = "name";
			return false;
		}
		return true;
	}
	//禁止浏览器的默认行为
	function fun() {
		return checkUserName() && checkPwd() && checkRePwd() && checkNickName();
	}

		</script>
	</head>
	<body>
		<!-- 引到外部为head1.jsp -->
		<%@ include file="/common/head1.jsp"%>
		<!-- 引到外部为head1.jsp -->
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<s:form name="ctl00" action="userAction!doRegister" namespace="/user"
				id="f" onsubmit="return fun();">
				<h2>
					以下均为必填项
				</h2>
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<s:textfield name="user.email" id="txtEmail"
								cssClass="text_input" onblur="javascript:checkUserName();" />
							<br />
							&nbsp;&nbsp;&nbsp;
							<span id="msg" class="error"></span>
							<span id="xingque" style="color: red"><s:property value="errorEmail"/></span>
						</td>
						<td>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
							</div>
						</td>

					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<s:textfield name="user.nickName" id="txtNickName"
								cssClass="text_input" onblur="javascript:checkNickName();" />
							<br />
							&nbsp;&nbsp;&nbsp;
							<span id="nick" class="error"></span>
						</td>
						<td>
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>

							</div>
						</td>

					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<s:password name="user.password" id="txtPassword"
								cssClass="text_input" onblur="javascript:checkPwd();" />
							<br />
							&nbsp;&nbsp;&nbsp;
							<span id="pwd" class="error"></span>
						</td>
						<td>
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
							</div>
						</td>

					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<s:password name="userPassword" id="txtRepeatPass"
								cssClass="text_input" onblur="javascript:checkRePwd();" />
							<br />
							&nbsp;&nbsp;&nbsp;
							<span id="repwdError" class="error"></span>

						</td>
						<td>
							<div class="text_left" id="repeatPassValidMsg">
								请再次输入密码
							</div>
						</td>

					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<s:textfield name="user.imageCode" id="txtVerifyCode"
								cssClass="yzm_input" />
							<img class="yzm_img" id='imgVcode' src="imageCodeAction" />
							<br />
							<span id="code" style="color: red">
							   <s:property value="errormsg" />
							</span>
						</td>
						<td>
							<div class="text_left t1">
								<p class="t1">
									&nbsp;&nbsp;&nbsp;
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>

									<a href="javascript:;" title="看不清，换一张"
										onclick="$('imgVcode').src='imageCodeAction?now='+new Date();">
										看不清楚？换个图片 </a>
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">
					<input id="btnClientRegister" class="button_1" name="submit"
						type="submit" value="注 册" />
				</div>
			</s:form>
		</div>
		<!--引到外部为foot1.html -->
		<%@include file="/common/foot1.jsp"%>
		<!--引到外部为foot1.html -->
	</body>
</html>

