import * as cherry_core from 'cherry-cljs/cljs.core.js';
import { tag, no_self_referring_link } from 'helpers';
var render = (function (root) {
root.appendChild(tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/css/styles.css")));
root.appendChild(tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/css/header.css")));
return root.appendChild(tag.call(null, cherry_core.keyword("header"), tag.call(null, cherry_core.keyword("div"), cherry_core.array_map(cherry_core.keyword("class"), "wrapper"), cherry_core.vector(tag.call(null, cherry_core.keyword("h1"), no_self_referring_link.call(null, "Jakub Šťastný", "/")), tag.call(null, cherry_core.keyword("h2"), cherry_core.array_map(cherry_core.keyword("class"), "tagline"), "Guiding you to wholeness")))));
});
class MyHeader extends HTMLElement {
  constructor() {
super();const self__ = this;
const this$ = this;
this$.attachShadow(({ "mode": "open" }))  }
connectedCallback() { 
const this$ = this;
const self__ = this;return render.call(null, this$.shadowRoot);
}};
customElements.define("my-header", MyHeader);

export { render, MyHeader }
