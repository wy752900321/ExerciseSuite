<%@page contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://xq.com/xq" prefix="xq" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<script type="text/javascript" src="../js/prototype-1.6.0.3.js"></script>

		<link href="${pageContext.request.contextPath }/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/css/list.css" rel="stylesheet" type="text/css" />
		<script>
				function fun(value){
				 document.form1.elements['sort'].value=value;
				 document.form1.submit();
				}
		</script>

	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="/common/head.jsp"%>
		<!-- 头部结束 -->
		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="${pageContext.request.contextPath }/images/default/book_banner_081203.jpg"
					border="0" /> 
		 </a>
		</div>
		<div class='your_position'>
			         您现在的位置:&nbsp;
			<a href='${pageContext.request.contextPath }/main/mainAction'>当当图书</a> &gt;&gt;
			 
					   	<s:if test="#session.categoryId==#session.fatherCategory.id">
					   	 <font style='color: #cc3300'>
				         <strong> 
								      <s:property	value="#session.fatherCategory.name"/>
								  </strong> 
	        		</font>
								</s:if>
								<s:else>
								  <s:property	value="#session.fatherCategory.name"/>
								</s:else>
			  
			<!-- 子类名字颜色处理 -->
			<font style='color: #cc3300'>
				 <strong> 
<s:iterator value="categorys" var="cate">
								<s:if test="#session.categoryId==#cate.id"> &gt;&gt; 
								   <s:property value="name" />
								</s:if>
</s:iterator>
				 </strong> 
			</font>
		</div>


		<div class="book">

			<!--左栏开始-->

			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
						
								<li>
									<div>
										<div class=second_fenlei>
										
								
										
										<!--<a href="${pageContext.request.contextPath}/book/bookAction!showBookCategory?category.id=<s:property value="id"/>&category.parentId=<s:property value="id"/>">
					                   	<s:if test="#session.categoryId==category.id">
					                   		<font style='color: #cc3300'>
				                          <strong> -->
														                &middot;全部&nbsp;
														                	(<s:property value="count"/>)
														                	<!--
									                	  </strong> 
	               	          	</font>
							               	</s:if>
							               	<s:else>
							               	   &middot;全部&nbsp;
									                	(<s:property value="count"/>)
							               	</s:else>
										</a>
										--></div>
									</div>
									<div class="clear"></div>
								</li>
						


							<!--2级分类开始-->
<s:iterator value="categorys" status="statuss" var="cate">
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
									<s:if test="#session.categoryId==#cate.id">
												
															<a href="${pageContext.request.contextPath}/book/bookAction!showBookCategory?category.id=<s:property value="id"/>&category.parentId=<s:property value="category.parentId"/>"> 
															 <font style='color:#cc3300'> 
												         <strong> 
															 <s:property value="name" /> &nbsp; 
															 (<s:property	value="count" />)
															    </strong>
									          </font>
														 </a>
									    
									 </s:if>
									 <s:else>
									 	<a href="${pageContext.request.contextPath}/book/bookAction!showBookCategory?category.id=<s:property value="id"/>&category.parentId=<s:property value="category.parentId"/>"> 
										 <s:property value="name" /> &nbsp; 
										 (<s:property	value="count" />)
									 </a>
									 </s:else>
									</div>
								</div>
							</li>
							<div class="clear"></div>
</s:iterator>
							<!--2级分类结束-->
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
<form action="" method="post" name="form1">
				<div id="divRight" class="list_right">
					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						
						<select onchange='fun(this.value)' name='select_order' size='1'	class='list_r_title_ml'>
							<s:if test="sort == 'publish_time desc'">
									<option value="publish_time desc" selected="selected">
										按出版时间降序
									</option>
							</s:if>
							<s:else>
									<option value="publish_time desc">
										按出版时间降序
									</option>
							</s:else>
							
							<s:if test="sort =='dang_price'">
									<option value="dang_price" selected="selected">
										按价格升序
									</option>
							</s:if>
							<s:else>
									<option value="dang_price">
										按价格升序
									</option>
							</s:else>
							
						</select>
						
						<input type="hidden" name="sort" value="<s:property value='sort'/>"/>
						
						
						<div id="divTopPageNavi" class="list_r_title_text3">

	

							<!--分页导航开始-->
<s:property value="page.pageInfo" escape="false"/>
                           <!--分页导航结束-->
						</div>
					</div>
					       <!--商品条目开始-->
<s:iterator value="books">
					<div class="list_r_line"></div>
					<div class="clear"></div>
					<div class="list_r_list">
						<span class="list_r_list_book">
						<a name="link_prd_img"	href='${pageContext.request.contextPath}/book/bookAction!product?book.id=<s:property value="id"/>'> <img src="${pageContext.request.contextPath }/productImages/<s:property value="productPic"/>" /> </a> </span>
						<h2>
							<a name="link_prd_name" href='#'>
							  <s:property value="productName"/>
							</a>
						</h2>
						<h3>
							顾客评分：100
						</h3>
						<h4 class="list_r_list_h4">
							作 者:
							<a href='#' name='作者'>
               <s:property value="author"/>
           </a>
						</h4>
						<h4>
							出版社：
							<a href='#' name='出版社'>
							 <s:property value="publishing"/>
          </a>
						</h4>
						<h4>
							出版时间：
							<xq:xq pattern="yyyy-MM-dd" time="${publishTime}"/>
						</h4>
						<h5>
							<s:property value="description"/>
						</h5>
						<div class="clear"></div>
						<h6>
							<span class="del">
							  <s:property value="fixedPrice"/>
							</span>
							<span class="red">
							   <s:property value="dangPrice"/>
							</span> 节省：￥<s:property value="savePrice"/>
						</h6>
						<span class="list_r_list_button">
						<!-- 购买 -->
						 <a href="${pageContext.request.contextPath }/cart/cartAction!addBook?book.id=<s:property value="id"/>"> 
						   <img	src='${pageContext.request.contextPath }/images/buttom_goumai.gif' /> 
						 </a> 
						 <span id="cartinfo"></span>
					</div>
</s:iterator>

					<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
</form>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="/common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
