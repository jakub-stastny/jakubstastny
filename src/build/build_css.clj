(ns build-css
  (:require [clojure.string :as str]
            [babashka.fs :as fs]
            [utils :as utils]
            [config :as config]))

(defn process-args [args]
  (fs/create-dirs config/css-dir)
  (doseq [source-path args]
    (let [target-path (str config/css-dir "/" (fs/file-name source-path))]
      (println (str "~ CSS " source-path " -> " target-path))
      (spit target-path (utils/minify-css (slurp source-path))))))

(defn process-default []
  (fs/delete-tree config/css-dir)
  (doseq [glob config/css-globs]
    (process-args
     (remove utils/emacs-file? (map str (fs/glob "src" glob))))))

(utils/generate-main-fn process-args process-default)
