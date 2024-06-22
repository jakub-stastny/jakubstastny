import { tag, linkOrNot } from "/assets/helpers.js"

const styleContent = `
  header {
    background: #f1f1f1
    padding: 10px
    text-align: center
    position: relative
    bottom: 0
    width: 100%
  }
`

class MyHeader extends HTMLElement {
  constructor() {
    super()
    const shadow = this.attachShadow({ mode: 'open' })

    shadow.appendChild(tag('style', styleContent))
    shadow.appendChild(tag('header', [
      linkOrNot(tag('h1', "Jakub Šťastný"), "/")
    ]))
  }
}

customElements.define('my-header', MyHeader)
