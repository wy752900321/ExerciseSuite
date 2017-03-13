<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<s:iterator value="books" var="b">
			<div class=second_c_02_b1>
				<div class=second_c_02_b1_1>
					<a href="detail.action?id=<s:property value='id'/>" title="查看id为<s:property value='id'/>的商品" target='_blank'><img
							src="../productImages/<s:property value='productPic'/>" width=70
							border=0 /> </a>
				</div>
				<div class=second_c_02_b1_2>
					<h3>
						<a href="detail.action?id=<s:property value='id'/>" title="查看id为<s:property value='id'/>的商品" target='_blank' title='输赢'><s:property
								value="productName" /> </a>
					</h3>
					<h4>
						作者：
						<s:property value="author" />
						著
						<br />
						出版社：
						<s:property value="publishing" />
						&nbsp;&nbsp;&nbsp;&nbsp;出版时间：
						<s:date name="publishDate" format="yyyy-MM-dd"></s:date>
					</h4>
					<h5>
						简介：
						<s:property value="catalogue" />
					</h5>
					<h6>
						定价：￥
						<s:property value="fixedPrice" />
						&nbsp;&nbsp;当当价：￥
						<s:property value="dangPrice" />
					</h6>
					<div class=line_xx></div>
				</div>
			</div>
		</s:iterator>
	</div>
</div>
