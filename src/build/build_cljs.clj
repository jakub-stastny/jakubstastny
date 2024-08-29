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
     (remove utils/emacs-file? (map str (fs/glob "src" config/cljs-glob)))))

(utils/generate-main-fn process-args process-default)
