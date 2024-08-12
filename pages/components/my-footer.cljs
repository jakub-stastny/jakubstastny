(ns my-footer
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [tag css-var get!]]))

;; TODO: Push upwards.
(def config
  {:youtube-link "https://www.youtube.com/@jakub-stastny"
   :reddit-link "https://www.reddit.com/user/jakubstastny"})

(defn social-icon [name link]
  (tag :a {:href link :target "_blank" :rel "noopener"}
       (tag :fa-icon {:name (str "brands/" name)
                      :colour (css-var (str name "-colour"))})))

(defn render [root]
  (let [copyright (tag :li (tag :a {:href "/uncopyright"} "uncopyright"))

        fa-envelope
        (tag :fa-icon {:name "envelope" :colour (css-var "envelope-colour")})

        envelope (tag :li (tag :my-email {:subject "Hey there!"} (tag :a fa-envelope)))
        youtube (tag :li (social-icon "youtube" (get! config :youtube-link)))
        reddit (tag :li (social-icon "reddit" (get! config :reddit-link)))

        social-icons (tag :ul {:class "inline-list"} [youtube envelope reddit copyright])]
    (.appendChild root (tag :script {:type "module" :src "/components/fa-icon.mjs"}))
    (.appendChild root (tag :script {:type "module" :src "/components/my-email.mjs"}))
    (.appendChild root (tag :link {:rel "stylesheet" :href "/css/styles.css"}))
    (.appendChild root (tag :link {:rel "stylesheet" :href "/css/footer.css"}))
    (.appendChild root (tag :footer social-icons))))

(defclass MyFooter
  (extends HTMLElement)

  (constructor [this]
               (super)
               (.attachShadow this #js {"mode" "open"}))

  Object
  (connectedCallback [this]
                     (render (.-shadowRoot this))))

(js/customElements.define "my-footer" MyFooter)
