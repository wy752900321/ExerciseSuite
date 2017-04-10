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










