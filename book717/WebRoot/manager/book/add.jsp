<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<html>
  <head>
    <title>添加图书</title>
  </head>
  <body>
    <br/><br/>
   图书信息录入:<br/>
    <form action="${pageContext.request.contextPath}/manager/bookServlet?method=save"  method="post" 
          enctype="multipart/form-data">
    	<table width="500px">
    	<tr>
    		<td>书名</td>
    		<td><input type="text" name="name" style="width: 200px"></td>
    	<tr>
    	<tr>
    		<td>作者</td>
    		<td><input type="text" name="author" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>售价</td>
    		<td><input type="text" name="price" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>图片</td>
    		<td><input type="file" name="image" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>描述</td>
    		<td><textarea rows="4" cols="40" name="description"></textarea></td>
    	</tr>
    	<tr>
    		<td>所属分类</td>
    		<td>
    		 <c:if test="${! empty categorys}" >
    			<select name="category_id">
    			     <c:forEach  items="${categorys}" var="category">
    					<option value="${category.id}">${category.name}</option>
    				 </c:forEach>
    			</select>
    		</c:if>
    		</td>
    	</tr>
    	<tr>
    		<td></td><td><input type="submit" value="保存"></td>
    	</tr>
    	</table>
    </form>
  </body>
</html>
