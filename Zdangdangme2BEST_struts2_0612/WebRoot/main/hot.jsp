<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h2>
	<span class="more"><a href="${pageContext.request.contextPath}/main/moreHotBooks.action" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<s:iterator value="hotBook">
	<div class="second_d_wai">
		<div class="img">
			<a href='${pageContext.request.contextPath}/main/bookDiscription.action?book_id=${id}' target='_blank'><img
					src='../productImages/<s:property value="product_pic"/>' border=0 /> </a>
		</div>
		<div class="shuming">
			<a href="#" target="_blank"><s:property value="product_name"/></a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			销量：<s:property value="saleCount"/>
		</div>
		<div class="price">
			定价：￥<s:property value="fixed_price"/>
		</div>
		<div class="price">
			当当价：￥<s:property value="dang_price"/>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	</s:iterator>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>