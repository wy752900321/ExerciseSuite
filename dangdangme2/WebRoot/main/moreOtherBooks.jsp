<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
		<script type="text/javascript" src="../js/dealCart.js"></script>
<script type="text/javascript" src="../js/book_list.js"></script>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />

	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="../images/default/book_banner_081203.jpg"
					border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href="../main/main.action">当当图书</a> &gt;&gt;
			MORE HOT BOOKS
		</div>
		<div class="book">
			<center>
				<!--中栏开始-->
				<div class="book_center">

					<!--图书列表开始-->
					<div id="divRight" class="list_right">

						<div id="book_list" class="list_r_title">
							<div class="list_r_title_text">
								排序方式
							</div>
							<select onchange='' name='select_order' size='1'
								class='list_r_title_ml'>
								<option value="">
									按上架时间 降序
								</option>
							</select>
							<div id="divTopPageNavi" class="list_r_title_text3">

								<!--分页导航开始-->
								<s:if test="page>1">
									<div class='list_r_title_text3a'>
										<a name=link_page_next
											href='../main/${nowAction}?page=${page-1}'> <img
												src='../images/page_up.gif' /> </a>
									</div>
								</s:if>
								<s:else>
									<div class='list_r_title_text3a'>
										<img src='../images/page_up_gray.gif' />
									</div>
								</s:else>
								<div class='list_r_title_text3b'>
									第
									<s:property value="page" />
									页/共
									<s:property value="maxPage" />
									页
								</div>
								<s:if test="page < maxPage">
									<div class='list_r_title_text3a'>
										<a name=link_page_next
											href='../main/${nowAction}?page=${page+1}'> <img
												src='../images/page_down.gif' /> </a>
									</div>
								</s:if>
								<s:else>
									<div class='list_r_title_text3a'>
										<img src='../images/page_down_gray.gif' />
									</div>
								</s:else>
								<!--分页导航结束-->
							</div>
						</div>

						<!--商品条目开始-->
						<s:iterator value="hotBook">
							<div class="clear"></div>
							<div class="list_r_line"></div>
							<div class="list_r_list">
								<span class="list_r_list_book"><a name="link_prd_img"
									href='../main/bookDiscription.action?bookId=${id}' > <img
											src='../productImages/<s:property value="product_pic" />' />
								</a> </span>
								<h2>
									<a name="link_prd_name" href='#'><s:property
											value="productName" /> </a>
								</h2>
								<h3>
									顾客评分：100
								</h3>
								<h4 class="list_r_list_h4">
									作 者:
									<a href='#' name='作者'><s:property value="author" /> </a>
								</h4>
								<h4>
									出版社：
									<a href='#' name='出版社'><s:property value="publishing" /> </a>
								</h4>
								<h4>
									出版时间：2009-01-01
								</h4>
								<h5>
									<s:property value="catalogue" />
								</h5>
								<div class="clear"></div>
								<h6>
									<span class="del">￥<s:property value="fixed_price" /> </span>
									<span class="red">￥<s:property value="dang_price" /> </span>
									节省：￥${fixed_price-dang_price}
								</h6>
								<span class="list_r_list_button"></span>
								<!-- 购买 -->
										<a href="javascript:;" onclick="buy(${id});" onmouseout="buyMsg(${id})"> <img
										src='../images/buttom_goumai.gif' /> </a>
								<span id="cartinfo_${id}"></span>
							</div>
						</s:iterator>
						<div class="clear"></div>
						<!--商品条目结束-->

						<div class="clear"></div>
						<div id="divBottomPageNavi" class="fanye_bottom">
						</div>

					</div>
					<!--图书列表结束-->
				</div>
			</center>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
