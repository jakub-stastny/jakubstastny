(ns macros
  (:require [cherry.core :refer [defclass]]))

(defmacro create-class [class-name]
  `(cherry.core/defclass ~class-name))


;; (defclass MyFooter
;;   (extends HTMLElement)

;;   (constructor [this]
;;                (super)
;;                (.attachShadow this #js {"mode" "open"}))

;;   Object
;;   (connectedCallback [this]
;;                      (render (.-shadowRoot this))))

;; (js/customElements.define "my-footer" MyFooter)

;; (defmacro component [element-name render-fn]
;;   `(js/customElements.define ~element-name
;;      (defclass
;;        (~'extends js/HTMLElement)
;;        (~'constructor [~'this]
;;          (~'super)
;;          (.attachShadow ~'this #js {"mode" "open"}))
;;        ~'Object
;;        (~'connectedCallback [~'this]
;;          (~render-fn (.-shadowRoot ~'this))))))

;; (defmacro component [class-name element-name render-fn]
;;   `(do
;;      (defclass ~class-name
;;        (~'extends js/HTMLElement)
;;        (~'constructor [~'this]
;;          (~'super)
;;          (js/console.log "HERE")
;;          (.attachShadow ~'this #js {"mode" "open"}))
;;        ~'Object
;;        (~'connectedCallback [~'this]
;;          (~render-fn (.-shadowRoot ~'this))))
;;      (js/customElements.define ~element-name ~class-name)))

;; (defmacro component [class-name tag-name render-fn]
;;   `(do
;;      (defclass ~class-name
;;        (extends HTMLElement)

;;        (constructor [this]
;;          (super)
;;          (js/console.log "HERE")
;;          (.attachShadow this #js {"mode" "open"}))

;;        Object
;;        (connectedCallback [this]
;;          (~render-fn (.-shadowRoot this))))

;;      (js/customElements.define ~tag-name ~class-name)))
