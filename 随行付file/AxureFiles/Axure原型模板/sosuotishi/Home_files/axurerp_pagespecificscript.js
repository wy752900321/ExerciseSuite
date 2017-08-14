
var PageName = 'Home';
var PageId = 'pc2b5c7a75871406097d8779c9b29397b'
var PageUrl = 'Home.html'
document.title = 'Home';

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
    if (pair[0].length > 0) eval("$" + pair[0] + " = decodeURIComponent(pair[1]);");
} 

if (hasQuery && $CSUM != 1) {
alert('Prototype Warning: Variable values were truncated.');
}

function GetQuerystring() {
    return '#OnLoadVariable=' + encodeURIComponent($OnLoadVariable) + '&CSUM=1';
}

function PopulateVariables(value) {
  value = value.replace(/\[\[OnLoadVariable\]\]/g, $OnLoadVariable);
  value = value.replace(/\[\[PageName\]\]/g, PageName);
  return value;
}

function OnLoad() {

if (true) {

SetWidgetFormText('u4', PopulateVariables('111个课程'));

SetGlobalVariableValue('$OnLoadVariable', PopulateVariables('1'));

}

}

var u10 = document.getElementById('u10');

u10.style.cursor = 'pointer';
if (bIE) u10.attachEvent("onclick", Clicku10);
else u10.addEventListener("click", Clicku10, true);
function Clicku10(e)
{

if (true) {

	self.location.href="http://webppd.5d6d.com/thread-66-1-1.html" + "";

}

}
gv_vAlignTable['u10'] = 'top';
var u5 = document.getElementById('u5');

var u0 = document.getElementById('u0');

var u3 = document.getElementById('u3');
gv_vAlignTable['u3'] = 'center';
var u9 = document.getElementById('u9');
gv_vAlignTable['u9'] = 'top';
var u6 = document.getElementById('u6');

if (bIE) u6.attachEvent("onchange", Changeu6);
else u6.addEventListener("change", Changeu6, true);
function Changeu6(e)
{

if ((GetSelectedOption('u6')) == (PopulateVariables('课程'))) {

SetWidgetFormText('u4', PopulateVariables('111个课程'));

SetGlobalVariableValue('$OnLoadVariable', PopulateVariables('1'));

}
else
if ((GetSelectedOption('u6')) == (PopulateVariables('附件'))) {

SetWidgetFormText('u4', PopulateVariables('222个附件'));

SetGlobalVariableValue('$OnLoadVariable', PopulateVariables('2'));

}
else
if ((GetSelectedOption('u6')) == (PopulateVariables('讨论'))) {

SetWidgetFormText('u4', PopulateVariables('333篇讨论'));

SetGlobalVariableValue('$OnLoadVariable', PopulateVariables('3'));

}
else
if ((GetSelectedOption('u6')) == (PopulateVariables('讲师'))) {

SetWidgetFormText('u4', PopulateVariables('444位讲师'));

SetGlobalVariableValue('$OnLoadVariable', PopulateVariables('4'));

}

}

var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
var u12 = document.getElementById('u12');

u12.style.cursor = 'pointer';
if (bIE) u12.attachEvent("onclick", Clicku12);
else u12.addEventListener("click", Clicku12, true);
function Clicku12(e)
{

if (true) {

	self.location.href="http://webppd.5d6d.com" + "";

}

}
gv_vAlignTable['u12'] = 'top';
var u4 = document.getElementById('u4');

if (bIE) u4.attachEvent("onfocus", Focusu4);
else u4.addEventListener("focus", Focusu4, true);
function Focusu4(e)
{

if (((GetWidgetFormText('u4')) == (PopulateVariables('111个课程'))) || (((GetWidgetFormText('u4')) == (PopulateVariables('222个附件'))) || (((GetWidgetFormText('u4')) == (PopulateVariables('333篇讨论'))) || ((GetWidgetFormText('u4')) == (PopulateVariables('444位讲师')))))) {

SetWidgetFormText('u4', PopulateVariables(''));

}

}

if (bIE) u4.attachEvent("onblur", LostFocusu4);
else u4.addEventListener("blur", LostFocusu4, true);
function LostFocusu4(e)
{

if (((GetGlobalVariableValue('$OnLoadVariable')) == (PopulateVariables('1'))) && ((GetWidgetFormText('u4')) == (PopulateVariables('')))) {

SetWidgetFormText('u4', PopulateVariables('111个课程'));

}
else
if (((GetGlobalVariableValue('$OnLoadVariable')) == (PopulateVariables('2'))) && ((GetWidgetFormText('u4')) == (PopulateVariables('')))) {

SetWidgetFormText('u4', PopulateVariables('222个附件'));

}
else
if (((GetGlobalVariableValue('$OnLoadVariable')) == (PopulateVariables('3'))) && ((GetWidgetFormText('u4')) == (PopulateVariables('')))) {

SetWidgetFormText('u4', PopulateVariables('333篇讨论'));

}
else
if (((GetGlobalVariableValue('$OnLoadVariable')) == (PopulateVariables('4'))) && ((GetWidgetFormText('u4')) == (PopulateVariables('')))) {

SetWidgetFormText('u4', PopulateVariables('444位讲师'));

}

}

var u11 = document.getElementById('u11');
gv_vAlignTable['u11'] = 'top';
var u7 = document.getElementById('u7');
gv_vAlignTable['u7'] = 'top';
var u2 = document.getElementById('u2');

var u8 = document.getElementById('u8');
gv_vAlignTable['u8'] = 'top';
if (window.OnLoad) OnLoad();
