(ns leiningen.hooks.scalac
  (:require [robert.hooke]
            [leiningen.compile]))

;; This is only needed in Leiningen 1.x

(robert.hooke/add-hook (resolve 'leiningen.compile/prep)
                       (fn [f project & args]
                         ;; Don't load scalac at every lein launch.
                         (require 'leiningen.scalac)
                         ((resolve 'leiningen.scalac/scalac) project)
                         (apply f project args)))