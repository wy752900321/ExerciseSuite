<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>列出所有文件</title>
	</head>
	<body style="font-size: 30px;">
			<c:forEach var="entry" items="${map}">
				<c:url var="downloadurl" value="/servlet/DownloadServlet">
					<c:param name="filename" value="${entry.key}"/>
				</c:url>				
			</c:forEach>
	</body>
</html>