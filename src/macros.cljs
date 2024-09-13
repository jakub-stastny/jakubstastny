(ns macros)

(defmacro create-class [class-name]
  `(cherry.core/defclass ~class-name))

;; (defmacro create-class [class-name & args]
;;   `(cherry.core/defclass ~class-name ~@args))


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

;(def ^:private mode #js {"mode" "open"})
(defmacro component [class-name element-name render-fn]
  `(do
     (cherry.core/defclass ~class-name
       (~'extends js/HTMLElement)
       (~'constructor [~'this]
        (~'super)
        ;; you can't emit a JS object from a macro
        ;; (.attachShadow ~'this #js {"mode" "open"})
        (.attachShadow ~'this (js-obj "mode" "open"))
        )
       ~'Object
       (~'connectedCallback [~'this]
        (~'set! (.-innerHTML ~'this) (~render-fn))))
     (js/customElements.define ~element-name ~class-name)))

;; (defmacro component [class-name tag-name render-fn]
;;   `(do
;;      (defclass ~class-name
;;        (extends HTMLElement)

;;        (constructor [this]
;;          (super)
;;          (.attachShadow this #js {"mode" "open"}))

;;        Object
;;        (connectedCallback [this]
;;          (~render-fn (.-shadowRoot this))))

;;      (js/customElements.define ~tag-name ~class-name)))
