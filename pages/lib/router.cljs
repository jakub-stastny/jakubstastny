;; TODO: Here's a difference between title as in what goes into navigation
;; vs document.title of index.html.

;; If I do this, it will be a Module and when required as [router :as router]}, it has to be access thus: (.-about router). Aka it's not a map.
;; (def index {:path "/" :title "Main page"})
;; (def about {:path "/about" :title "About me"})
;; (def spiritual-guidance {:path "/services/spiritual-guidance" :title "Spiritual guidance"})
;; (def intuitive-reading {:path "/services/intuitive-astrology-reading" :title "Intuitive astrology reading"})
;; (def energy-healing {:path "/services/remote-energy-healing" :title "Remote energy healing"})
;; (def services {:path "/services" :title "Services" :children [spiritual-guidance intuitive-reading energy-healing]})
;; (def contact {:path "/contact" :title "Contact"})

;; (def uncopyright {:path "/uncopyright" :title "Uncopyright"})

(def ^:private spiritual-guidance {:path "/services/spiritual-guidance" :title "Spiritual guidance"})
(def ^:private intuitive-reading {:path "/services/intuitive-astrology-reading" :title "Intuitive astrology reading"})
(def ^:private energy-healing {:path "/services/remote-energy-healing" :title "Remote energy healing"})

(def router
  {:index {:path "/" :title "Main page"}
   :about {:path "/about" :title "About me"}
   :spiritual-guidance spiritual-guidance
   :intuitive-reading intuitive-reading
   :energy-healing energy-healing
   :services {:path "/services" :title "Services" :children [spiritual-guidance intuitive-reading energy-healing]}
   :contact {:path "/contact" :title "Contact"}
   :uncopyright {:path "/uncopyright" :title "Uncopyright"}})
