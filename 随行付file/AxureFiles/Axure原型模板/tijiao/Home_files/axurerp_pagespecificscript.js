
var PageName = 'Home';
var PageId = 'p0ef28c2afe224a8caba2ec33f405ee8d'
var PageUrl = 'Home.html'
document.title = 'Home';

if (top.location != self.location)
{
	if (parent.HandleMainFrameChanged) {
		parent.HandleMainFrameChanged();
	}
}

var $OnLoadVariable = '';

var $subtext = '';

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
    return encodeURI('#OnLoadVariable=' + $OnLoadVariable + '&subtext=' + $subtext + '&CSUM=1');
}

function PopulateVariables(value) {
  value = value.replace(/\[\[OnLoadVariable\]\]/g, $OnLoadVariable);
  value = value.replace(/\[\[subtext\]\]/g, $subtext);
  value = value.replace(/\[\[PageName\]\]/g, PageName);
  return value;
}

function OnLoad() {

}

var u2 = document.getElementById('u2');

var u1 = document.getElementById('u1');
gv_vAlignTable['u1'] = 'center';
var u0 = document.getElementById('u0');

var u5 = document.getElementById('u5');
gv_vAlignTable['u5'] = 'top';
var u4 = document.getElementById('u4');
gv_vAlignTable['u4'] = 'top';
var u3 = document.getElementById('u3');

u3.style.cursor = 'pointer';
if (bIE) u3.attachEvent("onclick", Clicku3);
else u3.addEventListener("click", Clicku3, true);
function Clicku3(e)
{

if ((GetWidgetFormText('u2')) == (PopulateVariables(''))) {

SetWidgetRichText('u4', PopulateVariables('<span style=" font-family:\'\\\'cb\\\'ce\\\'cc\\\'e5\'; color:#0000FF; font-size:16px;"><b>请填写您的姓名。</b></span>'));

}
else
if ((GetWidgetFormText('u2')) != (PopulateVariables(''))) {

SetGlobalVariableValue('$subtext', GetWidgetFormText('u2'));

SetWidgetRichText('u4', PopulateVariables('<div style="text-align:center"><span style=" font-family:\'Arial\'; color:#0000FF; font-size:19px;"><b>Welcome</b></span><b><span style=" font-family:\'\\\'cb\\\'ce\\\'cc\\\'e5\'; color:#0000FF; font-size:19px;"> [[subtext]]！</b></span></div>'));

}

}

if (window.OnLoad) OnLoad();
