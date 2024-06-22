class MyFooter extends HTMLElement {
  constructor() {
    super()
    const shadow = this.attachShadow({ mode: 'open' })

    const styleContent = `
      footer {
        background: #f1f1f1
        padding: 10px
        text-align: center
        position: relative
        bottom: 0
        width: 100%
      }
    `
    const style = tag('style', styleContent)
    const footer = document.createElement('footer')

    footer.appendChild(tag('p', "Jakub Šťastný 2024"))

    shadow.appendChild(style)
    shadow.appendChild(footer)
  }
}

customElements.define('my-footer', MyFooter)
