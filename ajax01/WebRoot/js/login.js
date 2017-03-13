function getXMLHttpRequest() {
	var xhr = null;
	if (window.XMLHttpRequest) {
		//not IE
		xhr = new XMLHttpRequest();
	} else {
		//IE
		xhr = new ActionObject("Microsoft.XMLHttp");
	}
	return xhr;
}
function f1() {
	var xhr = getXMLHttpRequest();
	alert(xhr);
}

function check_username() {
	//构造XMLHttpRequest对象
	var xhr = getXMLHttpRequest();
	//发送请求
	xhr.open('get', 'check_username.do?username=' + $F('username'), true);
	//注册监听器
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4){
			alert(xhr.readyState);
			if(xhr.status==200){
				var txt=xhr.responseText;
				$('username_msg').innerHTML='<img src="img/unchecked.gif"/>' + txt;
			}else{
				$('username_msg').innerHTML='<img src="img/checked.gif"/>'+'系统错误,请稍后重试';
			}
		}else{
			$('username_msg').innerHTML='正在验证中';
		}
	};
	xhr.send(null);
}

function $(id){
	return document.getElementById(id);
}
function $F(id){
	return $(id).value;
}