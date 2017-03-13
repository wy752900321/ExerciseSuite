<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8"%>
<html>
	<head></head>
	<body style="font-size:30px;">
	文件上传
	<form action="${pageContext.request.contextPath}/upload.action"
	        enctype="multipart/form-data"
			  method="post">
		<input type="file" name="mf">
		<input type="submit" value="上传">
	</form>
	</body>
</html>