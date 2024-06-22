export function tag(tagName, ...args) {
  const element = document.createElement(tagName);

  args.forEach(arg => {
    if (typeof arg === 'string' || typeof arg === 'number') {
      element.textContent = arg;
    } else if (arg instanceof HTMLElement) {
      element.appendChild(arg);
    } else if (Array.isArray(arg)) {
      arg.forEach(child => {
        if (child instanceof HTMLElement) {
          element.appendChild(child);
        } else if (typeof child === 'string' || typeof child === 'number') {
          element.appendChild(document.createTextNode(child));
        }
      });
    } else if (typeof arg === 'object' && arg !== null) {
      Object.keys(arg).forEach(key => {
        element.setAttribute(key, arg[key]);
      });
    }
  });

  return element;
}

/*
 * linkOrNot("More about me", "/about")
 */
export function linkOrNot(title, href) {
  if (window.location.pathname === href) {
    return title
  } else {
    return tag('a', {href}, title)
  }
}
