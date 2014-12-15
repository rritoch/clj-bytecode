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

(defn get-access-flags
  [cf]
     (.getAccessFlags cf))

(defn get-fields
  [cf e]
    (.getFields cf))

(defn public?
  [cf]
    (if (> (bit-and (.intValue (get-access-flags cf)) 1) 0) 
      true
      false))
                                                             

(defn final?
  [cf]
    (if (> (bit-and (.intValue (get-access-flags cf)) 2) 0) 
      true
      false))

(defn super?
  [cf]
    (if (> (bit-and (.intValue (get-access-flags cf)) 32) 0) 
      true
      false))

(defn interface?
  [cf]
    (if (> (bit-and (.intValue (get-access-flags cf)) 512) 0) 
      true
      false))

(defn abstract?
  [cf]
    (if (> (bit-and (.intValue (get-access-flags cf)) 1024) 0) 
      true
      false))

(defn synthetic? 
  [cf]
    (if (> (bit-and (.intValue (get-access-flags cf)) 4096) 0) 
      true
      false))

(defn annotation? 
  [cf]
    (if (> (bit-and (.intValue (get-access-flags cf)) 8192) 0) 
      true
      false))

(defn enum?
  [cf]
    (if (> (bit-and (.intValue (get-access-flags cf)) 16384) 0) 
      true
      false))


(defn get-flags
  [cf]
     (into []
           (keep (partial #(if ((second %2) %1) (first %2)) 
                          cf)
                 [[:public public?]
                  [:final final?]
                  [:super super?]
                  [:interface interface?]
                  [:abstract abstract?]
                  [:synthetic synthetic?]
                  [:annotation annotation?]
                  [:enum enum?]])))


(defn -main
  [& args]
  
    (try
       (println (str "Major" (.getMajorVersion (read-class clojure.lang.RT))))
       (catch Throwable t (print-cause-trace t))))
