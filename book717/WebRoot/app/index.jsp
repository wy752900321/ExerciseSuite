<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>前台首页</title>
    
    <style type="text/css">
    	body{
    		margin:0px;
    		padding:0px;
    		text-align: center;
    	}
    	
    	#container{
    		width: 980px;
    		height: 300px;
    		text-align: left;
    	}
    	#main{
    		margin-top: 20px; 
    	}
    	#head{
    		text-align: center;
    	}
    	
    	#categories{
    		border: solid 1px blue;
    		width: 250px;
    		padding-left: 20px;
    		height: 400px;
    		line-height: 40px;
    		float: left;
    	}
    	
    	#books{
    		float: left;
    		margin-left: 40px;
    	}
    	
    	#image{
    		float: left;
    	}
    	
    	#info{
    		float: left;
    	}
    	
    	#book{
    		float: left;
    		width:230px;
    	}
    	
    </style>
  </head>
  
  <body>
  	
  	<div id="container">
  		<div id="head">
  			<%@include file="/app/head.jsp" %>
  		</div>
  		
  		<div id="main">
  			
  			<div id="categories">
  				书籍列表：
  				<c:forEach items="${categorys}"  var="category" >
  					<li><a href='${pageContext.request.contextPath }/app/appBookServelt?method=list&category_id=${category.id}'>${category.name}</a></li>
  				</c:forEach>
  			</div>
  			
  			<div id="books">
  				<c:forEach items="${books}" var="book" varStatus="status">
	  				<div id="book">
	  					<div id="image">
	  						<img src="${pageContext.request.contextPath }/images/${book.image}"/>
	  					</div>
	  					<div id="info">
	  						<li>${book.name}</li>
	  						<li>${book.author}</li>
	  						<li>${book.price}</li>
	  						<li>
	  							<a href="${pageContext.request.contextPath}/app/appBookCartServlet?method=addBook2Cart&id=${book.id}">购买</a>
	  						</li>
	  					</div>
	  					
	  				</div>
	  				<c:if test="${status.count%1==0}">
	  					<div style="clear: both"></div>
	  					<br/>
	  				</c:if>
	  				<br>
  				</c:forEach>
  				<div style="clear: both"></div>
  				<br/>
  			</div>
  		</div>
   	</div>
   	 总记录数${pageBean.recordCnt}  总页数${pageBean.pageCnt} 当期是${pageBean.curPage}页
   	 <a href="${pageContext.request.contextPath}/app/appBookServelt?method=list&curPage=1&category_id=${category_id}">首页</a>
   	 <a href="${pageContext.request.contextPath}/app/appBookServelt?method=list&curPage=${pageBean.prePage}&category_id=${category_id}">上页</a>
   	 <a href="${pageContext.request.contextPath}/app/appBookServelt?method=list&curPage=${pageBean.nextPage}&category_id=${category_id}">下页</a>
   	 <a href="${pageContext.request.contextPath}/app/appBookServelt?method=list&curPage=${pageBean.pageCnt}&category_id=${category_id}">尾页</a>
  </body>
</html>
