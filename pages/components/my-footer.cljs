(ns my-footer
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [append-tag tag no-self-referring-link]]))

(defclass MyFooter
  (extends HTMLElement)

  (constructor [this]
               (super)
               (let [shadow (.attachShadow this #js {"mode" "open"})]
                 (append-tag this (tag :script {:type "module" :src "/components/fa-icon.mjs"}))
                 (append-tag this (tag :link {:rel "stylesheet" :href "/css/styles.css"}))
                 (append-tag this (tag :link {:rel "stylesheet" :href "/css/footer.css"}))
                 (append-tag this (tag :footer
                                       [(tag :p {:class "copyright"} (str "Jakub Šťastný " (.getFullYear (js/Date.))))
                                        (tag :ul {:class "inline-list"}
                                             [(tag :li (no-self-referring-link "Main page" "/"))
                                              (tag :li (no-self-referring-link "About me" "/about"))
                                              (tag :li (no-self-referring-link "Services" "/services"))
                                              ;; (no-self-referring-link (tag :fa-icon {:name "envelope"}) "/contact")
                                              (tag :li (no-self-referring-link "Contact" "/contact"))])])))))

(js/customElements.define "my-footer" MyFooter)