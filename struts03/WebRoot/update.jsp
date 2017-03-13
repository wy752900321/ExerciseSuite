<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
	<head></head>

	<body style="font-size: 30px;">

		<s:form action="person" theme="simple" namespace="/day05">
			<s:hidden name="id" />
		姓名:<s:textfield name="name" id="name" />
			<br />
		密码:<s:password name="password" showPassword="true" />
			<br />
		年龄:<s:textfield name="age" />
			<br />
		性别1:<s:radio name="sex" list="#session.opts" listKey="key"
				listValue="value" />
			<br />
			<!-- 	性别2:<s:radio name="sex" 
			list="#{'M':'男','F':'女'}"/><br/>
	 -->
		是否已婚:<s:checkbox name="marry" />
			<br />
		简介:<s:textarea name="description" cols="20" rows="5" />
			<br />
		课程多选:
		<s:checkboxlist name="course" list="#session.pros" listKey="no"
				listValue="name" />
			<br />
		课程单选:
		<s:radio name="cradio" list="#session.pros" listKey="no"
				listValue="name" />
			<br />
		课程选择:
		<s:select headerKey="-1" headerValue="---请选择---" emptyOption="true"
				name="cselect" list="#session.pros" listKey="no" listValue="name" />
			<br />
		</s:form>


	</body>
</html>