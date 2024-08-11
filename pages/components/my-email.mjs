import * as cherry_core from 'cherry-cljs/cljs.core.js';
import { tag } from 'helpers';
class MyEmail extends HTMLElement {
  constructor() {
super();const self__ = this;
const this$ = this;
this$.attachShadow(({ "mode": "open" }));
this$.shadowRoot.appendChild(tag.call(null, cherry_core.keyword("slot")))  }
build_email() { 
const this$ = this;
const self__ = this;return cherry_core.str.call(null, "jakub.stastny.pt", "+", "web", "@", "gmail.com");
}
build_mailto(subject) { 
const this$ = this;
const self__ = this;return cherry_core.str.call(null, "mailto:", this$.build_email(), "?subject=", encodeURIComponent(subject));
}
insert_default() { 
const this$ = this;
const self__ = this;const subject1 = (() => {
const or__23438__auto__2 = this$.getAttribute("subject");
if (cherry_core.truth_.call(null, or__23438__auto__2)) {
return or__23438__auto__2;} else {
return "";}
})();
const email3 = this$.build_email();
const mailto4 = this$.build_mailto(subject1);
return this$.shadowRoot.appendChild(tag.call(null, cherry_core.keyword("a"), cherry_core.array_map(cherry_core.keyword("href"), mailto4), email3));
}
update_in_slot(slot_children) { 
const this$ = this;
const self__ = this;const subject5 = (() => {
const or__23438__auto__6 = this$.getAttribute("subject");
if (cherry_core.truth_.call(null, or__23438__auto__6)) {
return or__23438__auto__6;} else {
return "";}
})();
const mailto7 = this$.build_mailto(subject5);
let seq__18 = cherry_core.seq.call(null, slot_children);
let chunk__29 = null;
let count__310 = 0;
let i__411 = 0;
while(true){
if ((i__411) < (count__310)) {
const node12 = cherry_core._nth.call(null, chunk__29, i__411);
if (cherry_core.truth_.call(null, (() => {
const and__23453__auto__13 = cherry_core.instance_QMARK_.call(null, HTMLElement, node12);
if (cherry_core.truth_.call(null, and__23453__auto__13)) {
return cherry_core._EQ_.call(null, node12.tagName, "A");} else {
return and__23453__auto__13;}
})())) {
node12.href = mailto7;
};
let G__14 = seq__18;
let G__15 = chunk__29;
let G__16 = count__310;
let G__17 = cherry_core.unchecked_inc.call(null, i__411);
seq__18 = G__14;
chunk__29 = G__15;
count__310 = G__16;
i__411 = G__17;
continue;
} else {
const temp__23022__auto__18 = cherry_core.seq.call(null, seq__18);
if (cherry_core.truth_.call(null, temp__23022__auto__18)) {
const seq__119 = temp__23022__auto__18;
if (cherry_core.truth_.call(null, cherry_core.chunked_seq_QMARK_.call(null, seq__119))) {
const c__23272__auto__20 = cherry_core.chunk_first.call(null, seq__119);
let G__21 = cherry_core.chunk_rest.call(null, seq__119);
let G__22 = c__23272__auto__20;
let G__23 = cherry_core.count.call(null, c__23272__auto__20);
let G__24 = 0;
seq__18 = G__21;
chunk__29 = G__22;
count__310 = G__23;
i__411 = G__24;
continue;
} else {
const node25 = cherry_core.first.call(null, seq__119);
if (cherry_core.truth_.call(null, (() => {
const and__23453__auto__26 = cherry_core.instance_QMARK_.call(null, HTMLElement, node25);
if (cherry_core.truth_.call(null, and__23453__auto__26)) {
return cherry_core._EQ_.call(null, node25.tagName, "A");} else {
return and__23453__auto__26;}
})())) {
node25.href = mailto7;
};
let G__27 = cherry_core.next.call(null, seq__119);
let G__28 = null;
let G__29 = 0;
let G__30 = 0;
seq__18 = G__27;
chunk__29 = G__28;
count__310 = G__29;
i__411 = G__30;
continue;
}}};break;
}

}
connectedCallback() { 
const this$ = this;
const self__ = this;const slot31 = this$.shadowRoot.querySelector("slot");
const slot_children32 = slot31.assignedNodes();
if (cherry_core.truth_.call(null, cherry_core.empty_QMARK_.call(null, slot_children32))) {
return this$.insert_default(slot_children32);} else {
return this$.update_in_slot(slot_children32);}
}};
customElements.define("my-email", MyEmail);

export { MyEmail }
