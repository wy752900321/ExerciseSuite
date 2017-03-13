<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8"%>
<html>
	<head></head>
	<body style="font-size:30px;">
<form action="${pageContext.request.contextPath}/project!add.action"
		 method="post">
任务编号:<input type="text" name="pro.no"><br/>
任务名称:<input type="text" name="pro.name"><br/>
开始时间:<input type="text" name="pro.startDate"><br/>
结束时间:<input type="text" name="pro.endDate"><br/>
		<input type="submit" value="添加">
</form>
	</body>
</html>