# lein-thrush

A Leiningen plugin to thread execution.

## Usage

Put `[lein-thrush "0.1.0"]` into the `:plugins` vector of your project.clj.

Assuming you have an `upload` task that takes a project map and a
file to upload, this will upload the jar file:

    $ lein thrush uberjar upload

## License

Copyright © 2012 Phil Hagelberg

Distributed under the Eclipse Public License, the same as Clojure.
