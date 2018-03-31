<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<script type="text/javascript" src="../js/jquery-1.4.min.js">
		</script>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/book_list.js"></script>
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
			<a href='../main/main.action'>当当图书</a> &gt;&gt;
			<s:if test="pid==cid">
				<font style='color: #cc3300'><strong> <s:property
							value="parentName" /> </strong> </font>
			</s:if>
			<s:else>
				<font style='color: black;'><strong> <s:property
							value="parentName" /> </strong> </font>&gt;&gt;	<font style='color: #cc3300'>
					<strong><s:property value="childrenName" /> </strong> </font>
			</s:else>
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
										&middot;
										<a href='../main/booklist.action?cid=${pid}&pid=${pid}'
											style="color: green;">全部</a>&nbsp;(
										<s:property value="allBookNumbers" />
										)
									</div>
								</div>
							</li>
							<div class="clear"></div>

							<!--2级分类开始-->
							<s:iterator value="cats">
								<li>
									<div>
										<div class=second_fenlei>
											&middot;
										</div>
										<s:if test="id==cid">
											<div class=second_fenlei>
												<a href="../main/booklist.action?cid=${id}&pid=${pid}"
													style="color: red;"><s:property value="name" />&nbsp;(
													<s:property value="pnum" /> ) </a>
											</div>
										</s:if>
										<s:else>

											<div class=second_fenlei>
												<a href='booklist.action?cid=${id}&pid=${pid}'><s:property
														value="name" />&nbsp;(<s:property value="pnum" />)</a>
											</div>
										</s:else>
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
			<input id="cid" type="hidden" value="${cid}" />
			<input id="pid" type="hidden" value="${pid}" />
			<input id="pageUnum" type="hidden" value="${page-1}" />
			<input id="pageDnum" type="hidden" value="${page+1}" />
			<!-- SelectOrderAction->private String select_order="no";//从页面中获取到的排序方式 -->
			<input id="select_order" name="select_order" type="hidden"
				value="${select_order}" />
			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='selectFun()' name='select_order' size='1'
							class='list_r_title_ml' id="selectList">
							<option value="no">
								----请选择----
							</option>
							<option value="renyi">
								按默认排序规则排序
							</option>
							<option value="timeUp">
								按上架时间升序排序
							</option>
							<option value="timeDown">
								按上架时间降序排序
							</option>
							<option value="saleMoneyUp">
								按商品价格升序排序
							</option>
							<option value="saleMoneyDown">
								安商品价格降序排序
							</option>
							<option value="saleDown">
								按销量降序排序
							</option>
							<option value="saleUp">
								按销量降序排序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<s:if test="page>1">
								<div class='list_r_title_text3a'>
									<a name=link_page_next href="javascript:;" onclick='pageUp()'>
										<img src='../images/page_up.gif' /> </a>
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
									<a name=link_page_next href="javascript:;" onclick='pageDown()'>
										<img src='../images/page_down.gif' /> </a>
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
					<s:iterator value="pros">
						<div class="list_r_line"></div>
						<div class="clear"></div>

						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img"
								href='../main/bookDiscription.action?book_id=${id}'> <img
										src="../productImages/${product_pic }" /> </a> </span>
							<h2>
								<a name="link_prd_name" href='#'>${product_name }</a>
							</h2>
							<h3>
								顾客评分：100
							</h3>
							<h4 class="list_r_list_h4">
								作 者:
								<a href='#' name='作者'>${author }</a>
							</h4>
							<h4>
								出版社：
								<a href='#' name='出版社'>${publishing}</a>
							</h4>
							<h4>
								出版时间：${publishTimeFormat }
							</h4>
							<h5>
								这是一本好书，描述了Struts、Hibernate和Spring等框架的整合应用！
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥${fixed_price}</span>
								<span class="red">￥${dang_price}</span>
								节省：￥${fixed_price-dang_price}
							</h6>
							<span class="list_r_list_button"> <!-- 购买 --> <a
								href="javascript:;" onclick="buy(${id});"
								onmouseout="buyMsg(${id})"> <img
										src='${pageContext.request.contextPath }/images/buttom_goumai.gif' />
							</a> <span id="cartinfo_${id}"></span>
						</div>
						<div class="clear"></div>
					</s:iterator>
					<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
