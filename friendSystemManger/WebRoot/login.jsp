<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<html>
	<head>
		<title>用户登录页面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">

				<%@include file="head.jsp"%>

				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						登录页面
					</h1>
					<form action="login.userAction" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="userName" />
									<span style="color: red;">${userNameMessage}</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
									<span style="color: red;">${passwordMessage}</span>
								</td>
							</tr>
							<%@include file="check.jsp"%>
						</table>
						<p>
							<input id="click" type="submit" class="button" value="登录  &raquo;" disabled="disabled"/>
						</p>
					</form>
				</div>
			</div>
			<%@include file="foot.jsp"%>
		</div>
	</body>
</html>
