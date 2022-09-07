# Generating BNF grammar with some deviations
path = intelij-plugin/src/main/gen/tech/pantheon/yanginator/plugin

## Deviations from the original grammar

Following methods are used to modify the transformed BNF grammar for the plugin to function
correctly.


* `quoteStmts(lines)` [link](#Allows-statements-to-be-quoted)

* `splitDeviationStmt(result);` [link](#Split-deviation-statement)

* `removeOptional(result);` [link](#Removing-optional)

* `subDelimsAdjustment(result);` [link](#Sub-delims-adjustment)

* `additionalRules(result);` [link](#Additional-rules)

* `quotedAugmentArg(result);` [link](#Quoted-augment-arg)

* `quotedPath(result);` [link](#Quoted-path)

* `quotedStringSplitter(result);` [link](#Quoted-string-splitter)

* `revisionComment(result);` [link](#Comment-revision)

* `revisionReplace(result);` [link](#Changing-revision-statement)

* `linkageBodyReplace(result);` [link](#Changing-linkage-body)

* `metaBodyReplace(result);` [link](#Changing-meta-statement-body)

* `rewriteScheme(result);` [link](#Rewrite-scheme)

* `rewritePort(result);` [link](#Rewrite-port)

* `rewriteDateArg(result);` [link](#Improved-date-validation)

* `rewriteIdentifier(result);` [link](#Rewrite-identifier)

* `rewriteUnreserved(result);` [link](#Rewrite-unreserved)

* `rewriteZeroIntegerValue(result);`

* `rewriteIPV4Address(result);`

* `orderTokensForLexer(result);`

* `rewriteFractionDigitsArg(result);`

* `rewritePositiveIntegerValue(result);`

* `adjustModuleAndSubmoduleStmt(result);`

* `rewriteModuleHeaderStmts(result);`

* `rewriteSubModuleHeaderStmts(result);`

* `rewriteDataDefStmt(result);`

* `rewriteBodyStmts(result);`

* `adjustUnknownStatement(result);`

* `allowVersionOne(result);`

* `patternBodyChange(result);`

* `adjustRelPathKeyexpr(result);`

* `swapDecimalWithIntegerInRangeBoundaryDef(result);` [link](#swap-decimal-with-integer-in-range-boundary-def)

* `allowComments(result);`

* `makeSeparatorRulesPrivate(result);` [link](#make-separator-rules-private)

---


### Allows statements to be quoted
It's not explicitly defined in rfc but according to multiple validators it's allowed.

**Example**

Before

![quote statements before](doc-images/quote_statements_before.png)

After

![quote statements after](doc-images/quote_statements_after.png)


### Split deviation statement
Part of the definition is extracted to the separate statement to allow annotator to check for duplicities.
Doesn't change the logic of the grammar.

**Example**

Before

![split deviation statement before](doc-images/split_deviation_statement_before.png)

After

![split deviation statement after](doc-images/split_deviation_statement_after.png)


### Removing optional
Allowing parser to move on the next statement instead of matching 1st statement as empty in type-body-stmts.
Logic was intended this way.

**Example**

Before

![removing_optional_before](doc-images/removing_optional_before.png)

After

![removing_optional_after](doc-images/removing_optional_after.png)

### Sub delims adjustment
Removes semicolon from sub-delims allowing parser to match it as stmtend
after URI

**Example**

Before

![sub delims adjustment_before](doc-images/subdelimsadjustment_before.png)

After

![sub delims adjustment_after](doc-images/subdelimsadjustment_after.png)

### Additional rules
Method adds additional rules to the grammar.
string-splitter allows that some stmts can be in multiple strings joined with +
quoted-path-arg allows quoted path
vchar and quoted-vchar are replacement for yang-char until external rule checkString will work properly
Everything except chars is valid in yang 1.1 according to validators.

**Added rules**

![added rules](doc-images/added_rules.png)

### Quoted augment arg
Augment-arg can be quoted according to validators.

**Example**

Before

![quoted augment rules before](doc-images/quoted_augment_rules_before.png)

After

![quoted augment rules after](doc-images/quoted_augment_rules_after.png)


### Quoted path
Path can be quoted according to validators.

**Example**

Before

![quoted path before](doc-images/quoted_path_before.png)

After

![quoted path after](doc-images/quoted_path_after.png)

### Quoted string splitter
String-splitter can be quoted according to validators.

**Example**

Before

![quoted string splitter before](doc-images/quoted_string_splitter_before.png)

After

![quoted string splitter after](doc-images/quoted_string_splitter_after.png)

### Comment revision
Comment revision statement to make revision optional.

**Example**

Before

![revision comment before](doc-images/revision_comment_before.png)

After

![revision comment after](doc-images/revision_comment_after.png)


### Changing revision statement
Changing revision statement in module and submodule to make revision optional
and Format correctly in Yang 1.1

**Example**

Before

![revision replace before](doc-images/revision_replace_before.png)

After

![revision replace after](doc-images/revision_replace_after.png)


### Changing linkage body
Changing linkage body statement in BNF file to define that linkage must contain
at least one statement to Format correctly in Yang 1.1

**Example**

Before

![linkage body replace before](doc-images/linkage_body_replace_before.png)

After

![linkage body replace after](doc-images/linkage_body_replace_after.png)

### Changing meta statement body
Changing meta statement body in BNF file to define that meta must contain
at least one statement to Format correctly and error recovery to be functional.
Logic stays the same, statements can appear in any order and duplicities are
checked in annotator.

**Example**

Before

![meta body replace before](doc-images/meta_body_replace_before.png)

After

![meta body replace after](doc-images/meta_body_replace_after.png)

### Rewrite scheme
New tokens added due to double-click word selection.

**Example**

Before

![rewrite scheme before](doc-images/rewrite_scheme_before.png)

After

![rewrite scheme after](doc-images/rewrite_scheme_after.png)

### Rewrite port
New tokens added due to double-click word selection.

**Example**

Before

![rewrite port before](doc-images/rewrite_port_before.png)

After

![rewrite port after](doc-images/rewrite_port_after.png)

### Improved date validation
Improved check for valid year/month/day. Double-click word selection.

**Example**

Before

![rewrite date before](doc-images/rewrite_date_before.png)

After

![rewrite date after](doc-images/rewrite_date_after.png)

### Rewrite identifier
New tokens added due to double-click word selection.

**Example**

Before

![rewrite identifier before](doc-images/rewrite_identifier_before.png)

After

![rewrite identifier after](doc-images/rewrite_identifier_after.png)

### Rewrite unreserved
New tokens added due to double-click word selection.

**Example**

Before

![rewrite unreserved before](doc-images/rewrite_unreserved_before.png)

After

![rewrite unreserved after](doc-images/rewrite_unreserved_after.png)






### Swap decimal value With integer value

### Allow stmts to be Quoted
quoteStmts(lines)
### Swap decimal with integer in range boundary def


Decimal values, e.g. 7.58, were incorrectly identified as integers which caused the dot "." (decimal point),
that separates the decimal place from the whole, to trigger an error. The reason for the integer
preference over the decimal is that the integer-value was defined before the decimal-value
in the grammar(according to [rfc 6020](https://www.rfc-editor.org/rfc/rfc6020.html)).

**Decimal number highlighted as error**
![decimal value error](doc-images/decimal_value_error.png)  
**BNF transformed from the original ABNF (RFC 6020)**  
![decimal value error bnf](doc-images/decimal_value_error_bnf.png)

After swapping the two statements, integer-value and decimal-value, the error highlighting disappeared.  
**Modification to the BNF to support decimal values**  
![decimal value error fixed bnf](doc-images/decimal_value_error_fixed_bnf.png)  
**No error highlighting after the integer/decimal value swap**  
![decimal value error fixed](doc-images/decimal_value_error_fixed.png)  
From this behavior we can assume that when the first digit of a decimal number was inserted, it was
identified as an integer-value. The decimal point (i.e. the dot: ".") then caused an error. This is

no longer an issue after the swap in the grammar rule.

no longer an issue after the swap in the grammar rule.  
### Make separator rules private
The method [allowComments()](#allow-comments) adds support for comments into the definitions of 
separators (sep, optsep, stmtsep). These separators contain white space characters and should be also
treated as white spaces, but they can't be treated this way because they might contain comments. 
This created problems in formatting, which is the reason why they needed to be flagged as private.  
This ensures, that PsiElement is not created for these in the PsiTree, which results in comments 
not being a child of a node (as can be seen in the next figure), that should be treated as a white space.

![parent of comment that should be treated as a white space](doc-images/psiTreeComment_before.png)
  
After this change, no separator (i.e. sep, optsep, stmtsep) psi node is created. This results in 
comments having non-whitespace parents (shown in next figure). Finally, no problems with formatting.

![non-whitespace node being parent of a comment](doc-images/psiTreeComment_after.png)
  
This change solves problem with formatting. The problem was, that comments were not being covered by block
(whitespaces are skipped during block creation). This resulted in an exception being thrown when
manipulating with comments.

---
## ***More methods are used that are not yet documented***
