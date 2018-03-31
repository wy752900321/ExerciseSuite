<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p align="center">
	<a href="list.friendAction?page=1">首页</a>
	<c:if test="${now>1}">
		<a href="list.friendAction?page=${now-1}">上一页</a>
	</c:if>
	<span>当前第<span style="color: blue; font-size: 20px;">${now}</span>页</span><span>总共<span
		style="color: blue; font-size: 20px;">${totalPages}</span>页</span>
	<c:if test="${now<totalPages}">
		<a href="list.friendAction?page=${now+1}">下一页</a>
	</c:if>
	<a href="list.friendAction?page=${totalPages}">尾页</a>
</p>