(ns my-header
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [append-tag tag no-self-referring-link]]))

(defclass MyHeader
  (extends HTMLElement)

  (constructor [this]
               (super)
               (let [shadow (.attachShadow this #js {"mode" "open"})]
                 (append-tag this (tag :link {:rel "stylesheet" :href "/assets/css/styles.css"}))
                 (append-tag this (tag :link {:rel "stylesheet" :href "/assets/css/header.css"}))
                 (append-tag this (tag :header
                                       [(tag :h1 (no-self-referring-link "Jakub Šťastný" "/"))])))))

(js/customElements.define "my-header" MyHeader)
