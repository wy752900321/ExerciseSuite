<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
﻿
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>登录 - 当当网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${pageContext.request.contextPath }/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<style>
.name {
	border: 2px dotted blue;
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
		var username = $("txtUsername");
		//获取错误消息
		var msg = $("msg");
		username.className = "";
		msg.innerHTML = "";
		//定义正则表达式
		//var reg = /^[\w]+(@)[\w](.com)$/;
		if (username.value.length==0) {
			msg.innerHTML = "邮箱输入不合法";
			username.className = "name";
			return false;
		}
		return true;
	}

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
	//禁止浏览器的默认行为
	function fun() {
		return checkUserName() && checkPwd() ;
	}
</script>
	</head>
	<body>

		<!-- 引到外部为head1.jsp -->
		<%@ include file="/common/head1.jsp"%>
		<!-- 引到外部为head1.jsp -->
		<div class="enter_part">

			<!--引到外部为introduce.jsp -->
			<%@ include file="/common/introduce.jsp"%>
			<!--引到外部为introduce.jsp -->

			<div class="enter_in">
				<div class="bj_top"></div>
				<div class="center">
					<div style="height: 30px; padding: 5px; color: red"
						id="divErrorMssage">

					</div>
					<div class="main">
						<h3>
							登录当当网
						</h3>
						<s:form action="userAction!showBook" id="ctl00" namespace="/user" onsubmit="return fun();">
							<ul>
								<li>
									<span>请输入Email地址：</span>
									<s:textfield name="email" id="txtUsername" cssClass="textbox" onblur="javascript:checkUserName();"/>
									<span id="msg" class="error">
									<s:property value="msg"/>
									</span>
								</li>
								<li>
									<span class="blank">密码：</span>
									<s:password name="password" id="txtPassword" cssClass="textbox" onblur="javascript:checkPwd();"/>
									<span id="pwd" class="error">
									<a href="userAction!emailVerify?user.email=<s:property value="email"/>">
									<s:property value="emailVerify"/>
									</a>
									</span>
								</li>
								<li>
									<input type="submit" id="btnSignCheck" class="button_enter"
										value="登 录" />
									<!--<a href='/main/main.jsp'>登陆</a>
								--></li>
							</ul>
							<input type="hidden" name="uri" value="${uri}" />
						</s:form>
					</div>
					<div class="user_new">
						<p>
							您还不是当当网用户？
						</p>
						<p class="set_up">
							<a href="${pageContext.request.contextPath}/user/userAction!toRegister">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<%@include file="/common/foot1.jsp"%>
	</body>
</html>

