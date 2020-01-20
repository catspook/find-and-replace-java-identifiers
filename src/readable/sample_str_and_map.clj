(in-ns 'readable.core)

(def empty-str 
  "")

(def just-id 
  "[pass1]")

(def str-id-spaces
  "### [pass1] ###")

(def str-id-no-spaces
  "###[pass1]###")

(def two-seperate-id 
  "### [pass1] ### [pass2]")

(def no-id 
  "###")

(def two-id-together
  "[pass1][pass2]")

(def symbols
  "[_pass] [$pass] [$pass_] [$]")

(def should-fail 
  "[] [_] [0fail] [this] [fa.il]")

(def id-not-in-map
  "###[cat]###")

(def test-map
  {"pass1" "val1"
   "pass2" "val2"
   "_pass" "_val"
   "$pass" "$val"
   "$pass_" "$val_"
   "$" "v"
   "" "FAIL"
   "_" "FAIL"
   "0fail" "FAIL"
   "this" "FAIL"
   "fa.il" "FAIL"})
