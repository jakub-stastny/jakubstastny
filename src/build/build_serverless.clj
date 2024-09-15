(ns build-serverless
  (:require [clojure.string :as str]
            [babashka.fs :as fs]
            [babashka.process :as process]
            [utils :as utils]
            [config :as config]))

(defn process-args [args]
  (prn :pa args)
  (fs/create-dirs config/serverless-dir)
  (doseq [source-cljs-path args]
    (let [source-mjs-path (str/replace source-cljs-path #"\.cljs$" ".mjs")
          target-path (str config/serverless-dir "/" (fs/file-name source-mjs-path))]
      (process/shell "npx" "cherry" "compile" source-cljs-path)
      (println (str "~ JS " source-cljs-path " -> " target-path))
      (spit target-path (slurp source-mjs-path)))))

(defn process-default []
  (fs/delete-tree config/serverless-dir)
  (process-args
   (remove utils/emacs-file? (map str (fs/glob config/serverless-src "*.cljs")))))

(utils/generate-main-fn process-args process-default)
