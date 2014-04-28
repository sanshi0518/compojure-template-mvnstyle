(ns {{namespace}}.routes
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [compojure.core :refer :all])
  (:use [{{namespace}}.handler]))

(defroutes app-routes
  (GET "/" [] hello)
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
