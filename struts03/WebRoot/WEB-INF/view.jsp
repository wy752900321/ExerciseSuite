<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
	<head></head>
	<body style="font-size: 30px;">
		任务编号:
		<s:property value="pro.no" />
		<br />
		任务名称:
		<s:property value="pro.name" />
		<br />
		开始时间:
		<s:date name="pro.startDate" format="yyyy/MM/dd" />
		<br />
		结束时间:
		<s:date name="pro.endDate" format="yyyy/MM/dd" />
		<br />
	</body>
</html>