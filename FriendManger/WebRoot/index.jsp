<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.friend.system.manger.cn.bean.Friend"%>
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
						朋友列表
					</h1>
					<c:if test="${friends==null}">
						<jsp:forward page="list.friendAction"></jsp:forward>
					</c:if>
					<table class="table">
						<tr class="table_header" align="center">
							<td>
								编号
							</td>
							<td>
								姓名
							</td>
							<td>
								操作
							</td>
						</tr>
						<c:forEach items="${friends}" var="friend" varStatus="index">
							<tr class="row${index.index%2+1 }" align="center">
								<td>
								${friend.id}
								</td>
								<td>
								${friend.name}
								</td>
								<td>
									<a href="show.friendAction?id=${friend.id}">详细信息</a>
								</td>
							</tr>
						</c:forEach>
					</table>
					<jsp:include page="cutPage.jsp"></jsp:include>
				</div>
			</div>
			<%@include file="foot.jsp"%>
		</div>
	</body>
</html>
