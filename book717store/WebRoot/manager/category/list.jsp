<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'listcategory.jsp' starting page</title>
  </head>
  <body style="text-align: center">
   	<br/><br/>
   	<c:choose>
   	<c:when test="${! empty categorys}">
	   	<table frame="border" cellpadding="0" cellspacing="0" width="90%" border="1">
	   		<caption><h2>书籍分类信息</h2></caption>
	   		<tr>
	   			<td>分类名称</td>
	   			<td>分类描述</td>
	   			<td>操作</td>
	   		</tr>
	   		
	   		<c:forEach items="${requestScope.categorys}" var="category" >
	   			<tr>
	   				<td>${category.name}</td>
		   			<td>${category.description}</td>
		   			<td>
		   				<a href="${pageContext.request.contextPath }/manager/categoryServlet?method=edit&id=${category.id}">编辑</a>
		   				<a href="${pageContext.request.contextPath }/manager/categoryServlet?method=delete&id=${category.id}">删除</a>
		   			</td>
	   			</tr>
	   		</c:forEach>
	   	 </table>
   		</c:when>
   		<c:otherwise>
   		  没有您要查询的数据
   		</c:otherwise>
   	</c:choose>
  </body>
</html>
