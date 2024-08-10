(ns my-footer
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [append-tag tag no-self-referring-link]]))

(defclass MyFooter
  (extends HTMLElement)

  (constructor [this]
               (super)
               (let [shadow (.attachShadow this #js {"mode" "open"})]
                 (append-tag this (tag :script {:type "module" :src "/assets/components/fa-icon.mjs"}))
                 (append-tag this (tag :footer
                                       [(tag :p (str "Jakub Šťastný " (.getFullYear (js/Date.))))
                                        (no-self-referring-link (tag :fa-icon {:name "envelope"}) "/contact")])))))

(js/customElements.define "my-footer" MyFooter)
