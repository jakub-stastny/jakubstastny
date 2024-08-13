import * as cherry_core from 'cherry-cljs/cljs.core.js';
var set_attrs = (function (element, map) {
let seq__51 = cherry_core.seq.call(null, map);
let chunk__62 = null;
let count__73 = 0;
let i__84 = 0;
while(true){
if ((i__84) < (count__73)) {
const vec__95 = cherry_core._nth.call(null, chunk__62, i__84);
const key6 = cherry_core.nth.call(null, vec__95, 0, null);
const value7 = cherry_core.nth.call(null, vec__95, 1, null);
element.setAttribute(cherry_core.name.call(null, key6), value7);
let G__8 = seq__51;
let G__9 = chunk__62;
let G__10 = count__73;
let G__11 = cherry_core.unchecked_inc.call(null, i__84);
seq__51 = G__8;
chunk__62 = G__9;
count__73 = G__10;
i__84 = G__11;
continue;
} else {
const temp__23022__auto__12 = cherry_core.seq.call(null, seq__51);
if (cherry_core.truth_.call(null, temp__23022__auto__12)) {
const seq__513 = temp__23022__auto__12;
if (cherry_core.truth_.call(null, cherry_core.chunked_seq_QMARK_.call(null, seq__513))) {
const c__23272__auto__14 = cherry_core.chunk_first.call(null, seq__513);
let G__15 = cherry_core.chunk_rest.call(null, seq__513);
let G__16 = c__23272__auto__14;
let G__17 = cherry_core.count.call(null, c__23272__auto__14);
let G__18 = 0;
seq__51 = G__15;
chunk__62 = G__16;
count__73 = G__17;
i__84 = G__18;
continue;
} else {
const vec__1219 = cherry_core.first.call(null, seq__513);
const key20 = cherry_core.nth.call(null, vec__1219, 0, null);
const value21 = cherry_core.nth.call(null, vec__1219, 1, null);
element.setAttribute(cherry_core.name.call(null, key20), value21);
let G__22 = cherry_core.next.call(null, seq__513);
let G__23 = null;
let G__24 = 0;
let G__25 = 0;
seq__51 = G__22;
chunk__62 = G__23;
count__73 = G__24;
i__84 = G__25;
continue;
}}};break;
}
;
return element;
});
var set_children = (function (element, list) {
let seq__151 = cherry_core.seq.call(null, list);
let chunk__162 = null;
let count__173 = 0;
let i__184 = 0;
while(true){
if ((i__184) < (count__173)) {
const child5 = cherry_core._nth.call(null, chunk__162, i__184);
element.appendChild((cherry_core.truth_.call(null, cherry_core.string_QMARK_.call(null, child5))) ? (document.createTextNode(child5)) : (child5));
let G__6 = seq__151;
let G__7 = chunk__162;
let G__8 = count__173;
let G__9 = cherry_core.unchecked_inc.call(null, i__184);
seq__151 = G__6;
chunk__162 = G__7;
count__173 = G__8;
i__184 = G__9;
continue;
} else {
const temp__23022__auto__10 = cherry_core.seq.call(null, seq__151);
if (cherry_core.truth_.call(null, temp__23022__auto__10)) {
const seq__1511 = temp__23022__auto__10;
if (cherry_core.truth_.call(null, cherry_core.chunked_seq_QMARK_.call(null, seq__1511))) {
const c__23272__auto__12 = cherry_core.chunk_first.call(null, seq__1511);
let G__13 = cherry_core.chunk_rest.call(null, seq__1511);
let G__14 = c__23272__auto__12;
let G__15 = cherry_core.count.call(null, c__23272__auto__12);
let G__16 = 0;
seq__151 = G__13;
chunk__162 = G__14;
count__173 = G__15;
i__184 = G__16;
continue;
} else {
const child17 = cherry_core.first.call(null, seq__1511);
element.appendChild((cherry_core.truth_.call(null, cherry_core.string_QMARK_.call(null, child17))) ? (document.createTextNode(child17)) : (child17));
let G__18 = cherry_core.next.call(null, seq__1511);
let G__19 = null;
let G__20 = 0;
let G__21 = 0;
seq__151 = G__18;
chunk__162 = G__19;
count__173 = G__20;
i__184 = G__21;
continue;
}}};break;
}

});
var set_inner_html = (function (element, html) {
return element.innerHTML = html;
;
});
var set_content = (function (element, content) {
if (cherry_core.truth_.call(null, cherry_core.vector_QMARK_.call(null, content))) {
return set_children.call(null, element, content);} else {
if (cherry_core.truth_.call(null, cherry_core.string_QMARK_.call(null, content))) {
return set_inner_html.call(null, element, content);} else {
if (cherry_core.truth_.call(null, cherry_core.instance_QMARK_.call(null, HTMLElement, content))) {
return element.appendChild(content);} else {
if (cherry_core.truth_.call(null, cherry_core.keyword("else"))) {
return console.log("[set-content] Invalid attribute type", content);} else {
return null;}}}}
});
var tag = (() => {
const f19 = (function (var_args) {
const G__221 = cherry_core.alength.call(null, arguments);
switch (G__221) {case 1:
return f19.cljs$core$IFn$_invoke$arity$1((arguments[0]));
break;
case 2:
return f19.cljs$core$IFn$_invoke$arity$2((arguments[0]), (arguments[1]));
break;
case 3:
return f19.cljs$core$IFn$_invoke$arity$3((arguments[0]), (arguments[1]), (arguments[2]));
break;
default:
throw new Error(cherry_core.str.call(null, "Invalid arity: ", cherry_core.alength.call(null, arguments)))}
});
f19.cljs$core$IFn$_invoke$arity$1 = (function (tag_name) {
return document.createElement(cherry_core.name.call(null, tag_name));
});
f19.cljs$core$IFn$_invoke$arity$2 = (function (tag_name, arg) {
const element3 = document.createElement(cherry_core.name.call(null, tag_name));
if (cherry_core.truth_.call(null, cherry_core.map_QMARK_.call(null, arg))) {
set_attrs.call(null, element3, arg)} else {
set_content.call(null, element3, arg)};
return element3;
});
f19.cljs$core$IFn$_invoke$arity$3 = (function (tag_name, attrs, content) {
const element4 = document.createElement(cherry_core.name.call(null, tag_name));
set_attrs.call(null, element4, attrs);
set_content.call(null, element4, content);
return element4;
});
f19.cljs$lang$maxFixedArity = 3;
return f19;
})();
var no_self_referring_link = (function (title, link) {
if (cherry_core.truth_.call(null, cherry_core._EQ_.call(null, window.location.pathname, link))) {
return tag.call(null, cherry_core.keyword("span"), title);} else {
return tag.call(null, cherry_core.keyword("a"), cherry_core.array_map(cherry_core.keyword("href"), link), title);}
});
var css_var = (function (name) {
const css_var_name1 = cherry_core.str.call(null, "--", name);
const computed_styles2 = getComputedStyle.call(null, document.documentElement);
return computed_styles2.getPropertyValue(css_var_name1);
});
var get_BANG_ = (function (m, k) {
if (cherry_core.truth_.call(null, cherry_core.contains_QMARK_.call(null, m, k))) {
return cherry_core.get.call(null, m, k);} else {
throw cherry_core.ex_info.call(null, cherry_core.str.call(null, "Key '", k, "' not found in the map"), cherry_core.array_map(cherry_core.keyword("map"), m, cherry_core.keyword("key"), k))}
});

export { set_attrs, set_children, set_inner_html, set_content, tag, no_self_referring_link, css_var, get_BANG_ }
