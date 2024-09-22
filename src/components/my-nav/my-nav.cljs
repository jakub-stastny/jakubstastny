;; Since this is defined as a web component with shadow DOM,
;; its content isn't accessible to assistive technologies and
;; web crawlers (think SEO).

;; This is fine for now, but would the requirements change, making
;; it a light component (one without shadow DOM) would do the trick.

(ns my-nav
  (:require [helpers :refer [no-self-referring-link get!]]
            [router :refer [router]])
  (:require-macros [macros :refer [component]]))

(defn- item-link
  ([router-entry]
   (item-link router-entry {}))
  ([router-entry opts]
   (no-self-referring-link
    (get! router-entry :title)
    (get! router-entry :path)
    opts)))

(defn render []
  (let [main (item-link (get! router :index))
        about (item-link (get! router :about))
        spiritual-guidance (item-link (get! router :services-guidance))
        astro-reading (item-link (get! router :services-reading))
        remote-healing (item-link (get! router :services-healing))
        services [#html [:span {:id "services"} (item-link (get! router :services) {:class "mobile"})]
                  #html [:ul {:class "large-screen"}
                         [:li spiritual-guidance]
                         [:li astro-reading]
                         [:li remote-healing]]]
        contact (item-link (get! router :contact))]
    #html [:<>
           [:link {:rel "stylesheet" :href "/css/my-nav.css"}]
           [:nav
            [:ul [:li main] [:li about] [:li services] [:li contact]]]]))

(component MyNav "my-nav" render)
