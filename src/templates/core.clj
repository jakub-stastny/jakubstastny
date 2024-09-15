(ns templates.core
  (:require [hiccup2.core :as h]
            [cheshire.core :as json]
            [clojure.walk :as walk]))

(def import-map
  {:imports
   { ;;:cherry-cljs "/vendor/cherry-cljs"
    "cherry-cljs/cljs.core.js" "/vendor/cherry-cljs/cljs.core.js"
    "squint-cljs/src/squint/html.js" "/vendor/squint-cljs/html.js"
    :helpers "/js/helpers.mjs"
    :config "/js/config.mjs"
    :router "/js/router.mjs"}})

(def ga-initiation-code
  (str
   "if (window.location.hostname !== 'localhost' && window.location.hostname !== '127.0.0.1') {"
   "window.dataLayer = window.dataLayer || []; function gtag() { dataLayer.push(arguments) };"
   "gtag('js', new Date()); gtag('config', 'G-KQSJ36RMR3') }"))

(def routes
  {:index {:path "/" :title "Main page"}
   :about {:path "/about" :title "About me"}
   :services-guidance {:path "/services/spiritual-guidance" :title "Spiritual guidance"}
   :services-reading {:path "/services/intuitive-astrology-reading" :title "Intuitive astrology reading"}
   :services-healing {:path "/services/remote-energy-healing" :title "Remote energy healing"}
   :services {:path "/services" :title "Services"}
   :contact {:path "/contact" :title "Contact"}
   :uncopyright {:path "/uncopyright" :title "Uncopyright"}})

(def external-links
  {:gh-project-link "https://github.com/jakub-stastny/oso"
   :youtube-link "https://www.youtube.com/@jakub-stastny"
   :reddit-link "https://www.reddit.com/user/jakubstastny"
   :zenhabits-uncopyright "https://zenhabits.net/uncopyright"})

(def router
  (merge
   (reduce-kv (fn [acc k v] (assoc acc k (:path v))) {} routes)
   external-links))

(defn replace-href-keywords [node]
  (if (and (map? node) (:href node) (keyword? (:href node)))
    (update node :href router)
    node))

(defn run-filters [content]
  (walk/postwalk replace-href-keywords content))

(defn template [title content]
  (str
   (h/html (h/raw "<!DOCTYPE html>")
           [:html {:lang "en"}
            [:head
             [:title title]
             [:meta {:charset "utf-8"}]
             [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
             [:script {:type "importmap"} (h/raw (json/generate-string import-map))]
             [:link {:rel "stylesheet" :href "/css/layout.css"}]
             [:link {:rel "stylesheet" :href "/css/styles.css"}]

             ;; TODO: Only load what given page needs.
             [:script {:type "module" :src "/js/fa-icon.mjs"}]
             [:script {:type "module" :src "/js/my-email.mjs"}]

             [:script {:type "module" :src "/js/my-header.mjs"}]
             [:script {:type "module" :src "/js/my-nav.mjs"}]
             [:script {:type "module" :src "/js/my-footer.mjs"}]
             [:script {:type "module" :src "/js/my-newsletter.mjs"}]

             ;; Google Analytics 4 (gtag.js)
             [:script {:async true :src "https://www.googletagmanager.com/gtag/js?id=G-KQSJ36RMR3"}]
             [:script (h/raw ga-initiation-code)]]

            [:body
             [:div.main
              [:my-header]
              [:my-nav]
              (into [:main] (run-filters content))
              [:my-footer]]]])))
