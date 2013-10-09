# lein-scalac

Compile Scala source from Leiningen.

## Usage

Add `[lein-scalac "0.1.0"]` to `:plugins` project.clj. (Or
`:dev-dependencies` on Leiningen versions earlier than 1.7.0)

Set `:scala-source-paths` in project.clj, usually to "src/scala", and
place your `.scala` source files in there.

Run `lein scalac` to compile them to `.class` files.

If you want `scalac` to run automatically, add `:prep-tasks ["scalac"]`
to `project.clj`

For Leiningen 1.x support, need to add `leiningen.hooks.scalac` to
`:hooks` in project.clj.

If you need runtime features of Scala you'll have to declare a
dependency on `scala-library` like so:

`:dependencies [org.scala-lang/scala-library "2.9.1"]`

## License

Copyright © 2012 Phil Hagelberg and Scott Clasen

Distributed under the Eclipse Public License, the same as Clojure.
