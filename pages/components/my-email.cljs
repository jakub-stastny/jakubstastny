(ns my-footer
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [tag]]))

(defclass MyEmail
  (extends HTMLElement)

  (constructor [this]
               (super)
               (let [username "jakub.stastny.pt"
                     plus-address "web"
                     hostname "gmail.com"
                     email (str username "+" plus-address "@" hostname)
                     subject (or (.getAttribute this "subject") "")
                     encoded-subject (js/encodeURIComponent subject)]
                 (.appendChild this (tag :a {:href (str "mailto:" email "?subject=" encoded-subject)} email)))))

(js/customElements.define "my-email" MyEmail)
