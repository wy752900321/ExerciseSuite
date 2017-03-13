<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.friend.system.manger.cn.bean.Friend"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>用户上传照片页面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">

				<%@include file="head.jsp"%>

				<div id="content">
					<p id="whereami">
					</p>
					<jsp:include page="operate.jsp"></jsp:include>
					<form action="up.userAction" method="post" enctype="multipart/form-data">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									照片名字:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									照片:
								</td>
								<td valign="middle" align="left">
									<input type="file" name = "photo">
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
						</table>
						<p>
							<input type="submit" class="button" value="上传  &raquo;" />
						</p>
					</form>
				</div>
			</div>
			<%@include file="foot.jsp"%>
		</div>
	</body>
</html>
