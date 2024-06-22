const styleContent = `
  footer {
    background: #f1f1f1;
    padding: 10px;
    text-align: center;
    position: relative;
    bottom: 0;
    width: 100%;
  }
`

class MyFooter extends HTMLElement {
  constructor() {
    super()
    const shadow = this.attachShadow({ mode: 'open' })

    // CSS
    shadow.appendChild(tag('link', {rel: "stylesheet", href: "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"}))
    shadow.appendChild(tag('style', styleContent))

    // HTML
    shadow.appendChild(tag('footer', [
      tag('p', "Jakub Šťastný 2024"),
      tag('a', {href: "/contact"}, tag('i', {class: "fas fa-envelope icon"}))
    ]))
  }
}

customElements.define('my-footer', MyFooter)
