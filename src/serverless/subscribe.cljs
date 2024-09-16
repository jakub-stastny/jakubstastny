(ns functions.subscribe
  (:require [promesa :as p]
            [clojure.walk :refer [keywordize-keys]]))

(defn parse-json [body]
  (try
    (-> body js/JSON.parse js->clj keywordize-keys)
    (catch :default e
      nil)))

(defn handler [event context]
  (p/do
    (let [method (.-httpMethod event)]
      (cond
        ;; Handle POST request
        (= method "POST")
        (let [body (parse-json (.-body event))]
          (if (contains? body :email)
            #js {:statusCode 200 :body "OK"}
            #js {:statusCode 400 :body "Validation Error: 'email' key is missing"}))

        ;; Handle HEAD request
        (= method "HEAD")
        #js {:statusCode 200}

        ;; Handle other methods (PUT, GET, etc).
        :else
        #js {:statusCode 405 :body "Method Not Allowed"}))))
