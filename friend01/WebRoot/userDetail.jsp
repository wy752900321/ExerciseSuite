<%@page import="java.util.*,pojo.*"
	contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>update Emp</title>
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
						User Detail:
					</h1>
					<table class="table">
						<tr>
						<td>姓名</td><td>电话</td>
						</tr>
						<tr><td>${user.name}</td><td>${user.phone}</td></tr>
					</table>
					<h1>
						Load Photo:
					</h1>
					<c:if test="${sessionScope.id==user.id}">
						<form action="addPhoto.do?id=${user.id}" method="post"
							enctype="multipart/form-data">
							Upload File Name:
							<input type="file" name="file1" />
							<input type="submit" value="confirm" />
						</form>
					</c:if>

					<h1>
						view photo:
					</h1>
					<table>

						<c:if test="${!empty sessionScope.id}">
							<c:forEach var="p" items="${pictures}">
								<tr>
								<td>
									<img src="upload/pic_${p.userId}/${p.picName}"
										width="300" height="200"/>
								</td>
							</tr>
							</c:forEach>
						</c:if>
					</table>
				</div>
				<a href="listUsers.do">return</a>
			</div>
			<%@include file="foot.jsp"%>
		</div>
	</body>
</html>
