# Generating BNF grammar with some deviations
path = intelij-plugin/src/main/gen/tech/pantheon/yanginator/plugin

## Deviations from the original grammar

Following methods are used to modify the transformed BNF grammar for the plugin to function
correctly.


* `quoteStmts(lines)`

* `splitDeviationStmt(result);`

* `removeOptional(result);`

* `subDelimsAdjustment(result);`

* `additionalRules(result);`

* `quotedAugmentArg(result);`

* `quotedPath(result);`

* `quotedStringSplitter(result);`

* `revisionComment(result);`

* `revisionReplace(result);`

* `linkageBodyReplace(result);`

* `metaBodyReplace(result);`

* `rewriteScheme(result);`

* `rewritePort(result);`

* `rewriteDateArg(result);`

* `rewriteIdentifier(result);`

* `rewriteUnreserved(result);`

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
