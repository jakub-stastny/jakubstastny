(ns fa-icon
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [tag]]))

(defclass FaIcon
  (extends HTMLElement)
  (constructor [this] (super))

  Object
  (connectedCallback [this]
   (let [path (str "/assets/fa/svgs/solid/" (.getAttribute this "name") ".svg")]
     (.appendChild this (tag :object {:type "image/svg+xml" :data path :style "height: 14pt"})))))

(js/customElements.define "fa-icon" FaIcon)
