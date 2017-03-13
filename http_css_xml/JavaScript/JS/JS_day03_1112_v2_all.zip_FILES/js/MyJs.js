function fileFunction()
{
	//alert("function in file!");
	//var s = "111";//string
	//var s = 111;//number
	var s = true;//boolean
	alert(typeof(s));
}

function testDataType()
{
	var str1 = "hello";
	var n1 = 12;
	var b1 = true;

	var r1 = str1 + n1;
	alert(r1);//hello12
	var r2 = n1 + b1;
	alert(r2);//13
	var r3 = str1 + b1;
	alert(r3);//hellotrue
}

function add()
{
	var s1 = document.getElementById("txt1").value;//string
	var s2 = document.getElementById("txt2").value;
	var n1 = parseInt(s1);
	var n2 = parseInt(s2);
	alert(n1 + n2);
}

//两个参数都是数值,按照数值加;否则按照string加
function addMethod(n1,n2)
{
	if(typeof(n1) == "number" && typeof(n2) == "number")
	{
		alert(n1 + n2);
	}
	else
	{
		alert(n1.toString() + n2.toString());
	}	
}

function testEqual()
{
	var s1 = "11";
	var s2 = 11;

	if(s1 == s2)
		alert("equal");

	if(s1 === s2)
		alert("same");

	if( "" == 0)// "" true/false
		alert("aaaaa");//aaaaa
}

//获得文本的值,判断,如果不是数值,提示;否则计算平方
function calculateSq()
{
	var s = document.getElementById("txt3").value;
	if( isNaN(s))//is not a number
		alert("请录入数值类型");
	else
	{
		var n = parseFloat(s);
		alert(n*n);
	}
}

function testString()
{
	var s = "abcdefg";
	var r = s.charAt(3);//位置的字符
	alert(r);
	var r1 = s.indexOf("k");//字符的位置
	alert(r1);//-1
/*	
//alert(s.length);
	var result = s.substring(1,4);
	alert(result);//bcd
	var result1 = s.substr(4,2);//ef
	alert(result1);

	var s1 = "12,sd,56";
	var arr = s1.split(",");
	alert(arr.length);*/
}

function verifyString()
{
	//
	var s = document.getElementById("txt4").value;

	//判断录入的数字的位置和内容
	/*var result = s.search(/[0-9]/);
	alert(result);

	//g:global  i:ignour
	var result1 = s.match(/[0-9]+/g);	
	alert(result1);*/

	//将录入中的gcd都替换为*
	//不允许录入大写字母 /[A-Z]/
	var r = s.replace(/gcd/ig,"*");
	document.getElementById("txt4").value = r;
}

function testArray()
{
	//方式一:
	/*var arr = new Array();
	arr[0] = 1;
	arr[1] = "aaa";
	arr[2] = true;*/
	//方式二:
	/*var arr = [1,"aaa",true];

	alert(arr.length);
	alert(arr[1]);

	arr[3] = 234;
	alert(arr.length);*/
	
	var arr = [1,12,45,78,34];
	//alert(arr.toString());

	var arr1 = [9,8];
	var r = arr.concat(arr1);
	alert(r.join("-"));//1-12-45-78-34-9-8
}

function operateArray(t)
{
	var s = document.getElementById("txt5").value;
	var arr = s.split(",");
	var r1;
	switch(t)
	{
		case 1:
			r1 = arr.reverse();
			break;
		case 2:
			r1 = arr.sort();
			break;
		case 3:
			r1 = arr.sort(sortFunc);
			break;
	}
	alert(r1);
}
function sortFunc(a,b)
{
	return b-a;
}

//随机出一个1到7之间的整数(包括1,不包括7)
//Math.round/random(0=< <1)/floor/ceil
function testMath()
{	
	alert(randomInt(1,40));
}

//返回随机数
function randomInt(min,max)
{
	var r = Math.random();
	var result = Math.floor(r * (max-min) + min);
	return result;
}

function same1()
{
	alert("no param");
}

function same1(a,b)
{	
	alert(a+b);
}
//方法:不传入参数,alert;如果传入参数,计算所有参数的和
function useArguments()
{
	var info = "";
	if(arguments.length == 0)
		info = "no param";
	else
	{
		var sum = 0;
		for(var i=0;i<arguments.length;i++)
		{
			sum += arguments[i];
		}
		info = sum.toString();
	}

	document.getElementById("spanInfo").innerHTML = info;
}


function createWin()
{
	/*var arr = new Array(7);

	for(var i=0;i<7;i++)
	{
		var n = randomInt(1,37);
		//判断n是否重复:break,continue
		for()
		arr[i] = n;
	}
	arr.sort(sortFunc);
	document.. = arr.toString();
*/
}

function modifyElement()
{
	var p = document.getElementById("firstP");
	p.innerHTML = "new text";//文本
	p.style.color = "green";//字体颜色
	p.style.backgroundColor = "gray";//背景色
	p.style.fontSize = "30";//字体大小

	//修改样式类
	var d = document.getElementById("firstDiv");
	d.className = "s1";
}

//将所有段落的字体颜色修改为绿色
function findElements()
{
	var els = document.getElementsByTagName("p");
	for(var i=0;i<els.length;i++)
	{
		//得到数组中的某个元素
		els[i].style.color = "green";
	}
}

function changeTabs(index)
{	
	//先找到所有的页签:循环:如果是当前点中的页签,on;否则,off
	var parentDiv = document.getElementById("allTabs");
	var tabs = parentDiv.getElementsByTagName("div");

	for(var i=0;i<tabs.length;i++)
	{
		if(index == i)
			tabs[i].className = "tab_on";
		else
			tabs[i].className = "tab_off";
	}
}

function showMenu(liObject,isShow)
{
	var menuArray = liObject.getElementsByTagName("ul");
	var menu = menuArray[0];

	//显示还是消失
	if(isShow)
		menu.style.display = "block";
	else
		menu.style.display = "none";
}

function verifyName()
{
	var name = $("txtName").value;
	//不允许为空
	if(name == "")	
		document.getElementById("nameInfo").innerHTML = "请录入用户名";
	else
	{
		//验证内容格式
		var reg = /^\d{3}$/;
		var tag = reg.test(name);
		if(!tag)
			document.getElementById("nameInfo").innerHTML = "用户名格式错误";
		else
		{
			document.getElementById("nameInfo").innerHTML = "";
			return true;
		}
	}
	return false;
}

//3到6位的大小写字母/数字的组合
function verifyPwd(){
	var pwd = $("txtPwd").value;
	var reg = /^[A-Za-z0-9]{3,6}$/;
	if(reg.test(pwd)){
		$("pwdInfo").innerHTML = "";
		return true;
	}
	else{
		$("pwdInfo").innerHTML = "密码格式错误";
		return false;
	}
}
//定义一个方法替换document.getElementById
function $(id)
{
	return document.getElementById(id);
}
function verifyAll(){
	//调用各个验证方法
	var r1 = verifyName();
	var r2 = verifyPwd();

	if(r1 && r2)
		return true;
	else
		return false;	
}


function addNewElement()
{
	//按钮的后面添加一个超级链接,文本为Click me,点击后去往a.html  <a href="a.html">Click Me</a>
	var newEle = document.createElement("a");
	newEle.innerHTML = "Click Me";
	newEle.href = "a.html";

	$("parentDiv").appendChild(newEle);

	//创建一个按钮,放置于login按钮之前
	var txt = document.createElement("input");
	txt.type = "button";
	txt.value = "new button";
	
	var pNode = $("form1");
	var refNode = $("btnLogin");
	pNode.insertBefore(txt,refNode);
}

function createClasses()
{
	var sub = $("selSubjects");
	//清除旧数据
	$("selClasses").options.length = 0;

	var dataArray = new Array();
	dataArray[0] = ["--选择班级--"];
	dataArray[1] = ["jsd1111","jsd1112","jsd1201"];
	dataArray[2] = ["tsd1111","tsd1112"];

	//需要的数据
	var showDatas = dataArray[sub.selectedIndex];
	//循环数组,生成option
	for(var i=0;i<showDatas.length;i++)
	{
		var op = document.createElement("option");
		op.innerHTML = showDatas[i];

		$("selClasses").appendChild(op);
	}
}

function operateTable()
{
	/*
	传统的/通用的dom操作
	var td1 = document.createElement("td");
	td1.innerHTML = $("txtName").value;

	var td2 = document.createElement("td");
	td2.innerHTML = $("txtAge").value;

	var tr = document.createElement("tr");
	tr.appendChild(td1);
	tr.appendChild(td2);

	$("table1").appendChild(tr);*/
	
	//特定的table的操作
	var tr = $("table1").insertRow($("table1").rows.length);
	//tr.style.backgroundColor
	//tr.style.fontSize
	//tr.className

	var td1 = tr.insertCell(0);
	td1.innerHTML = $("txtName").value;
	var td2 = tr.insertCell(1);
	td2.innerHTML = $("txtAge").value;
}

function openNewWin()
{
	
	var newWin = window.open("day1.html",
		"name1",
		"width=300,height=200,status=yes");
	newWin.focus();
}

function deleteData()
{
	/*
	var r = confirm("really?");//bool
	return r;*/
	var r = window.prompt("请录入ID:");
	alert(r);//null null
}

function showTime()
{
	var t = new Date();
	$("spanTime").innerHTML = t.toLocaleTimeString();
}
var timer;
function startTime()
{
	timer = window.setInterval("showTime();",1000);
//	timer = window.setInterval(showTime,1000);
}
function stopTime()
{
	window.clearInterval(timer);
}
function openWait()
{
	window.setTimeout("window.open('day1.html');",3000);	
}

function testLocation()
{
	//location.href = "day1.html";
	location.replace("day1.html");
}
var timer1;
function hrefChange()
{
	timer1 = window.setTimeout(testLocation,5000);
}	
function cancelChange()
{
	//取消跳转的时钟
	window.clearTimeout(timer1);
}
//显示所有的属性
function testNavigator()
{
	//遍历一个对象的所有属性
	var message = "";
	for(var pName in navigator)
	{
		var pValue = navigator[pName];
		message += pName + " : " + pValue + "\n";
	}
	//结果写入一个<textarea>元素
	$("tData").innerHTML = message;
}
/*<input type="button" value="测试event对象" 
onclick="testEvent(event);">*/
function testEvent(a)
{	
	if(typeof(event) == "undefined")//firefox
	{
		alert(a.clientX);
	}
	else//ie/opera/chrome
	{
		alert(event.clientX);
	}
}
//得到的引发事件的那个元素对象
function myCalculater(e)
{
	//浏览器兼容性
	var obj;
	if(typeof(event) == "undefined"){
		obj = e.target;//firefox
	}
	else{
		obj = event.srcElement;//other
	}
	//只有点击按钮的时候,才弹出按钮上的数字
	if(obj.nodeName == "INPUT"){
		alert(obj.value);
	}
}
//为按钮准备好的备选方法
function f1()
{
	alert("aaaaaaaaaaaaaaaaaa");
}
function f2()
{
	alert("bbbbbbbbbbbbbbbbb");
}
//页面加载时,为btn1指定一个方法响应点击事件
//body onload="addEventToBtn();"
function addEventToBtn()
{
	$("btn1").onclick = f2;
}

//name;age;isPretty
function useObject(){
	var p = new Object();
	//属性:记载数据
	p.name = "mary";
	p.age = 18;
	p.isPretty = true;

	//方法:定义对象的行为
	//p.sing = singFunc;
	p.sing = function(){
		alert("singing..");
		};//匿名方法	
	
	//访问对象的属性数据
	alert(p.name + ":" + p.age + ":" + p.isPretty);
	p.sing();
}
function singFunc(){
	alert("singing....");
}

//方式二：自定义一个带有构造函数
function Person(n,a,isP){
	//记忆数据
	this.name = n;
	this.age = a;
	this.isPretty = isP;
	//定义行为
	this.introduceSelf = introFunc;}
function introFunc(){
	alert("My name is " + this.name 
		+ ",i am " + this.age 
		+ " years old." + this.isPretty);}
//测试自定义对象
function useMyObject(){
	var p = new Person("mary",23,true);
	p.introduceSelf();

	var p1 = new Person("john",45,false);
	p1.introduceSelf();
}

//使用Json的方式封装数据和行为
function useJson(){
	//封装数据和行为
	var p = {"myName":"mary","age":18,
		"isPretty":false,
		"play":introFuncByJson};
	//解析数据
	alert(p.age);
	p.play();
}
function introFuncByJson(){
	alert("My name is " + this.myName 
		+ ",i am " + this.age 
		+ " years old." + this.isPretty);}