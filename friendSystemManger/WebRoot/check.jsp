<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tr>
	<td valign="middle" align="right">
		验证码
	</td>
	<td valign="middle" align="left">
		<input id="checkInput" type="text" class="inputgri" name="userCheck" onblur="checkNum();">
		<img id="num" src="checkCode" />
		<a href="javascript:;" onclick="check();">看不清 换一张 </a>
		<span id="checkMe" style="color: red;">
		</span>
	</td>
</tr>