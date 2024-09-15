(ns config)

(def js-dir "pages/js")
(def vendor-dir "pages/vendor")
(def cljs-glob "**/*.cljs")

(def serverless-dir "netlify/functions")
(def serverless-src "src/serverless")

(def css-dir "pages/css")
(def css-globs ["stylesheets/*.css" "components/**/*.css"])

(def html-dir "pages")
(def svg-dirs (map #(str html-dir %) ["/svg/solid" "/svg/regular" "/svg/brands"]))
(def svgs ["solid/envelope.svg" "brands/youtube.svg" "brands/reddit.svg" "brands/github.svg" "brands/github-alt.svg" "brands/square-github.svg"])
(def page-glob "pages/*.edn")
