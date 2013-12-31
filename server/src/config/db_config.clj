(ns config.db-config
  (:use korma.db environ.core))

(defdb db (postgres {:db "workout_tracker"
                     :user (env :workout-tracker-db-app-user)
                     :password (env :workout-tracker-db-app-password)
                     :host (env :workout-tracker-db-host)
                     :port (env :workout-tracker-db-port)}))
