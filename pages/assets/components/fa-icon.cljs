(ns fa-icon
  (:require [cherry.core :refer [defclass]]
            [helpers :refer [append-tag tag no-self-referring-link]]))

(defn ^:async fetch-sprites [callback]
  (let [response (js/await (js/fetch "http://localhost:9000/assets/fa/sprites/solid.svg"))]
    (js/console.log response)
    (callback)))

(defn ahorita [callback]
  (setTimeout callback 3000))

(defclass FaIcon
  (extends HTMLElement)
  ;; (field -innerHTML)
                                        ;(set! -innerHTML "<svg><use href='http://localhost:9000/assets/fa/sprites/solid.svg#envelope'></use></svg>")

  (constructor [this]
               (super)
                                        ;(.attachShadow this #js {"mode" "open"})
                                        ;(append-tag this (tag :svg (tag :use {:href (str "http://localhost:9000/assets/fa/sprites/solid.svg#" (.getAttribute this "name"))})))
               )

  Object
  (connectedCallback [this]
                     (js/console.log "FaIcon connected: " (.getAttribute this "source"))
                     ;; The fetch works, if I remove the fetch, the sprites are never requested (using svg>use).
                     (fetch-sprites #(.render this))
                     ;;(fetch-sprites (fn [] (ahorita #(.render this))))
                     ;; (.render this)
                     )

  (render [this]
          (js/console.log "FaIcon render:" (.getAttribute this "source"))
          (.appendChild this
                        ;; (tag :b "test")) ; <-- this one works
                        (tag :svg (tag :use {:href (str "http://localhost:9000/assets/fa/sprites/solid.svg#" (.getAttribute this "name"))})))
          ))

(js/customElements.define "fa-icon" FaIcon)
