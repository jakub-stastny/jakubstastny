(ns build-router
  (:require [clojure.string :as str]
            [clojure.edn :as edn]
            [babashka.fs :as fs]
            [cheshire.core :as json]))

(defn- generate-routes []
  (let [paths (map str (fs/glob "src/pages" "*.edn"))]
    (reduce (fn [acc path]
              (let [data (edn/read-string (slurp path))
                    route {(data :key) (dissoc data :key :content)}]
                (merge acc route)))
            {} paths)))

;; TODO: Move from src/assets to src/data.
(defn -main []
  (spit "src/assets/router.json"
        (json/generate-string (generate-routes) {:pretty true})))
