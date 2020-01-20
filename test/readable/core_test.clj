(ns readable.core-test
  (:require [clojure.test :refer :all]
            [readable.core :refer :all]))

(deftest empty-str-test
  (testing "Empty string returns empty string"
    (is (= "" (expand-str-tmp empty-str "" test-map)))))

(deftest just-id-test
  (testing "Single identifer returns correct value"
    (is (= "val1" (expand-str-tmp just-id "" test-map)))))

(deftest str-id-spaces-test
  (testing "Identifer contained within string (spaces) returns string with correct value"
    (is (= "### val1 ###" (expand-str-tmp str-id-spaces "" test-map)))))

(deftest str-id-no-spaces-test
  (testing "Identifier contained within string (no spaces) returns same string with correct value"
    (is (= "###val1###" (expand-str-tmp str-id-no-spaces "" test-map)))))

(deftest two-sperate-id-test
  (testing "String with two identifiers returns string with values in correct positions"
    (is (= "### val1 ### val2" (expand-str-tmp two-seperate-id "" test-map)))))

(deftest no-id-test
  (testing "String with no identifiers is returned unchanged"
    (is (= "###" (expand-str-tmp no-id "" test-map)))))

(deftest two-id-together-test
  (testing "Two identifiers with no spaces return correct values."
    (is (= "val1val2" (expand-str-tmp two-id-together "" test-map)))))

(deftest symbols-test
  (testing "Identifiers with symbols return correctly"
    (is (= "_val $val $val_ v" (expand-str-tmp symbols "" test-map)))))

(deftest should-fail-test
  (testing "Things in  brackets that are not identifiers should return unchanged"
    (is (= "[] [_] [0fail] [this] [fa.il]" (expand-str-tmp should-fail "" test-map)))))

(deftest id-not-in-map-test
  (testing "Identifiers not in map should be removed"
    (is (= "######" (expand-str-tmp id-not-in-map "" test-map)))))
