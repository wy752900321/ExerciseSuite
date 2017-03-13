<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
	</head>
	<body style="font-size: 20px;">
			<table>
				<tr>
					<th>编号</th>
					<th>昵称</th>
					<th>邮箱</th>
				</tr>
				<s:iterator value="users">
					<tr>
					<th>${id }</th>
					<th>${nickname }</th>
					<th>${email }</th>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>