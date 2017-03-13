<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
	</head>
	<body style="font-size: 30px;">
			<form action="${pageContext.request.contextPath }/servlet/UploadServlet" enctype="multipart/form-data" method="post">
			用户名：<input type="text" name="username"><br/>
			上传文件 1：<input type="file" name="file1"/><br/>
			上传文件 2：<input type="file" name="file2"/><br/>
				<input type="submit" value="上传"/>
			</form>
	</body>
</html>