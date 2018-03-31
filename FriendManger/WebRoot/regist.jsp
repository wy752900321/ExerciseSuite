<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<html>
	<head>
		<title>用户注册页面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<script type="text/javascript" src="js/lujincheng.1.0.js"></script>
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">

				<%@include file="head.jsp"%>

				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						用户注册
					</h1>
					<form action="regist.friendAction" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="userName" />
									<span id="userNameMessage" style="color: red;">${userNameMessage}</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password">
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									确认密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd">
									<span id="checkMessage" style="color: red;">${passwordMessage}</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									出生日期:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="brithday">
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="sex" value="0"
										checked="checked">
									女
									<input type="radio" class="inputgri" name="sex" value="1">
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									电话:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="phone">
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									qq:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="qq">
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									地址:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="address">
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									简介:
								</td>
								<td valign="middle" align="left">
									<textarea class="inputgri" rows="5" cols="40" name = "info"></textarea>
								</td>
							</tr>
							<%@include file="check.jsp"%>
						</table>
						<p>
							<input id="click" type="submit" class="button" value="注册 &raquo;" disabled="disabled"/>
						</p>
					</form>
				</div>
			</div>
			<%@include file="foot.jsp"%>
		</div>
	</body>
</html>
