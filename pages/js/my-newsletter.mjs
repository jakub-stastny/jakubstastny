import * as cherry_core from 'cherry-cljs/cljs.core.js';
import * as squint_html from 'squint-cljs/src/squint/html.js';
import { custom_domain } from 'config';
var prn = (() => {
const f18 = (function (var_args) {
const args191 = cherry_core.array.call(null);
const len__22496__auto__2 = cherry_core.alength.call(null, arguments);
let i203 = 0;
while(true){
if ((i203) < (len__22496__auto__2)) {
args191.push((arguments[i203]));
let G__4 = (i203 + 1);
i203 = G__4;
continue;
};break;
}
;
const argseq__22705__auto__5 = ((0) < (cherry_core.alength.call(null, args191))) ? (new cherry_core.IndexedSeq(args191.slice(0), 0, null)) : (null);
return f18.cljs$core$IFn$_invoke$arity$variadic(argseq__22705__auto__5);
});
f18.cljs$core$IFn$_invoke$arity$variadic = (function (args) {
return cherry_core.apply.call(null, console.log, cherry_core.map.call(null, (function (_PERCENT_1) {
return cherry_core.clj__GT_js.call(null, _PERCENT_1);
}), args));
});
f18.cljs$lang$maxFixedArity = 0;
f18.cljs$lang$applyTo = (function (seq21) {
const self__22531__auto__6 = this;
return self__22531__auto__6.cljs$core$IFn$_invoke$arity$variadic(cherry_core.seq.call(null, seq21));
});
return f18;
})();
var subscribe_endpoint = cherry_core.str.call(null, custom_domain, "/.netlify/functions/subscribe");
var subscribe = (async function (email) {
console.log("EMAIL", email);
const headers1 = cherry_core.array_map(cherry_core.keyword("method"), "POST", cherry_core.keyword("headers"), cherry_core.array_map("Content-Type", "application/json"), cherry_core.keyword("body"), JSON.stringify(cherry_core.clj__GT_js.call(null, cherry_core.array_map(cherry_core.keyword("email"), email))));
return (await (async () => {
try{
prn.call(null, cherry_core.keyword("response"), headers1);
const response2 = (await fetch(subscribe_endpoint, cherry_core.clj__GT_js.call(null, headers1)));
const _3 = console.log(response2);
const result4 = (await response2.json());
return console.log("Success:", result4);}
catch(e5){
return console.error("Error:", e5);}

})());
});
var submit_handler = (function (event) {
event.preventDefault();
const form1 = event.target;
return subscribe.call(null, form1.email.value);
});
var render = (function () {
return squint_html.tag`<link rel="stylesheet" href="/css/styles.css"><link rel="stylesheet" href="/css/my-newsletter.css"><h2>Newsletter</h2><form><div style="display: flex"><input type="email" name="email" required="${squint_html.attr(true)}" placeholder="you@email.com"><button type="submit">Subscribe</button></div></form>`;
});
var setup = (function (component, shadow_root) {
const form1 = shadow_root.querySelector("form");
return form1.addEventListener("submit", submit_handler);
});
class MyNewsletter extends HTMLElement {
  constructor() {
super();const self__ = this;
const this$ = this;
this$.attachShadow(cherry_core.js_obj.call(null, "mode", "open"))  }
connectedCallback() { 
const this$ = this;
const self__ = this;this$.shadowRoot.innerHTML = render.call(null);
;
setup.call(null, this$, this$.shadowRoot);
return null;
}};
customElements.define("my-newsletter", MyNewsletter);

export { prn, subscribe_endpoint, subscribe, submit_handler, render, setup, MyNewsletter }
