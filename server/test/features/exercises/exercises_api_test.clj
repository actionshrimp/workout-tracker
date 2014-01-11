(ns features.exercises.exercises-api-test
  (:require [korma.db :as dbt])
  (:use midje.sweet
        test-helpers.http
        ring.mock.request
        features.exercises.exercises-api))

(facts "about the exercises api" :db
  (with-state-changes [(around :facts (dbt/transaction ?form (dbt/rollback)))]

    (fact "returns an empty list of exercises at first"
          (api (request :get "/")) => (contains {:status 200 :body []}))

    (fact "allows exercises to be added"
          (api (send-json :post "/" { :name "Situps" }))
            => (contains {:status 200 :body (contains {:name "Situps"})}))

    (fact "returns exercises if there are any present"
          (do
            (api (send-json :post "/" { :name "Bicep Curls" }))
            (:body (api (request :get "/")))) 
              => (one-of (contains {:name "Bicep Curls"})))

    (fact "allows exercises to be updated"
          (let [id (get-in (api (send-json :post "/" { :name "bicep curls" }))
                           [:body :id])]
            (api (send-json :put (str "/" id) {:name "Situps"})))
              => (contains {:body (contains {:name "Situps"})}))

    (fact "allows exercises to be deleted"
          (let [id (get-in 
                     (api (send-json :post "/" { :name "bicep curls" }))
                     [:body :id])]
            (api (request :delete (str "/" id)))
            (api (request :get "/"))) => (contains {:status 200 :body []}))
    ))
