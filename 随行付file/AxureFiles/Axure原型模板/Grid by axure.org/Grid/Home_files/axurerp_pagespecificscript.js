
var PageName = 'Home';
var PageId = 'pbbbb1a76d7a241da953e2794c4f10617'
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

}

eval(GetDynamicPanelScript('u83', 1));

var u86 = document.getElementById('u86');

var u54 = document.getElementById('u54');
gv_vAlignTable['u54'] = 'center';
var u60 = document.getElementById('u60');
gv_vAlignTable['u60'] = 'center';
var u29 = document.getElementById('u29');

var u45 = document.getElementById('u45');

var u83 = document.getElementById('u83');

var u51 = document.getElementById('u51');

var u79 = document.getElementById('u79');

u79.style.cursor = 'pointer';
if (bIE) u79.attachEvent("onclick", u79Click);
else u79.addEventListener("click", u79Click, true);
InsertAfterBegin(document.body, "<DIV class='intcases' id='u79LinksClick'></DIV>")
var u79LinksClick = document.getElementById('u79LinksClick');
function u79Click(e) 
{

	ToggleLinks(e, 'u79LinksClick');
}

InsertBeforeEnd(u79LinksClick, "<div class='intcaselink' onmouseout='SuppressBubble(event)' onclick='u79Clicku43d20ed7e6a24d1abd5c956072320396(event)'>下载地址一：box.net</div>");
function u79Clicku43d20ed7e6a24d1abd5c956072320396(e)
{

	NewWindow("http://www.box.net/shared/zkzxmfv4vt" + "", "", "directories=1, height=500, location=1, menubar=1, resizable=1, scrollbars=1, status=1, toolbar=1, width=500", true, 500, 500);

	ToggleLinks(e, 'u79LinksClick');
}

InsertBeforeEnd(u79LinksClick, "<div class='intcaselink' onmouseout='SuppressBubble(event)' onclick='u79Clickud0ddec4e19fe4153904d4d22470450fa(event)'>下载地址二：skydrive.live.com</div>");
function u79Clickud0ddec4e19fe4153904d4d22470450fa(e)
{

	NewWindow("http://cid-e53ab38e4f6639a4.skydrive.live.com/self.aspx/webppd/Grid%20by%20axure.org.rar" + "", "", "directories=1, height=500, location=1, menubar=1, resizable=1, scrollbars=1, status=1, toolbar=1, width=500", true, 500, 500);

	ToggleLinks(e, 'u79LinksClick');
}

var u42 = document.getElementById('u42');
gv_vAlignTable['u42'] = 'center';
var u80 = document.getElementById('u80');

var u26 = document.getElementById('u26');
gv_vAlignTable['u26'] = 'top';
var u5 = document.getElementById('u5');
gv_vAlignTable['u5'] = 'top';
var u23 = document.getElementById('u23');

var u76 = document.getElementById('u76');
gv_vAlignTable['u76'] = 'center';
var u14 = document.getElementById('u14');

var u67 = document.getElementById('u67');

u67.style.cursor = 'pointer';
if (bIE) u67.attachEvent("onclick", ClickLinkToReferencePageu67);
else u67.addEventListener("click", ClickLinkToReferencePageu67, true);
function ClickLinkToReferencePageu67(e)
{
    self.location.href="40-15.html" + GetQuerystring();
}

x = 0;
y = (u67.offsetHeight) - 4;
InsertAfterBegin(u67ann, "<img src='Resources/newwindow.gif' id='u67PagePopup' style='cursor:pointer;position:absolute;z-index:500;left:" + x + ";top:" + y + "'>");

var u67PagePopup = document.getElementById('u67PagePopup');
if (bIE) u67PagePopup.attachEvent("onclick", u67PagePopupHandler);
else u67PagePopup.addEventListener("click", u67PagePopupHandler, true);

function u67PagePopupHandler(event)
{
    window.open("40-15.html" + GetQuerystring());
}

var u20 = document.getElementById('u20');
gv_vAlignTable['u20'] = 'top';
var u73 = document.getElementById('u73');

u73.style.cursor = 'pointer';
if (bIE) u73.attachEvent("onclick", ClickLinkToReferencePageu73);
else u73.addEventListener("click", ClickLinkToReferencePageu73, true);
function ClickLinkToReferencePageu73(e)
{
    self.location.href="60-15.html" + GetQuerystring();
}

x = 0;
y = (u73.offsetHeight) - 4;
InsertAfterBegin(u73ann, "<img src='Resources/newwindow.gif' id='u73PagePopup' style='cursor:pointer;position:absolute;z-index:500;left:" + x + ";top:" + y + "'>");

var u73PagePopup = document.getElementById('u73PagePopup');
if (bIE) u73PagePopup.attachEvent("onclick", u73PagePopupHandler);
else u73PagePopup.addEventListener("click", u73PagePopupHandler, true);

function u73PagePopupHandler(event)
{
    window.open("60-15.html" + GetQuerystring());
}

var u48 = document.getElementById('u48');

var u4 = document.getElementById('u4');
gv_vAlignTable['u4'] = 'top';
var u11 = document.getElementById('u11');
gv_vAlignTable['u11'] = 'top';
var u64 = document.getElementById('u64');
gv_vAlignTable['u64'] = 'center';
var u70 = document.getElementById('u70');
gv_vAlignTable['u70'] = 'center';
var u39 = document.getElementById('u39');

var u87 = document.getElementById('u87');
gv_vAlignTable['u87'] = 'center';
var u55 = document.getElementById('u55');
gv_vAlignTable['u55'] = 'top';
var u61 = document.getElementById('u61');

u61.style.cursor = 'pointer';
if (bIE) u61.attachEvent("onclick", ClickLinkToReferencePageu61);
else u61.addEventListener("click", ClickLinkToReferencePageu61, true);
function ClickLinkToReferencePageu61(e)
{
    self.location.href="30-15.html" + GetQuerystring();
}

x = 0;
y = (u61.offsetHeight) - 4;
InsertAfterBegin(u61ann, "<img src='Resources/newwindow.gif' id='u61PagePopup' style='cursor:pointer;position:absolute;z-index:500;left:" + x + ";top:" + y + "'>");

var u61PagePopup = document.getElementById('u61PagePopup');
if (bIE) u61PagePopup.attachEvent("onclick", u61PagePopupHandler);
else u61PagePopup.addEventListener("click", u61PagePopupHandler, true);

function u61PagePopupHandler(event)
{
    window.open("30-15.html" + GetQuerystring());
}

var u84 = document.getElementById('u84');

var u52 = document.getElementById('u52');
gv_vAlignTable['u52'] = 'center';
var u36 = document.getElementById('u36');
gv_vAlignTable['u36'] = 'center';
var u89 = document.getElementById('u89');

var u81 = document.getElementById('u81');
gv_vAlignTable['u81'] = 'top';
var u27 = document.getElementById('u27');

var u33 = document.getElementById('u33');

var u0 = document.getElementById('u0');

var u24 = document.getElementById('u24');
gv_vAlignTable['u24'] = 'top';
var u77 = document.getElementById('u77');
gv_vAlignTable['u77'] = 'top';
var u30 = document.getElementById('u30');
gv_vAlignTable['u30'] = 'center';
var u58 = document.getElementById('u58');

var u15 = document.getElementById('u15');
gv_vAlignTable['u15'] = 'top';
var u21 = document.getElementById('u21');

var u74 = document.getElementById('u74');
gv_vAlignTable['u74'] = 'center';
var u49 = document.getElementById('u49');

var u12 = document.getElementById('u12');

var u65 = document.getElementById('u65');

u65.style.cursor = 'pointer';
if (bIE) u65.attachEvent("onclick", ClickLinkToReferencePageu65);
else u65.addEventListener("click", ClickLinkToReferencePageu65, true);
function ClickLinkToReferencePageu65(e)
{
    self.location.href="40-10.html" + GetQuerystring();
}

x = 0;
y = (u65.offsetHeight) - 4;
InsertAfterBegin(u65ann, "<img src='Resources/newwindow.gif' id='u65PagePopup' style='cursor:pointer;position:absolute;z-index:500;left:" + x + ";top:" + y + "'>");

var u65PagePopup = document.getElementById('u65PagePopup');
if (bIE) u65PagePopup.attachEvent("onclick", u65PagePopupHandler);
else u65PagePopup.addEventListener("click", u65PagePopupHandler, true);

function u65PagePopupHandler(event)
{
    window.open("40-10.html" + GetQuerystring());
}

var u71 = document.getElementById('u71');

u71.style.cursor = 'pointer';
if (bIE) u71.attachEvent("onclick", ClickLinkToReferencePageu71);
else u71.addEventListener("click", ClickLinkToReferencePageu71, true);
function ClickLinkToReferencePageu71(e)
{
    self.location.href="60-10.html" + GetQuerystring();
}

x = 0;
y = (u71.offsetHeight) - 4;
InsertAfterBegin(u71ann, "<img src='Resources/newwindow.gif' id='u71PagePopup' style='cursor:pointer;position:absolute;z-index:500;left:" + x + ";top:" + y + "'>");

var u71PagePopup = document.getElementById('u71PagePopup');
if (bIE) u71PagePopup.attachEvent("onclick", u71PagePopupHandler);
else u71PagePopup.addEventListener("click", u71PagePopupHandler, true);

function u71PagePopupHandler(event)
{
    window.open("60-10.html" + GetQuerystring());
}

var u62 = document.getElementById('u62');
gv_vAlignTable['u62'] = 'center';
var u46 = document.getElementById('u46');
gv_vAlignTable['u46'] = 'center';
var u85 = document.getElementById('u85');
gv_vAlignTable['u85'] = 'center';
var u37 = document.getElementById('u37');
gv_vAlignTable['u37'] = 'top';
var u43 = document.getElementById('u43');

var u17 = document.getElementById('u17');
gv_vAlignTable['u17'] = 'top';
var u18 = document.getElementById('u18');

var u82 = document.getElementById('u82');

u82.style.cursor = 'pointer';
if (bIE) u82.attachEvent("onclick", Clicku82);
else u82.addEventListener("click", Clicku82, true);
function Clicku82(e)
{

if (true) {

	SetPanelVisibilityu83("");

}

}

var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
var u34 = document.getElementById('u34');
gv_vAlignTable['u34'] = 'center';
var u40 = document.getElementById('u40');
gv_vAlignTable['u40'] = 'center';
var u68 = document.getElementById('u68');
gv_vAlignTable['u68'] = 'center';
var u25 = document.getElementById('u25');
gv_vAlignTable['u25'] = 'top';
var u31 = document.getElementById('u31');

var u59 = document.getElementById('u59');

u59.style.cursor = 'pointer';
if (bIE) u59.attachEvent("onclick", ClickLinkToReferencePageu59);
else u59.addEventListener("click", ClickLinkToReferencePageu59, true);
function ClickLinkToReferencePageu59(e)
{
    self.location.href="30-10.html" + GetQuerystring();
}

x = 0;
y = (u59.offsetHeight) - 4;
InsertAfterBegin(u59ann, "<img src='Resources/newwindow.gif' id='u59PagePopup' style='cursor:pointer;position:absolute;z-index:500;left:" + x + ";top:" + y + "'>");

var u59PagePopup = document.getElementById('u59PagePopup');
if (bIE) u59PagePopup.attachEvent("onclick", u59PagePopupHandler);
else u59PagePopup.addEventListener("click", u59PagePopupHandler, true);

function u59PagePopupHandler(event)
{
    window.open("30-10.html" + GetQuerystring());
}

var u22 = document.getElementById('u22');
gv_vAlignTable['u22'] = 'top';
var u75 = document.getElementById('u75');

u75.style.cursor = 'pointer';
if (bIE) u75.attachEvent("onclick", ClickLinkToReferencePageu75);
else u75.addEventListener("click", ClickLinkToReferencePageu75, true);
function ClickLinkToReferencePageu75(e)
{
    self.location.href="60-20.html" + GetQuerystring();
}

x = 0;
y = (u75.offsetHeight) - 4;
InsertAfterBegin(u75ann, "<img src='Resources/newwindow.gif' id='u75PagePopup' style='cursor:pointer;position:absolute;z-index:500;left:" + x + ";top:" + y + "'>");

var u75PagePopup = document.getElementById('u75PagePopup');
if (bIE) u75PagePopup.attachEvent("onclick", u75PagePopupHandler);
else u75PagePopup.addEventListener("click", u75PagePopupHandler, true);

function u75PagePopupHandler(event)
{
    window.open("60-20.html" + GetQuerystring());
}

var u88 = document.getElementById('u88');

u88.style.cursor = 'pointer';
if (bIE) u88.attachEvent("onclick", Clicku88);
else u88.addEventListener("click", Clicku88, true);
function Clicku88(e)
{

if (true) {

	SetPanelVisibilityu83("hidden");

}

}

var u8 = document.getElementById('u8');

u8.style.cursor = 'pointer';
if (bIE) u8.attachEvent("onclick", Clicku8);
else u8.addEventListener("click", Clicku8, true);
function Clicku8(e)
{

if (true) {

	NewWindow("http://v.axure.org" + "", "", "directories=1, height=500, location=1, menubar=1, resizable=1, scrollbars=1, status=1, toolbar=1, width=500", true, 500, 500);

}

}
gv_vAlignTable['u8'] = 'top';
var u72 = document.getElementById('u72');
gv_vAlignTable['u72'] = 'center';
var u56 = document.getElementById('u56');
gv_vAlignTable['u56'] = 'top';
var u47 = document.getElementById('u47');

var u53 = document.getElementById('u53');

var u28 = document.getElementById('u28');
gv_vAlignTable['u28'] = 'center';
var u2 = document.getElementById('u2');

var u44 = document.getElementById('u44');
gv_vAlignTable['u44'] = 'center';
var u50 = document.getElementById('u50');
gv_vAlignTable['u50'] = 'center';
var u19 = document.getElementById('u19');
gv_vAlignTable['u19'] = 'top';
var u78 = document.getElementById('u78');

u78.style.cursor = 'pointer';
if (bIE) u78.attachEvent("onclick", Clicku78);
else u78.addEventListener("click", Clicku78, true);
function Clicku78(e)
{

if (true) {

	NewWindow("http://webppd.5d6d.com/thread-66-1-1.html" + "", "", "directories=1, height=500, location=1, menubar=1, resizable=1, scrollbars=1, status=1, toolbar=1, width=500", true, 500, 500);

}

}
gv_vAlignTable['u78'] = 'top';
var u7 = document.getElementById('u7');

u7.style.cursor = 'pointer';
if (bIE) u7.attachEvent("onclick", Clicku7);
else u7.addEventListener("click", Clicku7, true);
function Clicku7(e)
{

if (true) {

	NewWindow("http://www.axure.org" + "", "", "directories=1, height=500, location=1, menubar=1, resizable=1, scrollbars=1, status=1, toolbar=1, width=500", true, 500, 500);

}

}

var u41 = document.getElementById('u41');

var u69 = document.getElementById('u69');

u69.style.cursor = 'pointer';
if (bIE) u69.attachEvent("onclick", ClickLinkToReferencePageu69);
else u69.addEventListener("click", ClickLinkToReferencePageu69, true);
function ClickLinkToReferencePageu69(e)
{
    self.location.href="40-20.html" + GetQuerystring();
}

x = 0;
y = (u69.offsetHeight) - 4;
InsertAfterBegin(u69ann, "<img src='Resources/newwindow.gif' id='u69PagePopup' style='cursor:pointer;position:absolute;z-index:500;left:" + x + ";top:" + y + "'>");

var u69PagePopup = document.getElementById('u69PagePopup');
if (bIE) u69PagePopup.attachEvent("onclick", u69PagePopupHandler);
else u69PagePopup.addEventListener("click", u69PagePopupHandler, true);

function u69PagePopupHandler(event)
{
    window.open("40-20.html" + GetQuerystring());
}

var u32 = document.getElementById('u32');
gv_vAlignTable['u32'] = 'center';
var u16 = document.getElementById('u16');
gv_vAlignTable['u16'] = 'top';
var u9 = document.getElementById('u9');

var u13 = document.getElementById('u13');
gv_vAlignTable['u13'] = 'top';
var u66 = document.getElementById('u66');
gv_vAlignTable['u66'] = 'center';
var u6 = document.getElementById('u6');

var u35 = document.getElementById('u35');

var u57 = document.getElementById('u57');
gv_vAlignTable['u57'] = 'top';
var u10 = document.getElementById('u10');
gv_vAlignTable['u10'] = 'center';
var u63 = document.getElementById('u63');

u63.style.cursor = 'pointer';
if (bIE) u63.attachEvent("onclick", ClickLinkToReferencePageu63);
else u63.addEventListener("click", ClickLinkToReferencePageu63, true);
function ClickLinkToReferencePageu63(e)
{
    self.location.href="30-20.html" + GetQuerystring();
}

x = 0;
y = (u63.offsetHeight) - 4;
InsertAfterBegin(u63ann, "<img src='Resources/newwindow.gif' id='u63PagePopup' style='cursor:pointer;position:absolute;z-index:500;left:" + x + ";top:" + y + "'>");

var u63PagePopup = document.getElementById('u63PagePopup');
if (bIE) u63PagePopup.attachEvent("onclick", u63PagePopupHandler);
else u63PagePopup.addEventListener("click", u63PagePopupHandler, true);

function u63PagePopupHandler(event)
{
    window.open("30-20.html" + GetQuerystring());
}

var u38 = document.getElementById('u38');
gv_vAlignTable['u38'] = 'top';
var u3 = document.getElementById('u3');
gv_vAlignTable['u3'] = 'center';
if (window.OnLoad) OnLoad();
