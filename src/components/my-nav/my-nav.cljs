(ns my-nav
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [tag no-self-referring-link get!]]
            [router :refer [router]]))

(defn- item-link
  ([router-entry]
   (item-link router-entry {}))
  ([router-entry opts]
   (no-self-referring-link
    (get! router-entry :title)
    (get! router-entry :path)
    opts)))

(defn- render [root]
  (.appendChild root (tag :link {:rel "stylesheet" :href "/css/styles.css"}))
  (.appendChild root (tag :link {:rel "stylesheet" :href "/css/my-nav.css"}))

  (let [main (item-link (get! router :index))
        about (item-link (get! router :about))
        spiritual-guidance (item-link (get! router :services-guidance))
        astro-reading (item-link (get! router :services-reading))
        remote-healing (item-link (get! router :services-healing))
        services [(item-link (get! router :services) {:class "mobile"})
                  (tag :ul {:class "large-screen"}
                       [(tag :li spiritual-guidance)
                        (tag :li astro-reading)
                        (tag :li remote-healing)])]
        contact (item-link (get! router :contact))]
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
