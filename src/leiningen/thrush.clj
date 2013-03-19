(ns leiningen.thrush
  (:require [leiningen.core.main :as main] [leiningen.do :refer [group-args]]))

(defn ^:no-project-needed ^:higher-order thrush
  "Like ->, but for leiningen tasks.

Each comma-separated group should be a task name followed by optional arguments."
  [project & tasks]
  (reduce (fn [acc [task-name & args]]
            [(main/apply-task (main/lookup-alias task-name project) project
                              (reduce conj acc args))])
          [] (group-args tasks)))
