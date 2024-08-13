import * as cherry_core from 'cherry-cljs/cljs.core.js';
import { tag, no_self_referring_link } from 'helpers';
import { router } from 'router';
var item_link = (function (router_entry) {
return no_self_referring_link.call(null, cherry_core.keyword("title").call(null, router_entry), cherry_core.keyword("path").call(null, router_entry));
});
var render = (function (root) {
root.appendChild(tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/css/styles.css")));
root.appendChild(tag.call(null, cherry_core.keyword("link"), cherry_core.array_map(cherry_core.keyword("rel"), "stylesheet", cherry_core.keyword("href"), "/css/nav.css")));
const main1 = item_link.call(null, cherry_core.keyword("index").call(null, router));
const about2 = item_link.call(null, cherry_core.keyword("about").call(null, router));
const spiritual_guidance3 = item_link.call(null, cherry_core.keyword("spiritual-guidance").call(null, router));
const astro_reading4 = item_link.call(null, cherry_core.keyword("intuitive-reading").call(null, router));
const remote_healing5 = item_link.call(null, cherry_core.keyword("energy-healing").call(null, router));
const services6 = cherry_core.vector(item_link.call(null, cherry_core.keyword("services").call(null, router)), tag.call(null, cherry_core.keyword("ul"), cherry_core.vector(tag.call(null, cherry_core.keyword("li"), spiritual_guidance3), tag.call(null, cherry_core.keyword("li"), astro_reading4), tag.call(null, cherry_core.keyword("li"), remote_healing5))));
const contact7 = item_link.call(null, cherry_core.keyword("contact").call(null, router));
return root.appendChild(tag.call(null, cherry_core.keyword("nav"), tag.call(null, cherry_core.keyword("ul"), cherry_core.vector(tag.call(null, cherry_core.keyword("li"), main1), tag.call(null, cherry_core.keyword("li"), about2), tag.call(null, cherry_core.keyword("li"), services6), tag.call(null, cherry_core.keyword("li"), contact7)))));
});
class MyNav extends HTMLElement {
  constructor() {
super();const self__ = this;
const this$ = this;
this$.attachShadow(({ "mode": "open" }))  }
connectedCallback() { 
const this$ = this;
const self__ = this;return render.call(null, this$.shadowRoot);
}};
customElements.define("my-nav", MyNav);

export { item_link, render, MyNav }
