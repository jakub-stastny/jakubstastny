import * as cherry_core from 'cherry-cljs/cljs.core.js';
import { tag } from 'helpers';
import { email_chunks } from 'config';
var build_email = (function () {
return cherry_core.apply.call(null, cherry_core.str, email_chunks);
});
var build_mailto = (function (subject) {
return cherry_core.str.call(null, "mailto:", build_email.call(null), "?subject=", encodeURIComponent(subject));
});
var insert_default = (function (root, subject) {
const email1 = build_email.call(null);
const mailto2 = build_mailto.call(null, subject);
return root.appendChild(tag.call(null, cherry_core.keyword("a"), cherry_core.array_map(cherry_core.keyword("href"), mailto2), email1));
});
var update_in_slot = (function (subject, slot_children) {
const mailto1 = build_mailto.call(null, subject);
let seq__192 = cherry_core.seq.call(null, slot_children);
let chunk__203 = null;
let count__214 = 0;
let i__225 = 0;
while(true){
if ((i__225) < (count__214)) {
const node6 = cherry_core._nth.call(null, chunk__203, i__225);
if (cherry_core.truth_.call(null, (() => {
const and__23453__auto__7 = cherry_core.instance_QMARK_.call(null, HTMLElement, node6);
if (cherry_core.truth_.call(null, and__23453__auto__7)) {
return cherry_core._EQ_.call(null, node6.tagName, "A");} else {
return and__23453__auto__7;}
})())) {
node6.href = mailto1;
};
let G__8 = seq__192;
let G__9 = chunk__203;
let G__10 = count__214;
let G__11 = cherry_core.unchecked_inc.call(null, i__225);
seq__192 = G__8;
chunk__203 = G__9;
count__214 = G__10;
i__225 = G__11;
continue;
} else {
const temp__23022__auto__12 = cherry_core.seq.call(null, seq__192);
if (cherry_core.truth_.call(null, temp__23022__auto__12)) {
const seq__1913 = temp__23022__auto__12;
if (cherry_core.truth_.call(null, cherry_core.chunked_seq_QMARK_.call(null, seq__1913))) {
const c__23272__auto__14 = cherry_core.chunk_first.call(null, seq__1913);
let G__15 = cherry_core.chunk_rest.call(null, seq__1913);
let G__16 = c__23272__auto__14;
let G__17 = cherry_core.count.call(null, c__23272__auto__14);
let G__18 = 0;
seq__192 = G__15;
chunk__203 = G__16;
count__214 = G__17;
i__225 = G__18;
continue;
} else {
const node19 = cherry_core.first.call(null, seq__1913);
if (cherry_core.truth_.call(null, (() => {
const and__23453__auto__20 = cherry_core.instance_QMARK_.call(null, HTMLElement, node19);
if (cherry_core.truth_.call(null, and__23453__auto__20)) {
return cherry_core._EQ_.call(null, node19.tagName, "A");} else {
return and__23453__auto__20;}
})())) {
node19.href = mailto1;
};
let G__21 = cherry_core.next.call(null, seq__1913);
let G__22 = null;
let G__23 = 0;
let G__24 = 0;
seq__192 = G__21;
chunk__203 = G__22;
count__214 = G__23;
i__225 = G__24;
continue;
}}};break;
}

});
class MyEmail extends HTMLElement {
  constructor() {
super();const self__ = this;
const this$ = this;
this$.attachShadow(({ "mode": "open" }));
this$.shadowRoot.appendChild(tag.call(null, cherry_core.keyword("slot")))  }
connectedCallback() { 
const this$ = this;
const self__ = this;const subject1 = (() => {
const or__23438__auto__2 = this$.getAttribute("subject");
if (cherry_core.truth_.call(null, or__23438__auto__2)) {
return or__23438__auto__2;} else {
return "";}
})();
const slot3 = this$.shadowRoot.querySelector("slot");
const slot_children4 = slot3.assignedNodes();
if (cherry_core.truth_.call(null, cherry_core.empty_QMARK_.call(null, slot_children4))) {
return insert_default.call(null, this$.shadowRoot, subject1);} else {
return update_in_slot.call(null, subject1, slot_children4);}
}};
customElements.define("my-email", MyEmail);

export { build_email, build_mailto, insert_default, update_in_slot, MyEmail }
