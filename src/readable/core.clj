(ns readable.core
  (:require [clojure.string :as cstr])
  (:gen-class))

(load "java_reserved_words")
(load "sample_str_and_map")

(defn find-identifiers [str-tmp old-result-str]
  "Pattern matching function to group str-tmp into <before identifier>, <identifier>, and <after identifier>.
   Finds the RIGHTMOST identifier first. String after identifier is joined with old result string to form new result string." 
  (let [match (re-find (re-matcher #"(.*)\[([a-zA-Z_$][a-zA-Z0-9_$]*)\](.*)" str-tmp))] ;identifiers have correct characters inside of brackets. See README.
    [(nth match 1)  ;will be new-str-tmp on next iteration 
     (nth match 2)  ;identifier
     (cstr/join [(nth match 3) old-result-str])  ;the new result string
     (nil? match)]))  ;will return nil if no identifiers are found

(defn is-id-reserved-word [id]
  "Returns true if id is a Java reserved word"
  (some true? (for [word java-reserved-words] (= word id))))

(defn expand-str-tmp [str-tmp old-result-str id-val-map]
  "Takes a string template containing java identifiers in brackets, an empty result string, and map of 
   identifiers to values (id-val-map). Recursively replaces bracketed identifiers with corresponding values."
  (let [[new-str-tmp id return-str stop?] (find-identifiers str-tmp old-result-str)]
      (cond  
        (true? stop?) (cstr/join [str-tmp old-result-str])  ;str-tmp had no identifier in it, return
        (is-id-reserved-word id) (expand-str-tmp new-str-tmp 
                                                    (cstr/join ["[" id "]" return-str])
                                                    id-val-map)  ;id is a reserved word, add it to return-str and recurse
        (empty? new-str-tmp) (cstr/join [(str (get id-val-map id)) return-str])  ;new-str-tmp is empty string, return 
        :else (expand-str-tmp new-str-tmp 
                              (cstr/join [(str (get id-val-map id)) return-str])
                              id-val-map))))  ;id found and value added to return-str, recurse

(defn -main
  [& args]
  (println (expand-str-tmp two-seperate-id "" test-map)))
