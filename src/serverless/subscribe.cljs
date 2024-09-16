;; https://app.netlify.com/sites/jakubstastny/logs/functions/subscribe

(ns functions.subscribe)

;; TODO: validation error if doesn't parse.
(defn- parse-json [body]
  (try
    [nil (js->clj (js/JSON.parse body) :keywordize-keys true)]
    (catch :default error
      (js/console.log "ERROR" error)
      [error nil])))

(defn- response [status body]
  #js {:statusCode status :body body})

(defn- handle-post [event context]
  (let [[error data] (parse-json (.-body event))]
    (js/console.log "handle-post" error data)
    (cond
      error                   (response 400 (ex-info error))
      (contains? data :email) (response 200 "OK")
      :else                   (response 400 "Validation error: key 'email' is missing."))))

(defn- dbg [event context fun]
  (let [result (fun event context)]
    (js/console.log "Response" result)
    result))

(defn handler [event context]
  (js/console.log "handler" event context)
  (dbg event context
       (fn [event context]
         (let [method (.-httpMethod event)]
           (js/console.log "HTTP method" method)
           (cond
             (= method "POST") (handle-post event context)
             (= method "HEAD") (response 200 "")
             :else (response 405 "Method not allowed"))))))
