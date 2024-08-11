(ns my-footer
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [tag no-self-referring-link css-var]]))

(defn social-icon [name link]
  (tag :a {:href link :target "_blank" :rel "noopener"}
       (tag :fa-icon {:name (str "brands/" name)
                      :colour (css-var (str name "-colour"))})))

(defclass MyFooter
  (extends HTMLElement)

  (constructor [this]
               (super)
               (let [shadow-root (.attachShadow this #js {"mode" "open"})
                     copyright
                     (tag :p {:class "copyright"}
                          [(tag :a {:href "/uncopyright"} "uncopyright")
                           (str " " (.getFullYear (js/Date.)))])

                     fa-envelope
                     (tag :fa-icon {:name "envelope" :colour (css-var "envelope-colour")})

                     envelope (tag :li (tag :my-email {:subject "Hey there!"} (tag :a fa-envelope)))
                     youtube (tag :li (social-icon "youtube" "https://www.youtube.com/@jakub-stastny"))
                     reddit  (tag :li (social-icon "reddit" "https://www.reddit.com/user/jakubstastny"))

                     social-icons (tag :ul {:class "inline-list"} [envelope youtube reddit])]
                 (.appendChild shadow-root (tag :script {:type "module" :src "/components/fa-icon.mjs"}))
                 (.appendChild shadow-root (tag :script {:type "module" :src "/components/my-email.mjs"}))
                 (.appendChild shadow-root (tag :link {:rel "stylesheet" :href "/css/styles.css"}))
                 (.appendChild shadow-root (tag :link {:rel "stylesheet" :href "/css/footer.css"}))
                 (.appendChild shadow-root (tag :footer [copyright social-icons])))))

(js/customElements.define "my-footer" MyFooter)
