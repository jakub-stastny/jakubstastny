(ns my-newsletter
  (:require [cherry.core :refer [defclass]]))

(defn render []
  #html [:<>
         [:link {:rel "stylesheet" :href "/css/styles.css"}]
         [:link {:rel "stylesheet" :href "/css/my-newsletter.css"}]
         [:script {:src "https://assets.mailerlite.com/js/universal.js" :async true}]

         [:h2 "Newsletter"]
         [:div {:class "ml-embedded" :data-form "GUqqOq"}]])

;; (defn- ml-fn [& args]
;;   (js/console.log "MailerLite" (clj->js args))
;;   (aset (.-ml js/window) "q"
;;         (conj (or (.-q (.-ml js/window)) [])
;;               args)))

;; (defn- initialize-mailer-lite []
;;   (aset js/window "ml" ml-fn)
;;   (ml-fn "account" "1062534"))

;; https://dashboard.mailerlite.com/forms/129574726427214925/overview
(defn- initialize-mailer-lite []
  (js* "(function(w,d,e,u,f,l,n){w[f]=w[f]||function(){(w[f].q=w[f].q||[])
    .push(arguments);},l=d.createElement(e),l.async=1,l.src=u,
    n=d.getElementsByTagName(e)[0],n.parentNode.insertBefore(l,n);})
    (window,document,'script','https://assets.mailerlite.com/js/universal.js','ml');
    ml('account', '1062534')"))

(defclass MyNewsletter
  (extends HTMLElement)

  ;; No shadow root -> the script tag will work.
  (constructor [this] (super))

  Object
  (connectedCallback [this]
                     (initialize-mailer-lite)
                     (set! (.-innerHTML this) (render))))

(js/customElements.define "my-newsletter" MyNewsletter)
