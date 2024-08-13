(ns my-nav
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [tag no-self-referring-link]]
            [router :refer [router]]))

(defn item-link [router-entry]
  (no-self-referring-link (:title router-entry) (:path router-entry)))

(defn render [root]
  (.appendChild root (tag :link {:rel "stylesheet" :href "/css/styles.css"}))
  (.appendChild root (tag :link {:rel "stylesheet" :href "/css/nav.css"}))

  (let [main (item-link (:index router))
        about (item-link (:about router))
        spiritual-guidance (item-link (:services-guidance router))
        astro-reading (item-link (:services-reading router))
        remote-healing (item-link (:services-healing router))
        services [(item-link (:services router))
                  (tag :ul
                       [(tag :li spiritual-guidance)
                        (tag :li astro-reading)
                        (tag :li remote-healing)])]
        contact (item-link (:contact router))]
    (.appendChild root
                  (tag :nav
                       (tag :ul
                            [(tag :li main)
                             (tag :li about)
                             (tag :li services)
                             (tag :li contact)])))))

(defclass MyNav
  (extends HTMLElement)

  (constructor [this]
               (super)
               (.attachShadow this #js {"mode" "open"}))

  Object
  (connectedCallback [this]
                     (render (.-shadowRoot this))))

(js/customElements.define "my-nav" MyNav)
