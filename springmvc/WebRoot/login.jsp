<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head></head>
	<body style="font-size:20px;">
	<h1>登录页面</h1>
	<font color="red" size="5">${error }</font>
	<form action="login.do" method="post">
		name:<input name="name" type="text"/><br/>
		password:<input name="password" type="password"/>
		<br/>
		<input type="submit" value="登录">
	</form>
	</body>
</html>