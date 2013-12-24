(ns server.test.handler
  (:use clojure.test
        ring.mock.request  
        server.handler))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= (:status response) 200))))
  
  (testing "api route"
    (let [response (app (request :get "/api/test"))]
      (is (= (:status response) 200)))) 
  
  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404))))
  )
