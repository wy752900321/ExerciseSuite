<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix = "s"  uri="/struts-tags"%>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<s:iterator value="pros" var="p">
	<div class="second_d_wai">
		<div class="img">
		
			<a href="#" target='_blank'>
			<img src="../productImages/${p.productPic }" border=0 /> </a>
		</div>
		<div class="shuming">
			<a href="#" target="_blank"><s:property value="#p.productName" /></a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：<s:property value="#p.fixedPrice" />
		</div>
		<div class="#p.dangPrice">
			当当价：<s:property value="#p.dangPrice" />
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	</s:iterator>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>