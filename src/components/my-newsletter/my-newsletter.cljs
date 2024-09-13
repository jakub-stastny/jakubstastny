(ns my-newsletter
  (:require [cherry.core :refer [defclass]]))

(defn render []
  #html [:<>
         [:link {:rel "stylesheet" :href "/css/styles.css"}]
         [:link {:rel "stylesheet" :href "/css/my-newsletter.css"}]
         [:script {:src "https://assets.mailerlite.com/js/universal.js" :async true}]
         [:div {:class "ml-embedded" :data-form "GUqqOq"}]])

(defn- ml-fn [& args]
  (js/console.log "MailerLite" (clj->js args))
  (aset (.-ml js/window) "q"
        (conj (or (.-q (.-ml js/window)) [])
              args)))

(defn- initialize-mailer-lite []
  ;; Make ml-fn global.
  ;; WHY SHOULD IT BE GLOBAL? I don't think it's used otherwise.
  ;; Maybe on submit?
  (aset js/window "ml" ml-fn)

  ;; Initialize MailerLite.
  (ml-fn "account" "1062534"))

(defclass MyNewsletter
  (extends HTMLElement)

  (constructor [this]
               (super)
               (.attachShadow this #js {"mode" "open"}))

  Object
  (connectedCallback [this]
                     (set! (.-innerHTML this) (render))
                     (initialize-mailer-lite)))

(js/customElements.define "my-newsletter" MyNewsletter)
