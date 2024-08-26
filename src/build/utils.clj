(ns utils
  (:require [clojure.string :as str]
            [babashka.fs :as fs]))

;; This simple approach works well for basic minification by reducing
;; the file size. However, it doesn’t handle advanced optimizations
;; like merging duplicate rules, resolving shorthand properties, or
;; removing unnecessary units (e.g., 0px to 0), which more sophisticated
;; minifiers do.
(defn minify-css [css]
  (-> css
      (str/replace #"/\*[^*]*\*+(?:[^/*][^*]*\*+)*/" "")
      (str/replace #"\s+" " ")
      (str/replace #"\s*([{}:;,])\s*" "$1")
      (str/trim)))

(defn ensure-parent-dir [file-path]
  (when (str/includes? (subs file-path 6) "/")
    (fs/create-dirs (str/join "/" (butlast (str/split file-path #"/"))))))

(defn gen-main [args process-args process-default]
  (if (seq args)
    (process-args args) (process-default)))
