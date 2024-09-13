(ns my-header
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [no-self-referring-link]]))

(defn render []
  #html [:<>
         [:link {:rel "stylesheet" :href "/css/styles.css"}]
         [:link {:rel "stylesheet" :href "/css/my-header.css"}]
         [:header
          [:div {:class "wrapper" :style "opacity: 0;"}]
          [:h1 (no-self-referring-link "Know thy Self" "/")]
          [:h2 {:class "tagline"} "Guiding you to wholeness"]]])

(defclass MyHeader
  (extends HTMLElement)

  (constructor [this]
               (super)
               (.attachShadow this #js {"mode" "open"}))

  Object
  (connectedCallback [this] (set! (.-innerHTML this) (render))))

(js/customElements.define "my-header" MyHeader)
