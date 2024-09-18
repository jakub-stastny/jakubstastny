(ns my-header
  (:require [helpers :refer [no-self-referring-link]])
  (:require-macros [macros :refer [component]]))

(defn render []
  #html [:<>
         [:link {:rel "stylesheet" :href "/css/styles.css"}]
         [:link {:rel "stylesheet" :href "/css/my-header.css"}]
         [:header
          [:div {:class "wrapper" :style "opacity: 0;"}]
          [:h1 (no-self-referring-link "Jakub Šťastný" "/")]
          [:h2 {:class "tagline"} "Spiritual guide & energy healer"]]])

(component MyHeader "my-header" render)
