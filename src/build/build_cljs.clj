(ns build-cljs
  (:require [clojure.string :as str]
            [babashka.fs :as fs]
            [babashka.process :as process]
            [utils :as utils]
            [config :refer [js-dir vendor-dir]]))

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
  (fs/delete-tree vendor-dir)
  (let [target-dir (str vendor-dir "/cherry-cljs")]
    (fs/create-dirs target-dir)
    (fs/copy "node_modules/cherry-cljs/lib/cljs.core.js" target-dir)
    ;; (fs/copy "node_modules/cherry-cljs/lib/clojure.set.js" target-dir)
    ;; (fs/copy "node_modules/cherry-cljs/lib/clojure.walk.js" target-dir)
    (fs/copy "node_modules/cherry-cljs/lib/clojure.string.js" target-dir)))

(defn process-args [args]
  (fs/create-dirs js-dir)
  (doseq [source-cljs-path args]
    (let [source-mjs-path (str/replace source-cljs-path #"\.cljs$" ".mjs")
          target-path (str js-dir "/" (fs/file-name source-mjs-path))]
      (process/shell "npx" "cherry" "compile" source-cljs-path)
      (println (str "~ JS " source-cljs-path " -> " target-path))
      (spit target-path (minify-js (slurp source-mjs-path))))))

(defn process-default []
  (fs/delete-tree js-dir)
  (copy-cherry)
  (process-args
   ;; Filter out Emacs files.
   (filter #(not (str/includes? % "#"))
           (map str (fs/glob "src" "**/*.cljs")))))

(defn -main [& args]
  (utils/gen-main args process-args process-default))
