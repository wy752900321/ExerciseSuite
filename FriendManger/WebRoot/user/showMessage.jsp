<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.friend.system.manger.cn.bean.Friend"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>用户留言列表</title>
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
						${user.userName}的留言列表
					</h1>
					<c:if test="${size==0}">
					<table class="table">
							<tr class="row2" align="center">
								<td colspan="3">
										您还没有留言
								</td>
							</tr>
					</table>
					</c:if>
					<c:if test="${size!=0}">
					<table class="table">
						<tr class="table_header" align="center">
							<td>
								用户名
							</td>
							<td>
								留言者
							</td>
							<td>
								留言内容
							</td>
							<td colspan="3">
								操作
							</td>
						</tr>
						<c:if test="${messages==null}">
							<jsp:forward page="showMessage.userOwn"></jsp:forward>
						</c:if>
						<c:forEach items="${messages}" var="message" varStatus="index">
							<tr class="row${index.index%2+1 }" align="center">
								<td>
									${message.user.userName}
								</td>
								<td>
									${message.messageUser.userName}
								</td>
								<td>
									${message.message}
								</td>
								<td>
									<a href="deleteMessage.userOwn?id=${message.id}">删除该条留言</a>
								</td>
								<td>
									<a href="leave.userOwn?friendId=${message.messageUser.id}">回复</a>
								</td>
							</tr>
						</c:forEach>
					</table>
					<p align="center">
						<a href="tshowMessage.userOwn?page=1">首页</a>
						<c:if test="${now>1}">
							<a href="showMessage.userOwn?page=${now-1}">上一页</a>
						</c:if>
						<span>当前第<span style="color: blue; font-size: 20px;">${now}</span>页</span><span>总共<span
							style="color: blue; font-size: 20px;">${totalPages}</span>页</span>
						<c:if test="${now<totalPages}">
							<a href="showMessage.userOwn?page=${now+1}">下一页</a>
						</c:if>
						<a href="showMessage.userOwn?page=${totalPages}">尾页</a>
					</p>
					</c:if>
				</div>
			</div>
			<%@include file="foot.jsp"%>
		</div>
	</body>
</html>
