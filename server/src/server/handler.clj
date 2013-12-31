(ns server.handler
  (:use compojure.core
        ring.middleware.json)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [features.exercises.exercises-api]
            ))

(defroutes api-routes
  (context "/exercises" [] features.exercises.exercises-api/exercises-routes))

(defroutes app-routes
  (context "/api" [] (wrap-json-response api-routes))
  (route/resources "/")
  (route/not-found "Not Found"))

(defn wrap-dir-index [handler]
  (fn [req]
    (handler
      (update-in req [:uri]
                 #(if (= "/" %) "/index.html" %)))))

(def app (-> (handler/site app-routes)
             (wrap-dir-index)))
