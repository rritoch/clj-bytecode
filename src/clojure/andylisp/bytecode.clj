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

(defn get-magic
  [cf]
     (.getMagic cf))

(defn get-this-class-ptr
  [cf]
     (.getThisClass cf))

(defn get-super-class-ptr
  [cf]
     (.getSuperClass cf))

(defn get-constant-pool-entry
  [cf ptr]
    (.get (.getConstantPoolList cf) ptr))

(defn get-version
  [cf]
    [(.getMajorVersion cf) (.getMinorVersion cf)])

(defn get-interfaces
  [cf]
    (.getInterfacesList cf))

(defn get-attributes
  [cf]
    (.getAttributes cf))

(defn get-methods
  [cf e]
    (.getMethods cf))

(def get-access-flags
  [cf e]
     (.getAccessFlags cf))

(defn get-fields
  [cf e]
    (.getFields cf))

(defn -main
  [& args]
  
    (try
       (println (str "Major" (.getMajorVersion (read-class clojure.lang.RT))))
       (catch Throwable t (print-cause-trace t))))
