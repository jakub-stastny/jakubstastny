(ns my-footer
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [append-tag tag no-self-referring-link]]))

(defclass MyFooter
  (extends HTMLElement)

  (constructor [this]
               (super)
               (let [shadow (.attachShadow this #js {"mode" "open"})]
                 (append-tag this (tag :script {:type "module" :src "/components/fa-icon.mjs"}))
                 (append-tag this (tag :link {:rel "stylesheet" :href "/css/styles.css"}))
                 (append-tag this (tag :link {:rel "stylesheet" :href "/css/footer.css"}))
                 (append-tag this (tag :footer
                                       [(tag :p {:class "copyright"} (str "Jakub Šťastný " (.getFullYear (js/Date.))))
                                        (tag :ul {:class "inline-list"}
                                             [(tag :li (tag :my-email (tag :a (tag :fa-icon {:name "envelope" :colour "lightblue"}))))
                                              (tag :li (tag :a {:href "https://www.youtube.com/@jakub-stastny" :target "_blank" :rel "noopener"}
                                                            (tag :fa-icon {:name "brands/youtube" :colour "#EA3323"})))
                                              (tag :li (tag :a {:href "https://www.reddit.com/user/jakubstastny" :target "_blank" :rel "noopener"}
                                                            (tag :fa-icon {:name "brands/reddit" :colour "#EB5528"})))])])))))

(js/customElements.define "my-footer" MyFooter)
