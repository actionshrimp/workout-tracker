(ns features.exercises.exercises-api
  (:use compojure.core
        ring.util.response
        features.exercises.exercises-entities))

(defroutes exercises-routes
  (GET "/:id" [id] 
       (response (by-id id))))
