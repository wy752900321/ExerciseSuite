<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />
		<link href="../css/jqzoom.css" rel="stylesheet" type="text/css" />
		<script src="../js/jquery-1.4.3.js" type="text/javascript">
</script>
		<script src="../js/jquery-1.3.2.min.codefans.net.js"
			type="text/javascript">
</script>
		<script src="../js/jqzoom.js" type="text/javascript">
</script>
		<script type="text/javascript">
// 购买
function buy(id) {
	$.post("${pageContext.request.contextPath}/cart/add.action", {
		"id" : id
	}, function(ok) {
		if (ok) {
			$("#cartinfo").html("购买成功").css("color", "green");
		} else {
			$("#cartinfo").html("购买失败").css("color", "red");
		}
	});
}

// 离开按钮
function exit() {
	$("#cartinfo").html("");
}

// 放大镜
$(function() {
	$(".jqzoom").jqzoom();
});

// 时间显示
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
	return i;
}

// 登出逻辑
function logout() {
	var out = confirm("亲！确定登出吗？");
	if (out == true) {
		window.location.href = "../user/login_out.action";
		return;
	}
}
</script>
	</head>
	<body onload="startTime()">
		&nbsp;
		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->
		<div style="width: 962px; margin: auto;">
			<a href="../user/help.jsp"><img
					src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class="book">
			<!-- 左部分空白 -->
			<div id="left" class="book_left">
			</div>
			<!-- 左部分空白结束 -->

			<!--中栏开始-->
			<div>

				<!--详细开始-->
				<div class=second_c_border1 id="recommend" style="width: 958px;">
					<h2>
						丛书详细
					</h2>
					<br />
					<h3>
						丛书名：${book.productName}
					</h3>
					<hr />
					<div id=__bianjituijian/danpin>
						<div class=second_c_02_b1>
							<div class=second_c_02_b1_1>
								<a href="../productImages/big${book.productPic}" class="jqzoom"
									style="" title="kawasaki"> <img
										src="../productImages/${book.productPic}" width=70 border=0
										title="kawasakigreen" style="border: 1px solid #666;" /> </a>
							</div>
							<div class=second_c_02_b1_2>
								<table>
									<tr>
										<td colspan="10"></td>
										<td>
											作者：${book.author}著
										</td>
									</tr>
									<tr>
										<td colspan="10"></td>
										<td>
											出版社：${book.publishing}
										</td>
									</tr>
									<tr>
										<td colspan="10"></td>
										<td>
											出版时间：
											<s:date name="book.publishDate" format="yyyy-MM-dd" />
										</td>
										<td colspan="20"></td>
										<td>
											字数：${book.wordNumber}
										</td>
									</tr>
									<tr>
										<td colspan="10"></td>
										<td>
											版次：1
										</td>
										<td colspan="20"></td>
										<td>
											页数：${book.totalPage}
										</td>
									</tr>
									<tr>
										<td colspan="10"></td>
										<td>
											印刷时间：${book.printTime}
										</td>
										<td colspan="20"></td>
										<td>
											开本：16开
										</td>
									</tr>
									<tr>
										<td colspan="10"></td>
										<td>
											印次：${book.printNumber}
										</td>
										<td colspan="20"></td>
										<td>
											纸张：胶版纸
										</td>
									</tr>
									<tr>
										<td colspan="10"></td>
										<td>
											ISBN：${book.isbn}
										</td>
										<td colspan="20"></td>
										<td>
											包装：平装
										</td>
									</tr>
									<tr>
										<td colspan="10"></td>
										<td>
											产品描述：${book.description}
										</td>
									</tr>
									<tr>
										<td colspan="12">
											<span class="del">定价￥${book.fixedPrice}</span>&nbsp;&nbsp;
											<span class="red">当当价￥${book.dangPrice}</span>&nbsp;&nbsp;
											节省：￥${book.fixedPrice-book.dangPrice}
											<span class="list_r_list_button"> </span>
										</td>
									</tr>
									<tr>
										<td></td>
									</tr>
									<tr>
										<td></td>
									</tr>
									<tr>
										<td colspan="10"></td>
										<td>
											<a href="javascript:;" onclick="buy(${book.id});"
												onmouseout="exit();"> <input type="button"
													value="添加到购物车" /> </a>
										</td>
									</tr>
									<tr>
										<td colspan="10"></td>
										<td>
											<span id="cartinfo"></span>
										</td>
									</tr>
								</table>
							</div>
							<div>
								<p style="height: 120px;"></p>
							</div>
							<div class=second_c_02_b1_2>
							</div>
						</div>
						<div class="clear">
						</div>
					</div>
				</div>
				<!--详细结束-->

			</div>
			<!--中栏结束-->

			<!--右部空白-->
			<div class="book_right">
			</div>
			<!--右栏右部空白结束-->
			<div class="clear"></div>
		</div>
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>