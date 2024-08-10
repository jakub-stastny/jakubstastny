import * as cherry_core from 'cherry-cljs/cljs.core.js';
import { append_tag, tag, no_self_referring_link } from 'helpers';
class MyHeader extends HTMLElement {
  constructor() {
super();const self__ = this;
const this$ = this;
const shadow1 = this$.attachShadow(({ "mode": "open" }));
append_tag.call(null, this$, tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/css/styles.css")));
append_tag.call(null, this$, tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/css/header.css")));
append_tag.call(null, this$, tag.call(null, cherry_core.keyword("header"), cherry_core.vector(tag.call(null, cherry_core.keyword("h1"), no_self_referring_link.call(null, "Jakub Šťastný", "/")))))  }
};
customElements.define("my-header", MyHeader);

export { MyHeader }
