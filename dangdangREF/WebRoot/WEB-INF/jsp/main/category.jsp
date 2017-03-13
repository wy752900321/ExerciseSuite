<%@page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>

		<!--1级分类开始-->
		<s:iterator value="categorys" var="category">

			<div class="bg_old" onmouseover=this.className
				= 'bg_white';;onmouseout=this.className='bg_old';;>
				<h3>
				<a href="${pageContext.request.contextPath}/book/bookAction!showBookCategory?category.id=<s:property value="id"/>&category.parentId=<s:property value="id"/>">
				   [<s:property value="name" />]
				</a>
		  	</h3>
				<ul class="ul_left_list">
					<s:iterator value="#category.cateChild" var="cate" status="statuss">
						<!--2级分类开始-->
						<li>
							<a  href='${pageContext.request.contextPath}/book/bookAction!showBookCategory?category.id=<s:property value="#cate.id"/>&category.parentId=<s:property value="#cate.parentId"/>'>
							   <s:property value="#cate.name" />
							</a>
							 <!--2级分类结束-->
					</s:iterator>
				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
			<!--1级分类结束-->

		</s:iterator>

		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
