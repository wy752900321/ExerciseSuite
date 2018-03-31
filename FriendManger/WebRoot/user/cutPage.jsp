<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p align="center">
	<a href="allFriend.userAction?page=1">首页</a>
	<c:if test="${now>1}">
		<a href="allFriend.userAction?page=${now-1}">上一页</a>
	</c:if>
	<span>当前第<span style="color: blue; font-size: 20px;">${now}</span>页</span><span>总共<span
		style="color: blue; font-size: 20px;">${totalPages}</span>页</span>
	<c:if test="${now<totalPages}">
		<a href="allFriend.userAction?page=${now+1}">下一页</a>
	</c:if>
	<a href="allFriend.userAction?page=${totalPages}">尾页</a>
</p>