(ns my-newsletter
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [tag]]))

(defn render [root]
  (.appendChild root (tag :link {:rel "stylesheet" :href "/css/styles.css"}))
  (.appendChild root (tag :link {:rel "stylesheet" :href "/css/newsletter.css"}))
  (.appendChild root (tag :div {:style "height: 70px; background: aliceblue;"})))

(defclass MyNewsletter
  (extends HTMLElement)

  (constructor [this]
               (super)
               (.attachShadow this #js {"mode" "open"}))

  Object
  (connectedCallback [this]
                     (render (.-shadowRoot this))))

(js/customElements.define "my-newsletter" MyNewsletter)
