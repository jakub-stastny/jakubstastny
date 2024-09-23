import { $APP, shadow$provide, $jscomp } from "./cljs.core.js";
const shadow_esm_import = function(x) { return import(x) };
var Vr,Wr,ds;$APP.Rr=function(a,b){return 0==a.lastIndexOf(b,0)};$APP.Sr=function(a){return String(a.charAt(0)).toUpperCase()+String(a.slice(1)).toLowerCase()};$APP.Ur=function(a){return a.replace(Tr,"$2$1").split("").reverse().join("")};Vr=function(a,b,c){var d=RegExp,e=b.source,g=$APP.p(b.ignoreCase)?"gi":"g";g=$APP.p(b.multiline)?[g,"m"].join(""):g;b=$APP.p(b.unicode)?[g,"u"].join(""):g;return a.replace(new d(e,b),c)};
Wr=function(a){return function(){function b(d){var e=null;if(0<arguments.length){e=0;for(var g=Array(arguments.length-0);e<g.length;)g[e]=arguments[e+0],++e;e=new $APP.xd(g,0,null)}return c.call(this,e)}function c(d){d=$APP.Po.g(2,d);if($APP.ce.g($APP.be(d),1))return d=$APP.x(d),a.h?a.h(d):a.call(null,d);d=$APP.tf(d);return a.h?a.h(d):a.call(null,d)}b.m=0;b.o=function(d){d=$APP.w(d);return c(d)};b.j=c;return b}()};
$APP.Xr=function(a,b,c){if("string"===typeof b)return a.replace(new RegExp(String(b).replace(/([-()\[\]{}+?*.$\^|,:#<!\\])/g,"\\$1").replace(/\x08/g,"\\x08"),"g"),c);if(b instanceof RegExp)return"string"===typeof c?Vr(a,b,c):Vr(a,b,Wr(c));throw["Invalid match arg: ",$APP.q.h(b)].join("");};$APP.Yr=function(a,b,c){return a.replace(b,c)};$APP.Zr=function(a){return a.toUpperCase()};$APP.$r=function(a){return a.toLowerCase()};$APP.bs=function(a){return $APP.Sr(a)};
ds=function(a,b){if(0>=b||b>=2+$APP.be(a))return $APP.Cg.g($APP.tf($APP.Fg("",$APP.ul.g($APP.q,$APP.w(a)))),"");if($APP.p($APP.cs.g?$APP.cs.g(1,b):$APP.cs.call(null,1,b)))return new $APP.E(null,1,5,$APP.F,[a],null);if($APP.p($APP.cs.g?$APP.cs.g(2,b):$APP.cs.call(null,2,b)))return new $APP.E(null,2,5,$APP.F,["",a],null);b-=2;return $APP.Cg.g($APP.tf($APP.Fg("",$APP.gp.l($APP.tf($APP.ul.g($APP.q,$APP.w(a))),0,b))),$APP.bl.g(a,b))};$APP.fs=function(a){return $APP.es.g(a,/\n|\r\n/)};$APP.gs=function(a){return(0,$APP.An)(a)};
$APP.hs=function(a){return a.replace(/^[\s\xa0]+/,"")};$APP.is=function(a){return a.replace(/[\s\xa0]+$/,"")};$APP.js=function(a){for(var b=a.length;;){if(0===b)return"";var c=$APP.df.g(a,b-1);if("\n"===c||"\r"===c)--b;else return a.substring(0,b)}};$APP.ks=function(a){return/^[\s\xa0]*$/.test(null==a?"":String(a))};$APP.ls=function(a,b){for(var c=new $APP.Da,d=a.length,e=0;;){if(d===e)return c.toString();var g=a.charAt(e),k=b.h?b.h(g):b.call(null,g);null!=k?c.append($APP.q.h(k)):c.append(g);e+=1}};
$APP.ms=function(a,b){return $APP.Rr(a,b)};$APP.ns=function(a,b){return $APP.ma(a,b)};$APP.os=function(a,b){return-1!=a.indexOf(b)};$APP.cs=function cs(a){switch(arguments.length){case 1:return cs.h(arguments[0]);case 2:return cs.g(arguments[0],arguments[1]);default:for(var c=[],d=arguments.length,e=0;;)if(e<d)c.push(arguments[e]),e+=1;else break;return cs.j(arguments[0],arguments[1],2<c.length?new $APP.xd(c.slice(2),0,null):null)}};$APP.cs.h=function(){return!0};
$APP.cs.g=function(a,b){return $APP.jc(a,b)};$APP.cs.j=function(a,b,c){for(;;)if(a===b)if($APP.y(c))a=b,b=$APP.x(c),c=$APP.y(c);else return b===$APP.x(c);else return!1};$APP.cs.o=function(a){var b=$APP.x(a),c=$APP.y(a);a=$APP.x(c);c=$APP.y(c);return this.j(b,a,c)};$APP.cs.m=2;var Tr;Tr=RegExp("([\\uD800-\\uDBFF])([\\uDC00-\\uDFFF])","g");$APP.ps=function ps(a){switch(arguments.length){case 1:return ps.h(arguments[0]);case 2:return ps.g(arguments[0],arguments[1]);default:throw Error(["Invalid arity: ",$APP.q.h(arguments.length)].join(""));}};$APP.ps.h=function(a){var b=new $APP.Da;for(a=$APP.w(a);;)if(null!=a)b=b.append($APP.q.h($APP.x(a))),a=$APP.y(a);else return b.toString()};
$APP.ps.g=function(a,b){var c=new $APP.Da;for(b=$APP.w(b);;)if(null!=b)c.append($APP.q.h($APP.x(b))),b=$APP.y(b),null!=b&&c.append(a);else return c.toString()};$APP.ps.m=2;$APP.es=function es(a){switch(arguments.length){case 2:return es.g(arguments[0],arguments[1]);case 3:return es.l(arguments[0],arguments[1],arguments[2]);default:throw Error(["Invalid arity: ",$APP.q.h(arguments.length)].join(""));}};$APP.es.g=function(a,b){return $APP.es.l(a,b,0)};
$APP.es.l=function(a,b,c){if("/(?:)/"===$APP.q.h(b))b=ds(a,c);else if(1>c)b=$APP.tf($APP.q.h(a).split(b));else a:for(var d=c,e=$APP.ri;;){if(1===d){b=$APP.Cg.g(e,a);break a}var g=$APP.Zk(b,a);if(null!=g){var k=a.indexOf(g);g=a.substring(k+$APP.be(g));--d;e=$APP.Cg.g(e,a.substring(0,k));a=g}else{b=$APP.Cg.g(e,a);break a}}if(0===c&&1<$APP.be(b))a:for(c=b;;)if(""===$APP.ze(c))c=$APP.Ae(c);else break a;else c=b;return c};$APP.es.m=3;
$APP.qs=function qs(a){switch(arguments.length){case 2:return qs.g(arguments[0],arguments[1]);case 3:return qs.l(arguments[0],arguments[1],arguments[2]);default:throw Error(["Invalid arity: ",$APP.q.h(arguments.length)].join(""));}};$APP.qs.g=function(a,b){a=a.indexOf(b);return 0>a?null:a};$APP.qs.l=function(a,b,c){a=a.indexOf(b,c);return 0>a?null:a};$APP.qs.m=3;
$APP.rs=function rs(a){switch(arguments.length){case 2:return rs.g(arguments[0],arguments[1]);case 3:return rs.l(arguments[0],arguments[1],arguments[2]);default:throw Error(["Invalid arity: ",$APP.q.h(arguments.length)].join(""));}};$APP.rs.g=function(a,b){a=a.lastIndexOf(b);return 0>a?null:a};$APP.rs.l=function(a,b,c){a=a.lastIndexOf(b,c);return 0>a?null:a};$APP.rs.m=3;export const replace_first=$APP.Yr;export const capitalize=$APP.bs;export const reverse=$APP.Ur;export const join=$APP.ps;export const escape=$APP.ls;export const starts_with_QMARK_=$APP.ms;export const blank_QMARK_=$APP.ks;export const upper_case=$APP.Zr;export const replace=$APP.Xr;export const includes_QMARK_=$APP.os;export const index_of=$APP.qs;export const trim_newline=$APP.js;export const lower_case=$APP.$r;export const split_lines=$APP.fs;export const split=$APP.es;
export const ends_with_QMARK_=$APP.ns;export const trimr=$APP.is;export const last_index_of=$APP.rs;export const trim=$APP.gs;export const triml=$APP.hs;