<%@page contentType="text/html;charset=utf-8"
	import="java.sql.Date.*,java.text.*"%>
<%@page import="java.sql.Date"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
	<!-- recList要显示的图书集合 -->
	<s:iterator value="recList">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='${pageContext.request.contextPath}/main/bookDiscription.action?book_id=${id}' target='_blank'><img 
						src='../productImages/<s:property value="product_pic"/>'
						 width=70 border=0 /> </a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='#' target='_blank' title='输赢'>
					<s:property value="#c1.product_name"/></a>
				</h3>
				<h4>
					作者：
					<s:property value="author"/> 著
					<br />
					出版社：
					<s:property value="publishing"/> 
					&nbsp;&nbsp;&nbsp;&nbsp;出版时间：
				</h4>
				<h5>
					简介:
					<s:property value="catalogue"/>
				</h5>
				<h6>
					定价￥：
					<s:property value="fixed_price"/>&nbsp;&nbsp;
					当当价：￥
					<s:property value="dang_price"/>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
		</s:iterator>
	</div>
</div>
