(ns test-helpers.http
  (:require [cheshire.core :as json])
  (:use ring.mock.request))

(defn send-json [verb url data]
  (-> (request verb url)
      (header :content-type "application/json")
      (body (json/generate-string data))))
