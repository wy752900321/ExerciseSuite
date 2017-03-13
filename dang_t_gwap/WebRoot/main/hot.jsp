<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<h2>
	<span class="more"><a href="../user/help.jsp" title="更多" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">
	<s:iterator value="products" var="pro">
		<!--热销图书A开始-->
		<div class="second_d_wai">
			<div class="img">
				<a href="detail.action?id=<s:property value='id'/>" title="查看id为<s:property value='id'/>的商品" target='_blank'><img
						src="../productImages/<s:property value='productPic'/>" border=0 />
				</a>
			</div>
			<div class="shuming">
				<a href="detail.action?id=<s:property value='id'/>" title="查看id为<s:property value='id'/>的商品" target="_blank"><s:property value="productName" />
				</a>
			</div>
			<div class="price">
				定价：￥
				<s:property value="fixedPrice" />
			</div>
			<div class="price">
				当当价：￥
				<s:property value="dangPrice" />
			</div>
		</div>
		<!--热销图书A结束-->
	</s:iterator>

	<div class="clear"></div>
</div>