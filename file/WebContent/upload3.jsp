<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'upload3.jsp' starting page</title>
    
    <script type="text/javascript">
    	function addfile(){
    		var div = document.getElementById("files");
    		
    		var input = document.createElement("input");
    		input.type= "file";
    		input.name = "file";
    		
    		var del = document.createElement("input");
    		del.type = "button";
    		del.value = "删除";
    		del.onclick = function d(){
    			this.parentNode.parentNode.removeChild(this.parentNode);
    		}
    		
    		var innerdiv = document.createElement("div");
    		innerdiv.appendChild(input);
    		innerdiv.appendChild(del);
    		
    		div.appendChild(innerdiv);
    		
    		
    	}
    </script>
  </head>
  
  <body>
   	
   	<form action="${pageContext.request.contextPath }/servlet/UploadServlet2" method="post" enctype="multipart/form-data">
   	<table>
   		<tr>
   			<td>用户名：</td>
   			<td>
   				<input type="text" name="username">
   			</td>
   		</tr>
   		
   		<tr>
   			<td></td>
   			<td>
   				<input type="button" value="添加文件" onclick="addfile()">
   			</td>
   		</tr>
   		
   		<tr>
   			<td></td>
   			<td>
   				<div id="files">
   				
   				</div>
   			</td>
   		</tr>
   		<tr>
   			<td></td>
   			<td>
   				<input type="submit" value="上传">
   			</td>
   		</tr>
   	</table>
   	</form>
   	
  </body>
</html>
