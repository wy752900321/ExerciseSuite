function $(id){
	return document.getElementById(id);
}
function $F(id){
	return document.getElementById(id).value;
}
function getXhr() {
	var xhr = null;
	if (window.XMLHttpRequest) {
					//·Çieä¯ÀÀÆ÷
		xhr = new XMLHttpRequest();
	} else {
					//ieä¯ÀÀÆ÷
		xhr = new ActiveXObject("Microsoft.XMLhttp");
	}
	return xhr;
}

