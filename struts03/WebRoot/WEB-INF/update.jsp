<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:30px;">
	<form method="post"
	 	action="${pageContext.request.contextPath}/project!update.action">
		<s:hidden name="pro.id"/>
		任务编号:
		<s:textfield name="pro.no"/><br/>
		任务名称:
		<s:textfield name="pro.name"/><br/>
		开始时间:
        <s:textfield name="pro.startDate"/><br/>
		结束时间:
		<s:textfield name="pro.endDate"/><br/>
		<input type="submit" value="更新">
	</form>
	</body>
</html>