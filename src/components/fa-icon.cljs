(ns fa-icon
  (:require [cherry.core :refer [defclass]]))

;; This approach didn't work with <a href="/contact"><fa-icon:
;; <object type="image/svg+xml" data={path} :style "height: 14pt">
(defclass FaIcon
  (extends HTMLElement)
  (constructor [this] (super))

  Object
  (^:async connectedCallback [this]
   (let [name (.getAttribute this "name")
         qualified-name (if (.includes name "/") name (str "solid/" name))
         path (str "/svg/" qualified-name ".svg")
         response (js/await (js/fetch path))
         svg (js/await (.text response))
         colour (.getAttribute this "colour")]
     (set! (.-innerHTML this) svg)

     ;; This is a bit silly. Maybe wrap in a div and set the style of the div.
     (js* "const svg = this.getElementsByTagName('svg')[0]")
     (js* "svg.style.height = '14pt'")

     (when colour
       (js* "svg.children[0].setAttribute('fill', this.getAttribute('colour'))")))))

(js/customElements.define "fa-icon" FaIcon)
