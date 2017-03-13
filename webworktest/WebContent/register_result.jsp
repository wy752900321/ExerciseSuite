<%@ page language="java"
	import="java.util.*,cn.com.webwork.register.registerAction"
	pageEncoding="gb2312"%>
<%@ taglib prefix="ww" uri="webwork"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String strTest = "zhangsan!!!";

	registerAction registerClass = new registerAction();
	request.setAttribute("strTest", "zhangsan!!!");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	注册成功！
	<br> username:
	<ww:property value="user.username" />
	<br> password:
	<ww:property value="user.password" />
	<br> email:
	<ww:property value="user.email" />
	<br> age:
	<ww:property value="user.age" />
	<br>

	<ww:if
		test="@cn.com.webwork.register.registerAction@testel('11','${strTest}')">
		输出1 可以 ！
	</ww:if>

	<ww:if
		test="@cn.com.webwork.register.registerAction@testel('12',${strTest})">
		输出2！
	</ww:if>

	<ww:if
		test="@cn.com.webwork.register.registerAction@testel('13','<%=strTest%>')">
		输出3！
	</ww:if>

	<ww:if
		test="@cn.com.webwork.register.registerAction@testel('14',<%=strTest%>)">
		输出4！
	</ww:if>

	<ww:if
		test="@cn.com.webwork.register.registerAction@testel('15',%{strTest})">selected</ww:if>
	<ww:if
		test="@cn.com.webwork.register.registerAction@testel('16','%{strTest}')">selected2</ww:if>


	<ww:if
		test="@cn.com.webwork.register.registerAction@testel('17',#request.strTest)">
		输出6！可以。放入request时。
	</ww:if>

	<ww:if
		test="@cn.com.webwork.register.registerAction@testel('18','#session.strTest')">
		输出7！
	</ww:if>
	<ww:if
		test="@cn.com.webwork.register.registerAction@testel('19',#request.strTest)">
		输出8！。放入request时。
	</ww:if>

</body>
</html>
