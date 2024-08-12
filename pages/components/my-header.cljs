(ns my-header
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [tag no-self-referring-link]]))

(defn render [root]
  (.appendChild root (tag :link {:rel "stylesheet" :href "/css/styles.css"}))
  (.appendChild root (tag :link {:rel "stylesheet" :href "/css/header.css"}))
  (.appendChild root (tag :header
                        (tag :div {:class "wrapper"}
                             [(tag :h1 (no-self-referring-link "Jakub Šťastný" "/"))
                              (tag :h2 {:class "tagline"} "Guiding you to wholeness")]))))

(defclass MyHeader
  (extends HTMLElement)

  (constructor [this]
               (super)
               (.attachShadow this #js {"mode" "open"}))

  Object
  (connectedCallback [this]
                     (render (.-shadowRoot this))))

(js/customElements.define "my-header" MyHeader)
