(function(){'use strict';
'use strict';var e="object"===typeof __ScalaJSEnv&&__ScalaJSEnv?__ScalaJSEnv:{},k="object"===typeof e.global&&e.global?e.global:"object"===typeof global&&global&&global.Object===Object?global:this;e.global=k;var m="object"===typeof e.exportsNamespace&&e.exportsNamespace?e.exportsNamespace:k;e.exportsNamespace=m;k.Object.freeze(e);var aa={envInfo:e,semantics:{asInstanceOfs:2,arrayIndexOutOfBounds:2,moduleInit:2,strictFloats:!1,productionMode:!0},assumingES6:!1,linkerVersion:"0.6.31",globalThis:this};
k.Object.freeze(aa);k.Object.freeze(aa.semantics);var ba=k.Math.imul||function(a,b){var c=a&65535,d=b&65535;return c*d+((a>>>16&65535)*d+c*(b>>>16&65535)<<16>>>0)|0},n=k.Math.clz32||function(a){if(0===a)return 32;var b=1;0===(a&4294901760)&&(a<<=16,b+=16);0===(a&4278190080)&&(a<<=8,b+=8);0===(a&4026531840)&&(a<<=4,b+=4);0===(a&3221225472)&&(a<<=2,b+=2);return b+(a>>31)},q=0,t=k.WeakMap?new k.WeakMap:null;
function u(a){return function(b,c){return!(!b||!b.$classData||b.$classData.k!==c||b.$classData.i!==a)}}function ca(a){for(var b in a)return b}function da(a,b,c){var d=new a.D(b[c]);if(c<b.length-1){a=a.m;c+=1;for(var h=d.z,g=0;g<h.length;g++)h[g]=da(a,b,c)}return d}
function ea(a){switch(typeof a){case "string":return v(fa);case "number":var b=a|0;return b===a?ha(b)?v(ia):ja(b)?v(ka):v(la):"number"===typeof a?v(ma):v(na);case "boolean":return v(oa);case "undefined":return v(pa);default:return null===a?a.ma():a instanceof w?v(qa):a&&a.$classData?v(a.$classData):null}}
function ra(a){switch(typeof a){case "string":sa||(sa=(new x).b());for(var b=0,c=1,d=-1+(a.length|0)|0;0<=d;)b=b+ba(65535&(a.charCodeAt(d)|0),c)|0,c=ba(31,c),d=-1+d|0;return b;case "number":y||(y=(new z).b());b=y;c=a|0;if(c===a&&-Infinity!==1/a)b=c;else{if(b.f)b.F[0]=a,b=A(b.s[b.I]|0,b.s[b.G]|0);else{if(a!==a)b=!1,a=2047,c=+k.Math.pow(2,51);else if(Infinity===a||-Infinity===a)b=0>a,a=2047,c=0;else if(0===a)b=-Infinity===1/a,c=a=0;else if(d=(b=0>a)?-a:a,d>=+k.Math.pow(2,-1022)){a=+k.Math.pow(2,52);
c=+k.Math.log(d)/.6931471805599453;c=+k.Math.floor(c)|0;c=1023>c?c:1023;var h=+k.Math.pow(2,c);h>d&&(c=-1+c|0,h/=2);h=d/h*a;d=+k.Math.floor(h);h-=d;d=.5>h?d:.5<h?1+d:0!==d%2?1+d:d;2<=d/a&&(c=1+c|0,d=1);1023<c?(c=2047,d=0):(c=1023+c|0,d-=a);a=c;c=d}else a=d/+k.Math.pow(2,-1074),c=+k.Math.floor(a),d=a-c,a=0,c=.5>d?c:.5<d?1+c:0!==c%2?1+c:c;c=+c;b=A(c|0,(b?-2147483648:0)|(a|0)<<20|c/4294967296|0)}b=b.t^b.r}return b;case "boolean":return a?1231:1237;case "undefined":return 0;default:return a&&a.$classData||
null===a?a.y():null===t?42:ta(a)}}var ta=null!==t?function(a){switch(typeof a){case "string":case "number":case "boolean":case "undefined":return ra(a);default:if(null===a)return 0;var b=t.get(a);void 0===b&&(q=b=q+1|0,t.set(a,b));return b}}:function(a){if(a&&a.$classData){var b=a.$idHashCode$0;if(void 0!==b)return b;if(k.Object.isSealed(a))return 42;q=b=q+1|0;return a.$idHashCode$0=b}return null===a?0:ra(a)};function ha(a){return"number"===typeof a&&a<<24>>24===a&&1/a!==1/-0}
function ja(a){return"number"===typeof a&&a<<16>>16===a&&1/a!==1/-0}function B(){this.u=this.D=void 0;this.i=this.m=this.h=null;this.k=0;this.B=null;this.q="";this.c=this.o=this.p=void 0;this.name="";this.isRawJSType=this.isArrayClass=this.isInterface=this.isPrimitive=!1;this.isInstance=void 0}function C(a,b,c){var d=new B;d.h={};d.m=null;d.B=a;d.q=b;d.c=function(){return!1};d.name=c;d.isPrimitive=!0;d.isInstance=function(){return!1};return d}
function D(a,b,c,d,h,g,l){var f=new B,p=ca(a);g=g||function(r){return!!(r&&r.$classData&&r.$classData.h[p])};l=l||function(r,N){return!!(r&&r.$classData&&r.$classData.k===N&&r.$classData.i.h[p])};f.u=h;f.h=c;f.q="L"+b+";";f.c=l;f.name=b;f.isInterface=!1;f.isRawJSType=!!d;f.isInstance=g;return f}
function ua(a){function b(f){if("number"===typeof f){this.z=Array(f);for(var p=0;p<f;p++)this.z[p]=h}else this.z=f}var c=new B,d=a.B,h="longZero"==d?E().w:d;b.prototype=new F;b.prototype.constructor=b;b.prototype.$classData=c;d="["+a.q;var g=a.i||a,l=a.k+1;c.D=b;c.u=va;c.h={a:1,pa:1,d:1};c.m=a;c.i=g;c.k=l;c.B=null;c.q=d;c.p=void 0;c.o=void 0;c.c=void 0;c.name=d;c.isPrimitive=!1;c.isInterface=!1;c.isArrayClass=!0;c.isInstance=function(f){return g.c(f,l)};return c}
function v(a){if(!a.p){var b=new G;b.n=a;a.p=b}return a.p}B.prototype.getFakeInstance=function(){if(this===fa)return"some string";if(this===oa)return!1;if(this===ia||this===ka||this===la||this===ma||this===na)return 0;if(this===qa)return E().w;if(this!==pa)return{$classData:this}};B.prototype.getSuperclass=function(){return this.u?v(this.u):null};B.prototype.getComponentType=function(){return this.m?v(this.m):null};
B.prototype.newArrayOfThisClass=function(a){for(var b=this,c=0;c<a.length;c++)b.o||(b.o=ua(b)),b=b.o;return da(b,a,0)};var wa=C(!1,"Z","boolean"),xa=C(0,"C","char"),ya=C(0,"B","byte"),za=C(0,"S","short"),Aa=C(0,"I","int"),Ba=C("longZero","J","long"),Ca=C(0,"F","float"),Da=C(0,"D","double");wa.c=u(wa);xa.c=u(xa);ya.c=u(ya);za.c=u(za);Aa.c=u(Aa);Ba.c=u(Ba);Ca.c=u(Ca);Da.c=u(Da);function H(){}function F(){}F.prototype=H.prototype;H.prototype.b=function(){return this};H.prototype.v=function(){var a=ea(this).n.name,b=(+(this.y()>>>0)).toString(16);return a+"@"+b};H.prototype.y=function(){return ta(this)};H.prototype.toString=function(){return this.v()};var va=D({a:0},"java.lang.Object",{a:1},void 0,void 0,function(a){return null!==a},function(a,b){if(a=a&&a.$classData){var c=a.k||0;return!(c<b)&&(c>b||!a.i.isPrimitive)}return!1});H.prototype.$classData=va;
function I(){this.C=null}I.prototype=new F;I.prototype.constructor=I;I.prototype.b=function(){J=this;this.C=k.$;return this};I.prototype.$classData=D({P:0},"org.querki.jquery.package$",{P:1,a:1});var J=void 0;function Ea(){J||(J=(new I).b());return J}function G(){this.n=null}G.prototype=new F;G.prototype.constructor=G;G.prototype.v=function(){return(this.n.isInterface?"interface ":this.n.isPrimitive?"":"class ")+this.n.name};G.prototype.$classData=D({U:0},"java.lang.Class",{U:1,a:1});
function K(){this.E=this.J=null}K.prototype=new F;K.prototype.constructor=K;K.prototype.b=function(){L=this;this.J=Fa(!1);this.E=Fa(!0);return this};K.prototype.$classData=D({ca:0},"java.lang.System$",{ca:1,a:1});var L=void 0;function Ga(){L||(L=(new K).b());return L}function M(){}M.prototype=new F;M.prototype.constructor=M;function Ha(){}Ha.prototype=M.prototype;function O(){this.A=null}O.prototype=new F;O.prototype.constructor=O;O.prototype.v=function(){return"DynamicVariable("+this.A+")"};
function Ia(a,b){a.A=b;return a}O.prototype.$classData=D({ea:0},"scala.util.DynamicVariable",{ea:1,a:1});function z(){this.f=!1;this.F=this.s=this.j=null;this.x=!1;this.I=this.G=0}z.prototype=new F;z.prototype.constructor=z;
z.prototype.b=function(){y=this;this.j=(this.f=!!(k.ArrayBuffer&&k.Int32Array&&k.Float32Array&&k.Float64Array))?new k.ArrayBuffer(8):null;this.s=this.f?new k.Int32Array(this.j,0,2):null;this.f&&new k.Float32Array(this.j,0,2);this.F=this.f?new k.Float64Array(this.j,0,1):null;if(this.f)this.s[0]=16909060,a=1===((new k.Int8Array(this.j,0,8))[0]|0);else var a=!0;this.G=(this.x=a)?0:1;this.I=this.x?1:0;return this};z.prototype.$classData=D({fa:0},"scala.scalajs.runtime.Bits$",{fa:1,a:1});var y=void 0;
function x(){}x.prototype=new F;x.prototype.constructor=x;x.prototype.b=function(){return this};x.prototype.$classData=D({ia:0},"scala.scalajs.runtime.RuntimeString$",{ia:1,a:1});var sa=void 0;function P(){}P.prototype=new F;P.prototype.constructor=P;P.prototype.b=function(){return this};
P.prototype.main=function(){Q||(Q=(new R).b());for(var a=Q.K.A,b="Hey!\n";""!==b;){var c=b.indexOf("\n")|0;if(0>c)a.l=""+a.l+b,b="";else{var d=""+a.l+b.substring(0,c);k.console&&(a.H&&k.console.error?k.console.error(d):k.console.log(d));a.l="";b=b.substring(1+c|0)}}(0,Ea().C)("#root").append("\x3cp\x3e[message]\x3c/p\x3e")};P.prototype.$classData=D({L:0},"Boggle.Main$",{L:1,a:1,ta:1});var Ja=void 0;function S(){}S.prototype=new F;S.prototype.constructor=S;function Ka(){}Ka.prototype=S.prototype;
var pa=D({ja:0},"scala.runtime.BoxedUnit",{ja:1,a:1,d:1},void 0,void 0,function(a){return void 0===a}),oa=D({S:0},"java.lang.Boolean",{S:1,a:1,d:1,e:1},void 0,void 0,function(a){return"boolean"===typeof a});function R(){this.K=null}R.prototype=new Ha;R.prototype.constructor=R;R.prototype.b=function(){Q=this;this.K=Ia(new O,Ga().J);Ia(new O,Ga().E);Ia(new O,null);return this};R.prototype.$classData=D({da:0},"scala.Console$",{da:1,qa:1,a:1,sa:1});var Q=void 0;function T(){this.w=null}T.prototype=new F;
T.prototype.constructor=T;T.prototype.b=function(){U=this;this.w=A(0,0);return this};
function La(a,b){if(0===(-2097152&b))b=""+(4294967296*b+ +(a>>>0));else{var c=(32+n(1E9)|0)-(0!==b?n(b):32+n(a)|0)|0,d=c,h=0===(32&d)?1E9<<d:0;d=0===(32&d)?5E8>>>(31-d|0)|0|0<<d:1E9<<d;var g=a,l=b;for(a=b=0;0<=c&&0!==(-2097152&l);){var f=g,p=l,r=h,N=d;if(p===N?(-2147483648^f)>=(-2147483648^r):(-2147483648^p)>=(-2147483648^N))f=l,p=d,l=g-h|0,f=(-2147483648^l)>(-2147483648^g)?-1+(f-p|0)|0:f-p|0,g=l,l=f,32>c?b|=1<<c:a|=1<<c;c=-1+c|0;f=d>>>1|0;h=h>>>1|0|d<<31;d=f}c=l;if(0===c?-1147483648<=(-2147483648^
g):-2147483648<=(-2147483648^c))c=4294967296*l+ +(g>>>0),g=c/1E9,h=g/4294967296|0,d=b,b=g=d+(g|0)|0,a=(-2147483648^g)<(-2147483648^d)?1+(a+h|0)|0:a+h|0,g=c%1E9|0;c=""+g;b=""+(4294967296*a+ +(b>>>0))+"000000000".substring(c.length|0)+c}return b}T.prototype.$classData=D({ha:0},"scala.scalajs.runtime.RuntimeLong$",{ha:1,a:1,ra:1,d:1});var U=void 0;function E(){U||(U=(new T).b());return U}function V(){}V.prototype=new F;V.prototype.constructor=V;function Ma(){}Ma.prototype=V.prototype;
var fa=D({Q:0},"java.lang.String",{Q:1,a:1,d:1,oa:1,e:1},void 0,void 0,function(a){return"string"===typeof a}),ia=D({T:0},"java.lang.Byte",{T:1,g:1,a:1,d:1,e:1},void 0,void 0,function(a){return ha(a)}),na=D({V:0},"java.lang.Double",{V:1,g:1,a:1,d:1,e:1},void 0,void 0,function(a){return"number"===typeof a}),ma=D({W:0},"java.lang.Float",{W:1,g:1,a:1,d:1,e:1},void 0,void 0,function(a){return"number"===typeof a}),la=D({X:0},"java.lang.Integer",{X:1,g:1,a:1,d:1,e:1},void 0,void 0,function(a){return"number"===
typeof a&&(a|0)===a&&1/a!==1/-0}),qa=D({aa:0},"java.lang.Long",{aa:1,g:1,a:1,d:1,e:1},void 0,void 0,function(a){return a instanceof w}),ka=D({ba:0},"java.lang.Short",{ba:1,g:1,a:1,d:1,e:1},void 0,void 0,function(a){return ja(a)});function w(){this.r=this.t=0}w.prototype=new Ka;w.prototype.constructor=w;w.prototype.v=function(){E();var a=this.t,b=this.r;return b===a>>31?""+a:0>b?"-"+La(-a|0,0!==a?~b:-b|0):La(a,b)};function A(a,b){var c=new w;c.t=a;c.r=b;return c}
w.prototype.y=function(){return this.t^this.r};w.prototype.$classData=D({ga:0},"scala.scalajs.runtime.RuntimeLong",{ga:1,g:1,a:1,d:1,e:1});function W(){}W.prototype=new Ma;W.prototype.constructor=W;function Na(){}Na.prototype=W.prototype;function X(){}X.prototype=new Ma;X.prototype.constructor=X;X.prototype.b=function(){return this};X.prototype.$classData=D({Z:0},"java.lang.JSConsoleBasedPrintStream$DummyOutputStream",{Z:1,O:1,a:1,M:1,R:1,N:1});function Y(){}Y.prototype=new Na;
Y.prototype.constructor=Y;function Oa(){}Oa.prototype=Y.prototype;function Z(){this.H=!1;this.l=null}Z.prototype=new Oa;Z.prototype.constructor=Z;function Fa(a){var b=new Z;b.H=a;(new X).b();b.l="";return b}Z.prototype.$classData=D({Y:0},"java.lang.JSConsoleBasedPrintStream",{Y:1,la:1,ka:1,O:1,a:1,M:1,R:1,N:1,na:1});m.Boggle=m.Boggle||{};m.Boggle.Main=function(){Ja||(Ja=(new P).b());return Ja};
}).call(this);
//# sourceMappingURL=bogglescalajs-opt.js.map
