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





