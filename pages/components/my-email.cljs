(ns my-footer
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [tag]]))

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
  (build-email [this]
               (str "jakub.stastny.pt" "+" "web" "@" "gmail.com"))

  (build-mailto [this subject]
                (str "mailto:" (.build-email this) "?subject=" (js/encodeURIComponent subject)))

  (insert-default [this]
                  (let [subject (or (.getAttribute this "subject") "")
                        email (.build-email this)
                        mailto (.build-mailto this subject)]
                    (.appendChild (.-shadowRoot this) (tag :a {:href mailto} email))))

  (update-in-slot [this slot-children]
                  (let [subject (or (.getAttribute this "subject") "")
                        mailto (.build-mailto this subject)]
                    (doseq [node slot-children]
                      (js/console.log node) ;;;;
                      (when (and (instance? js/HTMLElement node)
                                 (= (.-tagName node) "A"))
                        (set! (.-href node) mailto)))))

  (connectedCallback [this]
                     (let [slot (.querySelector (.-shadowRoot this) "slot")
                           slot-children (.assignedNodes slot)]
                       (if (empty? slot-children)
                         (.insert-default this slot-children)
                         (.update-in-slot this slot-children)))))

(js/customElements.define "my-email" MyEmail)
