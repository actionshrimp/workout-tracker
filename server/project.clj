(defproject server "0.1.0-SNAPSHOT"
  :description "workout-tracker api"
  :url "http://github.com/actionshrimp/workout-tracker"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [korma "0.3.0-RC5"]
                 [org.postgresql/postgresql "9.2-1002-jdbc4"]
                 [environ "0.4.0"]
                 [ring/ring-json "0.2.0"]]
  :plugins [[lein-environ "0.4.0"]
            [lein-ring "0.8.8"]
            [drift "1.5.2"]
            [lein-midje "3.0.0"]]
  :ring {:handler server.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]
                        [org.drift-db/drift-db-postgresql "1.1.6"]
                        [midje "1.6.0"]
                        [cheshire "5.3.1"]]}})
