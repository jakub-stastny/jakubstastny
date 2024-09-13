(ns my-nav
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [no-self-referring-link get!]]
            [router :refer [router]]))

(defn- item-link
  ([router-entry]
   (item-link router-entry {}))
  ([router-entry opts]
   (no-self-referring-link
    (get! router-entry :title)
    (get! router-entry :path)
    opts)))

(defn render []
  (let [main (item-link (get! router :index))
        about (item-link (get! router :about))
        spiritual-guidance (item-link (get! router :services-guidance))
        astro-reading (item-link (get! router :services-reading))
        remote-healing (item-link (get! router :services-healing))
        services [(item-link (get! router :services) {:class "mobile"})
                  #html [:ul {:class "large-screen"}
                         [:li spiritual-guidance]
                         [:li astro-reading]
                         [:li remote-healing]]]
        contact (item-link (get! router :contact))]
    #html [:<>
           [:link {:rel "stylesheet" :href "/css/styles.css"}]
           [:link {:rel "stylesheet" :href "/css/my-nav.css"}]
           [:nav
            [:ul [:li main] [:li about] [:li services] [:li contact]]]]))

(defclass MyNav
  (extends HTMLElement)

  (constructor [this]
               (super)
               (.attachShadow this #js {"mode" "open"}))

  Object
  (connectedCallback [this] (set! (.-innerHTML this) (render))))

(js/customElements.define "my-nav" MyNav)
