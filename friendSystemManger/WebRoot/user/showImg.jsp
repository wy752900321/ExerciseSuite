<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.friend.system.manger.cn.bean.Friend"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>显示相册页面</title>
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
					<%@include file="operate.jsp"%>
					<h1>
						<c:if test="${user.id!=friend.id}">
						欢迎${user.userName}查看${friend.name}的相册
						</c:if>
						<c:if test="${user.id==friend.id}">
						欢迎${user.userName}管理自己的相册
						</c:if>
						
					</h1>
					<table class="table">
						<tr class="table_header" align="center">
							<td>
								图片名称
							</td>
							<td>
								图片简介
							</td>
							<td>
								图片
							</td>
							<c:if test="${user.id==friend.id}">
								<td>
									操作
								</td>
							</c:if>
						</tr>
						<c:forEach items="${photos}" var="photo" varStatus="index">
							<tr class="row${index.index%2+1}" align="center">
								<td>
									${photo.name}
								</td>
								<td>
									${photo.info}
								</td>
								<td>
									<img src="../upload/${friend.id}/${photo.img}" height="200px;"
										width="200px;" />
								</td>
								<c:if test="${user.id==friend.id}">
									<td>
										<a href="deleteImg.userOwn?id=${photo.id}">删除</a>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</table>
					<p align="center">
						<a href="showImg.userOwn?page=1&id=${friend.id}">首页</a>
						<c:if test="${now>1}">
							<a href="showImg.userOwn?page=${now-1}&id=${friend.id}">上一页</a>
						</c:if>
						<span>当前第<span style="color: blue; font-size: 20px;">${now}</span>页</span><span>总共<span
							style="color: blue; font-size: 20px;">${totalPages}</span>页</span>
						<c:if test="${now<totalPages}">
							<a href="showImg.userOwn?page=${now+1}&id=${friend.id}">下一页</a>
						</c:if>
						<a href="showImg.userOwn?page=${totalPages}&id=${friend.id}">尾页</a>
					</p>
				</div>
			</div>
			<%@include file="foot.jsp"%>
		</div>
	</body>
</html>
