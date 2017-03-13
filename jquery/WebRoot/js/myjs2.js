//当浏览器将整个html内容解析成dom树之后，会
	//执行function里的内容。
	$(function(){
		//相当于 obj.onclick=function(){}
		$('#b1').click(function(){
			$('#d1').html('hello jQuery');
		});
	});