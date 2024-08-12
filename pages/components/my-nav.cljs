(ns my-nav
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [tag no-self-referring-link]]))

(defn render [root]
  (.appendChild root (tag :link {:rel "stylesheet" :href "/css/styles.css"}))
  (.appendChild root (tag :link {:rel "stylesheet" :href "/css/nav.css"}))
  (.appendChild root (tag :nav {:style "margin: 2ex;"}
                        (tag :ul
                             [(tag :li (no-self-referring-link "Main page" "/"))
                              (tag :li (no-self-referring-link "About me" "/about"))
                              (tag :li (no-self-referring-link "Services" "/services"))
                              (tag :li (no-self-referring-link "Contact" "/contact"))]))))

(defclass MyNav
  (extends HTMLElement)

  (constructor [this]
               (super)
               (.attachShadow this #js {"mode" "open"}))

  Object
  (connectedCallback [this]
                     (render (.-shadowRoot this))))

(js/customElements.define "my-nav" MyNav)
