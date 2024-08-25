(ns build-css
  (:require [clojure.string :as str]
            [babashka.fs :as fs]))

(def css-dir "pages/css")
(def globs ["stylesheets/*.css" "components/**/*.css"])

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

(defn process-args [args]
  (fs/create-dirs css-dir)
  (doseq [source-path args]
    (let [target-path (str css-dir "/" (fs/file-name source-path))]
      (println (str "~ CSS " source-path " -> " target-path))
      (spit target-path (minify-css (slurp source-path))))))

(defn process-default []
  (fs/delete-tree css-dir)
  (doseq [glob globs]
    (process-args
     ;; Filter out Emacs files.
     (filter #(not (str/includes? % "#"))
             (map str (fs/glob "src" glob))))))

(defn -main [& args]
  (if (seq args)
    (process-args args) (process-default)))
