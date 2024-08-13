import * as cherry_core from 'cherry-cljs/cljs.core.js';
import { tag } from 'helpers';
var render = (function (root) {
root.appendChild(tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/css/styles.css")));
root.appendChild(tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/css/newsletter.css")));
root.appendChild(tag.call(null, cherry_core.keyword("script"), cherry_core.array_map(cherry_core.keyword("src"), "https://assets.mailerlite.com/js/universal.js", cherry_core.keyword("async"), true)));
return root.appendChild(tag.call(null, cherry_core.keyword("div"), cherry_core.array_map(cherry_core.keyword("class"), "ml-embedded", cherry_core.keyword("data-form"), "GUqqOq")));
});
var ml_fn = (() => {
const f23 = (function (var_args) {
const args241 = cherry_core.array.call(null);
const len__22506__auto__2 = cherry_core.alength.call(null, arguments);
let i253 = 0;
while(true){
if ((i253) < (len__22506__auto__2)) {
args241.push((arguments[i253]));
let G__4 = (i253 + 1);
i253 = G__4;
continue;
};break;
}
;
const argseq__22667__auto__5 = ((0) < (cherry_core.alength.call(null, args241))) ? (new cherry_core.IndexedSeq(args241.slice(0), 0, null)) : (null);
return f23.cljs$core$IFn$_invoke$arity$variadic(argseq__22667__auto__5);
});
f23.cljs$core$IFn$_invoke$arity$variadic = (function (args) {
console.log("MailerLite", cherry_core.clj__GT_js.call(null, args));
return cherry_core.aset.call(null, window.ml, "q", cherry_core.conj.call(null, (() => {
const or__23438__auto__6 = window.ml.q;
if (cherry_core.truth_.call(null, or__23438__auto__6)) {
return or__23438__auto__6;} else {
return cherry_core.vector();}
})(), args));
});
f23.cljs$lang$maxFixedArity = 0;
f23.cljs$lang$applyTo = (function (seq26) {
const self__22536__auto__7 = this;
return self__22536__auto__7.cljs$core$IFn$_invoke$arity$variadic(cherry_core.seq.call(null, seq26));
});
return f23;
})();
var initialize_mailer_lite = (function () {
cherry_core.aset.call(null, window, "ml", ml_fn);
return ml_fn.call(null, "account", "1062534");
});
class MyNewsletter extends HTMLElement {
  constructor() {
super();const self__ = this;
const this$ = this;
this$.attachShadow(({ "mode": "open" }))  }
connectedCallback() { 
const this$ = this;
const self__ = this;render.call(null, this$.shadowRoot);
return initialize_mailer_lite.call(null);
}};
customElements.define("my-newsletter", MyNewsletter);

export { render, ml_fn, initialize_mailer_lite, MyNewsletter }
