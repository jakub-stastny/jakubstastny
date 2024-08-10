(ns my-footer
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


(defclass MyFooter
  (extends HTMLElement)

  (constructor [this]
               (super)
               (let [shadow (.attachShadow this #js {"mode" "open"})]
                 ;; (append-tag this (tag :link {:rel "stylesheet"
                 ;;                              :href "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"}))

                 ;; (append-tag this
                 ;;             (tag :symbol
                 ;;                  {:id "envelope" :viewBox "0 0 512 512"}
                 ;;                  (tag :path
                 ;;                       {:d "M48 64C21.5 64 0 85.5 0 112c0 15.1 7.1 29.3 19.2 38.4L236.8 313.6c11.4 8.5 27 8.5 38.4 0L492.8 150.4c12.1-9.1 19.2-23.3 19.2-38.4c0-26.5-21.5-48-48-48L48 64zM0 176L0 384c0 35.3 28.7 64 64 64l384 0c35.3 0 64-28.7 64-64l0-208L294.4 339.2c-22.8 17.1-54 17.1-76.8 0L0 176z"})))

                 (append-tag this (tag :footer
                                       [(tag :p (str "Jakub Šťastný " (.getFullYear (js/Date.))))
                                        (tag :object {:type "image/svg+xml" :data "/assets/fa/svgs/solid/envelope.svg"})
                                        (tag :svg {:width 25} (tag :use {:href "#envelope"}))
                                        (tag :fa-icon {:name "envelope" :source "my-footer"})
                                        (no-self-referring-link
                                         (tag :i {:class "fa-solid fa-envelope"}) "/contact")])))))

(js/customElements.define "my-footer" MyFooter)
