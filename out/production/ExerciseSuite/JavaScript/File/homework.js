function fun() {
	findBlue();
	findRed();
}
function findRed() {
	var ar = new Array();
	var count = 0;
	while (true) {
			n = RandomNumber(1,33);
//		n = Math.floor(Math.random() * (33 - 1) + (1 - 0));
		if (constain(ar, n)) {
			continue;
		}
		ar[count] = n;
		if (count == 6) {
			break;
		}
		count++;
	}
	var result = ar.slice(0, 6);
	var newArray = result.sort(c);
	var d = document.getElementById("span1");
	d.innerHTML=newArray;
}

function constain(ar,n)
{
	for(i=0;i<ar.length;i++)
	{
		if(ar[i]==n){
			return true;
		}
	}
}
function c(a,b)
{
	return a-b;
}
function findBlue()
{
	var r = Math.random();
//	var n = Math.floor(r*(17-1))+(1-0);
	var n = RandomNumber(1,17);
	var d = document.getElementById("span2");
	d.innerHTML=n;
}
//单独封装一个方法：针对min和max，为其产生随机整数
function RandomNumber(min,max)
{
	var r = Math.random();
	var n = Math.floor(r*(max-min))+min;
	return n;
}