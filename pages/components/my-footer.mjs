import * as cherry_core from 'cherry-cljs/cljs.core.js';
import { tag, no_self_referring_link, css_var } from 'helpers';
var social_icon = (function (name, link) {
return tag.call(null, cherry_core.keyword("a"), cherry_core.array_map(cherry_core.keyword("href"), link, cherry_core.keyword("target"), "_blank", cherry_core.keyword("rel"), "noopener"), tag.call(null, cherry_core.keyword("fa-icon"), cherry_core.array_map(cherry_core.keyword("name"), cherry_core.str.call(null, "brands/", name), cherry_core.keyword("colour"), css_var.call(null, cherry_core.str.call(null, name, "-colour")))));
});
class MyFooter extends HTMLElement {
  constructor() {
super();const self__ = this;
const this$ = this;
const shadow_root1 = this$.attachShadow(({ "mode": "open" }));
const copyright2 = tag.call(null, cherry_core.keyword("p"), cherry_core.array_map(cherry_core.keyword("class"), "copyright"), cherry_core.vector(tag.call(null, cherry_core.keyword("a"), cherry_core.array_map(cherry_core.keyword("href"), "/uncopyright"), "uncopyright"), cherry_core.str.call(null, " ", new Date().getFullYear())));
const fa_envelope3 = tag.call(null, cherry_core.keyword("fa-icon"), cherry_core.array_map(cherry_core.keyword("name"), "envelope", cherry_core.keyword("colour"), css_var.call(null, "envelope-colour")));
const envelope4 = tag.call(null, cherry_core.keyword("li"), tag.call(null, cherry_core.keyword("my-email"), cherry_core.array_map(cherry_core.keyword("subject"), "Hey there!"), tag.call(null, cherry_core.keyword("a"), fa_envelope3)));
const youtube5 = tag.call(null, cherry_core.keyword("li"), social_icon.call(null, "youtube", "https://www.youtube.com/@jakub-stastny"));
const reddit6 = tag.call(null, cherry_core.keyword("li"), social_icon.call(null, "reddit", "https://www.reddit.com/user/jakubstastny"));
const social_icons7 = tag.call(null, cherry_core.keyword("ul"), cherry_core.array_map(cherry_core.keyword("class"), "inline-list"), cherry_core.vector(envelope4, youtube5, reddit6));
shadow_root1.appendChild(tag.call(null, cherry_core.keyword("script"), cherry_core.array_map(cherry_core.keyword("type"), "module", cherry_core.keyword("src"), "/components/fa-icon.mjs")));
shadow_root1.appendChild(tag.call(null, cherry_core.keyword("script"), cherry_core.array_map(cherry_core.keyword("type"), "module", cherry_core.keyword("src"), "/components/my-email.mjs")));
shadow_root1.appendChild(tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/css/styles.css")));
shadow_root1.appendChild(tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/css/footer.css")));
shadow_root1.appendChild(tag.call(null, cherry_core.keyword("footer"), cherry_core.vector(copyright2, social_icons7)))  }
};
customElements.define("my-footer", MyFooter);

export { social_icon, MyFooter }
