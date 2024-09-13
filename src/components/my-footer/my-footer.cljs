(ns my-footer
  (:require [helpers :refer [css-var]]
            [config :refer [youtube-link reddit-link]])
  (:require-macros [macros :refer [component]]))

(defn- social-icon [name link]
  #html [:a {:href link :target "_blank" :rel "noopener"}
         [:fa-icon {:name (str "brands/" name)
                    :colour (css-var (str name "-colour"))}]])

(defn- render-footer []
  #html [:ul {:class "footer-icons"}
         [:li (social-icon "youtube" youtube-link)]
         [:li [:my-email {:subject "Hey there!"}]
          [:a [:fa-icon {:name "envelope" :colour (css-var "envelope-colour")}]]]
         [:li (social-icon "reddit" reddit-link)]])

(defn render []
  #html [:<>
         [:script {:type "module" :src "/js/fa-icon.mjs"}]
         [:script {:type "module" :src "/js/my-email.mjs"}]
         [:link {:rel "stylesheet" :src "/css/styles.css"}]
         [:link {:rel "stylesheet" :src "/css/my-footer.css"}]
         [:footer (render-footer)]])

(component MyFooter "my-footer" render)
