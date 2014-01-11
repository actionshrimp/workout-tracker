(ns features.exercises.exercises-api
  (:require [cheshire.core :as json])
  (:use compojure.core
        ring.util.response
        features.exercises.exercises-entities))

(defroutes api
  (GET "/" [] (response (list-exercises)))

  (POST "/" {:keys [body]} (-> (slurp body)
                               (json/parse-string true)
                               (add-exercise)
                               (response)))
  (GET "/:id" [id]
       (response (exercise-by-id id)))

  (PUT "/:id" { body :body {id :id} :params} 
       (-> (slurp body)
           (json/parse-string true)
           (update-exercise id)
           (response)))

  (DELETE "/:id" [id]
          (response (delete-exercise id)))

  )
