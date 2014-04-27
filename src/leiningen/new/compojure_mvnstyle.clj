(ns leiningen.new.compojure-mvnstyle
  (:require [leiningen.new.templates :refer [renderer year name-to-path ->files]]
            [leiningen.core.main :as main]
            [clojure.string :as string]))

(defn compojure-mvnstyle
  "Create a new maven style compojure project"
  [name]
  (let [data {:name name
              :namespace (string/replace name #"\w+-" "")
              :year (year)}
        render #((renderer "compojure_mvnstyle") % data)]
    (main/info "Generating fresh 'lein new' compojure-mvnstyle project.")
    (->files data
             [".gitignore"  (render "gitignore")]
             ["project.clj" (render "project.clj")]
             ["README.md"   (render "README.md")]
             ["src/main/clojure/{{namespace}}/handler.clj" (render "handler.clj")]
             ["src/test/clojure/{{namespace}}/test/handler.clj" (render "handler_test.clj")]
             ["src/main/resources/public/js/bootstrap.min.js" (render "bootstrap.min.js")]
             ["src/main/resources/public/js/jquery-1.9.1.min.js" (render "jquery-1.9.1.min.js")]
             ["src/main/resources/public/css/bootstrap.min.css" (render "bootstrap.min.css")]
             "src/main/resources/public/img"
             "src/test/resources")))