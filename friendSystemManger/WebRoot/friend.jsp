<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>朋友列表</title>
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
						朋友信息
					</h1>
					<table class="table">
						<tr class="row1" align="center">
							<td>
								编号
							</td>
							<td>
								${friend.id}
							</td>
						</tr>
						<tr class="row2" align="center">
							<td>
								姓名
							</td>
							<td>
								${friend.name}
							</td>
						</tr>
						<tr class="row1" align="center">
							<td>
								性别
							</td>
							<td>
								<c:if test="${friend.sex==0}">男</c:if>
								<c:if test="${friend.sex==1}">女</c:if>
							</td>
						</tr>
						<tr class="row2" align="center">
							<td>
								简介
							</td>
							<td>
								${friend.info}
							</td>
						</tr>
					</table>
				</div>
					<input type="button" class="button" value="返回朋友列表"
							onclick="location='list.friendAction?page=1'" />
			</div>
			<%@include file="foot.jsp"%>
		</div>
	</body>
</html>
