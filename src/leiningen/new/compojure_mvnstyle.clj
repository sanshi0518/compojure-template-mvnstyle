(ns leiningen.new.compojure-mvnstyle
  (:require [leiningen.new.templates :refer [renderer year name-to-path ->files]]
            [leiningen.core.main :as main]))

(defn compojure-mvnstyle
  "Create a new maven style compojure project"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)
              :year (year)}
        render #((renderer "compojure_mvnstyle") % data)]
    (main/info "Generating fresh 'lein new' compojure-mvnstyle project.")
    (->files data
             [".gitignore"  (render "gitignore")]
             ["project.clj" (render "project.clj")]
             ["README.md"   (render "README.md")]
             ["src/main/clojure/{{sanitized}}/handler.clj" (render "handler.clj")]
             ["src/test/clojure/{{sanitized}}/handler.clj" (render "handler-test.clj")]
             ["src/main/resources/public/js/bootstrap.min.js" (render "bootstrap.min.js")]
             ["src/main/resources/public/js/jquery-1.9.1.min.js" (render "jquery-1.9.1.min.js")]
             ["src/main/resources/public/css/bootstrap.min.css" (render "bootstrap.min.css")]
             "src/main/resources/public/img"
             "src/test/resources")))