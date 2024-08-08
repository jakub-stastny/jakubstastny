(ns my-header
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [append-tag tag no-self-referring-link]]))

(defclass MyHeader
  (extends HTMLElement)

  (constructor [this]
               (super)
               (let [shadow (.attachShadow this #js {"mode" "open"})]
                 (append-tag this
                             (tag :style
                                  "header { background: #f1f1f1; padding: 40px; text-align: center; position: relative; bottom: 0; width: 100%; }"))
                 (append-tag this (tag :link {:rel "stylesheet" :href "/assets/styles.css"}))

                 ;; header>h1>a
                 (append-tag this (tag :header
                                       [(tag :h1 (no-self-referring-link "Jakub Šťastný" "/"))])))))

(js/customElements.define "my-header" MyHeader)
