(ns features.exercises.exercises-entities
  (:use korma.core)
  (:require [config.db-config]))

(defentity exercises (pk :id))

(defn by-id [id-str]
  (let [id (Integer/parseInt id-str)]
  (first (select exercises (where {:id id})))))
