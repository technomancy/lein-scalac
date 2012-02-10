(defproject test-project "0.1.0"
  :description "test project with some scala"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [org.scala-lang/scala-library "2.9.1"]]
  :plugins [[lein-scalac "0.1.0"]]
  :hooks [leiningen.hooks.scalac]
  :source-path "src/clj"
  :scala-source-path "src/scala")
