(ns test-project.core)

(defn -main
  "I don't do a whole lot."
  [& args]
  (test.Test/main (into-array String []))
  (println "Hello from Clojure!"))