# Transformation of ABNF to BNF

Following methods are used for transformation of Augmented Backus–Naur form (.abnf) grammar into Backus–Naur form (.bnf)
.

<b>For your own safety and mental well-being, do not change the order in which the methods are called.</b>

<ul>
  <li>replaceAllAbnfTokens(oldGrammar)</li>
  <li>deleteWhitespaces(result)</li>
  <li>trimAndAppendOperator(result, "1*", "+")</li>
  <li>trimAndAppendOperator(result, "*", "*")</li>
  <li>replaceAsterWord(result, "1*")</li>
  <li>replaceAsterWord(result, "*")</li>
  <li>replaceHexadecimalRange(result)</li>
  <li>replaceHexadecimal(result)</li>
  <li>rewriteStringRules(result)</li>
</ul>

## YANG versions

Abnf specification for different YANG versions can be found in RFCs:

* YANG 1.0 - defined in RFC 6020
* YANG 1.1 - defined in RFC 7950

### 1. Replace tokens

Method  <code><b>replaceAllAbnfTokens(List<String> oldGrammar)</b></code> takes original .abnf grammar as a parameter. 
Except tokens enclosed inside double quotes.

* The method transforms:
    * Equal sign: = changed to ::= 
    * Or: / changed to | 
    * Comment: ;; changed to // 
    * Comment: ; changed to // 

Example of original .abnf grammar:

<img src="doc-images/01_clean_abnf.png" style="border: 2px solid gray; text-align: left; padding: 5px; width: 600px">

After transformation of equal sign, or and comment:

<img src="doc-images/02_abnfToBnfTokens_1.png" style="border: 2px solid gray; text-align: left; padding: 5px; width: 600px">

### 2. Delete whitespaces

Method <code><b>deleteWhitespaces(result)</b></code> removes redundant spaces:

<img src="doc-images/03_deleteWhiteSpaces.png" style="border: 2px solid gray; text-align: left; padding: 5px; width: 600px">

### 3. Replace "1*" multiplication operator

Method <code><b>trimAndAppendOperator(result,"1*","+")</b></code> removes .abnf operator "1*"
placed in front of parentheses and adds its .bnf equivalent "+" to correct position.

* Operator "1*\<element\>" requires at least one repetition of \<element\>.

<img src="doc-images/04_trimAndAppendOp_1asterisk.png" style="border: 2px solid gray; text-align: left;; padding: 5px; width: 600px">

### 4. Replace "*" multiplication operator

Method <code><b>trimAndAppendOperator(result,"*","*")</b></code> removes .abnf operator "\*"
placed in front of parentheses and adds its .bnf equivalent "\*" to correct position.

* Operator "*\<element\>" allows 0 or any number of repetitions of \<element\>.

Example of original .abnf grammar:

<img src="doc-images/05_trimAndAppendOp_asterisk_before.png" style="border: 2px solid gray; text-align: left; padding: 5px; width: 550px">

After transformation of "*" multiplication operator:

<img src="doc-images/06_trimAndAppendOp_asterisk_after.png" style="border: 2px solid gray; text-align: left; padding: 5px; width: 550px">

### 5. Replace "1*" multiplication operator

Method <code><b>replaceAsterWord(result, "1*")</b></code> removes .abnf operator "1*"
placed in front of string and adds its .bnf equivalent "+" to correct position.

* Operator "1*string" requires at least one repetition of "string".

Example of original .abnf grammar:

<img src="doc-images/07_asterWord_1asterisk_before.png" style="border: 2px solid gray; text-align: left; padding: 5px; width: 400px">

After transformation of "1*" multiplication operator:

<img src="doc-images/08_asterWord_1asterisk_after.png" style="border: 2px solid gray; text-align: left; padding: 5px; width: 400px">

### 6. Replace "*" multiplication operator

Method <code><b>replaceAsterWord(result, "*")</b></code> removes .abnf operator "\*"
placed in front of a string and adds its .bnf equivalent "\*" to correct position.

* Operator "*string" allows 0 or any number of repetitions of "string".

Example of original .abnf grammar:

<img src="doc-images/09_asterWord_asterisk_before.png" style="border: 2px solid gray; text-align: left; padding: 5px; width: 600px">

After transformation of "1*" multiplication operator:

<img src="doc-images/10_asterWord_asterisk_after.png" style="border: 2px solid gray; text-align: left; padding: 5px; width: 600px">

### 7. Replace range of hexadecimal values

Method <code><b>replaceHexadecimalRange(result)</b></code> replaces range of hexadecimal values with corresponding
string values.

Example of original .abnf grammar with range hexadecimal values:

<img src="doc-images/11_hexRange_before.png" style="border: 2px solid gray; text-align: left; padding: 5px; width: 350px">

After transformation of hexadecimal range to corresponding strings:

<img src="doc-images/12_hexRange_after.png" style="border: 2px solid gray; text-align: left; padding: 5px; width: 750px">

### 8. Replace single hexadecimal value

Method <code><b>replaceHexadecimal(result)</b></code> replaces single hexadecimal value with corresponding string value.

Example of original .abnf grammar with hexadecimal value:

<img src="doc-images/13_hex_before.png" style="border: 2px solid gray; text-align: left; padding: 5px; width: 300px">

After transformation of hexadecimal value to corresponding string:

<img src="doc-images/14_hex_after.png" style="border: 2px solid gray; text-align: left; padding: 5px; width: 300px">

### 9. Replace string rules

Method <code><b>rewriteStringRules(List<String>)</b></code> replaces commentaries enclosed in angle brackets

Example of original .abnf -str rule:

<img src="doc-images/15_stringRule_before.png" style="border: 2px solid gray; text-align: left; padding: 5px; width: 600px">

After transformation of rule:

<img src="doc-images/16_stringRule_after.png" style="border: 2px solid gray; text-align: left; padding: 5px; width: 600px">
