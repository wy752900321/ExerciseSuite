<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<script type="text/javascript" src="../js/prototype-1.6.0.3.js">
</script>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.3.js">
</script>
		<script type="text/javascript">
// 购买操作
function buy(id) {
	$.post("${pageContext.request.contextPath}/cart/add.action", {
		"id" : id
	}, function(ok) {
		if (ok) {
			$("#cartinfo" + id).html("购买成功").css("color", "green");
		} else {
			$("#cartinfo" + id).html("购买失败").css("color", "red");
		}
	});
}

// 离开购买按钮
function exit(id) {
	$("#cartinfo" + id).html("");
}

// 排序
function getSort() {
	var rule = $(".list_r_title_ml").val();
	$.post("sort.action", {
		"rule" : rule
	}, function(pid, cid, page) {
		window.location.href = "book_list!sort.action?cid=" + pid.cid + "&pid="
				+ pid.pid + "&page=" + pid.page + "&rule=" + rule;
	});
}

// 启动时间显示
function startTime() {
	var today = new Date()
	var y = today.getYear() + 1900
	var M = today.getMonth() + 1
	var d = today.getDate()
	var h = today.getHours()
	var m = today.getMinutes()
	var s = today.getSeconds()
	// add a zero in front of numbers<10
	m = checkTime(m)
	s = checkTime(s)
	document.getElementById('txt').innerHTML = "当前时间为：" + y + "-" + M + "-" + d
			+ " " + h + ":" + m + ":" + s
	t = setTimeout('startTime()', 500)
}

// 格式化时间 
function checkTime(i) {
	if (i < 10) {
		i = "0" + i
	}
	return i
}

// 加黑
function addBlack(id) {
	document.getElementById("black_" + id).style.fontWeight = "900";
}

// 移除加黑
function moveBlack(id) {
	document.getElementById("black_" + id).style.fontWeight = "100";
}
</script>
	</head>
	<body onload="startTime()">
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="../user/help.jsp" title="08年度礼品季"><img
					src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<strong><a href='main.jsp' title="当当图书">当当图书</a> </strong> &gt;&gt;
			<font style='color: #FF5D5D'> <strong><s:property
						value="pname" /> </strong> </font>&gt;&gt;
			<font style='color: #FF5D5D'> <strong><b><s:property
							value="cname" /> </b> </strong> </font>
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
										<a href="main.jsp" title="查看全部种类"> &middot;全部&nbsp;( <s:property
												value="allSum" /> ) </a>
									</div>
								</div>
								<div class="clear"></div>
							</li>
							<s:iterator value="cats">
								<!--2级分类开始-->
								<li>
									<div>
										<div class=second_fenlei>
											&middot;
										</div>
										<div class=second_fenlei>
											<a id="black_<s:property value='id'/>"
												onmouseout="moveBlack(<s:property value='id'/>);"
												onmouseover="addBlack(<s:property value='id'/>);"
												title="查看此分类"
												href="book_list.action?cid=<s:property value='id'/>&pid=${pid}">${name}&nbsp;(<s:property
													value="pnum" />)</a>
										</div>
									</div>
								</li>
								<div class="clear"></div>
								<!--2级分类结束-->
							</s:iterator>

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
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='getSort();' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="0">
								--排序规则--
							</option>
							<option value="1">
								按类别排序
							</option>
							<option value="2">
								按上架时间降序
							</option>
							<option value="3">
								按上架时间升序
							</option>
							<option value="4">
								按价格降序
							</option>
							<option value="5">
								按价格升序
							</option>
							<option value="6">
								按销量降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<s:if test="page>1">
								<div class='list_r_title_text3a'>
									<a name=link_page_next title="上一页"
										href="book_list.action?cid=${cid}&pid=${pid}&page=${page-1}">
										<img src='../images/page_up.gif' /> </a>
								</div>
							</s:if>
							<s:else>
								<div class='list_r_title_text3a'>
									<img src='../images/page_up_gray.gif' />
								</div>
							</s:else>

							<div class='list_r_title_text3b'>
								第${page}页/共${maxPage}页
							</div>
							<s:if test="maxPage>page">
								<div class='list_r_title_text3a'>
									<a name=link_page_next title="下一页"
										href="book_list.action?cid=${cid}&pid=${pid}&page=${page+1}">
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
								href="detail.action?id=<s:property value='id'/>"
								title="查看id为<s:property value='id'/>的商品"> <img
										src="../productImages/${productPic}" /> </a> </span>
							<h2>
								<a name="link_prd_name"
									href="detail.action?id=<s:property value='id'/>"
									title="查看id为<s:property value='id'/>的商品">${productName}</a>
							</h2>
							<h3 class="list_r_list_h4">
								作 者:
								<a href="detail.action?id=<s:property value='id'/>"
									title="查看id为<s:property value='id'/>的商品" name='作者'>${author}</a>
							</h3>
							<h4>
								顾客评分：100
							</h4>
							<h3>
								出版社：
								<a href="detail.action?id=<s:property value='id'/>"
									title="查看id为<s:property value='id'/>的商品" name='出版社'>${publishing}</a>
							</h3>
							<h4>
								出版时间：
								<s:property value="publishDate" />
							</h4>
							<h4>
								上架时间：
								<s:date name="addDate" format="yyyy-MM-dd" />
							</h4>
							<h4>
								总销量：
								<s:property value="bookNum" />
							</h4>
							<h5>
								${authorSummary}
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥<s:property value="fixedPrice" /> </span>
								<span class="red">￥<s:property value="dangPrice" /> </span>
								节省：￥ ${fixedPrice-dangPrice}
							</h6>
							<span class="list_r_list_button" />
							<a title="添加到购物车" href="javascript:;" onclick="buy(${id});"
								onmouseout="exit(${id});"> <img
									src='../images/buttom_goumai.gif' /> </a>
							<span id="cartinfo${id}"></span>
						</div>
						<div class="clear"></div>
						<!--商品条目结束-->
					</s:iterator>

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
