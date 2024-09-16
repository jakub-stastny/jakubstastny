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

  (let [package-json (str config/serverless-src "/package.json")
        cljs-files (map str (fs/glob config/serverless-src "*.cljs"))]
    (fs/copy package-json (str config/serverless-dir "/package.json") {:replace-existing true})
    (process-args (remove utils/emacs-file? cljs-files))))

(utils/generate-main-fn process-args process-default)
