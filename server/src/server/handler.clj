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

(defn wrap-dir-index [handler]
  (fn [req]
    (handler
      (update-in req [:uri]
                 #(if (= "/" %) "/index.html" %)))))

(def app (-> (handler/site app-routes)
             (wrap-dir-index)))
