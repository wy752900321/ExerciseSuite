<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<div class="book_r_border2" id="__XinShuReMai">
	<div class="book_r_b2_1x" id="new_bang">
		<h2 class="t_xsrm">
			新书热卖榜
		</h2>
		<div id="NewProduct_1_o_t" onmouseover="">
			<s:iterator value="pros" var="p">
				<span class="dot_r"><a
					id="blackRight_<s:property value='id'/>"
					onmouseout="moveBlackRight(<s:property value='id'/>);"
					onmouseover="addBlackRight(<s:property value='id'/>);"
					href="detail.action?id=<s:property value='id'/>" title="查看id为<s:property value='id'/>的商品"><s:property
							value='productName' /> </a> <br /> </span>
			</s:iterator>
			<h3 class="second">
			</h3>
		</div>
		<a href="../user/help.jsp" title="更多" target="_blank">更多&gt;&gt;</a>
	</div>
</div>