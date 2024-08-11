(ns fa-icon
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [tag]]))

;; This approach didn't work with <a href="/contact"><fa-icon.
;; (.appendChild this (tag :object {:type "image/svg+xml" :data path :style "height: 14pt"}))
(defclass FaIcon
  (extends HTMLElement)
  (constructor [this] (super))

  Object
  (^:async connectedCallback [this]
   (let [name (.getAttribute this "name")
         path (str "/assets/fa/svgs/" name ".svg")
         response (js/await (js/fetch path))
         svg (js/await (.text response))]
     (set! (.-innerHTML this) svg)
     ;; This is a bit silly. Maybe wrap in a div and set the style of the div.
     (js* "this.getElementsByTagName('svg')[0].style.height = '14pt'"))))

(js/customElements.define "fa-icon" FaIcon)
