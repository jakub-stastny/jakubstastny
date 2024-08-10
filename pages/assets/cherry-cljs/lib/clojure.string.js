import { $APP, shadow$provide, $jscomp } from "./cljs.core.js";
const shadow_esm_import = function(x) { return import(x) };
var sr,tr,Ar;$APP.nr=function(a,b){return 0==a.lastIndexOf(b,0)};$APP.or=function(a){return String(a.charAt(0)).toUpperCase()+String(a.slice(1)).toLowerCase()};$APP.rr=function(a){return a.replace(qr,"$2$1").split("").reverse().join("")};sr=function(a,b,c){var d=RegExp,e=b.source,f=$APP.r(b.ignoreCase)?"gi":"g";f=$APP.r(b.multiline)?[f,"m"].join(""):f;b=$APP.r(b.unicode)?[f,"u"].join(""):f;return a.replace(new d(e,b),c)};
tr=function(a){return function(){function b(d){var e=null;if(0<arguments.length){e=0;for(var f=Array(arguments.length-0);e<f.length;)f[e]=arguments[e+0],++e;e=new $APP.pd(f,0,null)}return c.call(this,e)}function c(d){d=$APP.go.g(2,d);if($APP.Td.g($APP.Sd(d),1))return d=$APP.A(d),a.h?a.h(d):a.call(null,d);d=$APP.ef(d);return a.h?a.h(d):a.call(null,d)}b.m=0;b.o=function(d){d=$APP.y(d);return c(d)};b.j=c;return b}()};
$APP.ur=function(a,b,c){if("string"===typeof b)return a.replace(new RegExp(String(b).replace(/([-()\[\]{}+?*.$\^|,:#<!\\])/g,"\\$1").replace(/\x08/g,"\\x08"),"g"),c);if(b instanceof RegExp)return"string"===typeof c?sr(a,b,c):sr(a,b,tr(c));throw["Invalid match arg: ",$APP.t.h(b)].join("");};$APP.vr=function(a,b,c){return a.replace(b,c)};$APP.wr=function(a){return a.toUpperCase()};$APP.xr=function(a){return a.toLowerCase()};$APP.yr=function(a){return $APP.or(a)};
Ar=function(a,b){if(0>=b||b>=2+$APP.Sd(a))return $APP.lg.g($APP.ef($APP.og("",$APP.Mk.g($APP.t,$APP.y(a)))),"");if($APP.r($APP.zr.g?$APP.zr.g(1,b):$APP.zr.call(null,1,b)))return new $APP.J(null,1,5,$APP.O,[a],null);if($APP.r($APP.zr.g?$APP.zr.g(2,b):$APP.zr.call(null,2,b)))return new $APP.J(null,2,5,$APP.O,["",a],null);b-=2;return $APP.lg.g($APP.ef($APP.og("",$APP.yo.l($APP.ef($APP.Mk.g($APP.t,$APP.y(a))),0,b))),$APP.Ck.g(a,b))};$APP.Cr=function(a){return $APP.Br.g(a,/\n|\r\n/)};$APP.Dr=function(a){return(0,$APP.Rm)(a)};
$APP.Er=function(a){return a.replace(/^[\s\xa0]+/,"")};$APP.Fr=function(a){return a.replace(/[\s\xa0]+$/,"")};$APP.Gr=function(a){for(var b=a.length;;){if(0===b)return"";var c=$APP.Se.g(a,b-1);if("\n"===c||"\r"===c)--b;else return a.substring(0,b)}};$APP.Hr=function(a){return/^[\s\xa0]*$/.test(null==a?"":String(a))};$APP.Ir=function(a,b){for(var c=new $APP.xa,d=a.length,e=0;;){if(d===e)return c.toString();var f=a.charAt(e),h=b.h?b.h(f):b.call(null,f);null!=h?c.append($APP.t.h(h)):c.append(f);e+=1}};
$APP.Jr=function(a,b){return $APP.nr(a,b)};$APP.Kr=function(a,b){return $APP.ka(a,b)};$APP.Lr=function(a,b){return-1!=a.indexOf(b)};$APP.zr=function zr(a){switch(arguments.length){case 1:return zr.h(arguments[0]);case 2:return zr.g(arguments[0],arguments[1]);default:for(var c=[],d=arguments.length,e=0;;)if(e<d)c.push(arguments[e]),e+=1;else break;return zr.j(arguments[0],arguments[1],2<c.length?new $APP.pd(c.slice(2),0,null):null)}};$APP.zr.h=function(){return!0};
$APP.zr.g=function(a,b){return $APP.dc(a,b)};$APP.zr.j=function(a,b,c){for(;;)if(a===b)if($APP.B(c))a=b,b=$APP.A(c),c=$APP.B(c);else return b===$APP.A(c);else return!1};$APP.zr.o=function(a){var b=$APP.A(a),c=$APP.B(a);a=$APP.A(c);c=$APP.B(c);return this.j(b,a,c)};$APP.zr.m=2;var qr;qr=RegExp("([\\uD800-\\uDBFF])([\\uDC00-\\uDFFF])","g");$APP.Mr=function Mr(a){switch(arguments.length){case 1:return Mr.h(arguments[0]);case 2:return Mr.g(arguments[0],arguments[1]);default:throw Error(["Invalid arity: ",$APP.t.h(arguments.length)].join(""));}};$APP.Mr.h=function(a){var b=new $APP.xa;for(a=$APP.y(a);;)if(null!=a)b=b.append($APP.t.h($APP.A(a))),a=$APP.B(a);else return b.toString()};
$APP.Mr.g=function(a,b){var c=new $APP.xa;for(b=$APP.y(b);;)if(null!=b)c.append($APP.t.h($APP.A(b))),b=$APP.B(b),null!=b&&c.append(a);else return c.toString()};$APP.Mr.m=2;$APP.Br=function Br(a){switch(arguments.length){case 2:return Br.g(arguments[0],arguments[1]);case 3:return Br.l(arguments[0],arguments[1],arguments[2]);default:throw Error(["Invalid arity: ",$APP.t.h(arguments.length)].join(""));}};$APP.Br.g=function(a,b){return $APP.Br.l(a,b,0)};
$APP.Br.l=function(a,b,c){if("/(?:)/"===$APP.t.h(b))b=Ar(a,c);else if(1>c)b=$APP.ef($APP.t.h(a).split(b));else a:for(var d=c,e=$APP.ai;;){if(1===d){b=$APP.lg.g(e,a);break a}var f=$APP.zk(b,a);if(null!=f){var h=a.indexOf(f);f=a.substring(h+$APP.Sd(f));--d;e=$APP.lg.g(e,a.substring(0,h));a=f}else{b=$APP.lg.g(e,a);break a}}if(0===c&&1<$APP.Sd(b))a:for(c=b;;)if(""===$APP.le(c))c=$APP.me(c);else break a;else c=b;return c};$APP.Br.m=3;
$APP.Nr=function Nr(a){switch(arguments.length){case 2:return Nr.g(arguments[0],arguments[1]);case 3:return Nr.l(arguments[0],arguments[1],arguments[2]);default:throw Error(["Invalid arity: ",$APP.t.h(arguments.length)].join(""));}};$APP.Nr.g=function(a,b){a=a.indexOf(b);return 0>a?null:a};$APP.Nr.l=function(a,b,c){a=a.indexOf(b,c);return 0>a?null:a};$APP.Nr.m=3;
$APP.Or=function Or(a){switch(arguments.length){case 2:return Or.g(arguments[0],arguments[1]);case 3:return Or.l(arguments[0],arguments[1],arguments[2]);default:throw Error(["Invalid arity: ",$APP.t.h(arguments.length)].join(""));}};$APP.Or.g=function(a,b){a=a.lastIndexOf(b);return 0>a?null:a};$APP.Or.l=function(a,b,c){a=a.lastIndexOf(b,c);return 0>a?null:a};$APP.Or.m=3;export const replace_first=$APP.vr;export const capitalize=$APP.yr;export const reverse=$APP.rr;export const join=$APP.Mr;export const escape=$APP.Ir;export const starts_with_QMARK_=$APP.Jr;export const blank_QMARK_=$APP.Hr;export const upper_case=$APP.wr;export const replace=$APP.ur;export const includes_QMARK_=$APP.Lr;export const index_of=$APP.Nr;export const trim_newline=$APP.Gr;export const lower_case=$APP.xr;export const split_lines=$APP.Cr;export const split=$APP.Br;
export const ends_with_QMARK_=$APP.Kr;export const trimr=$APP.Fr;export const last_index_of=$APP.Or;export const trim=$APP.Dr;export const triml=$APP.Er;