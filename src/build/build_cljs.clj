(ns build-cljs
  (:require [clojure.string :as str]
            [babashka.fs :as fs]
            [babashka.process :as process]
            [utils :as utils]
            [config :as config]))

(defn process-fn [source-cljs-path]
  (println (str "~ FN " source-cljs-path " -> " config/fn-dir))
  (process/shell "npx" "cherry" "compile" source-cljs-path "--output-dir" config/fn-dir))

(defn process-js [source-cljs-path]
  (let [source-mjs-path (str/replace source-cljs-path #"\.cljs$" ".mjs")
        target-path (str config/js-dir "/" (fs/file-name source-mjs-path))]
    (println (str "~ JS " source-cljs-path " -> " target-path))
    (process/shell "npx" "cherry" "compile" source-cljs-path)
    (spit target-path (utils/minify-js (slurp source-mjs-path)))))

(defn process-args [args]
  (doseq [source-cljs-path args]
    (if (str/starts-with? source-cljs-path "src/serverless/")
      (process-fn source-cljs-path)
      (process-js source-cljs-path))))

(defn process-default []
  (utils/recreate-dir config/js-dir)
  (utils/recreate-dir config/fn-dir)

  (utils/copy-cherry)

  (let [paths (map str (fs/glob "src" config/cljs-glob))]
    (process-args (remove utils/emacs-file? paths))))

(utils/generate-main-fn process-args process-default)
