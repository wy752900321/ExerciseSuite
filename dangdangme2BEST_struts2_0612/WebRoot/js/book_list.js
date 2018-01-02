function buy(id) {
	$.post("../cart/AddCart.action", {
		"id" : id
	}, function(ok) {
		if (ok) {
			$("#cartinfo_" + id).html("购买成功!").css("color", "green");
		} else {
			$("#cartinfo_" + id).html("购买失败!").css("color", "red");
		}
	});
}
function buyMsg(id) {
	var msgId = "cartinfo_" + id;
	$("#" + msgId).html("");
}

function pageUp(){
	var cid = $("#cid").val();
	var pid=$("#pid").val();
	var order = $("#select_order").val();
	var pageUnum=$("#pageUnum").val();
	alert("pageUP()"+pageUnum);
	window.location.href="../main/selectOrder.action?cid="+cid+"&pid="
									+pid+"&select_order="+order+"$page="+pageUnum;
}

function pageDown() {
	var cid = $("#cid").val();
	var pid = $("#pid").val();
	var order = $("#select_order").val();
	var pageDnum = $("#pageDnum").val();
	alert("pageDown()"+pageDnum);
	window.location.href = "../main/selectOrder.action?cid=" + cid + "&pid="
			+ pid + "&select_order=" + order + "&page=" + pageDnum;
}

function selectFun(){
	var cid = $("#cid").val();
	var pid=$("#pid").val();;
	var order=$("#selectList").val();
	window.location.href="../main/selectOrder.action?cid="+cid+"&pid="
									+pid+"&select_order="+order
}

