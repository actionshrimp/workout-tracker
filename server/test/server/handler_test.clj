(ns server.handler-test
  (:use midje.sweet
        ring.mock.request
        server.handler))

(facts "about the app"
       (fact "has a main route"
             (:status (app (request :get "/"))) => 200)
       (fact "has api routes"
             (:status (app (request :get "/api/exercises"))) => 200)
       (fact "handles not found routes"
             (:status (app (request :get "/not-found"))) => 404)
       )
