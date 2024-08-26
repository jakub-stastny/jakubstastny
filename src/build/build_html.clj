(ns build-html
  (:require [clojure.string :as str]
            [clojure.edn :as edn]
            [babashka.fs :as fs]
            [config :refer [html-dir svgs page-glob svg-dirs]]
            [utils :as utils]
            [templates.core :refer [template routes]]))

(defn page [{:keys [path title content]}]
  (let [path-fix-index (if (str/ends-with? path "/") (str path "index") path)
        html-path (str html-dir path-fix-index ".html")]
    (println (str "~ Building " html-path "."))
    (utils/ensure-parent-dir html-path)
    (spit html-path (template title content))))

;; It'd be best to automate, however in my-footer there's dynamic code.
(defn copy-svgs []
  (doseq [svg-dir svg-dirs]
    (fs/create-dirs svg-dir))

  (doseq [source-path (map #(str "src/svgs/" %) svgs)]
    (let [parent-dir (fs/file-name (fs/parent source-path))
          base-name (fs/file-name source-path)
          target-path (str html-dir "/svg/" parent-dir "/" base-name)]
      (println (str "~ SVG " target-path))
      (fs/copy source-path target-path {:replace-existing true}))))

(defn write-robots-txt []
  (println (str "~ Building " html-dir "/robots.txt."))
  (let [paths (map :path (vals routes))
        lines (concat ["User-agent: *" "Disallow: /"]
                      (map #(str "Allow: " % "$") paths))]
    (spit (str html-dir "/robots.txt") (str/join "\n" lines))))

(defn process-args [args]
  (fs/create-dirs html-dir)
  (doseq [path args]
    (let [data (edn/read-string (slurp path))]
      (page data))))

(defn process-default []
  (write-robots-txt)
  (copy-svgs)
  (process-args
   (filter #(not (str/includes? % "#"))
           (map str (fs/glob "src" page-glob)))))

(defn -main [& args]
  (utils/gen-main args process-args process-default))
