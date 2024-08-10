import * as cherry_core from 'cherry-cljs/cljs.core.js';
import { tag } from 'helpers';
class MyEmail extends HTMLElement {
  constructor() {
super();const self__ = this;
const this$ = this;
const username1 = "jakub.stastny.pt";
const plus_address2 = "web";
const hostname3 = "gmail.com";
const email4 = cherry_core.str.call(null, username1, "+", plus_address2, "@", hostname3);
const subject5 = (() => {
const or__23438__auto__6 = this$.getAttribute("subject");
if (cherry_core.truth_.call(null, or__23438__auto__6)) {
return or__23438__auto__6;} else {
return "";}
})();
const encoded_subject7 = encodeURIComponent(subject5);
this$.appendChild(tag.call(null, cherry_core.keyword("a"), cherry_core.array_map(cherry_core.keyword("href"), cherry_core.str.call(null, "mailto:", email4, "?subject=", encoded_subject7)), email4))  }
};
customElements.define("my-email", MyEmail);

export { MyEmail }
