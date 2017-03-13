<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8"%>
<html>
	<head></head>
	<body style="font-size:30px;">
	用户登录
	<form action="${pageContext.request.contextPath}/login.action" method="post">
		用户名:<input type="text" name="username"><br>
		密码:<input type="password" name="password">
		<br>
		<input type="submit" value="登录">
	</form>
	</body>
</html>