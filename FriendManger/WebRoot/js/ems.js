
function showTime() {
	var time = new Date();
	$("time").innerHTML = time.toLocaleDateString()+time.toLocaleTimeString();
}

function startTime(){
	timer = window.setInterval(showTime,1000);
}
function check(){
	$('num').src = 'checkCode?'+(new Date()).getTime();
	$('checkMe').innerHTML='';
}
function checkNum(){
	var data = $('checkInput').value;
	var xhr = getXMLHttpRequest();
	xhr.open('get','checkNum.friendAction?userCheck='+data,true);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4){
			var txt = xhr.responseText;
			$('checkMe').innerHTML=txt;
			if(txt!=''){
				$('click').disabled='disabled';
			}
			else{
				$('click').disabled=null;
			}
		}
	};
	xhr.send(null);
}