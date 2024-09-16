(ns build-serverless
  (:require [clojure.string :as str]
            [babashka.fs :as fs]
            [babashka.process :as process]
            [utils :as utils]
            [config :as config]))

(defn process-args [args]
  (doseq [source-cljs-path args]
    (let [source-mjs-path (str/replace source-cljs-path #"\.cljs$" ".mjs")
          target-path (str config/serverless-dir "/" (fs/file-name source-mjs-path))]
      (process/shell "npx" "cherry" "compile" source-cljs-path)
      (println (str "~ FN " source-cljs-path " -> " target-path))
      (fs/move source-mjs-path target-path {:replace-existing true}))))

(defn process-default []
  (fs/delete-tree config/serverless-dir)
  (fs/create-dirs config/serverless-dir)

  (let [cljs-files (map str (fs/glob config/serverless-src "*.cljs"))]
    (process-args (remove utils/emacs-file? cljs-files))))

(utils/generate-main-fn process-args process-default)
