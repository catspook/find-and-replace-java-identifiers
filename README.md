# code-review-assignment-1-good-code

Readable solution for Code Review Assignment 1:

"Write a function that recursively expands a string template, 
where a string template is a string that may contain Java identifiers within square brackets. 
The template expanding function should take in a string template and a dictionary mapping strings 
to values of any type; it should recursively replace bracketed identifiers in the string with the 
string representation of the value of the corresponding key in the dictionary, so that there are 
no bracketed identifiers in the output string. If an identifier in the input string is missing 
from the dictionary, just remove it in the output string."

## Usage

sample\_map\_and\_str-tmp.clj contains a pre-made identifier-value map (test-map) and several string 
templates (str-tmp). A sample string and map are already built into core.clj. 

If Leiningen is installed on your machine, you can run 'lein test' to see how it performs on every 
test case I could come up with.

To run, copy and run this command in the cr-a1-readable folder:
    $ java -jar ./target/uberjar/cr-a1-readable-0.1.0-SNAPSHOT-standalone.jar

Must have Java installed.

## License

Copyright © 2020 CMR
For use in PSU CS510 Code Review course only.
