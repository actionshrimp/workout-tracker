(ns config.migrate-config
  (:use [environ.core])
  (:require [drift-db.core :as drift-db]
            [drift-db.migrate :as drift-db-migrate]
            [drift-db-postgresql.flavor :as postgresql-flavor]))

(def flavor (postgresql-flavor/postgresql-flavor
              (env :workout-tracker-db-mig-user)
              (env :workout-tracker-db-mig-password)
              "workout_tracker"
              (format "%s:%s"
                      (env :workout-tracker-db-host)
                      (env :workout-tracker-db-port))))

(defn migrate-config []
  { :directory "/src/migrations"
    :init (fn [& args] (drift-db/init-flavor flavor))
    :current-version drift-db-migrate/current-version
    :update-version drift-db-migrate/update-version
    :ns-content "\n (:use drift-db.core)" })
