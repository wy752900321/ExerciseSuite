function buyFun(productId) {
	$.post("../cart/cartAction!add.action", {
		"productId" : productId
	}, function(ok) {
		if (ok) {
			$("#cartinfo_" + productId).html("购买成功！").css("color", "green");
		} else {
			$("#cartinfo_" + productId).html("购买失败！").css("color", "red");
		}
	});
}


function updateFun(productId) {
	var pnum = $("#productNum_" + productId).val();
	//alert($("#productNum_"+productId).val());
	if (pnum == "") {
		alert("不能更新为空！");
		return;
	}
	var testPnum = /^[0-9]+$/;
	if (!testPnum.test(strip(pnum))) {
		alert("格式错误，请输入一个数字！");
		return;
	}
	if (pnum == 0) {
		alert("不能输入0 ");
		return;
	}
	$.post("../cart/cartAction!update.action", {
		"productId" : productId,
		"pnum" : pnum
	});
	window.location.href = "../cart/cartAction!showCart.action";
}

function selectFun() {
	var cid = $("#cid").val();
	var pid = $("#pid").val();
	var order = $("#selectList").val();
	window.location.href = "../main/selectOrder.action?cid=" + cid + "&pid="
			+ pid + "&select_order=" + order
}
function pageUp() {
	var cid = $("#cid").val();
	var pid = $("#pid").val();
	var order = $("#select_order").val();
	var pageUnum = $("#pageUnum").val();
	window.location.href = "../main/selectOrder.action?cid=" + cid + "&pid="
			+ pid + "&select_order=" + order + "&page=" + pageUnum;

}
function pageDown() {
	var cid = $("#cid").val();
	var pid = $("#pid").val();
	var order = $("#select_order").val();
	var pageDnum = $("#pageDnum").val();
	window.location.href = "../main/selectOrder.action?cid=" + cid + "&pid="
			+ pid + "&select_order=" + order + "&page=" + pageDnum;
}



function strip(str) {
	return str = str.replace(/(^\s*)|(\s*)/, '');
}
