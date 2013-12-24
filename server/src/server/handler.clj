(ns server.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes api-routes
  (GET "/test" [] "hello api world!"))

(defroutes app-routes
  (context "/api" [] api-routes)
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
