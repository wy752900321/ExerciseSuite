<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>网上书店</h1>
<br/><br/>
<div>    
<div style="margin-left: 40%;float: left">
	<a href="${pageContext.request.contextPath }/index.jsp">首页</a>
	<a href="${pageContext.request.contextPath }/app/appBookCartServlet?method=listBookCart">查看购物车</a>
	<a href="${pageContext.request.contextPath }/app/listorder.jsp">查看自己的订单</a>
</div>
 	
<div style="float: right;">
		<c:if test="${user==null}">
			<form action="${pageContext.request.contextPath }/app/userServlet?method=login" method="post">
	 			用户名：<input type="text" name="name" style="width: 50px">
	 			密码：<input type="password" name="password" style="width: 50px">
	 			<input type="submit" value="登陆">
	 			<input type="button" value="注册" onclick="javascript:window.location.href='${pageContext.request.contextPath }/app/register.jsp'">
			</form>
		</c:if>
		<c:if test="${user!=null}">
			当前的登陆用户是:${user.name }
		</c:if>
		
</div>
<div style="clear: both"></div>
</div>
<hr>
