(ns features.exercises.exercises-entities
  (:use korma.core)
  (:require [config.db-config]))

(defentity exercises (pk :id))

(defn list-exercises [] (select exercises))

(defn parseId [id-str] (Integer/parseInt id-str))

(defn exercise-by-id [id-str]
  (let [id (parseId id-str)]
  (first (select exercises (where {:id id})))))

(defn add-exercise [exercise]
  (let [{:keys [name description image]} exercise]
  (insert exercises
              (values {:name name :description description :image image}))))

(defn update-exercise [exercise id-str]
  (let [id (parseId id-str)
        exercise-filtered (select-keys exercise [:name :description :image])]
    (update exercises (set-fields exercise-filtered) (where {:id id}))
    (exercise-by-id id-str)))

(defn delete-exercise [id-str]
  (let [id (parseId id-str)]
    (delete exercises (where {:id id}))))
