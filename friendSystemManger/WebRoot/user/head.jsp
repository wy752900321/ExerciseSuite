<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<script type="text/javascript" src="../js/ems.js">
</script>
		<script type="text/javascript" src="../js/lujincheng.1.0.js">
</script>
	</head>
	<body onload="startTime();">
		
		<div id="header">
			<div id="rightheader">
				<span></span>
				<br>
				<span></span>
				<br>
				<span id="time"> </span>
				<br>
				<span> 欢迎<span style="color: blue; font-size: 30px;">${user.userName}</span>光临
					一生朋友 </span>
				<span> <a href="../logout.userAction"
					style="color: blue; font-size: 20px;">注销</a> </span>
			</div>

			<div id="topheader">
				<h1 id="title">
					一声朋友，一生朋友
				</h1>
			</div>
			<div id="navigation" align="right">

			</div>
		</div>
	</body>
</html>