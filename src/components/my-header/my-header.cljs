(ns my-header
  (:require [helpers :refer [no-self-referring-link]])
  (:require-macros [macros :refer [component]]))

(defn render []
  #html [:<>
         [:link {:rel "stylesheet" :href "/css/styles.css"}]
         [:link {:rel "stylesheet" :href "/css/my-header.css"}]
         [:header
          [:div {:class "wrapper" :style "opacity: 0;"}]
          [:h1 (no-self-referring-link "Know thy Self" "/")]
          [:h2 {:class "tagline"} "Guiding you to wholeness"]]])

(component MyHeader "my-header" render)
