<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;">
	<a href="${pageContext.request.contextPath}/toAdd.action">添加</a>
	<table border="1">
		<tr>
			<th>任务编号</th>
			<th>任务名称</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th></th>
			<th></th>
		</tr>

	<s:iterator value="projects">
		<tr>
			<td>${no}</td>
			<td>
<a href="${pageContext.request.contextPath}/project!view.action?pro.id=${id }">
				${name }</a>
			</td>
			<td>
				${startDate }
				<s:date name="startDate" 
								format="yyyy年MM月dd日"/>
			</td>
			<td>
				${endDate }
				<s:date name="endDate" 
								format="yyyy年MM月dd日"/>
			</td>
						<td>
			<a 
href="${pageContext.request.contextPath}/project!delete.action?pro.id=${id }">
			删除
			</a>
			</td>
			<td>
<a href="${pageContext.request.contextPath}/project!init.action?pro.id=${id }">
更新</a>
			</td>
		</tr>
	</s:iterator>

	</table>
	<a href="${pageContext.request.contextPath}/list.action?page=1">第一页</a>

	<s:if test="page < totalPage">
	   <a href="${pageContext.request.contextPath}/list.action?page=${page+1}">
		下一页</a>
	</s:if>
	<s:else>
		<a>下一页</a>
	</s:else>

  	<s:if test="page>1">
  			<a href="${pageContext.request.contextPath}/list.action?page=${page-1}">
				上一页</a>
	</s:if>
	<s:else>
		<a>上一页</a>
	</s:else>
  	
	<a href="${pageContext.request.contextPath}/list.action?page=${totalPage}">最后一页</a><br/>
	当前页${page } | ${totalPage }
	<hr/>
	
	</body>
</html>