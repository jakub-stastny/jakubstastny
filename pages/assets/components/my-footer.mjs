import * as cherry_core from 'cherry-cljs/cljs.core.js';
import { append_tag, tag, no_self_referring_link } from 'helpers';
class MyFooter extends HTMLElement {
  constructor() {
super();const self__ = this;
const this$ = this;
const shadow1 = this$.attachShadow(({ "mode": "open" }));
append_tag.call(null, this$, tag.call(null, cherry_core.keyword("script"), cherry_core.array_map(cherry_core.keyword("type"), "module", cherry_core.keyword("src"), "/assets/components/fa-icon.mjs")));
append_tag.call(null, this$, tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/assets/styles.css")));
append_tag.call(null, this$, tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/assets/footer.css")));
append_tag.call(null, this$, tag.call(null, cherry_core.keyword("footer"), cherry_core.vector(tag.call(null, cherry_core.keyword("p"), cherry_core.array_map(cherry_core.keyword("class"), "copyright"), cherry_core.str.call(null, "Jakub Šťastný ", new Date().getFullYear())), tag.call(null, cherry_core.keyword("ul"), cherry_core.array_map(cherry_core.keyword("class"), "inline-list"), cherry_core.vector(tag.call(null, cherry_core.keyword("li"), no_self_referring_link.call(null, "Main page", "/")), tag.call(null, cherry_core.keyword("li"), no_self_referring_link.call(null, "About me", "/about")), tag.call(null, cherry_core.keyword("li"), no_self_referring_link.call(null, "Contact", "/contact")))))))  }
};
customElements.define("my-footer", MyFooter);

export { MyFooter }
