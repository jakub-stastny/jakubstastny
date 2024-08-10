import * as cherry_core from 'cherry-cljs/cljs.core.js';
import { tag } from 'helpers';
class FaIcon extends HTMLElement {
  constructor() {
super();const self__ = this;
const this$ = this;
  }
async connectedCallback() { 
const this$ = this;
const self__ = this;const name1 = this$.getAttribute("name");
const path2 = cherry_core.str.call(null, "/assets/fa/svgs/solid/", name1, ".svg");
const response3 = (await fetch(path2));
const svg4 = (await response3.text());
this$.innerHTML = svg4;
return this.getElementsByTagName('svg')[0].style.height = '14pt';
}};
customElements.define("fa-icon", FaIcon);

export { FaIcon }
