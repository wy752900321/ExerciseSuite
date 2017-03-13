<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@page import="java.net.*" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>
	<body style="font-size: 30px;">
			<a href="some?name=<%=URLEncoder.encode("小张" , "utf-8")%>">点击这儿，访问 名叫some的servlet</a>
	</body>
</html>