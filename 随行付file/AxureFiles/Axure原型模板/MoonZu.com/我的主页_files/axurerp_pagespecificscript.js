
var PageName = '我的主页';
var PageId = 'p434256c858b846fe8cf20af360e1bcdb'
var PageUrl = '我的主页.html'
document.title = '我的主页';

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

eval(GetDynamicPanelScript('u12', 2));

var u20 = document.getElementById('u20');

u20.style.cursor = 'pointer';
if (bIE) u20.attachEvent("onclick", u20Click);
else u20.addEventListener("click", u20Click, true);
InsertAfterBegin(document.body, "<DIV class='intcases' id='u20LinksClick'></DIV>")
var u20LinksClick = document.getElementById('u20LinksClick');
function u20Click(e) 
{

	ToggleLinks(e, 'u20LinksClick');
}

InsertBeforeEnd(u20LinksClick, "<div class='intcaselink' onmouseout='SuppressBubble(event)' onclick='u20Clicku434fd4fabe3a4e52912f7ce70d879b8f(event)'>到达登录页</div>");
function u20Clicku434fd4fabe3a4e52912f7ce70d879b8f(e)
{

	self.location.href="登录页.html" + GetQuerystring();

	ToggleLinks(e, 'u20LinksClick');
}

InsertBeforeEnd(u20LinksClick, "<div class='intcaselink' onmouseout='SuppressBubble(event)' onclick='u20Clicku15822a33c5de489490b024ee7b5dc753(event)'>显示登录状态</div>");
function u20Clicku15822a33c5de489490b024ee7b5dc753(e)
{

	SetPanelStateu12("pd0u12");

	ToggleLinks(e, 'u20LinksClick');
}
gv_vAlignTable['u20'] = 'top';
var u36 = document.getElementById('u36');

var u31 = document.getElementById('u31');
gv_vAlignTable['u31'] = 'center';
var u11 = document.getElementById('u11');
gv_vAlignTable['u11'] = 'center';
var u27 = document.getElementById('u27');
gv_vAlignTable['u27'] = 'center';
var u6 = document.getElementById('u6');

var u4 = document.getElementById('u4');

u4.style.cursor = 'pointer';
if (bIE) u4.attachEvent("onclick", Clicku4);
else u4.addEventListener("click", Clicku4, true);
function Clicku4(e)
{

if (true) {

	self.location.href="首页.html" + GetQuerystring();

}

}

var u2 = document.getElementById('u2');

var u10 = document.getElementById('u10');

u10.style.cursor = 'pointer';
if (bIE) u10.attachEvent("onclick", Clicku10);
else u10.addEventListener("click", Clicku10, true);
function Clicku10(e)
{

if (true) {

	self.location.href=PageUrl + GetQuerystring();
    window.location.reload();

}

}

var u0 = document.getElementById('u0');

var u26 = document.getElementById('u26');

var u35 = document.getElementById('u35');
gv_vAlignTable['u35'] = 'center';
var u29 = document.getElementById('u29');
gv_vAlignTable['u29'] = 'center';
var u8 = document.getElementById('u8');

var u34 = document.getElementById('u34');

var u14 = document.getElementById('u14');
gv_vAlignTable['u14'] = 'top';
var u28 = document.getElementById('u28');

var u33 = document.getElementById('u33');
gv_vAlignTable['u33'] = 'center';
var u22 = document.getElementById('u22');

var u13 = document.getElementById('u13');
gv_vAlignTable['u13'] = 'top';
var u12 = document.getElementById('u12');

var u21 = document.getElementById('u21');
gv_vAlignTable['u21'] = 'top';
var u37 = document.getElementById('u37');
gv_vAlignTable['u37'] = 'center';
var u7 = document.getElementById('u7');
gv_vAlignTable['u7'] = 'center';
var u17 = document.getElementById('u17');
gv_vAlignTable['u17'] = 'top';
var u5 = document.getElementById('u5');
gv_vAlignTable['u5'] = 'center';
var u15 = document.getElementById('u15');
gv_vAlignTable['u15'] = 'top';
var u3 = document.getElementById('u3');
gv_vAlignTable['u3'] = 'center';
var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
var u25 = document.getElementById('u25');
gv_vAlignTable['u25'] = 'center';
var u16 = document.getElementById('u16');

x = 0;
y = 0;
InsertAfterBegin(u16ann, "<div id='u16Note' class='annnoteimage' style='left:" + x + ";top:" + y + "' onclick=\"ToggleWorkflow(event, 'u16', 300, 300, false)\"></div>");

eval(annwindow.replace(/\[\[id\]\]/g, 'u16').replace(/\[\[label\]\]/g, "?"));

InsertAfterBegin(document.body, "<div id='u16based' style='z-index:1; visibility:hidden; position:absolute'></div><div id='u16base' style='z-index:1; visibility:hidden; position:absolute'></div>");
var u16based = document.getElementById('u16based');
            
InsertBeforeEnd(u16based, "<div class='anncontent'><span class='annfieldname'>Specification:</span> 点退出，退出登录状态。<BR><BR></div>");

u16.style.cursor = 'pointer';
if (bIE) u16.attachEvent("onclick", Clicku16);
else u16.addEventListener("click", Clicku16, true);
function Clicku16(e)
{

if (true) {

	SetPanelStateu12("pd1u12");

}

}
gv_vAlignTable['u16'] = 'top';
var u39 = document.getElementById('u39');
gv_vAlignTable['u39'] = 'center';
var u19 = document.getElementById('u19');

u19.style.cursor = 'pointer';
if (bIE) u19.attachEvent("onclick", Clicku19);
else u19.addEventListener("click", Clicku19, true);
function Clicku19(e)
{

if (true) {

	self.location.href="注册页.html" + GetQuerystring();

}

}
gv_vAlignTable['u19'] = 'top';
var u9 = document.getElementById('u9');
gv_vAlignTable['u9'] = 'center';
var u30 = document.getElementById('u30');

var u24 = document.getElementById('u24');

var u38 = document.getElementById('u38');

var u18 = document.getElementById('u18');
gv_vAlignTable['u18'] = 'top';
var u32 = document.getElementById('u32');

var u23 = document.getElementById('u23');
gv_vAlignTable['u23'] = 'center';
if (window.OnLoad) OnLoad();
