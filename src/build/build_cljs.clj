(ns build-cljs
  (:require [clojure.string :as str]
            [babashka.fs :as fs]
            [babashka.process :as process]
            [utils :as utils]
            [config :as config]))

(defn process-args [args]
  (fs/create-dirs config/js-dir)
  (doseq [source-cljs-path args]
    (let [source-mjs-path (str/replace source-cljs-path #"\.cljs$" ".mjs")
          target-path (str config/js-dir "/" (fs/file-name source-mjs-path))]
      (process/shell "npx" "cherry" "compile" source-cljs-path)
      (println (str "~ JS " source-cljs-path " -> " target-path))
      (spit target-path (utils/minify-js (slurp source-mjs-path))))))

(defn process-default []
  (fs/delete-tree config/js-dir)
  (utils/copy-cherry)
  (process-args
   ;; Filter out Emacs files.
   (filter #(not (str/includes? % "#"))
           (map str (fs/glob "src" "**/*.cljs")))))

(defn -main [& args]
  (utils/gen-main args process-args process-default))
