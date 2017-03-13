<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
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
// 时间格式化
function checkTime(i) {
	if (i < 10) {
		i = "0" + i
	}
	return i
}

// 登出逻辑
function logout() {
	var out=confirm("亲！确定登出吗？");
	if (out==true) {
		window.location.href = "../user/login_out.action";
		return;
	}
}

//左侧加黑显示
function addBlackLeft(id) {
	document.getElementById("blackLeft_" + id).style.fontWeight = "900";
}

//左侧移出加黑
function moveBlackLeft(id) {
	document.getElementById("blackLeft_" + id).style.fontWeight = "100";
}
//右侧加黑显示
function addBlackRight(id) {
	document.getElementById("blackRight_" + id).style.fontWeight = "900";
}
//右侧移出加黑
function moveBlackRight(id) {
	document.getElementById("blackRight_" + id).style.fontWeight = "100";
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

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<s:action name="category" namespace="/main" executeResult="true"></s:action>
			</div>
			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--推荐图书开始-->
				<div class=second_c_border1 id="recommend">
					<s:action name="recommend" namespace="/main" executeResult="true"></s:action>
				</div>

				<!--推荐图书结束-->

				<!--热销图书开始-->
				<div class="book_c_border2" id="hot">
					<s:action name="hotProduct" namespace="/main" executeResult="true"></s:action>
				</div>
				<!--热销图书结束-->

				<!--最新上架图书开始-->
				<div class="book_c_border2" id="new">
					<!-- 调用一个Action，将result结果填充标签所在位置 -->
					<s:action name="newProduct" namespace="/main" executeResult="true"></s:action>
				</div>

				<!--最新上架图书结束-->

				<div class="clear">
				</div>
			</div>
			<!--中栏结束-->

			<!--右栏开始-->
			<div class="book_right">
				<s:action name="newHotProduct" namespace="/main"
					executeResult="true"></s:action>
			</div>
			<!--右栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
