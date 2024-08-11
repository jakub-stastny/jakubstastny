import * as cherry_core from 'cherry-cljs/cljs.core.js';
import { append_tag, tag, no_self_referring_link } from 'helpers';
class MyNav extends HTMLElement {
  constructor() {
super();const self__ = this;
const this$ = this;
const shadow1 = this$.attachShadow(({ "mode": "open" }));
append_tag.call(null, this$, tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/css/styles.css")));
append_tag.call(null, this$, tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/css/nav.css")));
append_tag.call(null, this$, tag.call(null, cherry_core.keyword("nav"), cherry_core.array_map(cherry_core.keyword("style"), "margin: 2ex;"), tag.call(null, cherry_core.keyword("ul"), cherry_core.array_map(cherry_core.keyword("class"), "inline-list", cherry_core.keyword("style"), "justify-content: center;"), cherry_core.vector(tag.call(null, cherry_core.keyword("li"), no_self_referring_link.call(null, "Main page", "/")), tag.call(null, cherry_core.keyword("li"), no_self_referring_link.call(null, "About me", "/about")), tag.call(null, cherry_core.keyword("li"), no_self_referring_link.call(null, "Services", "/services")), tag.call(null, cherry_core.keyword("li"), no_self_referring_link.call(null, "Contact", "/contact"))))))  }
};
customElements.define("my-nav", MyNav);

export { MyNav }
