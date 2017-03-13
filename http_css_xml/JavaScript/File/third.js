function addDataToTable() {
	// 将数据作为一行加入表格
	var row = document.createElement("tr");
	// 创建td
	var td1 = document.createElement("td");
	td1.innerHTML = $("txtName").value;
	row.appendChild(td1);

	var td2 = document.createElement("td");
	td2.innerHTML = $("txtPrice").value;
	row.appendChild(td2);

	// 将tr加入到table
	$("t1").appendChild(row);

}
// table.insertRow(index)deleteRow(index)
// row.insertCell(index)/deleteCell(index)
function addDataToTable1() {
	var t = $("t1");

	// 将新行放置在最下方
	var row = t.insertRow(t.rows.length);// 插入到第几行

	var cell1 = row.insertCell(0);
	cell1.innerHTML = $("txtName").value;

	var cell2 = row.insertCell(0);
	cell2.innerHTML = $("txtPrice").value;
}

function openWin() {
	var newW = window.open("second.html", "aaa", "width=200");
	newW.focus();// 再次点时，使之成为焦点页面
}

function showTime() {
	var d = new Date();
	$("spanTime").innerHTML = d.toLocaleTimeString();
}

var timer;
function startTime() {
	timer = window.setInterval(showTime, 1000);// 是系统的定时器在调用
	// window.setInterval(showTime,1000);//错误，不是我们自己调用
}
function stopTime() {
	window.clearInterval(timer);
}
var timer1;
function waitClose() {
	timer1 = window.setTimeout(addButton, 3000)
}
function addButton() {
	var bu = document.createElement("input");
	bu.type = "button";
	$("form1").appendChild(bu);
}
function clearClose() {
	window.clearInterval(timer1);
}
function deleteDate() {
	// window.confirm("Are you really-----?");//没有真实提交,录入一些信息进行测试
	var r = window.confirm("Are you really-----?");// 没有真实提交
	return r;// 返回true或false
}
function inputData() {
	var r = window.prompt("请录入ID：");
	alert(r);
}
function testLocation() {
	// alert(window.location.href);
	// alert(location.href);
	location.href = "second.html";
	// location.replace("second.html");
}
function testDocument() {
	document.write(history.length);
}
function calculate(event) {
	// 页上示navigargt对象所有的属性和
	/*
	 * for ( var p in navigator) { document.write(p + ":" + navigator[p] + "<br>"); }
	 */
	// 用的是IE／火狐／Chrom
	// MSIE Firefox Chrome
	/*
	 * var index = navigator.userAgent.indexOf("Firefox"); if (index > -1)
	 * alert("Firefox浏览器") else alert("其它浏览器");
	 */
	// 获取点击的子元素
	var obj = e.sreElement || e.target;
	if (obj.nodeName == "INPUT") {
		if (obj.type == "button")
			alert(obj.value);
	}
}
function addEvent() {
	var i = 12;
	if (i > 10)
		$("btn1").onclick = MMM;
	else
		$("btn1").onclick = function() {
			alert("匿名函数");
		};
}
function MMM() {
	alert("aaa");
}
function testObject() {
	// 封装 数据：mary 18 true
	var p = new Object();
	p.name="mary";
	p.age=18;
	p.isG = true;
	//定义行为：方法
	p.sing = MMM;
	p.swim = function(){alert('bbbb')};
	//测试
	alert(p.name);
	alert(p.address);//undefined
	p.sing();
	p.sweim();
}
//定义一个自定义的对象Student
//使用关键字this
function Student(name,a,isGra)
{
	this.name = name;//this.属性＝属性名
	this.age = a;
	this.isG= isGra
	//方法
	this.introduceSelf = intro;//func对象匿名函数
}
function intro()
{
	//i am, i am years old ,t
	alert("i am "+this.name+",i am"+this.age+"years old"+this.isG);
}
//按钮点击事件调用
function testStudent()
{
	var s = new Student("mary",18,true);
	var s1 = new Student("john",23,false);
	//test
	alert(s.name);
	alert(s1.age);
	s.introduceSelf();
	s1.introduceSelf();
}
function testJson()
{
	var p = {"name":"mary","age":18,"isG":true,"sing":MMM};
	alert(p.name);
	p.sing();
}

