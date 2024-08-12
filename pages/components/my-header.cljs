(ns my-header
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [append-tag tag no-self-referring-link]]))

(defclass MyHeader
  (extends HTMLElement)

  (constructor [this]
               (super)
               (let [shadow (.attachShadow this #js {"mode" "open"})]
                 (append-tag this (tag :link {:rel "stylesheet" :href "/css/styles.css"}))
                 (append-tag this (tag :link {:rel "stylesheet" :href "/css/header.css"}))
                 (append-tag this (tag :header
                                       (tag :div {:class "wrapper"}
                                            [(tag :h1 (no-self-referring-link "Jakub Šťastný" "/"))
                                             (tag :h2 {:class "tagline"} "Guiding you to wholeness")]))))))

(js/customElements.define "my-header" MyHeader)
