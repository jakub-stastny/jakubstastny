(ns my-newsletter
  (:require [cherry.core :refer [defclass]]))

(defn render []
  #html [:<>
         [:link {:rel "stylesheet" :href "/css/styles.css"}]
         [:link {:rel "stylesheet" :href "/css/my-newsletter.css"}]
         [:script {:src "https://assets.mailerlite.com/js/universal.js" :async true}]

         ;; [:h2 "Newsletter"]
         [:div {:class "ml-embedded" :data-form "GUqqOq"}]])

(defn- ml-fn [& args]
  (js/console.log "MailerLite" (clj->js args))
  (aset (.-ml js/window) "q"
        (conj (or (.-q (.-ml js/window)) [])
              args)))

(defn- initialize-mailer-lite []
  (aset js/window "ml" ml-fn)
  (ml-fn "account" "1062534"))

(defclass MyNewsletter
  (extends HTMLElement)

  ;; No shadow root -> the script tag will work.
  (constructor [this] (super))

  Object
  (connectedCallback [this]
   (initialize-mailer-lite)
   (set! (.-innerHTML this) (render))))

(js/customElements.define "my-newsletter" MyNewsletter)
