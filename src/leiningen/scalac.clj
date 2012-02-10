(ns leiningen.scalac
  (:require [lancet.core :as lancet]
            [leiningen.classpath :as classpath])
  (:import (org.apache.tools.ant.types Path)))

(defn task-props [project]
  (merge {:srcdir (:scala-source-path project)
          :destdir (:compile-path project)}
         (:scalac-options project)))

(.addTaskDefinition lancet/ant-project "scalac" scala.tools.ant.Scalac)

(lancet/define-ant-task ant-scalac scalac)

(defn scalac
  "Compile Scala source in :scala-source-path to :compile-path.

Set :scalac-options in project.clj to pass options to the Scala compiler.
See http://www.scala-lang.org/node/98 for details."
  [project]
  (let [classpath (classpath/get-classpath-string project)
        task (doto (lancet/instantiate-task lancet/ant-project "scalac"
                                            (task-props project))
               (.setClasspath (Path. lancet/ant-project classpath)))]
    (lancet/mkdir {:dir (:compile-path project)})
    (.execute task)))
