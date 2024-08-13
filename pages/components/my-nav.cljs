(ns my-nav
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [tag no-self-referring-link]]))

(defn render [root]
  (.appendChild root (tag :link {:rel "stylesheet" :href "/css/styles.css"}))
  (.appendChild root (tag :link {:rel "stylesheet" :href "/css/nav.css"}))

  ;; Like this is quite good'n'all, but having router with all these including the titles and iterating over it would be better.
  ;; The router would have to be ordered correctly for this, not just a map (unless the map is ordered in CLJ, I don't know).
  (let [main (no-self-referring-link "Main page" "/")
        about (no-self-referring-link "About me" "/about")
        spiritual-guidance (no-self-referring-link "Spiritual guidance" "/services/spiritual-guidance")
        astro-reading (no-self-referring-link "Intuitive astrology reading" "/services/intuitive-astrology-reading")
        remote-healing (no-self-referring-link "Remote energy healing" "/services/remote-energy-healing")
        services ["Services"
                  (tag :ul [(tag :li spiritual-guidance) (tag :li astro-reading) (tag :li remote-healing)])]
        contact (no-self-referring-link "Contact" "/contact")]
    (.appendChild root (tag :nav (tag :ul
                                      [(tag :li main) (tag :li about)
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
