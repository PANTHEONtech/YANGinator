# Generating BNF grammar with some deviations

path = intelij-plugin/src/main/gen/tech/pantheon/yanginator/plugin

## Deviations from the original grammar

Following methods are used to modify the transformed BNF grammar for the plugin to function
correctly.

* `quoteStmts(lines)` [link](#Allows-statements-to-be-quoted)

* `splitDeviationStmt(result);` [link](#Split-deviation-statement)

* `removeOptional(result);` [link](#Removing-optional)

* `subDelimsAdjustment(result);` [link](#Sub-delims-adjustment)

* `rewriteYangInitialization(result);` [link](#Rewrite-Yang-Initialization)

* `additionalRules(result);` [link](#Additional-rules)

* `quotedAugmentArg(result);` [link](#Quoted-augment-arg)

* `quotedPath(result);` [link](#Quoted-path)

* `quotedStringSplitter(result);` [link](#Quoted-string-splitter)

* `linkageBodyReplace(result);` [link](#Changing-linkage-body)

* `metaBodyReplace(result);` [link](#Changing-meta-statement-body)

* `rewriteScheme(result);` [link](#Rewrite-scheme)

* `rewritePort(result);` [link](#Rewrite-port)

* `rewriteDateArg(result);` [link](#Improved-date-validation)

* `rewriteIdentifier(result);` [link](#Rewrite-identifier)

* `rewriteUnreserved(result);` [link](#Rewrite-unreserved)

* `rewriteZeroIntegerValue(result);`[link](#Rewrite-Zero-Integer-Value)

* `rewriteIPV4Address(result);`[link](#Rewrite-IPV4-Address)

* `makeSeparatorRulesPrivate(result);` [link](#make-separator-rules-private)

* `orderTokensForLexer(result);`[link](#Order-Tokens-For-Lexer)

* `rewriteFractionDigitsArg(result);`[link](#Rewrite-Fraction-DigitsArg)

* `rewritePositiveIntegerValue(result);`[link](#Rewrite-Positive-Integer-Value)

* `adjustModuleAndSubmoduleStmt(result);`[link](#Adjust-Module-And-Submodule-Stmt)

* `rewriteModuleHeaderStmts(result);`[link](#Rewrite-Module-Header-Stmts)

* `rewriteSubModuleHeaderStmts(result);`[link](#Rewrite-SubModule-Header-Stmts)

* `rewriteDataDefStmt(result);`[link](#Rewrite-Data-Def-Stmt)

* `rewriteBodyStmts(result);`[link](#Rewrite-Body-Stmts)

* `adjustUnknownStatement(result);`[link](#Adjust-Unknown-Statement)

* `allowVersionOne(result);`[link](#Allow-Version-One)

* `patternBodyChange(result);`[link](#Pattern-Body-Change)

* `adjustRelPathKeyexpr(result);`[link](#Adjust-Rel-Path-Keyexpr)

* `swapDecimalWithIntegerInRangeBoundaryDef(result);`[link](#Swap-Decimal-With-Integer-In-Range-Boundary-Def)

* `allowComments(result);`[link](#Allow-Comments)

* `addStringSplittersForIfFeatures(result);` [link](#add-splitters-for-if-features) 

* `allowIndentString(result);`[link](#Allow-indents-for-certain-strings)

* `rewriteUsesAugmentStmt(result);`[link](#Rewrite-Uses-Augment-Stmt)

* `adjustDoubleColonInPchar(result);`[link](#Adjust-Double-Colon-In-Pchar)

* `allowReferenceLinkage(result);`[link](#Make-linkages-referencable)

* `changeInputOutputCardinality(result);`[link](#Change-input-and-output-data-def-stmt-cardinality)


### Rewrite Zero Integer Value

  Rewrites zero-integer-value with proper tokens

  Before:

  ![rewriteZeroIntegerValue](doc-images/rewriteZeroIntegerValue_input.png)

  After:

  ![rewriteZeroIntegerValue](doc-images/rewriteZeroIntegerValue_output.png)

### Rewrite IPV4 Address

  Rewrites IPv4address with proper token

  Before:

  ![rewriteIPV4Address](doc-images/rewriteIPV4Address_input.png)

  After:

  ![rewriteIPV4Address](doc-images/rewriteIPV4Address_output.png)

### Adjust Double Colon In Pchar

  Adjust Double Colon In Pchar

  Before:

  ![adjustDoubleColonInPchar](doc-images/adjustDoubleColonInPchar_input.png)

  After:

  ![adjustDoubleColonInPchar](doc-images/adjustDoubleColonInPchar_output.png)

### Order Tokens For Lexer 

  Order of tokens sets the priority for lexer when it needs to pick one of the multiple matches.
  The sooner it occurs in bnf the higher the priority to be matched if multiple tokens can match multiple
  different characters or strings

  This method makes sure order looks like this:

  ![orderTokensForLexer](doc-images/orderTokensForLexer_output.png)

### Rewrite Fraction DigitsArg

  Rewrites fraction-digits-arg with proper tokens

  Before:

  ![rewriteFractionDigitsArg](doc-images/rewriteFractionDigitsArg_input.png)

  After:

  ![rewriteFractionDigitsArg](doc-images/rewriteFractionDigitsArg_output.png)

### Rewrite Yang Initialization

  Adds WSP | ZERO_LENGTH_STRING | LINEFEED | CARRIAGE_RETURN against empty yang error.

  Before:

  ![rewriteYangInitialization](doc-images/rewriteYangInitialization_input.png)

  After:

  ![rewriteYangInitialization](doc-images/rewriteYangInitialization_output.png)

### Rewrite Positive Integer Value

  Rewrites positive-integer-value with proper tokens

  Before:

  ![rewritePositiveIntegerValue](doc-images/rewritePositiveIntegerValue_input.png)

  After:

  ![rewritePositiveIntegerValue](doc-images/rewritePositiveIntegerValue_output.png)

### Adjust Module And Submodule Stmt

  Making meta and linkage stmts optional in module and submodule stmts
  due to changes in their definitions to prevent grammar logic changes.

  Before:

  ![adjustModuleAndSubmoduleStmt](doc-images/adjustModuleAndSubmoduleStmt_input.png)

  After:

  ![adjustModuleAndSubmoduleStmt](doc-images/adjustModuleAndSubmoduleStmt_output.png)

### Rewrite Module Header Stmts

  Adjust module-header-stmts for error recovery. Logic stays the same,
  statements can appear in any order and duplicities are checked in annotator.

  Before:

  ![rewriteModuleHeaderStmts](doc-images/rewriteModuleHeaderStmts_input.png)

  After:

  ![rewriteModuleHeaderStmts](doc-images/rewriteModuleHeaderStmts_output.png)

### Rewrite SubModule Header Stmts

  Adjust submodule-header-stmts for error recovery. Logic stays the same,
  statements can appear in any order and duplicities are checked in annotator.

  Before:

  ![rewriteSubModuleHeaderStmts](doc-images/rewriteSubModuleHeaderStmts_input.png)

  After:

  ![rewriteSubModuleHeaderStmts](doc-images/rewriteSubModuleHeaderStmts_output.png)

### Rewrite Data Def Stmt

  Switching positions of leaf-list-stmt and leaf-stmt due to error recovery always
  matching leaf-stmt if it was before leaf-list-stmt.

  Before:

  ![rewriteDataDefStmt](doc-images/rewriteDataDefStmt_input.png)

  After:

  ![rewriteDataDefStmt](doc-images/rewriteDataDefStmt_output.png)

### Rewrite Body Stmts

  Decomposing body-stmts into sub statements due error recovery.
  Logic should remain the same only change against RFC 7950 is
  changing * (0 - infinity) to + (1 - infinity) not allowing empty body.

  Before:

  ![rewriteBodyStmts](doc-images/rewriteBodyStmts_input.png)

  After:

  ![rewriteBodyStmts](doc-images/rewriteBodyStmts_output.png)

### Adjust Unknown Statement

  Allowing quoted-string in unknown statement.

  Before:

  ![adjustUnknownStatement](doc-images/adjustUnknownStatement_input.png)

  After:

  ![adjustUnknownStatement](doc-images/adjustUnknownStatement_output.png)

### Allow Version One

  Allowing version to be 1 or 1.1 instead of only 1.1

  Before:

  ![allowVersionOne](doc-images/allowVersionOne_input.png)

  After:

  ![allowVersionOne](doc-images/allowVersionOne_output.png)

### Pattern Body Change

  Adding new pattern-body Statement to pattern-stmt expression in BNF file for separate
  Regex value expression

  Before:

  ![patternBodyChange](doc-images/patternBodyChange_input.png)

  After:

  ![patternBodyChange](doc-images/patternBodyChange_output.png)

### Adjust Rel Path Keyexpr

  Adding token to the definition because it's prioritized to be matched in lexer
  as it's matching more characters at once.

  Before:

  ![adjustRelPathKeyexpr](doc-images/adjustRelPathKeyexpr_input.png)

  After:

  ![adjustRelPathKeyexpr](doc-images/adjustRelPathKeyexpr_output.png)

### Swap Decimal With Integer In Range Boundary Def

  When a decimal value was used, the integer-value statement was recognized first,
  and it resulted in an error. See [link](#swap-decimal-value-with-integer-value).

  By swapping these statements, the decimal-value statement will be recognized first resulting
  in correctly identifying both decimal-value and integer-value

  Before:

  ![swapDecimalWithIntegerInRangeBoundaryDef](doc-images/swapDecimalWithIntegerInRangeBoundaryDef_input.png)

  After:

  ![swapDecimalWithIntegerInRangeBoundaryDef](doc-images/swapDecimalWithIntegerInRangeBoundaryDef_output.png)

### Allow Comments

  Allowing single and multi-line comments in yang 1.1 according to validator.

  Before:

  ![allowComments](doc-images/allowComments_input.png)

  ![allowComments](doc-images/allowComments_input2.png)

  After:

  ![allowComments](doc-images/allowComments_output.png)

  ![allowComments](doc-images/allowComments_output2.png)

  Comment initialization:

  add extra keywords only for comment
  ![allowComments](doc-images/allowComments_commentInit.png)


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
These rules have been changed during development.

**Added rules**

new:

![added rules](doc-images/added_rules.png)

changed: 

![added_rules_after.png](doc-images/added_rules_after.png)

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

New tokens added due to double-click word selection and multi-line capability.

**Example**

Before

![rewrite identifier before](doc-images/rewrite_identifier_before.png)

After

![identifier_after.png](doc-images/identifier_after.png)

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


### String separation possibility for paths

The method addStringSplitterForPaths() adds support for string separators into the path definition.
String separation in paths was not possible for not completed definitions of path based on RFC.
This threw an error that did not allow next elements to be parsed correctly. The solution is to insert 
split-strings (plus sign surrounded with quotes) inside the definitions of paths.

**Augment arg str**  

before:  

![](doc-images/augment_arg_str_before.png)

after:  

![](doc-images/augment_arg_str_after.png)  

**Absolute schema nodeid**  

before:  

![](doc-images/absolute_schema_nodeid_before.png)  

after:  

![](doc-images/absolute_schema_nodeid_after.png)  

### Path definitions

before:  

![](doc-images/path_definition_before.png)  

after:  

![](doc-images/path_definition_after.png)  

#### Path predicate

before:

![](doc-images/path_predicate_before.png)

after:

![](doc-images/path_predicate_after.png)

#### Relative Path expressions

before:

![rel_path_exp_before.png](doc-images%2Frel_path_exp_before.png)

after:

![rel_path_exp_after.png](doc-images%2Frel_path_exp_after.png)

#### Segments
before:

![segment_before.png](doc-images%2Fsegment_before.png)

after:

![segment_after.png](doc-images%2Fsegment_after.png)

### Allow indents for certain strings

The method allowIndentString() adds support for keyword strings to have proper indent. 

Before:  
![statements_to_indent_before.png](doc-images/statements_to_indent_before.png)

After:  
![statements_to_indent_after.png](doc-images/statements_to_indent_after.png)

![indentable_string.png](doc-images/indentable_string.png)

### Resolved inconsistent quantifiers

Changed quantifiers for **linkage-stmts** and **body-stmts** according to RFC6020  
Before:  
![](doc-images/resolved_inconsistent_quantifiers_before.png)  
After:  
![](doc-images/resolved_inconsistent_quantifiers_after.png)


### Rewrite Uses Augment Stmt

Overwrite UsesAugmentStmt according to rfc.

                 +--------------+---------+-------------+
                 | substatement | section | cardinality |
                 +--------------+---------+-------------+
                 | augment      | 7.15    | 0..1        |
                 | description  | 7.19.3  | 0..1        |
                 | if-feature   | 7.18.2  | 0..n        |
                 | refine       | 7.12.2  | 0..1        |
                 | reference    | 7.19.4  | 0..1        |
                 | status       | 7.19.2  | 0..1        |
                 | when         | 7.19.5  | 0..1        |
                 +--------------+---------+-------------+

Before:

![](doc-images/path_predicate_before.png)

After:

![](doc-images/path_predicate_after.png)


### Add splitters for if-features

Changed if-feature expressions, so that splitting the string is possible.

before:

![if_feature_before.png](doc-images/if_feature_before.png)

after:

![if_feature_after.png](doc-images/if_feature_after.png)


### Make linkages referencable

Changed import and linkage statements string arguments so hey can be referenced. 
Grammar is the same, only these elements implement referencing

before:

![linkage_stmts_before_ref.png](doc-images%2Flinkage_stmts_before_ref.png)

after:

![linkage_stmts_after_ref.png](doc-images%2Flinkage_stmts_after_ref.png)

### Added single quote possibility 
Added single quote possibility for **identifier-ref-arg** and **identifier-ref-arg-str** statements

Before:  
![](doc-images/identifier-ref-arg_SQOTE_before.png)

After:  
![](doc-images/identifier-ref-arg_SQOTE_after.png)


### Rewrite Augment Stmt  

Changed Augment-Stmt according to rfc6020.

                 +--------------+---------+-------------+
                 | substatement | section | cardinality |
                 +--------------+---------+-------------+
                 | anyxml       | 7.10    | 0..n        |
                 | case         | 7.9.2   | 0..n        |
                 | choice       | 7.9     | 0..n        |
                 | container    | 7.5     | 0..n        |
                 | description  | 7.19.3  | 0..1        |
                 | if-feature   | 7.18.2  | 0..n        |
                 | leaf         | 7.6     | 0..n        |
                 | leaf-list    | 7.7     | 0..n        |
                 | list         | 7.8     | 0..n        |
                 | reference    | 7.19.4  | 0..1        |
                 | status       | 7.19.2  | 0..1        |
                 | uses         | 7.12    | 0..n        |
                 | when         | 7.19.5  | 0..1        |
                 +--------------+---------+-------------+

Before:  
![](doc-images/Augment-stmt-before.png)

After:  
![](doc-images/Augment-stmt-after.png)


### Change input and output data def stmt cardinality
Changed input-stmt and output-stmt data-def-stmt cardinality to 0..n 

Input-stmt

            7.14.2.1.  The input's Substatements (RFC7950)

                +--------------+---------+-------------+
                | substatement | section | cardinality |
                +--------------+---------+-------------+
                | anydata      | 7.10    | 0..n        |
                | anyxml       | 7.11    | 0..n        |
                | choice       | 7.9     | 0..n        |
                | container    | 7.5     | 0..n        |
                | grouping     | 7.12    | 0..n        |
                | leaf         | 7.6     | 0..n        |
                | leaf-list    | 7.7     | 0..n        |
                | list         | 7.8     | 0..n        |
                | must         | 7.5.3   | 0..n        |
                | typedef      | 7.3     | 0..n        |
                | uses         | 7.13    | 0..n        |
                +--------------+---------+-------------+

Before:

![input_stmt_before.png](doc-images/input_stmt_before.png)

After:

![input_stmt_after.png](doc-images/input_stmt_after.png)

Output-stmt

            7.14.3.1.  The output's Substatements (RFC7950)

                +--------------+---------+-------------+
                | substatement | section | cardinality |
                +--------------+---------+-------------+
                | anydata      | 7.10    | 0..n        |
                | anyxml       | 7.11    | 0..n        |
                | choice       | 7.9     | 0..n        |
                | container    | 7.5     | 0..n        |
                | grouping     | 7.12    | 0..n        |
                | leaf         | 7.6     | 0..n        |
                | leaf-list    | 7.7     | 0..n        |
                | list         | 7.8     | 0..n        |
                | must         | 7.5.3   | 0..n        |
                | typedef      | 7.3     | 0..n        |
                | uses         | 7.13    | 0..n        |
                +--------------+---------+-------------+

Before:

![output_stmt_before.png](doc-images/output_stmt_before.png)

After:

![output_stmt_after.png](doc-images/output_stmt_after.png)

### Edited identifier for support string splitter in if-feature
### Edited identifier to support string splitter in if-feature
Added "**or**","**and**" and "**not**" keywords as possible to **identifier** to support 
string-splitter in **if-feature** stmt after these keywords

Before:  
![](doc-images/identifier_for_if-feature_before.png)

After:  
![](doc-images/identifier_for_if-feature_after.png)

---

## ***More methods are used that are not yet documented***
