<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.friend.system.manger.cn.bean.Friend"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>自己的朋友页面</title>
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
						${team.name}
					</h1>
					<c:if test="${size==0}">
					<table class="table">
							<tr class="row2" align="center">
								<td colspan="3">
										<span>该分组还没有<a href="allFriend.userAction">去向该分组添加好友吧</a></span>
								</td>
							</tr>
					</table>
					</c:if>
					<c:if test="${size!=0}">
					<table class="table">
						<c:if test="${size==0}">
					
							<tr class="row2" align="center">
								<td colspan="5">
										<span>您还没有好友<a href="allFriend.userAction">去添加好友吧</a></span>
								</td>
							</tr>
						</c:if>
						<tr class="table_header" align="center">
							<td>
								编号
							</td>
							<td>
								姓名
							</td>
							<td>
								性别
							</td>
							<td colspan="3">
								操作
							</td>
						</tr>
						<c:if test="${friends==null}">
							<jsp:forward page="teamFriend.userOwn"></jsp:forward>
						</c:if>
						<c:forEach items="${friends}" var="friend" varStatus="index">
							<tr class="row${index.index%2+1 }" align="center">
								<td>
									${friend.id}
								</td>
								<td>
									${friend.name}
								</td>
								<td>
									<c:if test="${friend.sex==0}">男</c:if>
									<c:if test="${friend.sex==1}">女</c:if>
								</td>
								<td>
									<a href="delete.userOwn?friendId=${friend.id}">删除该好友</a>
								</td>
								<td>
									<a href="showMeFriend.userOwn?friendId=${friend.id}">详细信息</a>
								</td>
								<td>
									<a href="leave.userOwn?friendId=${friend.id}">留言</a>
								</td>
							</tr>
						</c:forEach>
					</table>
					<p align="center">
						<a href="teamFriend.userOwn?page=1">首页</a>
						<c:if test="${now>1}">
							<a href="teamFriend.userOwn?page=${now-1}">上一页</a>
						</c:if>
						<span>当前第<span style="color: blue; font-size: 20px;">${now}</span>页</span><span>总共<span
							style="color: blue; font-size: 20px;">${totalPages}</span>页</span>
						<c:if test="${now<totalPages}">
							<a href="teamFriend.userOwn?page=${now+1}">下一页</a>
						</c:if>
						<a href="teamFriend.userOwn?page=${totalPages}">尾页</a>
					</p>
					</c:if>
				</div>
			</div>
			<%@include file="foot.jsp"%>
		</div>
	</body>
</html>
