function f2(){
	var obj2 = document.getElementById('d1');
	obj2.innerHTML = 'hello jQuery';
}
window.onload = function(){
	var obj = document.getElementById('b1');
	obj.onclick = f2;
};

