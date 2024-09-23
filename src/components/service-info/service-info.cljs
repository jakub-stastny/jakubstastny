(ns service-info
  (:require-macros [macros :refer [component]]))

(defn render [component]
  (let [donation (.getAttribute component "donation")
        duration (.getAttribute component "duration")]
    (js/console.log donation duration)
    #html [:<>
           [:link {:rel "stylesheet" :href "/css/service-info.css"}]
           [:p {:id "details"}
            [:strong "Suggested donation: "] (str  "$" donation) ", "
            [:strong "duration: "] (str duration ".")]]))

(component ServiceInfo "service-info" render)
