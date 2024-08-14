(ns my-newsletter
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [tag]]))

(defn- render [root]
  (.appendChild root (tag :link {:rel "stylesheet" :href "/css/styles.css"}))
  (.appendChild root (tag :link {:rel "stylesheet" :href "/css/my-newsletter.css"}))
  (.appendChild root (tag :script {:src "https://assets.mailerlite.com/js/universal.js" :async true}))
  (.appendChild root (tag :div {:class "ml-embedded" :data-form "GUqqOq"})))

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
                     (render (.-shadowRoot this))
                     (initialize-mailer-lite)))

(js/customElements.define "my-newsletter" MyNewsletter)
