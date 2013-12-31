(ns migrations.001-create-exercises
  (:use drift-db.core))

(defn up []
  (create-table :exercises
                (id :id)
                (string :name { :length 1024 :not-null true })
                (string :description { :length 2048 :not-null false })
                (string :image { :length 1024 :not-null false })))

(defn down []
  (drop-table :exercises))
