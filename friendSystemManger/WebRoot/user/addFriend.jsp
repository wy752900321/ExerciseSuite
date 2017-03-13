<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>添加好友页面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
		<script type="text/javascript">
function add(id) {
	var team = document.getElementById('team').value;
	location = 'add.userAction?id=' + id + '&team=' + team;
}
</script>
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
						将要添加的好友信息
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
						<tr class="row1" align="center">
							<td>
								选择分组
								<select name="team" id="team">
									<c:forEach items="${teams}" var="team">
										<option value="${team.id}">
											${team.name}
										</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<a href="javascript:;" onclick="add(${friend.id});">添加</a>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<%@include file="foot.jsp"%>
		</div>
	</body>
</html>
