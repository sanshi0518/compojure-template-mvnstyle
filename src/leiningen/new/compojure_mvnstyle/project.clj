(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://www.github.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.0"]
                 [compojure "1.1.6"]]
  :source-paths ["src/main/clojure"]
  :resource-paths ["src/main/resources"]
  :test-paths ["src/test/clojure"]
  :global-vars {*warn-on-reflection* true}
  :plugins [[lein-ring "0.8.9"]]
  :ring {:handler {{namespace}}.routes/app}
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]]
                   :resource-paths ["src/test/resources"]}})
