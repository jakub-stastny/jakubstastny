(ns my-footer
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [tag css-var]]
            [config :refer [youtube-link reddit-link]])
  (:require-macros [macros :refer [component]]))

(defn- social-icon [name link]
  (tag :a {:href link :target "_blank" :rel "noopener"}
       (tag :fa-icon {:name (str "brands/" name)
                      :colour (css-var (str name "-colour"))})))

(defn render-envelope []
  #html [:li [:my-email {:subject "Hey there!"}]
         [:a [:fa-icon {:name "envelope" :colour (css-var "envelope-colour")}]]])

(defn render []
  (let [youtube (tag :li (social-icon "youtube" youtube-link))
        reddit (tag :li (social-icon "reddit" reddit-link))]
    #html [:<>
           [:script {:type "module" :src "/js/fa-icon.mjs"}]
           [:script {:type "module" :src "/js/my-email.mjs"}]
           [:link {:rel "stylesheet" :src "/css/styles.css"}]
           [:link {:rel "stylesheet" :src "/css/my-footer.css"}]
           [:footer [:ul {:class "footer-icons"}] [youtube (render-envelope) reddit]]]))

(component MyFooter "my-footer" render)
