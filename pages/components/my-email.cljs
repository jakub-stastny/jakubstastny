(ns my-footer
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [tag]]
            [config :refer [email-chunks]]))

(defn build-email [] (apply str email-chunks))

(defn build-mailto [subject]
  (str "mailto:" (build-email) "?subject=" (js/encodeURIComponent subject)))

(defn insert-default [root subject]
  (let [email (build-email)
        mailto (build-mailto subject)]
    (.appendChild root (tag :a {:href mailto} email))))

(defn update-in-slot [subject slot-children]
  (let [mailto (build-mailto subject)]
    (doseq [node slot-children]
      (when (and (instance? js/HTMLElement node)
                 (= (.-tagName node) "A"))
        (set! (.-href node) mailto)))))

;; Insert default mailto link:
;; <my-email></my-email>
;;
;; Update href:
;; <my-email subject="Hey there!" >
;;   <a class="button">Order now</a>
;; </my-email>
(defclass MyEmail
  (extends HTMLElement)

  (constructor [this]
               (super)
               (.attachShadow this #js {"mode" "open"})
               (.appendChild (.-shadowRoot this) (tag :slot)))

  Object
  (connectedCallback [this]
                     (let [subject (or (.getAttribute this "subject") "")
                           slot (.querySelector (.-shadowRoot this) "slot")
                           slot-children (.assignedNodes slot)]
                       (if (empty? slot-children)
                         (insert-default (.-shadowRoot this) subject)
                         (update-in-slot subject slot-children)))))

(js/customElements.define "my-email" MyEmail)
