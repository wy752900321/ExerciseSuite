<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>page</title>
  </head>
  <body style="text-align: center">
   	<br/><br/>
   	
   	<c:choose>
   	<c:when test="${!empty bookCart.map}">
   	<table frame="border" cellpadding="0" cellspacing="0" width="90%">
   		<caption><h2>购物车页面</h2></caption>
   		<tr>
   			<td>书名</td>
   			<td>售价</td>
   			<td>数量</td>
   			<td>小计</td>
   		</tr>
   		<c:forEach items="${bookCart.map}" var="entity">
	   		<tr>
		   			<td>${entity.value.book.name}</td>
		   			<td>${entity.value.book.price}</td>
		   			<td>${entity.value.quantity}</td>
		   			<td>${entity.value.totalprice}</td>
	   		</tr>
   		</c:forEach>
   		<tr>
   			<td colspan="2">合计</td>
   			<td colspan="2">${bookCart.sumprice}元</td>
   		</tr>
   	</table>
   
    <a href="/bookstore_plan/app/appOrderServlet?method=saveOrder">生成订单</a>
    </c:when>
    <c:otherwise>
          购物车没有商品
    </c:otherwise>
     </c:choose>
  </body>
</html>
