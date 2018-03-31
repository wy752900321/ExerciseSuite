<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>自己的详细信息</title>
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
						我的信息
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
								生日
							</td>
							<td>
								${friend.brithday}
							</td>
						</tr>
						<tr class="row2" align="center">
							<td>
								性别
							</td>
							<td>
								<c:if test="${friend.sex==0}">男</c:if>
								<c:if test="${friend.sex==1}">女</c:if>
							</td>
						</tr>
						<tr class="row1" align="center">
							<td>
								简介
							</td>
							<td>
								${friend.info}
							</td>
						</tr>
						<tr class="row2" align="center">
							<td>
								电话
							</td>
							<td>
								${friend.phone}
							</td>
						</tr>
						<tr class="row1" align="center">
							<td>
								QQ
							</td>
							<td>
								${friend.qq}
							</td>
						</tr>
						<tr class="row2" align="center">
							<td>
								地址
							</td>
							<td>
								${friend.address}
							</td>
						</tr>
						
						<c:if test="${friend.id==user.id}">
							<tr class="row1" align="center">
								<td rowspan="${size+1}">
									分组
								</td>
							</tr>
							<c:forEach items="${teams}" var="team" varStatus="index">
								<tr class="row${index.index%2+1}" align="center">
									<td>
										<a href="teamFriend.userOwn?id=${team.id}">${team.name}</a>
									</td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${friend.id!=user.id}">
							<tr class="row1" align="center">
								<td>
									所属分组
								</td>
								<td>
									<a href="teamFriend.userOwn?id=${team.id}">${team.name}</a>
								</td>
							</tr>
						</c:if>
						<tr class="row2" align="center">
							<td colspan="2">
								<a href="showImg.userOwn?id=${friend.id}">
								<c:if test="${friend.id==user.id}">
									管理我的照片
								</c:if>
								
								<c:if test="${friend.id!=user.id}">
								查看${friend.name}的相册
								</c:if>
								</a>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<%@include file="foot.jsp"%>
		</div>
	</body>
</html>
