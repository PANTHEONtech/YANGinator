# How to successfully enable Highlighter

* Step 1 : generate lexer and parser according to tutorial [here](rfc-parser/docs/README.md)
* Step 2 : navigate into intelij-plugin-1-1/src/main/java/tech/pantheon/yanginator/plugin/highlighter
and right-click YangHighlighter.bnf and select Generate Parser Code
* Step 3 : right-click the bnf again and select Generate JFlex Lexer, the path for generated lexer should be gen/tech/pantheon/yanginator/plugin/highlighter
* Step 4 : navigate to the new generated lexer file, right-click it and select Run JFlex Generator