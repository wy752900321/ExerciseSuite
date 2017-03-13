/**
 * 
 * @param {Object} id
 * @return {TypeName} 
 */
function $(id){
	return document.getElementById(id);
}
/**
 * 
 * @param {Object} reticle
 * @return {TypeName} 
 */
function $create(reticle){
	return document.createElement(reticle);
}
function getXMLHttpRequest(){
	var xhr;
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest();
	}
	else{
		xhr = new ActiveObject("Microsoft.XMLHttpRequest");
	}
	return xhr;
}