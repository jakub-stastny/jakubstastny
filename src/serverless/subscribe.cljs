;; https://app.netlify.com/sites/jakubstastny/logs/functions/subscribe

(ns netlify.functions.subscribe
  (:require [axios :as all-axios]))

(def axios (.-default all-axios))

(def api-key (.. process -env -MAILER_LITE_API_TOKEN))
(def group-id "129574750637787099")
(def headers ["Content-Type" "application/json" "X-MailerLite-ApiKey" api-key])
(def endpoint "https://api.mailerlite.com/api/v2/subscribers")

(defn- parse-json [body]
  (try
    [nil (js->clj (js/JSON.parse body) :keywordize-keys true)]
    (catch :default error
      (js/console.log "ERROR" error)
      [error nil])))

(defn- response [status body]
  #js {:statusCode status :body (str (js/JSON.stringify #js {:message body} nil 2) "\n")})

(defn ^:async subscribe [email]
  (js/console.log (str "Subscribing " email "."))
  (try
    (let [data {:email email :groups [group-id]}
          options {:headers headers}
          response (js/await (.post axios endpoint (clj->js data) (clj->js options)))]
      (js/console.log "RESPONSE")
      (js/console.log response)
      ;; (js/console.log "Subscription successful:" (.-data response)))
      ;; (response 200 (str (.-data response))
      )
      (catch js/Error error
        (js/console.log "ERROR")
        (js/console.log error)
        ;; (let [ ;;status (.. error -response -status)
        ;;       ;; response-data (.. error -response -data)
        ;;       ]
        ;;   ;; (js/console.error "Subscription failed with status code:" status)
        ;;   ;; (js/console.error "Response data:" response-data)
        ;;   (js/console.log error)
        ;;   ;; (js/console.log (.-response error))
        ;;   ;; (response (.. response -error -status) (.. response -error -data))
        ;;   (response 400 ""))
        )))

(defn- handle-post [event context]
  (let [[error data] (parse-json (.-body event))]
    (js/console.log "handle-post" error (clj->js data))
    (cond
      error                   (response 400 (ex-info error))
      (contains? data :email) (response 200 (subscribe (:email data)))
      :else                   (response 400 "Validation error: key 'email' is missing."))))

(defn- dbg [event context fun]
  (let [result (fun event context)]
    (js/console.log "Response" result)
    result))

(defn ^:async handler [event context]
  (js/console.log "handler")
  (dbg event context
       (fn [event context]
         (let [method (.-httpMethod event)]
           (cond (= method "POST") (handle-post event context)
             (= method "HEAD")     (response 200 "")
             :else                 (response 405 "Method not allowed"))))))
