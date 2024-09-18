(ns my-newsletter
  (:require [config :refer [custom-domain]])
  (:require-macros [macros :refer [component]]))

(js/import "/js/fa-icon.mjs")

(defn prn [& args]
  (apply js/console.log (map #(clj->js %) args)))

(def subscribe-endpoint (str custom-domain "/.netlify/functions/subscribe"))

(defn- ^:async subscribe [email]
  (let [headers
        {:method "POST"
         :headers {"Content-Type" "application/json"}
         :body (js/JSON.stringify (clj->js {:email email}))}]
    (try
      (js/await (js/fetch subscribe-endpoint (clj->js headers)))
        ;; TODO: Show success message.
      (catch js/Error e
        ;; TODO: Show error message.
        (js/console.error "Error:" e)))))

(defn- submit-handler [event]
  (.preventDefault event)
  ;; TODO: Show a spinner, it looks like nothing's going on.
  (let [form (.-target event)]
    (subscribe (.. form -email -value))))

(defn render []
  #html [:<>
         [:link {:rel "stylesheet" :href "/css/styles.css"}]
         [:link {:rel "stylesheet" :href "/css/my-newsletter.css"}]

         [:h2 "Newsletter"]
         [:fa-icon {:name "spinner" :style "visibility: hidden"}]
         [:form
          [:div {:style "display: flex"}
           [:input {:type "email" :name "email" :required true :placeholder "you@email.com"}]
           [:button {:type "submit"} "Subscribe"]]]])

(defn setup [component shadow-root]
  (let [form (.querySelector shadow-root "form")]
    (.addEventListener form "submit" submit-handler)))

(component MyNewsletter "my-newsletter" render setup)
