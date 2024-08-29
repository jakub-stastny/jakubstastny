(ns utils
  (:require [clojure.string :as str]
            [config :as config]
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

(defn minify-js [code]
  (-> code
      ;; Remove single-line comments
      (str/replace #"(//.*)$" "")

      ;; Remove multi-line comments
      (str/replace #"/\*[^*]*\*+(?:[^/*][^*]*\*+)*/" "")

      ;; Replace multiple spaces or newlines with a single space
      (str/replace #"\s+" " ")

      ;; Remove spaces around JS syntax characters
      (str/replace #"\s*([{};,:()])\s*" "$1")
      (str/trim)))

(defn copy-cherry []
  (println "~ Copying Cherry JS libs.")
  (fs/delete-tree config/vendor-dir)
  (let [target-dir (str config/vendor-dir "/cherry-cljs")]
    (fs/create-dirs target-dir)
    (fs/copy "node_modules/cherry-cljs/lib/cljs.core.js" target-dir)
    ;; (fs/copy "node_modules/cherry-cljs/lib/clojure.set.js" target-dir)
    ;; (fs/copy "node_modules/cherry-cljs/lib/clojure.walk.js" target-dir)
    (fs/copy "node_modules/cherry-cljs/lib/clojure.string.js" target-dir)))

(defn ensure-parent-dir [file-path]
  (when (str/includes? (subs file-path 6) "/")
    (fs/create-dirs (str/join "/" (butlast (str/split file-path #"/"))))))

(defn emacs-file? [path]
  (str/includes? path "#"))

(defmacro generate-main-fn [fn-args fn-default]
  `(defn ~'-main [& ~'args]
     (if (seq ~'args) (~fn-args ~'args) (~fn-default))))
