;; https://app.netlify.com/sites/jakubstastny/logs/functions/subscribe

(ns netlify.functions.subscribe
  (:require [axios :as axios]))

(def api-key (.. process -env -MAILER_LITE_API_TOKEN))
(def group-id "129574750637787099")

(defn- parse-json [body]
  (try
    [nil (js->clj (js/JSON.parse body) :keywordize-keys true)]
    (catch :default error
      (js/console.log "ERROR" error)
      [error nil])))

(defn- response [status body]
  #js {:statusCode status :body (str (js/JSON.stringify #js {:message body} nil 2) "\n")})

(defn subscribe [email]
  (js/console.log (str "Subscribing " email "."))
  (let [data {:email email
              :groups [group-id]}
        options {:headers {"Content-Type" "application/json"
                           "X-MailerLite-ApiKey" api-key}}]
    (.then
     (.post axios "https://api.mailerlite.com/api/v2/subscribers"
            (clj->js data)
            (clj->js options))
     (fn [response]
       (js/console.log "Subscription successful:" (.-data response))
       (response 200 (str (.-data response))))
     (fn [error]
       (js/console.error "Subscription failed:" (.-response -error -data))
       (response (.. response -error -status) (.. response -error -data))
       (response)))))

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
