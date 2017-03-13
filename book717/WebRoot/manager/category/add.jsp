<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
  <head>
    <title>添加分类页面</title>
  </head>

  <body>
  添加分类
    <br/><br/>
    <form action="${pageContext.request.contextPath }/manager/categoryServlet?method=save" method="post">
    	<table width="500px;">
    	
    	<tr>
    		<td>分类名称：</td>
    		<td><input type="text" name="name" style="width: 200px"></td>
    	<tr>
    	<tr>
    		<td>分类描述：</td>
    		<td><textarea rows="4" cols="40" name="description"></textarea></td>
    	</tr>
    	<tr>
    		<td></td><td><input type="submit" value="保存"></td>
    	</tr>
    	</table>
    </form>
    
  </body>
</html>
