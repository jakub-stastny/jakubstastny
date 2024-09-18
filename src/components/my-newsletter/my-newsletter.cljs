(ns my-newsletter
  (:require-macros [macros :refer [component]]))

(defn- subscribe [email]
  (js/console.log "EMAIL" email)
  ;; TODO: POST to /.netlify/functions/subscribe
  )

(defn- submit-handler [event]
  (.preventDefault event)
  (let [form (.-target event)]
    (subscribe (.. form -email -value))))

(defn render []
  #html [:<>
         [:link {:rel "stylesheet" :href "/css/styles.css"}]
         [:link {:rel "stylesheet" :href "/css/my-newsletter.css"}]

         [:h2 "Newsletter"]
         [:form
          [:div {:style "display: flex"}
           [:input {:type "email" :name "email" :placeholder "you@email.com"}]
           [:button {:type "submit"} "Subscribe"]]]])

(defn setup [component shadow-root]
  (let [form (.querySelector shadow-root "form")]
    (.addEventListener form "submit" submit-handler)))

(component MyNewsletter "my-newsletter" render setup)
