import * as cherry_core from 'cherry-cljs/cljs.core.js';
import { append_tag, tag, no_self_referring_link, css_var } from 'helpers';
class MyFooter extends HTMLElement {
  constructor() {
super();const self__ = this;
const this$ = this;
const shadow1 = this$.attachShadow(({ "mode": "open" }));
append_tag.call(null, this$, tag.call(null, cherry_core.keyword("script"), cherry_core.array_map(cherry_core.keyword("type"), "module", cherry_core.keyword("src"), "/components/fa-icon.mjs")));
append_tag.call(null, this$, tag.call(null, cherry_core.keyword("script"), cherry_core.array_map(cherry_core.keyword("type"), "module", cherry_core.keyword("src"), "/components/my-email.mjs")));
append_tag.call(null, this$, tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/css/styles.css")));
append_tag.call(null, this$, tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/css/footer.css")));
append_tag.call(null, this$, tag.call(null, cherry_core.keyword("footer"), cherry_core.vector(tag.call(null, cherry_core.keyword("p"), cherry_core.array_map(cherry_core.keyword("class"), "copyright"), cherry_core.str.call(null, "Jakub Šťastný ", new Date().getFullYear())), tag.call(null, cherry_core.keyword("ul"), cherry_core.array_map(cherry_core.keyword("class"), "inline-list"), cherry_core.vector(tag.call(null, cherry_core.keyword("li"), tag.call(null, cherry_core.keyword("my-email"), cherry_core.array_map(cherry_core.keyword("subject"), "Hey there!"), tag.call(null, cherry_core.keyword("a"), tag.call(null, cherry_core.keyword("fa-icon"), cherry_core.array_map(cherry_core.keyword("name"), "envelope", cherry_core.keyword("colour"), css_var.call(null, "envelope-colour")))))), tag.call(null, cherry_core.keyword("li"), tag.call(null, cherry_core.keyword("a"), cherry_core.array_map(cherry_core.keyword("href"), "https://www.youtube.com/@jakub-stastny", cherry_core.keyword("target"), "_blank", cherry_core.keyword("rel"), "noopener"), tag.call(null, cherry_core.keyword("fa-icon"), cherry_core.array_map(cherry_core.keyword("name"), "brands/youtube", cherry_core.keyword("colour"), css_var.call(null, "youtube-colour"))))), tag.call(null, cherry_core.keyword("li"), tag.call(null, cherry_core.keyword("a"), cherry_core.array_map(cherry_core.keyword("href"), "https://www.reddit.com/user/jakubstastny", cherry_core.keyword("target"), "_blank", cherry_core.keyword("rel"), "noopener"), tag.call(null, cherry_core.keyword("fa-icon"), cherry_core.array_map(cherry_core.keyword("name"), "brands/reddit", cherry_core.keyword("colour"), css_var.call(null, "reddit-colour"))))))))))  }
};
customElements.define("my-footer", MyFooter);

export { MyFooter }
