
var PageName = '验证邮箱邮件';
var PageId = 'p1b8c6bca85d041d082a1ff24972db9b3'
var PageUrl = '验证邮箱邮件.html'
document.title = '验证邮箱邮件';

if (top.location != self.location)
{
	if (parent.HandleMainFrameChanged) {
		parent.HandleMainFrameChanged();
	}
}

var $OnLoadVariable = '';

var $CSUM;

var hasQuery = false;
var query = window.location.hash.substring(1);
if (query.length > 0) hasQuery = true;
var vars = query.split("&");
for (var i = 0; i < vars.length; i++) {
    var pair = vars[i].split("=");
    if (pair[0].length > 0) eval("$" + pair[0] + " = decodeURI(pair[1]);");
} 

if (hasQuery && $CSUM != 1) {
alert('Prototype Warning: Variable values were truncated.');
}

function GetQuerystring() {
    return encodeURI('#OnLoadVariable=' + $OnLoadVariable + '&CSUM=1');
}

function PopulateVariables(value) {
  value = value.replace(/\[\[OnLoadVariable\]\]/g, $OnLoadVariable);
  value = value.replace(/\[\[PageName\]\]/g, PageName);
  return value;
}

function OnLoad() {

}

var u10 = document.getElementById('u10');

u10.style.cursor = 'pointer';
if (bIE) u10.attachEvent("onclick", Clicku10);
else u10.addEventListener("click", Clicku10, true);
function Clicku10(e)
{

if (true) {

	self.location.href="首页.html" + GetQuerystring();

}

}
gv_vAlignTable['u10'] = 'top';
var u5 = document.getElementById('u5');
gv_vAlignTable['u5'] = 'top';
var u0 = document.getElementById('u0');

var u3 = document.getElementById('u3');
gv_vAlignTable['u3'] = 'top';
var u9 = document.getElementById('u9');
gv_vAlignTable['u9'] = 'center';
var u6 = document.getElementById('u6');

var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
var u4 = document.getElementById('u4');

u4.style.cursor = 'pointer';
if (bIE) u4.attachEvent("onclick", u4Click);
else u4.addEventListener("click", u4Click, true);
InsertAfterBegin(document.body, "<DIV class='intcases' id='u4LinksClick'></DIV>")
var u4LinksClick = document.getElementById('u4LinksClick');
function u4Click(e) 
{

	ToggleLinks(e, 'u4LinksClick');
}

InsertBeforeEnd(u4LinksClick, "<div class='intcaselink' onmouseout='SuppressBubble(event)' onclick='u4Clickud2f34af8199540c4bc532bd585bf8648(event)'>头一次使用</div>");
function u4Clickud2f34af8199540c4bc532bd585bf8648(e)
{

	self.location.href="完成注册.html" + GetQuerystring();

	ToggleLinks(e, 'u4LinksClick');
}

InsertBeforeEnd(u4LinksClick, "<div class='intcaselink' onmouseout='SuppressBubble(event)' onclick='u4Clickua590afe707c546f5b2cd4ed2de895272(event)'>地址被使用过之后</div>");
function u4Clickua590afe707c546f5b2cd4ed2de895272(e)
{

	self.location.href="当注册地址使用过后.html" + GetQuerystring();

	ToggleLinks(e, 'u4LinksClick');
}
gv_vAlignTable['u4'] = 'top';
var u7 = document.getElementById('u7');
gv_vAlignTable['u7'] = 'center';
var u2 = document.getElementById('u2');
gv_vAlignTable['u2'] = 'top';
var u8 = document.getElementById('u8');

if (window.OnLoad) OnLoad();
