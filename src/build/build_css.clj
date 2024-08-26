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
     ;; Filter out Emacs files.
     (filter #(not (str/includes? % "#"))
             (map str (fs/glob "src" glob))))))

(defn -main [& args]
  (utils/gen-main args process-args process-default))
