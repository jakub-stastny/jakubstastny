(ns my-footer
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [append-tag tag no-self-referring-link]]))

(defclass MyFooter
  (extends HTMLElement)

  (constructor [this]
               (super)
               (let [shadow (.attachShadow this #js {"mode" "open"})]
                 (append-tag this (tag :link {:rel "stylesheet"
                                              :href "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"}))
                 (append-tag this (tag :footer
                                       [(tag :p "Jakub Šťastný 2024")
                                        (no-self-referring-link
                                         (tag :i {:class "fas fa-envelope icon"}) "/contact")])))))

(js/customElements.define "my-footer" MyFooter)
