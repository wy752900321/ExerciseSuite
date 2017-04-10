/*
 * 多行注释
 */	
function SecondMethod()
	{
		//位于js文件中的方法
		alert("code in file");
	}
	function testDataType(){
		var i="100";//string
		var j=100;//number
		if(i==j)//用＝＝比值
				alert("equal");
		else
			alert("no")
		if(i===j)//用===比类型
			alert("same");
		else
			alert("no");
	}

	/*function testDataType(){
		var s="";//s的值由外部传入，非空字符串时，处理
		if(s != "")//
				alert("处理数据");
	}*/
	function calculate(){
		var d = document.getElementById("TestData").value;
		//判断用户录入的是否是数值
		var r = isNaN(d);
		if(r)
			alert("请录入数值")
		else
		{
			//转换为数值
			var number = parseInt(d);
			var result=number*number;
			alert(result);
			
		}
}
	
	function testString()
	{
		/*var s = "abcdeffdadsgcddsf";
		var r = s.substring(1,3);;
		alert(r);*/
		//var s="aaaagcdbbgcdbb";//gcd
		//var r = s.replace("gcd", "*");//把gcd被*号替代
//		var r = s.replace(/gcd/g, "*");
		/*var r = s.replace(/gcd/gi, "*");
		alert(r);*/
		
		var s="aaaaGCDcccGcdcgCD";//
		//判断是否有敏感字符，然后替换
		//search返回找到的首位置
		var i=s.search(/gcd/i);
		alert(i);//4
		
		//显示出来所有gcd的，不管大小写
	/*	var matchData=s.match(/gcd/gi);
		alert(matchData);*/
		
		if(i>-1){
				var r = s.replace(/gcd/gi, "*");
				alert(r);
		}
	}
		function testArray()
		{
			/*var r = new Array();
			r[0]=11;
			r[1]="aaa";
			r[2]=true;
			alert(r.length);*/
//		var r= new Array(11,"aa",true);
			
	/*	var r =[11,"aaa",true];//声明且赋值数组的一种简写
		alert(r.length);
		alert(r[2]);*/
			
	/*		alert(r.toString());//11,aaa,true
			alert(r.join("*"));//11*aaa*true
*/			
			/*var r1 = [1,2,3];
			var r2 =[4,5];
			var result = r1.concat(r2);
			alert(result.toString());
			
			var large = [1,2,3,4,5,6];
			result = large.slice(1, 4);//2,3,4
			alert(result.toString());*/
			
			
			//数组的翻转及排序
			var r = [12,34,123,11,234];
			alert(r.toString());//原有顺序
			
			var newArray = r.reverse();//翻转
			alert(newArray.toString());
			
			var newArray = r.sort();//按照String比较排序
			alert(newArray.toString());//String
			
			//number
			newArray = r.sort(Compare);//使用某个函数对象进行比较
			alert(newArray.toString());
			
		}
		
		function Compare(a,b)
		{
			return a-b;//正数  0   负数
		}
		function testMath()
		{
			//属性
//			alert(Math.PI);
			alert(Math.random());//0=< <1
			alert(Math.floor(32.21));//32
			//随机出3到9之间的整数，包含3，不包含9
			/*var r = Math.random();
			var n = Math.floor(r*(9-3))+3;
			alert(n);*/
			//调用方法随机出3到9之间的整数，包含3，不包含9
			var data = RandomNumber(3,9);
			alert(data);
		}
		//单独封装一个方法：针对min和max，为其产生随机整数
		function RandomNumber(min,max)
		{
			var r = Math.random();
			var n = Math.floor(r*(max-min))+min;
			return n;
		}
		//实验方法的重载
/*		function M1()
		{
			alert("hello,no param");
		}*/
		//M1添加代码：如果没有传入参数，弹出hello;否则，弹出和
		function M2(x,y)
		{
			/*alert(arguments.length);
			alert(arguments[1]);
			alert(x+y);*/
			//arguments:方法中使用它，它代表实际参数的数组
			if(arguments.length==0)
						alert("Hello");
			if(arguments.length==2)
				alert(arguments[0]+arguments[1]);
		}
		
		function testDOM()
		{
			//找到Input元素节点
			var i = document.getElementById("txt1");
//			alert(typeof(i));//object
//			alert(i.value);
			i.value = "aaa";
			
			//img显示某个节点
			var m = document.getElementById("myImage");
			m.src = "bang.gif";
			
			//操作div元素
			var d = document.getElementById("div1");
			d.innerHTML="div text";
			
			
		}