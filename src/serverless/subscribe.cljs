(defn handler [event context]
  (js/Promise.resolve #js {:statusCode 200 :body "Hello, World!"}))
