
var PageName = '评论或反馈功能';
var PageId = 'p462fcafaa1644eb7a020499e46aabefc'
document.title = '评论或反馈功能';

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

eval(GetDynamicPanelScript('u40', 2));

eval(GetDynamicPanelScript('u71', 2));

eval(GetDynamicPanelScript('u19', 1));

eval(GetDynamicPanelScript('u68', 1));

eval(GetDynamicPanelScript('u9', 2));

eval(GetDynamicPanelScript('u36', 1));

eval(GetDynamicPanelScript('u29', 2));

eval(GetDynamicPanelScript('u61', 2));

eval(GetDynamicPanelScript('u77', 2));

eval(GetDynamicPanelScript('u2', 2));

var u54 = document.getElementById('u54');

var u60 = document.getElementById('u60');

u60.style.cursor = 'pointer';
if (bIE) u60.attachEvent("onclick", Clicku60);
else u60.addEventListener("click", Clicku60, true);
function Clicku60(e)
{

if (true) {

	var obj1 = document.getElementById("u68");
	if (obj1.style.visibility == "" || obj1.style.visibility == "visible") { SetPanelVisibilityu68("hidden"); }
	else {SetPanelVisibilityu68("");}

}

}
gv_vAlignTable['u60'] = 'top';
var u29 = document.getElementById('u29');

x = 0;
y = 0;
InsertAfterBegin(u29ann, "<div id='u29Note' class='annnoteimage' style='left:" + x + ";top:" + y + "' onclick=\"ToggleWorkflow(event, 'u29', 300, 300, false)\"></div>");

eval(annwindow.replace(/\[\[id\]\]/g, 'u29').replace(/\[\[label\]\]/g, "验证码判断"));

InsertAfterBegin(document.body, "<div id='u29based' style='z-index:1; visibility:hidden; position:absolute'></div><div id='u29base' style='z-index:1; visibility:hidden; position:absolute'></div>");
var u29based = document.getElementById('u29based');
            
InsertBeforeEnd(u29based, "<div class='anncontent'><span class='annfieldname'>Specification:</span> 输入验证码后显示验证结果。<BR><BR></div>");

var u45 = document.getElementById('u45');

x = 0;
y = 0;
InsertAfterBegin(u45ann, "<div id='u45Note' class='annnoteimage' style='left:" + x + ";top:" + y + "' onclick=\"ToggleWorkflow(event, 'u45', 300, 300, false)\"></div>");

eval(annwindow.replace(/\[\[id\]\]/g, 'u45').replace(/\[\[label\]\]/g, "?"));

InsertAfterBegin(document.body, "<div id='u45based' style='z-index:1; visibility:hidden; position:absolute'></div><div id='u45base' style='z-index:1; visibility:hidden; position:absolute'></div>");
var u45based = document.getElementById('u45based');
            
InsertBeforeEnd(u45based, "<div class='anncontent'><span class='annfieldname'>Specification:</span> 在控件上限制最多可输入500个汉字，字数超限将无法再输入字符。粘贴进来的内容自动截前500个汉字当量的内容。<BR><BR></div>");

var u51 = document.getElementById('u51');

u51.style.cursor = 'pointer';
if (bIE) u51.attachEvent("onclick", Clicku51);
else u51.addEventListener("click", Clicku51, true);
function Clicku51(e)
{

if (true) {

	SetPanelStateu2("pd1u2");

}

}

var u79 = document.getElementById('u79');
gv_vAlignTable['u79'] = 'center';
var u42 = document.getElementById('u42');
gv_vAlignTable['u42'] = 'center';
var u80 = document.getElementById('u80');

var u26 = document.getElementById('u26');
gv_vAlignTable['u26'] = 'top';
var u5 = document.getElementById('u5');

var u23 = document.getElementById('u23');
gv_vAlignTable['u23'] = 'top';
var u76 = document.getElementById('u76');

x = 0;
y = 0;
InsertAfterBegin(u76ann, "<div id='u76Note' class='annnoteimage' style='left:" + x + ";top:" + y + "' onclick=\"ToggleWorkflow(event, 'u76', 300, 300, false)\"></div>");

eval(annwindow.replace(/\[\[id\]\]/g, 'u76').replace(/\[\[label\]\]/g, "?"));

InsertAfterBegin(document.body, "<div id='u76based' style='z-index:1; visibility:hidden; position:absolute'></div><div id='u76base' style='z-index:1; visibility:hidden; position:absolute'></div>");
var u76based = document.getElementById('u76based');
            
InsertBeforeEnd(u76based, "<div class='anncontent'><span class='annfieldname'>Specification:</span> 提交成功后，内容文本框中的内容重置为默认值。图型验证码刷新换另一张。用户邮箱处保留用户的输入。<BR><BR></div>");

u76.style.cursor = 'pointer';
if (bIE) u76.attachEvent("onclick", u76Click);
else u76.addEventListener("click", u76Click, true);
InsertAfterBegin(document.body, "<DIV class='intcases' id='u76LinksClick'></DIV>")
var u76LinksClick = document.getElementById('u76LinksClick');
function u76Click(e) 
{

	ToggleLinks(e, 'u76LinksClick');
}

InsertBeforeEnd(u76LinksClick, "<div class='intcaselink' onmouseout='SuppressBubble(event)' onclick='Clickuce29a60b45354b468397da96aaaaba80()'>提交成功</div>");
function Clickuce29a60b45354b468397da96aaaaba80()
{

	SetPanelStateu77("pd0u77");

	ToggleLinks(window.event, 'u76LinksClick');
}

InsertBeforeEnd(u76LinksClick, "<div class='intcaselink' onmouseout='SuppressBubble(event)' onclick='Clickubd2b79939294458ab2f7a7c0e0cc756a()'>验证码错误</div>");
function Clickubd2b79939294458ab2f7a7c0e0cc756a()
{

	SetPanelStateu77("pd1u77");

	ToggleLinks(window.event, 'u76LinksClick');
}

var u14 = document.getElementById('u14');

u14.style.cursor = 'pointer';
if (bIE) u14.attachEvent("onclick", u14Click);
else u14.addEventListener("click", u14Click, true);
InsertAfterBegin(document.body, "<DIV class='intcases' id='u14LinksClick'></DIV>")
var u14LinksClick = document.getElementById('u14LinksClick');
function u14Click(e) 
{

	ToggleLinks(e, 'u14LinksClick');
}

InsertBeforeEnd(u14LinksClick, "<div class='intcaselink' onmouseout='SuppressBubble(event)' onclick='Clicku223b1387f2004833a81de5820a1d50c1()'>登录成功</div>");
function Clicku223b1387f2004833a81de5820a1d50c1()
{

	SetPanelStateu9("pd1u9");

	ToggleLinks(window.event, 'u14LinksClick');
}

InsertBeforeEnd(u14LinksClick, "<div class='intcaselink' onmouseout='SuppressBubble(event)' onclick='Clickuc4a0a2fe504b410181f50671194fac0d()'>登录错误</div>");
function Clickuc4a0a2fe504b410181f50671194fac0d()
{

	SetPanelVisibilityu19("");

	ToggleLinks(window.event, 'u14LinksClick');
}

var u67 = document.getElementById('u67');
gv_vAlignTable['u67'] = 'center';
var u20 = document.getElementById('u20');

var u73 = document.getElementById('u73');
gv_vAlignTable['u73'] = 'center';
var u48 = document.getElementById('u48');
gv_vAlignTable['u48'] = 'center';
var u4 = document.getElementById('u4');
gv_vAlignTable['u4'] = 'center';
var u11 = document.getElementById('u11');

var u64 = document.getElementById('u64');

var u70 = document.getElementById('u70');
gv_vAlignTable['u70'] = 'center';
var u39 = document.getElementById('u39');

x = 0;
y = 0;
InsertAfterBegin(u39ann, "<div id='u39Note' class='annnoteimage' style='left:" + x + ";top:" + y + "' onclick=\"ToggleWorkflow(event, 'u39', 300, 300, false)\"></div>");

eval(annwindow.replace(/\[\[id\]\]/g, 'u39').replace(/\[\[label\]\]/g, "?"));

InsertAfterBegin(document.body, "<div id='u39based' style='z-index:1; visibility:hidden; position:absolute'></div><div id='u39base' style='z-index:1; visibility:hidden; position:absolute'></div>");
var u39based = document.getElementById('u39based');
            
InsertBeforeEnd(u39based, "<div class='anncontent'><span class='annfieldname'>Specification:</span> 提交成功后，内容文本框中的内容重置为默认值。图型验证码刷新换另一张。用户邮箱处保留用户的输入。<BR><BR></div>");

u39.style.cursor = 'pointer';
if (bIE) u39.attachEvent("onclick", u39Click);
else u39.addEventListener("click", u39Click, true);
InsertAfterBegin(document.body, "<DIV class='intcases' id='u39LinksClick'></DIV>")
var u39LinksClick = document.getElementById('u39LinksClick');
function u39Click(e) 
{

	ToggleLinks(e, 'u39LinksClick');
}

InsertBeforeEnd(u39LinksClick, "<div class='intcaselink' onmouseout='SuppressBubble(event)' onclick='Clicku6f35c11892fa4005971eee9060fea3df()'>提交成功</div>");
function Clicku6f35c11892fa4005971eee9060fea3df()
{

	SetPanelStateu40("pd0u40");

	ToggleLinks(window.event, 'u39LinksClick');
}

InsertBeforeEnd(u39LinksClick, "<div class='intcaselink' onmouseout='SuppressBubble(event)' onclick='Clicku7fdde97c028d41afb155a9052ead4193()'>验证码错误</div>");
function Clicku7fdde97c028d41afb155a9052ead4193()
{

	SetPanelStateu40("pd1u40");

	ToggleLinks(window.event, 'u39LinksClick');
}

var u55 = document.getElementById('u55');
gv_vAlignTable['u55'] = 'top';
var u61 = document.getElementById('u61');

x = 0;
y = 0;
InsertAfterBegin(u61ann, "<div id='u61Note' class='annnoteimage' style='left:" + x + ";top:" + y + "' onclick=\"ToggleWorkflow(event, 'u61', 300, 300, false)\"></div>");

eval(annwindow.replace(/\[\[id\]\]/g, 'u61').replace(/\[\[label\]\]/g, "验证码判断"));

InsertAfterBegin(document.body, "<div id='u61based' style='z-index:1; visibility:hidden; position:absolute'></div><div id='u61base' style='z-index:1; visibility:hidden; position:absolute'></div>");
var u61based = document.getElementById('u61based');
            
InsertBeforeEnd(u61based, "<div class='anncontent'><span class='annfieldname'>Specification:</span> 输入验证码后显示验证结果。<BR><BR></div>");

var u52 = document.getElementById('u52');
gv_vAlignTable['u52'] = 'center';
var u36 = document.getElementById('u36');

var u81 = document.getElementById('u81');
gv_vAlignTable['u81'] = 'center';
var u27 = document.getElementById('u27');

var u33 = document.getElementById('u33');

if (bIE) u33.attachEvent("onmouseout", MouseOutu33);
else u33.addEventListener("mouseout", MouseOutu33, true);
function MouseOutu33(e)
{
if (!IsTrueMouseOut('u33',e)) return;
if (true) {

	SetPanelStateu29("pd0u29");

}

}

var u0 = document.getElementById('u0');

var u24 = document.getElementById('u24');

u24.style.cursor = 'pointer';
if (bIE) u24.attachEvent("onclick", Clicku24);
else u24.addEventListener("click", Clicku24, true);
function Clicku24(e)
{

if (true) {

	SetPanelStateu9("pd0u9");

}

}

var u77 = document.getElementById('u77');

x = 0;
y = 0;
InsertAfterBegin(u77ann, "<div id='u77Note' class='annnoteimage' style='left:" + x + ";top:" + y + "' onclick=\"ToggleWorkflow(event, 'u77', 300, 300, false)\"></div>");

eval(annwindow.replace(/\[\[id\]\]/g, 'u77').replace(/\[\[label\]\]/g, "提交成功"));

InsertAfterBegin(document.body, "<div id='u77based' style='z-index:1; visibility:hidden; position:absolute'></div><div id='u77base' style='z-index:1; visibility:hidden; position:absolute'></div>");
var u77based = document.getElementById('u77based');
            
InsertBeforeEnd(u77based, "<div class='anncontent'><span class='annfieldname'>Specification:</span> 提交成功后显示提示信息，信息5秒钟后自动消失，验证码错误信息同样。<BR><BR></div>");

var u30 = document.getElementById('u30');

var u58 = document.getElementById('u58');
gv_vAlignTable['u58'] = 'top';
var u15 = document.getElementById('u15');
gv_vAlignTable['u15'] = 'top';
var u21 = document.getElementById('u21');
gv_vAlignTable['u21'] = 'center';
var u74 = document.getElementById('u74');

if (bIE) u74.attachEvent("onmouseout", MouseOutu74);
else u74.addEventListener("mouseout", MouseOutu74, true);
function MouseOutu74(e)
{
if (!IsTrueMouseOut('u74',e)) return;
if (true) {

	SetPanelStateu71("pd0u71");

}

}

var u49 = document.getElementById('u49');

var u12 = document.getElementById('u12');
gv_vAlignTable['u12'] = 'top';
var u65 = document.getElementById('u65');

if (bIE) u65.attachEvent("onmouseout", MouseOutu65);
else u65.addEventListener("mouseout", MouseOutu65, true);
function MouseOutu65(e)
{
if (!IsTrueMouseOut('u65',e)) return;
if (true) {

	SetPanelStateu61("pd0u61");

}

}

var u71 = document.getElementById('u71');

var u62 = document.getElementById('u62');

var u46 = document.getElementById('u46');

x = 0;
y = 0;
InsertAfterBegin(u46ann, "<div id='u46Note' class='annnoteimage' style='left:" + x + ";top:" + y + "' onclick=\"ToggleWorkflow(event, 'u46', 300, 300, false)\"></div>");

eval(annwindow.replace(/\[\[id\]\]/g, 'u46').replace(/\[\[label\]\]/g, "?"));

InsertAfterBegin(document.body, "<div id='u46based' style='z-index:1; visibility:hidden; position:absolute'></div><div id='u46base' style='z-index:1; visibility:hidden; position:absolute'></div>");
var u46based = document.getElementById('u46based');
            
InsertBeforeEnd(u46based, "<div class='anncontent'><span class='annfieldname'>Specification:</span> 点击到达会员注册页面，在新窗口中打开。<BR><BR></div>");
gv_vAlignTable['u46'] = 'top';
var u37 = document.getElementById('u37');

var u43 = document.getElementById('u43');

var u17 = document.getElementById('u17');

var u18 = document.getElementById('u18');

x = 0;
y = 0;
InsertAfterBegin(u18ann, "<div id='u18Note' class='annnoteimage' style='left:" + x + ";top:" + y + "' onclick=\"ToggleWorkflow(event, 'u18', 300, 300, false)\"></div>");

eval(annwindow.replace(/\[\[id\]\]/g, 'u18').replace(/\[\[label\]\]/g, "?"));

InsertAfterBegin(document.body, "<div id='u18based' style='z-index:1; visibility:hidden; position:absolute'></div><div id='u18base' style='z-index:1; visibility:hidden; position:absolute'></div>");
var u18based = document.getElementById('u18based');
            
InsertBeforeEnd(u18based, "<div class='anncontent'><span class='annfieldname'>Specification:</span> 点击到网站忘记密码页面。在新窗口打开。<BR><BR></div>");
gv_vAlignTable['u18'] = 'top';
var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
var u34 = document.getElementById('u34');

var u40 = document.getElementById('u40');

x = 0;
y = 0;
InsertAfterBegin(u40ann, "<div id='u40Note' class='annnoteimage' style='left:" + x + ";top:" + y + "' onclick=\"ToggleWorkflow(event, 'u40', 300, 300, false)\"></div>");

eval(annwindow.replace(/\[\[id\]\]/g, 'u40').replace(/\[\[label\]\]/g, "提交成功"));

InsertAfterBegin(document.body, "<div id='u40based' style='z-index:1; visibility:hidden; position:absolute'></div><div id='u40base' style='z-index:1; visibility:hidden; position:absolute'></div>");
var u40based = document.getElementById('u40based');
            
InsertBeforeEnd(u40based, "<div class='anncontent'><span class='annfieldname'>Specification:</span> 提交成功后显示提示信息，信息5秒钟后自动消失，验证码错误信息同样。<BR><BR></div>");

var u68 = document.getElementById('u68');

var u25 = document.getElementById('u25');
gv_vAlignTable['u25'] = 'top';
var u31 = document.getElementById('u31');

if (bIE) u31.attachEvent("onmouseover", MouseOveru31);
else u31.addEventListener("mouseover", MouseOveru31, true);
function MouseOveru31(e)
{
if (!IsTrueMouseOver('u31',e)) return;
if (true) {

	SetPanelStateu29("pd1u29");

}

}

var u59 = document.getElementById('u59');

var u22 = document.getElementById('u22');
gv_vAlignTable['u22'] = 'top';
var u75 = document.getElementById('u75');
gv_vAlignTable['u75'] = 'center';
var u8 = document.getElementById('u8');
gv_vAlignTable['u8'] = 'center';
var u72 = document.getElementById('u72');

if (bIE) u72.attachEvent("onmouseover", MouseOveru72);
else u72.addEventListener("mouseover", MouseOveru72, true);
function MouseOveru72(e)
{
if (!IsTrueMouseOver('u72',e)) return;
if (true) {

	SetPanelStateu71("pd1u71");

}

}

var u56 = document.getElementById('u56');

x = 0;
y = 0;
InsertAfterBegin(u56ann, "<div id='u56Note' class='annnoteimage' style='left:" + x + ";top:" + y + "' onclick=\"ToggleWorkflow(event, 'u56', 300, 300, false)\"></div>");

eval(annwindow.replace(/\[\[id\]\]/g, 'u56').replace(/\[\[label\]\]/g, "?"));

InsertAfterBegin(document.body, "<div id='u56based' style='z-index:1; visibility:hidden; position:absolute'></div><div id='u56base' style='z-index:1; visibility:hidden; position:absolute'></div>");
var u56based = document.getElementById('u56based');
            
InsertBeforeEnd(u56based, "<div class='anncontent'><span class='annfieldname'>Specification:</span> 点击到达会员注册页面，在新窗口中打开。<BR><BR></div>");
gv_vAlignTable['u56'] = 'top';
var u47 = document.getElementById('u47');

u47.style.cursor = 'pointer';
if (bIE) u47.attachEvent("onclick", Clicku47);
else u47.addEventListener("click", Clicku47, true);
function Clicku47(e)
{

if (true) {

	SetPanelStateu2("pd0u2");

}

}

var u53 = document.getElementById('u53');
gv_vAlignTable['u53'] = 'top';
var u28 = document.getElementById('u28');

u28.style.cursor = 'pointer';
if (bIE) u28.attachEvent("onclick", Clicku28);
else u28.addEventListener("click", Clicku28, true);
function Clicku28(e)
{

if (true) {

	var obj1 = document.getElementById("u36");
	if (obj1.style.visibility == "" || obj1.style.visibility == "visible") { SetPanelVisibilityu36("hidden"); }
	else {SetPanelVisibilityu36("");}

}

}
gv_vAlignTable['u28'] = 'top';
var u2 = document.getElementById('u2');

var u44 = document.getElementById('u44');
gv_vAlignTable['u44'] = 'center';
var u50 = document.getElementById('u50');
gv_vAlignTable['u50'] = 'center';
var u19 = document.getElementById('u19');

x = 0;
y = 0;
InsertAfterBegin(u19ann, "<div id='u19Note' class='annnoteimage' style='left:" + x + ";top:" + y + "' onclick=\"ToggleWorkflow(event, 'u19', 300, 300, false)\"></div>");

eval(annwindow.replace(/\[\[id\]\]/g, 'u19').replace(/\[\[label\]\]/g, "登录错误"));

InsertAfterBegin(document.body, "<div id='u19based' style='z-index:1; visibility:hidden; position:absolute'></div><div id='u19base' style='z-index:1; visibility:hidden; position:absolute'></div>");
var u19based = document.getElementById('u19based');
            
InsertBeforeEnd(u19based, "<div class='anncontent'><span class='annfieldname'>Specification:</span> 密码错误时显示错误提示，５秒后自动消失。<BR><BR></div>");

var u78 = document.getElementById('u78');

var u7 = document.getElementById('u7');

u7.style.cursor = 'pointer';
if (bIE) u7.attachEvent("onclick", Clicku7);
else u7.addEventListener("click", Clicku7, true);
function Clicku7(e)
{

if (true) {

	SetPanelStateu2("pd0u2");

}

}

var u41 = document.getElementById('u41');

var u69 = document.getElementById('u69');

var u32 = document.getElementById('u32');

var u16 = document.getElementById('u16');

var u9 = document.getElementById('u9');

var u13 = document.getElementById('u13');

var u66 = document.getElementById('u66');

var u6 = document.getElementById('u6');
gv_vAlignTable['u6'] = 'center';
var u35 = document.getElementById('u35');
gv_vAlignTable['u35'] = 'center';
var u57 = document.getElementById('u57');

x = 0;
y = 0;
InsertAfterBegin(u57ann, "<div id='u57Note' class='annnoteimage' style='left:" + x + ";top:" + y + "' onclick=\"ToggleWorkflow(event, 'u57', 300, 300, false)\"></div>");

eval(annwindow.replace(/\[\[id\]\]/g, 'u57').replace(/\[\[label\]\]/g, "?"));

InsertAfterBegin(document.body, "<div id='u57based' style='z-index:1; visibility:hidden; position:absolute'></div><div id='u57base' style='z-index:1; visibility:hidden; position:absolute'></div>");
var u57based = document.getElementById('u57based');
            
InsertBeforeEnd(u57based, "<div class='anncontent'><span class='annfieldname'>Specification:</span> 在控件上限制最多可输入500个汉字，字数超限将无法再输入字符。粘贴进来的内容自动截前500个汉字当量的内容。<BR><BR></div>");

var u10 = document.getElementById('u10');
gv_vAlignTable['u10'] = 'top';
var u63 = document.getElementById('u63');

if (bIE) u63.attachEvent("onmouseover", MouseOveru63);
else u63.addEventListener("mouseover", MouseOveru63, true);
function MouseOveru63(e)
{
if (!IsTrueMouseOver('u63',e)) return;
if (true) {

	SetPanelStateu61("pd1u61");

}

}

var u38 = document.getElementById('u38');
gv_vAlignTable['u38'] = 'center';
var u3 = document.getElementById('u3');

u3.style.cursor = 'pointer';
if (bIE) u3.attachEvent("onclick", Clicku3);
else u3.addEventListener("click", Clicku3, true);
function Clicku3(e)
{

if (true) {

	SetPanelStateu2("pd1u2");

}

}

if (window.OnLoad) OnLoad();
