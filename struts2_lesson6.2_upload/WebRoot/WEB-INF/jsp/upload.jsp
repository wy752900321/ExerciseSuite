<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'one.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body style="font-size:30px;color:red;">
		<s:form action="toUploadAction" namespace="/user" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td>
						<s:file name="file" />
					</td>
					<td>
						<input type="submit" value="上传" name="uploadButton">
					</td>
				</tr>
			</table>
		</s:form>
		<div>
			<s:if test="imagePath!=null">
				<img src="<s:property value="imagePath"/>">
			</s:if>
			<s:else>
                <img src="imagesUpload/mm2.jpg">
			</s:else>

		</div>
	</body>
</html>
