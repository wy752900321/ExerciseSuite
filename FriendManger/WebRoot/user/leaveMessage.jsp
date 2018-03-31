<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.friend.system.manger.cn.bean.Friend"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>用户留言页面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">

				<%@include file="head.jsp"%>

				<div id="content">
					<p id="whereami">
					</p>
					<jsp:include page="operate.jsp"></jsp:include>
					<h1>
						向${friend.name}留言
					</h1>
					<form action="leaveMessage.userOwn?friendId=${friend.id}" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									请输入留言内容:${friendId}
								</td>
								<td valign="middle" align="left">
									<textarea class="inputgri" rows="5" cols="40" name = "message"></textarea>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="留言  &raquo;" />
						</p>
					</form>
				</div>
			</div>
			<%@include file="foot.jsp"%>
		</div>
	</body>
</html>
