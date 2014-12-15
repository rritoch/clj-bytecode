(ns andylisp.bytecode
  (:gen-class)
  (:require [clojure.java.io :as io]
            [clojure.stacktrace :refer [print-cause-trace]])
  (:import [com.vnetpublishing.java.asm.bytecode ClassFile]
           [java.io IOException]))


(defn read-class
  [cl]
    (if-let [r (io/resource (str (clojure.string/replace  (.getName cl) #"\." "/")
                                 ".class"))]
        (let [cf (ClassFile. r)]
          (.read cf)
          cf)
       (IOException. "Source not found on classpath")))

(defn -main
  [& args]
  
    (try
       (println (str "Major" (.getMajorVersion (read-class clojure.lang.RT))))
       (catch Throwable t (print-cause-trace t))))

