(ns my-header
  (:require [cherry.core :refer [defclass]]))

(defn- set-attrs [element map]
  (doseq [[key value] map]
    (.setAttribute element (name key) value))
  element)

(defn- set-children [element list]
  (doseq [child list]
    (.appendChild element child)))

(defn- set-inner-html [element html]
  (set! element -innerHTML html))

(defn tag
  ([tag-name]
   ;; (tag :hr)
   (js/document.createElement (name tag-name)))

  ([tag-name arg]
   (let [element (js/document.createElement (name tag-name))]
     (js/console.log "eljs" element)

     (cond
       ;; (tag :link {:rel "stylesheet" :href "..."})
       (map? arg)
       (do (set-attrs element arg) element)

       ;; (tag :header [(tag :h1 "Site name")])
       (vector? arg)
       (do (set-children element arg) element)

       ;; (tag :h1 "Site name")
       (string? arg)
       (do (set-inner-html element arg) element)

       :else
       (throw (js/TypeError. "Invalid argument type"))))))

(defn append-tag [instance tag-or-tag-name & tag-opts]
  (let [shadow-root (.-shadowRoot instance)
        child-node (if (symbol? tag-or-tag-name) (apply tag tag-or-tag-name tag-opts) tag-or-tag-name)]
    ;; (js/console.log "append-tag to " shadow-root child-node)
    (.appendChild shadow-root child-node)))

(defn no-self-referring-link [title link]
  (if (= js/window.location.pathname link)
    title
    (tag :a {:href link} title)))

(defonce style-content "header {
  background: #f1f1f1;
  padding: 40px;
  text-align: center;
  position: relative;
  bottom: 0;
  width: 100%;
}")

(defclass MyHeader
  (extends HTMLElement)

  (constructor [this]
               (super)
               (let [shadow (.attachShadow this #js {"mode" "open"})]
                 (append-tag this (tag :style style-content))
                 (append-tag this (tag :link {:rel "stylesheet" :href "/assets/styles.css"}))

                 ;; header>h1>a
                 (append-tag this (tag :header
                                       [(tag :h1 (no-self-referring-link "Jakub Šťastný" "/"))])))))

(js/customElements.define "my-header" MyHeader)
