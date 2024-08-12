import * as cherry_core from 'cherry-cljs/cljs.core.js';
import { tag, css_var, get_BANG_ } from 'helpers';
var config = cherry_core.array_map(cherry_core.keyword("youtube-link"), "https://www.youtube.com/@jakub-stastny", cherry_core.keyword("reddit-link"), "https://www.reddit.com/user/jakubstastny");
var social_icon = (function (name, link) {
return tag.call(null, cherry_core.keyword("a"), cherry_core.array_map(cherry_core.keyword("href"), link, cherry_core.keyword("target"), "_blank", cherry_core.keyword("rel"), "noopener"), tag.call(null, cherry_core.keyword("fa-icon"), cherry_core.array_map(cherry_core.keyword("name"), cherry_core.str.call(null, "brands/", name), cherry_core.keyword("colour"), css_var.call(null, cherry_core.str.call(null, name, "-colour")))));
});
var render = (function (root) {
const copyright1 = tag.call(null, cherry_core.keyword("li"), tag.call(null, cherry_core.keyword("a"), cherry_core.array_map(cherry_core.keyword("href"), "/uncopyright"), "uncopyright"));
const fa_envelope2 = tag.call(null, cherry_core.keyword("fa-icon"), cherry_core.array_map(cherry_core.keyword("name"), "envelope", cherry_core.keyword("colour"), css_var.call(null, "envelope-colour")));
const envelope3 = tag.call(null, cherry_core.keyword("li"), tag.call(null, cherry_core.keyword("my-email"), cherry_core.array_map(cherry_core.keyword("subject"), "Hey there!"), tag.call(null, cherry_core.keyword("a"), fa_envelope2)));
const youtube4 = tag.call(null, cherry_core.keyword("li"), social_icon.call(null, "youtube", get_BANG_.call(null, config, cherry_core.keyword("youtube-link"))));
const reddit5 = tag.call(null, cherry_core.keyword("li"), social_icon.call(null, "reddit", get_BANG_.call(null, config, cherry_core.keyword("reddit-link"))));
const social_icons6 = tag.call(null, cherry_core.keyword("ul"), cherry_core.array_map(cherry_core.keyword("class"), "inline-list"), cherry_core.vector(youtube4, envelope3, reddit5, copyright1));
root.appendChild(tag.call(null, cherry_core.keyword("script"), cherry_core.array_map(cherry_core.keyword("type"), "module", cherry_core.keyword("src"), "/components/fa-icon.mjs")));
root.appendChild(tag.call(null, cherry_core.keyword("script"), cherry_core.array_map(cherry_core.keyword("type"), "module", cherry_core.keyword("src"), "/components/my-email.mjs")));
root.appendChild(tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/css/styles.css")));
root.appendChild(tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/css/footer.css")));
return root.appendChild(tag.call(null, cherry_core.keyword("footer"), social_icons6));
});
class MyFooter extends HTMLElement {
  constructor() {
super();const self__ = this;
const this$ = this;
this$.attachShadow(({ "mode": "open" }))  }
connectedCallback() { 
const this$ = this;
const self__ = this;return render.call(null, this$.shadowRoot);
}};
customElements.define("my-footer", MyFooter);

export { config, social_icon, render, MyFooter }
