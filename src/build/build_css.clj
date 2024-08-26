(ns build-css
  (:require [clojure.string :as str]
            [babashka.fs :as fs]
            [utils :as utils]
            [config :refer [css-dir css-globs]]))

(defn process-args [args]
  (fs/create-dirs css-dir)
  (doseq [source-path args]
    (let [target-path (str css-dir "/" (fs/file-name source-path))]
      (println (str "~ CSS " source-path " -> " target-path))
      (spit target-path (utils/minify-css (slurp source-path))))))

(defn process-default []
  (fs/delete-tree css-dir)
  (doseq [glob css-globs]
    (process-args
     ;; Filter out Emacs files.
     (filter #(not (str/includes? % "#"))
             (map str (fs/glob "src" glob))))))

(defn -main [& args]
  (utils/gen-main args process-args process-default))
