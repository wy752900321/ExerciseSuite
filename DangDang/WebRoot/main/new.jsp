<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<!--最新上架图书A开始-->
	<s:iterator value="pros">
	<div class="second_d_wai">
		<div class="img">
			<a href="#" target='_blank'><img
					src="../productImages/${product_pic }" border=0 /> </a>
		</div>
		<div class="shuming">
			<a href="#" target="_blank">书籍标题</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${fixed_price}
		</div>
		<div class="price">
			当当价：￥${dang_price }
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	</s:iterator>
	<!--最新上架图书A结束-->

</div>
<div class="clear"></div>