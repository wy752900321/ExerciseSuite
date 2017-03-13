<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>page</title>
  </head>
	<body style="text-align: center">
   	<br/><br/>
    <c:choose> 	
      <c:when test="${! empty books}">
	   	<table frame="border" cellpadding="0" cellspacing="0" width="90%">
	   		<caption><h2>图书信息</h2></caption>
	   		<tr>
	   			<td>书名</td>
	   			<td>作者</td>
	   			<td>描述</td>
	   			<td>图片</td>
	   			<td>所属类别</td>
	 			<td>操作</td>
	   		</tr>
   			<c:forEach items="${books}" var="book">
	   			<tr>
	   				<td>${book.name}</td>
	   				<td>${book.author}</td>
	   				<td>${book.description}</td>
	   				<td><a href="${pageContext.request.contextPath}/images/${book.image}">查看图片</a></td>
	   				<td>${book.category.name}</td>
		   			<td>
		   				<a href="${pageContext.request.contextPath}/manager/bookServlet?method=edit&id=${book.id}">修改</a>
		   				<a href="${pageContext.request.contextPath}/manager/bookServlet?method=delete&id=${book.id}">删除</a>
		   			</td>
	   			</tr>
   			</c:forEach>
	   	 </table>
	     </c:when>
	     <c:otherwise>
	         您要查询的图书信息不存在
	     </c:otherwise> 
   	</c:choose>
  </body>
</html>
