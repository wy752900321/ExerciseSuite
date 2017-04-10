function changeStyle() {
	var obj = $("myP");
	// 修改文本
	obj.innerHTML = "aaaaa";

	// 修改样式
	obj.style.color = "red";
	obj.style.height = "100px";
	obj.style.backgroundColor = "yellow";
	obj.style.fontSize = "30pt";

	// 修改div的各边框
	var div = $("myDiv");
	div.className = "myStyle";

	// 弹出页面上段落的个数
	var pArray = document.getElementsByTagName("p");
	alert(pArray.length);
	// 弹出每个段落里的文本
	for ( var i = 0; i < pArray.length; i++) {
		alert(pArray[i].innerHTML);
	}

}
function showSubMenu(isShow, menuID) {
	var menu = $(menuID);
	if (isShow)
		menu.style.display = "block";// 鼠标移入
	else
		menu.style.display = "none";
}

// 将当前选中的tab背景色改为blue,其它的所有tab背景色改为silver
function changeTab(divID) {
	// 将所有的tab面签修改为初始样式
	var parentDiv = $("allTabs");
	var divArray = parentDiv.getElementsByTagName("div");
	// document.getElementsByTagName("div");
	for ( var i = 0; i < divArray.length; i++) {
		// 将当前选中的修改
		divArray[i].style.backgroundColor = "silver";
	}
	$(divID).style.backgroundColor = "blue";
}
// 判断用户录入的用户名：不允许为空，只能为3位小写字母
// 录入完毕，应该判断且提示
// 如果提交页面，必须判断：难不成功，避免验证不成功
function judgeUserName() {
	var obj = $("txtUserName");
	var span = $("errorInfo");
	if (obj.value != "") {
		var reg = /^[a-z]{3}$/;
		if (reg.test(obj.value)) {
			span.innerHTML = "已验证";
			return true;
		} else {
			span.innerHTML = "用户名必 须为三位小写字母 ";
			return false;
		}
	} else
		span.innerHTML = "用户名不允许为空! ";
	return false;
}

	function addNew()
	{
		//创建一个文本框和一个按钮
		var obj = document.createElement("input");
		var button=document.createElement("input");
		button.type="button";
		button.value="new button";
		
		//加入文档中
		$("form1").appendChild(obj);
		$("form1").appendChild(button);
		
		//创建a   <a href="">ddd</a>
		var link = document.createElement("a");
		link.innerHTML = "click me";
		link.href = "a.html";
		
		var hobj =$("h1");
		$("form1").insertBefore(link,hobj);
	}
	function testSelect()
	{
		var obj = $("mySelect");
		//每个选项的文本及值
		for(var i=0;i<obj.options.length;i++)
		{
			var op = obj.options[i];
			alert(op.innerHTML);
			alert(op.value);
		}
		alert(obj.options.length);
	}
	
	//弹出所选择项的值和文本7	7+\il
		function showSelect()
	{
		var obj = $("mySelect");
		var op = obj.options[obj.selectedIndex];
		alert(op.innerHTML);
		alert(op.value);
	}
		
		var dataArray = new Array();
		dataArray[0] = ["JSD1202","JSD1203","JSD1204"];
		dataArray[0] = ["JSD1202","JSD1203"];
		dataArray[0] = ["JSD1202","JSD1203","PHD1204"];
		//根据所选择的课程显示相应的班级信息
		function showClasses()
		{
			var index = $("selSubjects").selectedIndex;
			
			//先清空原有的班级数据
			$("selClasses").options.length=0;
			
			//得到班级信息
			//假如0：["JSD1202","JSD1203","JSD1204"];
			var classArray = sdataArray[index]
			  for(var i=0;i<classArray.length;i++ )
			  {
				  //创建并加入
				  var op = document.createElement("option");
				  op.innerHTML = classArray[i];
				  $("selClasses").appendChild();
			  }
		}