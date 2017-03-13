<%@page import="java.util.*,pojo.*" contentType="text/html;charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>emplist</title>
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
						Welcome!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Username
							</td>
							<td>
								Gendar
							</td>
							<td>
								Age
							</td>
							<td>
								
							</td>
						</tr>
						<c:forEach var="user" items="${users}" varStatus="status">
							<tr class="row${status.index % 2 + 1}">
								<td><c:out value="${user.id}"/></td>
								<td><c:out value="${user.username}"/></td>
								<td><c:out value="${user.gendar ? '男' : '女'}"/></td>
								<td><c:out value="${user.age}"/></td>
								<td><a href="loadUser.do?id=${user.id}">详细</a></td>
							</tr>
						</c:forEach>
					</table>
					<p>
						<input type="button" class="button" value="退出系统" onclick="location='logout.do'"/>
					</p>
				</div>
			</div>
			<%@include file="foot.jsp" %>
		</div>
	</body>
</html>
