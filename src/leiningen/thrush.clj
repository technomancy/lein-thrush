(ns leiningen.thrush
  (:require [leiningen.core.main :as main]))

(defn run-task [project acc task-name]
  (main/apply-task (main/lookup-alias task-name project) project [acc]))

(defn ^:higher-order thrush
  "Run a series of tasks, passing the return value of one to the next."
  [project first-task & tasks]
  (let [init (main/apply-task (main/lookup-alias first-task project) project)]
    (reduce (partial project run-task) tasks)))