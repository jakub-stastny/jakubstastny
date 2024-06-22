class MyHeader extends HTMLElement {
  constructor() {
    super()
    const shadow = this.attachShadow({ mode: 'open' })

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
    const style = tag('style', styleContent)
    const header = document.createElement('header')

    header.appendChild(tag('h1', "Jakub Šťastný"))

    shadow.appendChild(style)
    shadow.appendChild(header)
  }
}

customElements.define('my-header', MyHeader)
