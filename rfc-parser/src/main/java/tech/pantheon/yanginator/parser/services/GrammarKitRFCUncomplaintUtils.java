/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.parser.services;

import java.util.ArrayList;
import java.util.List;

public class GrammarKitRFCUncomplaintUtils {
    public static List<String> additionalAdjustments(List<String> lines) {
        List<String> result = quoteStmts(lines);
        result = rewriteYangInitialization(result);
        result = splitDeviationStmt(result);
        result = removeOptional(result);
        result = subDelimsAdjustment(result);
        addXpath(result);
        additionalRules(result);
        addYangKeywords(result);
        addFileReference(result);
        result = quotedAugmentArg(result);
        result = quotedPath(result);
        result = quotedStringSplitter(result);
        result = linkageBodyReplace(result);
        result = metaBodyReplace(result);
        result = rewriteScheme(result);
        result = rewritePort(result);
        result = rewriteDateArg(result);
        result = rewriteIdentifier(result);
        result = rewriteUnreserved(result);
        result = rewriteZeroIntegerValue(result);
        result = rewriteIPV4Address(result);
        result = orderTokensForLexer(result);
        result = rewriteFractionDigitsArg(result);
        result = rewritePositiveIntegerValue(result);
        result = adjustModuleAndSubmoduleStmt(result);
        result = rewriteModuleHeaderStmts(result);
        result = rewriteSubModuleHeaderStmts(result);
        result = rewriteDataDefStmt(result);
        result = rewriteBodyStmts(result);
        result = adjustUnknownStatement(result);
        result = allowVersionOne(result);
        result = patternBodyChange(result);
        result = adjustRelPathKeyexpr(result);
        result = swapDecimalWithIntegerInRangeBoundaryDef(result);
        result = allowComments(result);
        result = addStringSplitterForPaths(result);
        result = allowIndentString(result);
        result = rewriteUsesAugmentStmt(result);
        result = adjustDoubleColonInPchar(result);
        result = addStringSplittersForIfFeatures(result);
        result = allowReferenceLinkage(result);
        result = addSingleQuotePossibility(result);
        result = rewriteAugment(result);
        result = changeInputOutputCardinality(result);
        result = changeOrderOfTypeBodyStmt(result);
        result = changeListCardinality(result);
        return makeSeparatorRulesPrivate(result);
    }

    private static void addXpath(List<String> lines) {
        lines.add("// Xpath functions\n" +
                "function-body-start ::= string-splitter? LEFT_PARENTHESIS\n" +
                "function-body-end ::= RIGHT_PARENTHESIS\n" +
                "function-body-node ::= string-splitter? (path-arg | DOT | schema-nodeid) string-splitter?\n" +
                "function-body-identity ::= string-splitter? identifier-arg-str string-splitter?\n" +
                "function-body-string ::= string-splitter? quoted-string string-splitter?\n" +
                "function-body-node-identity ::=  function-body-start function-body-node WSP* COMMA WSP* function-body-identity function-body-end\n" +
                "function-body-node-string ::=  function-body-start function-body-node WSP* COMMA WSP* function-body-string function-body-end\n" +
                "function-body-string-string ::= function-body-start function-body-string WSP* COMMA WSP* function-body-string function-body-end\n" +
                "deref-keyword ::= \"deref\"\n" +
                "deref-function ::= deref-keyword function-body-start function-body-node function-body-end\n" +
                "                    (schema-nodeid | FORWARD_SLASH? path-arg) string-splitter? EQUALS string-splitter? (true-keyword | false-keyword) |\n" +
                "    deref-keyword function-body-start function-body-node function-body-end (schema-nodeid | FORWARD_SLASH? path-arg) string-splitter? |\n" +
                "    deref-keyword function-body-start function-body-node function-body-end\n" +
                "\n" +
                "rematch-keyword ::= \"re-match\"\n" +
                "rematch-function ::= rematch-keyword function-body-string-string\n" +
                "\n" +
                "derived-from-keyword ::= \"derived-from\"\n" +
                "derived-from-function ::= derived-from-keyword function-body-node-identity\n" +
                "\n" +
                "derived-from-or-self-keyword ::= \"derived-from-or-self\"\n" +
                "derived-from-or-self-function ::= derived-from-or-self-keyword function-body-node-identity\n" +
                "\n" +
                "enum-value-keyword ::= \"enum-value\"\n" +
                "enum-value-function ::= enum-value-keyword function-body-start function-body-node function-body-end\n" +
                "\n" +
                "bit-is-set-keyword ::= \"bit-is-set\"\n" +
                "bit-is-set-function ::= bit-is-set-keyword function-body-node-string\n" +
                "\n" +
                "function ::= (deref-function |\n" +
                "    rematch-function |\n" +
                "    derived-from-or-self-function |\n" +
                "    derived-from-function |\n" +
                "    enum-value-function |\n" +
                "    bit-is-set-function)+\n" +
                "\n" +
                "XPath-function ::= WSP* (and-keyword | not-keyword | or-keyword) WSP* string-splitter?\n" +
                "                   LEFT_PARENTHESIS string-splitter? function string-splitter? RIGHT_PARENTHESIS string-splitter? |\n" +
                "    WSP* (and-keyword | not-keyword | or-keyword) WSP* string-splitter? function string-splitter? |\n" +
                "    function string-splitter?\n" +
                "\n" +
                "Quoted_xpath_function ::= DQUOTE XPath-function+ DQUOTE | SQUOTE XPath-function+ SQUOTE");
    }

    /**
     * Allows stmts to be quoted. It's not explicitly defined in rfc
     * but according to multiple validators it's allowed.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> quoteStmts(List<String> lines) {
        List<String> result = new ArrayList<>();
        List<String> stmts = new ArrayList<>(List.of("description-stmt ::=", "organization-stmt ::=", "contact-stmt ::=", "reference-stmt ::=",
                "units-stmt ::=", "default-stmt ::=", "presence-stmt ::=", "error-message-stmt ::=", "error-app-tag-stmt ::=", "enum-stmt ::=", "when-stmt ::=",
                "must-stmt ::="));
        for (String line : lines) {
            for (String stmt : stmts) {
                if (line.contains(stmt)) {
                    if (stmt.equals("when-stmt ::=") || stmt.equals("must-stmt ::=")) {
                        line = line.replace("string", "( XPath-function | Quoted_xpath_function | quoted-string | string )");
                    } else {
                        line = line.replace("string", "( quoted-string | string )");
                    }
                }
                if (line.contains("quoted-string ::=")) {
                    line = line.replace(" string", " quoted-vchar");
                }
                if (line.contains("pattern-stmt ::=")) {
                    line = "pattern-stmt ::= pattern-keyword sep quoted-string optsep";
                }
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Part of the definition is extracted to the separate statement to allow
     * annotator to check for duplicities. Doesn't change the logic of the grammar.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> splitDeviationStmt(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean found = false;
        for (String line : lines) {
            if (line.contains("deviation-stmt ::=")) {
                result.add("deviation-stmt-body-args ::= deviate-not-supported-stmt |\n" +
                        "  (deviate-add-stmt |\n" +
                        "  deviate-replace-stmt |\n" +
                        "  deviate-delete-stmt)+");
                result.add("");
                found = true;
            }
            result.add(line);
            if (found && line.contains("deviate")) {
                result.remove(line);
            }
            if (found && line.contains("RIGHT_BRACE")) {
                result.remove(result.size() - 1);
                result.add("  deviation-stmt-body-args>>");
                result.add(line);
                found = false;
            }
        }
        return result;
    }

    /**
     * Allowing parser to move on the next statement instead of matching 1st statement as empty
     * in type-body-stmts. Logic was intended this way.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> removeOptional(List<String> lines) {
        List<String> result = new ArrayList<>();
        List<String> stmts = new ArrayList<>(List.of("instance-identifier-specification ::=", "numerical-restrictions ::=",
                "binary-specification ::="));
        boolean found = false, restriction = false;
        for (String line : lines) {
            for (String stmt : stmts) {
                if (line.contains(stmt)) {
                    found = true;
                }
                if (found && line.contains("[")) {
                    line = line.replace("[", "").replace("]", "");
                    found = false;
                }
                if (line.contains("string-restrictions ::=")) {
                    restriction = true;
                }
                if (restriction && line.contains("*")) {
                    line = line.replace("*", "+");
                    restriction = false;
                }
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Removes semicolon from sub-delims allowing parser to match it as stmtend
     * after URI;
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> subDelimsAdjustment(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean subDelims = false;
        for (String line : lines) {
            if (line.contains("sub-delims ::=")) {
                subDelims = true;
            }
            if (subDelims && line.contains("SEMICOLON")) {
                line = line.replace("SEMICOLON | ", "");
                subDelims = false;
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Method adds additional rules to the grammar.
     * string-splitter allows that some stmts can be in multiple strings joined with +
     * quoted-path-arg allows quoted path
     * vchar and quoted-vchar are replacement for yang-char until external rule checkString will work properly
     * Everything except chars is valid in yang 1.1 according to validators.
     *
     * @param lines list of strings
     */
    private static void additionalRules(List<String> lines) {
        lines.add("");
        lines.add("string-splitter ::= (WSP* SQUOTE optsep PLUS_SIGN optsep SQUOTE WSP*) | (WSP* DQUOTE optsep PLUS_SIGN optsep DQUOTE WSP*)");
        lines.add("");
        lines.add("quoted-path-arg ::= (DQUOTE path-arg (string-splitter path-arg)* DQUOTE) | (SQUOTE path-arg (string-splitter path-arg)* SQUOTE)");
        lines.add("");
        lines.add("double-quoted-vchar ::= (SINGLE_QUOTE | BACK_SLASH | ESCAPES | VCHAR | SPACE | SEMICOLON | LEFT_BRACE | RIGHT_BRACE | TAB | LINEFEED sep | LINEFEED | CARRIAGE_RETURN)*");
        lines.add("");
        lines.add("quoted-vchar ::= (VCHAR | BACK_SLASH | DOUBLE_QUOTE | ESCAPES | SPACE | SEMICOLON | LEFT_BRACE | RIGHT_BRACE | TAB | LINEFEED sep | LINEFEED | CARRIAGE_RETURN)*");
        lines.add("");
        lines.add("VCHAR ::= (DATE | FRACTIONS | ZEROS | ALPHANUMERICAL_ALPHA_FIRST | ALPHANUMERICAL_DIGIT_FIRST | IPV4 | DIGITS | CHARS | APOSTROPHE | EXCLAMATION_MARK | HASH | DOLLAR_SIGN | PERCENT_SIGN | AMPERSAND | LEFT_PARENTHESIS | RIGHT_PARENTHESIS | ASTERISK | PLUS_SIGN | COMMA | DASH | DOT | FORWARD_SLASH | DOUBLE_FORWARD_SLASH | ZERO | ONE | TWO | THREE | FOUR | FIVE | SIX | SEVEN | EIGHT | NINE | COLON |  LESS_THAN_SIGN | EQUALS | GREATER_THAN_SIGN | QUESTION_MARK | AT_SIGN | ALPHA | OPEN_BRACKET | CLOSED_BRACKET | CIRCUMFLEX_ACCENT | UNDERSCORE | GRAVE_ACCENT | PIPE | TILDE | DOUBLE_DOT | DOUBLE_COLON | PARENT_FOLDER )");
    }


    private static void addYangKeywords(List<String> lines) {
        lines.add("");
        lines.add("yang-keyword ::= action-keyword |");
        lines.add("anydata-keyword |");
        lines.add("anyxml-keyword |");
        lines.add("argument-keyword |");
        lines.add("augment-keyword |");
        lines.add("base-keyword |");
        lines.add("belongs-to-keyword |");
        lines.add("bit-keyword |");
        lines.add("case-keyword |");
        lines.add("choice-keyword |");
        lines.add("config-keyword |");
        lines.add("contact-keyword |");
        lines.add("container-keyword |");
        lines.add("default-keyword |");
        lines.add("description-keyword |");
        lines.add("deviation-keyword |");
        lines.add("deviate-keyword |");
        lines.add("enum-keyword |");
        lines.add("error-app-tag-keyword |");
        lines.add("error-message-keyword |");
        lines.add("extension-keyword |");
        lines.add("feature-keyword |");
        lines.add("fraction-digits-keyword |");
        lines.add("grouping-keyword |");
        lines.add("identity-keyword |");
        lines.add("if-feature-keyword |");
        lines.add("import-keyword |");
        lines.add("include-keyword |");
        lines.add("input-keyword |");
        lines.add("key-keyword |");
        lines.add("leaf-list-keyword |");
        lines.add("leaf-keyword |");
        lines.add("length-keyword |");
        lines.add("list-keyword |");
        lines.add("mandatory-keyword |");
        lines.add("max-elements-keyword |");
        lines.add("min-elements-keyword |");
        lines.add("modifier-keyword |");
        lines.add("module-keyword |");
        lines.add("must-keyword |");
        lines.add("namespace-keyword |");
        lines.add("notification-keyword |");
        lines.add("ordered-by-keyword |");
        lines.add("organization-keyword |");
        lines.add("output-keyword |");
        lines.add("path-keyword |");
        lines.add("pattern-keyword |");
        lines.add("position-keyword |");
        lines.add("prefix-keyword |");
        lines.add("presence-keyword |");
        lines.add("range-keyword |");
        lines.add("reference-keyword |");
        lines.add("refine-keyword |");
        lines.add("require-instance-keyword |");
        lines.add("revision-date-keyword |");
        lines.add("revision-keyword |");
        lines.add("rpc-keyword |");
        lines.add("status-keyword |");
        lines.add("submodule-keyword |");
        lines.add("typedef-keyword |");
        lines.add("type-keyword |");
        lines.add("unique-keyword |");
        lines.add("units-keyword |");
        lines.add("uses-keyword |");
        lines.add("value-keyword |");
        lines.add("when-keyword |");
        lines.add("yang-version-keyword |");
        lines.add("yin-element-keyword");
        lines.add("");
    }

    private static void addFileReference(List<String> lines) {
        lines.add("file-reference ::= <<fileReference>>");
    }

    /**
     * Path can be quoted according to validators.
     * Added Xpath possibility.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> quotedPath(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("path-arg-str ::=")) {
                line = line.replaceAll("::= ", "::= XPath-function | Quoted_xpath_function | ");
                line = line + " | quoted-path-arg";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * augment-arg can be quoted according to validators.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> quotedAugmentArg(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("augment-arg-str ::= augment-arg")) {
                line = "augment-arg-str ::= augment-arg | (DQUOTE augment-arg DQUOTE)" +
                        " | (SQUOTE augment-arg SQUOTE)";
            }
            result.add(line);
        }
        return result;
    }

    private static List<String> quotedStringSplitter(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("quoted-string ::=")) {
                line = "quoted-string ::= (DQUOTE double-quoted-vchar (string-splitter double-quoted-vchar)* DQUOTE) | (SQUOTE quoted-vchar (string-splitter quoted-vchar)* SQUOTE)";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Allowing single and multi-line comments in yang 1.1 according to validator.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> allowComments(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("stmtsep ::=")) {
                line = "stmtsep ::= (WSP | line-break | unknown-statement | comment)*";
            }
            if (line.contains("optsep ::=")) {
                line = "optsep ::= (WSP | line-break | comment)*";
            }
            if (line.contains("sep ::= (WSP | line-break)+")) {
                line = "sep ::= (WSP | line-break | comment)+";
            }
            result.add(line);
        }
        result.add("");
        result.add("DOUBLE_FORWARD_SLASH ::= FORWARD_SLASH FORWARD_SLASH");
        result.add("BLOCK_COMMENT_START::= FORWARD_SLASH ASTERISK");
        result.add("BLOCK_COMMENT_END ::= ASTERISK FORWARD_SLASH");
        result.add("");
        result.add("BLOCK_COMMENT_BODY ::= <<blockComment>>");
        result.add("BLOCK_COMMENT ::= BLOCK_COMMENT_START BLOCK_COMMENT_BODY BLOCK_COMMENT_END");

        result.add("");
        result.add("comment ::= BLOCK_COMMENT |(DOUBLE_FORWARD_SLASH (DQUOTE | LEFT_BRACE | DOUBLE_BACKSLASH | BACKSLASH_QUOTE | RIGHT_BRACE | SEMICOLON | VCHAR | SPACE | TAB | BACK_SLASH | SINGLE_QUOTE | CARRIAGE_RETURN )+ ) | DOUBLE_FORWARD_SLASH");
        //add extra keywords only for comment
        result.add("DOUBLE_BACKSLASH ::= '\\\\'");
        result.add("BACKSLASH_QUOTE ::= '\\\"'");
        return result;
    }

    /**
     * Changing linkage body statement in BNF file to define that linkage must contain
     * at least one statement to Format correctly in Yang 1.1
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> linkageBodyReplace(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean tmp = false;
        for (String line : lines) {
            if (line.contains("linkage-stmts ::=")) {
                tmp = true;
                line = "linkage-stmts ::= (import-stmt | include-stmt)*";
            }
            result.add(line);
            if (tmp && (line.contains("<<anyOrder  import-stmt*"))) {
                result.remove(result.size() - 1);
            }
            if (tmp && (line.contains("include-stmt*"))) {
                result.remove(result.size() - 1);
            }
            if (tmp && (line.contains(">>"))) {
                result.remove(result.size() - 1);
                result.add("");
                tmp = false;
            }
        }
        return result;
    }

    /**
     * Changing meta statement body in BNF file to define that meta must contain
     * at least one statement to Format correctly and error recovery to be functional.
     * Logic stays the same, statements can appear in any order and duplicities are
     * checked in annotator.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> metaBodyReplace(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean tmp = false;
        for (String line : lines) {
            if (line.contains("meta-stmts ::=")) {
                tmp = true;
            }
            if (tmp && (line.contains("<<anyOrder  [organization-stmt]"))) {
                line = "(meta-body stmtsep)+";
            }
            if (tmp && (line.contains("[contact-stmt]"))) {
                line = "";
            }
            if (tmp && (line.contains("[description-stmt]"))) {
                line = "private meta-body ::=(organization-stmt |";
            }
            if (tmp && (line.contains("[reference-stmt]"))) {
                line = "        contact-stmt |";
            }
            if (tmp && (line.contains(">>"))) {
                line = "        description-stmt |";
                tmp = false;
                result.add(line);
                result.add("        reference-stmt )");
                line = "";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Making meta and linkage stms optional in moduel and submodule stmts
     * due to changes in their definitions to prevent grammar logic changes.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> adjustModuleAndSubmoduleStmt(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.equals("  linkage-stmts")) {
                line = "  [linkage-stmts]";
            }
            if (line.equals("  meta-stmts")) {
                line = "  [meta-stmts]";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Improved check for valid year/month/day. Double-click word selection.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> rewriteDateArg(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("date-arg ::=")) {
                line = "date-arg ::= DATE";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * New tokens added due to double-click word selection bug.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> rewriteIdentifier(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean found = false;
        for (String line : lines) {
            if (found) {
                line = "((string-splitter (or-keyword | and-keyword | not-keyword)?)? (ALPHA | ZEROS | DIGIT | DATE | ALPHANUMERICAL_ALPHA_FIRST | ALPHANUMERICAL_DIGIT_FIRST | FRACTIONS | DIGITS | UNDERSCORE | DASH | DOT))*";
                found = false;
            }
            if (line.contains("identifier ::= (ALPHA | UNDERSCORE)")) {
                line = "identifier ::= (ALPHA | UNDERSCORE | ALPHANUMERICAL_ALPHA_FIRST)";
                found = true;
            }
            result.add(line);
        }
        return result;
    }

    /**
     * New tokens added due to double-click word selection bug.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> rewriteZeroIntegerValue(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("zero-integer-value ::=")) {
                line = "zero-integer-value ::= DIGIT+ | DIGITS | FRACTIONS | ZEROS";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * New tokens added due to double-click word selection bug.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> rewriteIPV4Address(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("IPv4address ::=")) {
                line = "IPv4address ::= IPV4";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * New tokens added due to double-click word selection bug.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> rewriteScheme(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("scheme ::= ALPHA")) {
                line = "scheme ::= ALPHA ( ALPHA | DIGIT | DATE | ALPHANUMERICAL_ALPHA_FIRST | ALPHANUMERICAL_DIGIT_FIRST | FRACTIONS | DIGITS | PLUS_SIGN | DASH | DOT )*";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * New tokens added due to double-click word selection bug.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> rewritePort(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("port ::=")) {
                line = "port ::= DIGIT* | DIGITS | FRACTIONS | ZEROS";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * New tokens added due to double-click word selection bug.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> rewriteUnreserved(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("unreserved ::=")) {
                line = "unreserved ::= ALPHA | DIGIT | DATE | ALPHANUMERICAL_ALPHA_FIRST | ALPHANUMERICAL_DIGIT_FIRST | FRACTIONS | DIGITS | DASH | DOT | UNDERSCORE | TILDE";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Order of tokens sets the priority for lexer when it needs to pick one of the multiple matches.
     * The sooner it occurs in bnf the higher the priority to be matched if multiple tokens can match multiple
     * different characters or strings.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> orderTokensForLexer(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("yang ::=  (module-stmt | submodule-stmt | file-reference | ( WSP | ZERO_LENGTH_STRING | LINEFEED | CARRIAGE_RETURN )*)")) {
                result.add(line);
                result.add("");
                result.add("private tokens ::= BLOCK_COMMENT | ONE | TWO | THREE | FOUR | FIVE | SIX | SEVEN |");
                result.add(" EIGHT | NINE | DATE | FRACTIONS | ZEROS | ESCAPES // do not change the order of tokens !");
                line = "";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * New tokens added due to double-click word selection bug.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> rewriteFractionDigitsArg(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean found = false;
        for (String line : lines) {
            if (line.contains("fraction-digits-arg ::=")) {
                line = "fraction-digits-arg ::= ONE | TWO | THREE | FOUR | FIVE | SIX | SEVEN | EIGHT | NINE | FRACTIONS";
                result.add(line);
                found = true;
            }
            if (line.equals("")) {
                found = false;
            }
            if (!found) {
                result.add(line);
            }
        }
        return result;
    }

    /**
     * New tokens added due to double-click word selection bug.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> rewritePositiveIntegerValue(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("positive-integer-value ::=")) {
                line = "positive-integer-value ::= (non-zero-digit DIGIT*) | FRACTIONS | DIGITS";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Adjust module-header-stmts for error recovery. Logic stays the same,
     * statements can appear in any order and duplicities are checked in annotator.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> rewriteModuleHeaderStmts(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean found = false;
        for (String line : lines) {
            if (found && line.contains("yang-version-stmt")) {
                result.add("(module-header-body stmtsep)+");
                result.add("");
                line = "private module-header-body ::=  (yang-version-stmt |";
            }
            if (found && line.contains("namespace-stmt")) {
                line = "  namespace-stmt  |";
            }
            if (found && line.contains("prefix-stmt")) {
                line = "  prefix-stmt)";
            }
            if (found && line.contains(">>")) {
                line = "";
                found = false;
            }
            if (line.contains("module-header-stmts ::=") && !line.contains("submodule")) {
                found = true;
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Adjust submodule-header-stmts for error recovery. Logic stays the same,
     * statements can appear in any order and duplicities are checked in annotator.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> rewriteSubModuleHeaderStmts(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean found = false;
        for (String line : lines) {
            if (found && line.contains("yang-version-stmt")) {
                result.add("(submodule-header-body stmtsep)+");
                result.add("");
                line = "private submodule-header-body ::=  (yang-version-stmt |";
            }
            if (found && line.contains("belongs-to-stmt")) {
                line = "  belongs-to-stmt)";
            }
            if (found && line.equals(">>")) {
                line = "";
                found = false;
            }
            if (line.contains("submodule-header-stmts ::=")) {
                found = true;
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Switching positions of leaf-list-stmt and leaf-stmt due to error recovery always
     * matching leaf-stmt if it was before leaf-list-stmt.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> rewriteDataDefStmt(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean found = false;
        for (String line : lines) {
            if (line.contains("data-def-stmt ::=") || line.contains("short-case-stmt")) {
                found = true;
            }
            if (found && line.contains("  leaf-stmt |")) {
                line = "  leaf-list-stmt |";
            } else if (found && line.contains("  leaf-list-stmt |")) {
                line = "  leaf-stmt |";
            }
            if (found && line.equals("")) {
                found = false;
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Decomposing body-stmts into sub statements due error recovery.
     * Logic should remain the same only change against RFC 7950 is
     * changing * (0 - infinity) to + (1 - infinity) not allowing empty body.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> rewriteBodyStmts(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean found = false;
        for (String line : lines) {
            if (line.contains("body-stmts ::= (extension-stmt |")) {
                result.add("body-stmts ::= body-sub-stmt*");
                result.add("");
                result.add("private body-sub-stmt ::=body-body-stmts stmtsep");
                result.add("");
                result.add("private body-body-stmts ::=(extension-stmt |");
                result.add("    feature-stmt |");
                result.add("    identity-stmt |");
                result.add("    typedef-stmt |");
                result.add("    grouping-stmt |");
                result.add("    data-def-stmt |");
                result.add("    augment-stmt |");
                result.add("    rpc-stmt |");
                result.add("    notification-stmt |");
                result.add("    deviation-stmt)");
                found = true;
            }
            if (found && line.equals("")) {
                found = false;
            }
            if (!found) {
                result.add(line);
            }
        }
        return result;
    }

    /**
     * Allows quoted-string in unknown statement.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> adjustUnknownStatement(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("unknown-statement ::=")) {
                line = "unknown-statement ::= prefix COLON identifier ([sep] [quoted-string | string]) optsep";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Allows double colon in pchar.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> adjustDoubleColonInPchar(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("pchar ::=")) {
                line = "pchar ::= unreserved | pct-encoded | sub-delims | COLON | AT_SIGN | DOUBLE_COLON";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Allowing version to be 1 or 1.1 instead of only 1.1
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> allowVersionOne(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("yang-version-arg ::=")) {
                line = "yang-version-arg ::= ONE [DOT ONE]";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Adding new pattern-body Statement to pattern-stmt expression in BNF file for separate
     * Regex value expression
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> patternBodyChange(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("pattern-stmt ::= pattern-keyword sep quoted-string optsep")) {
                result.add("pattern-stmt ::= pattern-keyword sep pattern-body");
                result.add("pattern-body ::= quoted-string optsep");
            } else {
                result.add(line);
            }
        }
        return result;
    }

    /**
     * Added token to the definition because it's prioritized to be matched in lexer
     * as it's matching more characters at once.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> adjustRelPathKeyexpr(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("rel-path-keyexpr ::=")) {
                line = "rel-path-keyexpr ::= (DOUBLE_DOT WSP* FORWARD_SLASH WSP* | PARENT_FOLDER)+";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * When a decimal value was used, the integer-value statement was recognized first,
     * and it resulted in an error.
     * By swapping these statements, the decimal-value statement will be recognized first resulting
     * in correctly identifying both decimal-value and integer-value
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> swapDecimalWithIntegerInRangeBoundaryDef(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("integer-value | decimal-value")) {
                line = line.replace("integer-value | decimal-value", "decimal-value | integer-value");
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Overwrite UsesAugmentStmt according to rfc.
     * <p>
     * +--------------+---------+-------------+
     * | substatement | section | cardinality |
     * +--------------+---------+-------------+
     * | augment      | 7.15    | 0..1        |
     * | description  | 7.19.3  | 0..1        |
     * | if-feature   | 7.18.2  | 0..n        |
     * | refine       | 7.12.2  | 0..1        |
     * | reference    | 7.19.4  | 0..1        |
     * | status       | 7.19.2  | 0..1        |
     * | when         | 7.19.5  | 0..1        |
     * +--------------+---------+-------------+
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> rewriteUsesAugmentStmt(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean found = false;
        for (String line : lines) {
            if (line.contains("uses-augment-stmt ::= augment-keyword sep uses-augment-arg-str optsep")) {
                result.add(line);
                result.add("  LEFT_BRACE stmtsep");
                result.add("  // these stmts can appear in any order");
                result.add("<<anyOrder  [when-stmt]");
                result.add("  if-feature-stmt*");
                result.add("  [status-stmt]");
                result.add("  [description-stmt]");
                result.add("  [reference-stmt]");
                result.add("  (data-def-stmt | case-stmt |");
                result.add("  action-stmt | notification-stmt)*>>");
                result.add("  RIGHT_BRACE stmtsep");
                found = true;
            }
            if (found && line.equals("")) {
                found = false;
            }
            if (!found) {
                result.add(line);
            }
        }
        return result;
    }

    /**
     * Making separator rules private. This ensures that a PsiElement is not created in the PsiTree for these.
     * This method is important, because comments would be otherwise a child of node, that is treated
     * as a whitespace. This way the relationship between whitespace elements and comment elements
     * is not parent -> child, but rather sibling <-> sibling
     *
     * @param lines lines of the generated bnf grammar file
     * @return resulting lines of the bnf grammar file
     */
    private static List<String> makeSeparatorRulesPrivate(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("sep ::=") || line.contains("optsep ::=") || line.contains("stmtsep ::=")) {
                line = "private " + line;
            }
            if(line.contains("stmtsep ::=")) {
                line = line.replace("comment", "comment | <<dummyElement>>");
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Adds string-splitter to absolute-node-id (so it can start and end with / when it is multi lined),
     * absolute-path, relative-path, descendant-path, path expressions and segments. It makes multi lined paths possible.
     *
     * @param lines lines of the generated bnf grammar file
     * @return resulting lines of the bnf grammar file
     */
    private static List<String> addStringSplitterForPaths(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("absolute-schema-nodeid ::=")) {
                line = "absolute-schema-nodeid ::= (FORWARD_SLASH string-splitter? node-identifier string-splitter?)+";
            }
            if (line.contains("absolute-path ::=")) {
                line = "absolute-path ::= (FORWARD_SLASH string-splitter? (node-identifier string-splitter? path-predicate*) string-splitter?)+";
            }
            if (line.contains("relative-path ::=")) {
                line = "relative-path ::= (DOUBLE_DOT string-splitter? WSP* FORWARD_SLASH WSP* | PARENT_FOLDER string-splitter?)+ descendant-path";
            }
            if (line.contains("descendant-path ::=")) {
                line = "descendant-path ::= node-identifier string-splitter?";
            }
            if (line.contains("path-predicate ::=")) {
                line = "path-predicate ::= OPEN_BRACKET WSP* path-equality-expr WSP* CLOSED_BRACKET string-splitter?";
            }
            if (line.contains("path-equality-expr ::=")) {
                line = "path-equality-expr ::= node-identifier string-splitter? WSP* EQUALS WSP* string-splitter? path-key-expr";
            }
            if (line.contains("path-key-expr ::=")) {
                line = "path-key-expr ::= current-function-invocation string-splitter? WSP* FORWARD_SLASH WSP*";
            }
            if (line.contains("rel-path-keyexpr ::=")) {
                line = "rel-path-keyexpr ::= (string-splitter? DOUBLE_DOT string-splitter? WSP* FORWARD_SLASH WSP* string-splitter? | string-splitter? PARENT_FOLDER string-splitter?)+";
            }
            if (line.contains("(node-identifier WSP* FORWARD_SLASH WSP*)*")) {
                line = "  (node-identifier string-splitter? WSP* FORWARD_SLASH WSP* string-splitter?)*";
            }
            if (line.contains("segment ::=") || line.contains("segment-nz ::=")) {
                line = line.replace("pchar", "(string-splitter? pchar string-splitter?)");
            }
            if (line.contains("segment-nz-nc ::=")) {
                line = "segment-nz-nc ::= (string-splitter? ( unreserved | pct-encoded | sub-delims | AT_SIGN ) string-splitter?)+";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Allows certain strings to start with an indent on a new line
     *
     * @param lines lines of the generated bnf grammar file
     * @return resulting lines of the bnf grammar file
     */
    private static List<String> allowIndentString(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if ((line.contains("contact-stmt ::=") && line.contains("( quoted-string | string )"))
                    || (line.contains("description-stmt ::= ") && line.contains("( quoted-string | string )"))
                    || (line.contains("reference-stmt ::= ") && line.contains("( quoted-string | string )"))
                    || (line.contains("organization-stmt ::= ") && line.contains("( quoted-string | string )"))) {
                line = line.replace("( quoted-string | string )", "indentable-string");
            }
            result.add(line);
        }
        result.add("");
        result.add("indentable-string ::= ( quoted-string | string )");
        return result;
    }

    /**
     * Adds WSP | ZERO_LENGTH_STRING | LINEFEED | CARRIAGE_RETURN against empty yang error.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> rewriteYangInitialization(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("yang ::=  (module-stmt | submodule-stmt)")) {
                line = "yang ::=  (module-stmt | submodule-stmt | file-reference | ( WSP | ZERO_LENGTH_STRING | LINEFEED | CARRIAGE_RETURN )*)";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Adds string-splitters to if-feature statements.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> addStringSplittersForIfFeatures(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("[sep or-keyword sep if-feature-expr]")) {
                line = line.replaceAll("sep", "(string-splitter|sep)");
            }
            if (line.contains("[sep and-keyword sep if-feature-term]")) {
                line = line.replaceAll("sep", "(string-splitter|sep)");
            }
            if (line.contains("if-feature-factor ::=")) {
                line = line.replaceAll("sep", "(string-splitter|sep)");
                line = line.replace("not-keyword", "string-splitter? not-keyword");
            }
            if (line.contains("LEFT_PARENTHESIS optsep if-feature-expr optsep RIGHT_PARENTHESIS |")) {
                line = line.replace("LEFT_PARENTHESIS", "string-splitter? LEFT_PARENTHESIS");
                line = line.replace("if-feature-expr", "string-splitter? if-feature-expr string-splitter?");
            }
            if (line.equals("  identifier-ref-arg")) {
                line = line.replace("identifier-ref-arg", "string-splitter? identifier-ref-arg");
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Changes import and include string arguments, so they can be referenced.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> allowReferenceLinkage(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("import-stmt ::=") || line.contains("include-stmt ::=")) {
                line = line.replace("identifier-arg-str", "identifier-ref-arg-str");
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Adds single quote possibility to identifier-ref-arg-str and identifier-arg-str.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> addSingleQuotePossibility(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("identifier-ref-arg-str ::= identifier-ref-arg | DOUBLE_QUOTE identifier-ref-arg DOUBLE_QUOTE")) {
                line = "identifier-ref-arg-str ::= identifier-ref-arg | DQUOTE identifier-ref-arg DQUOTE | SQUOTE identifier-ref-arg SQUOTE";
            }
            if (line.contains("identifier-arg-str ::= identifier-arg | DOUBLE_QUOTE identifier-arg DOUBLE_QUOTE")) {
                line = "identifier-arg-str ::= identifier-arg | DQUOTE identifier-arg DQUOTE | SQUOTE identifier-arg SQUOTE";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Changes quantifiers of augment's substatments according to cardinality in table in rfc6020 - 7.15.1.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> rewriteAugment(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean found = false;
        for (String line : lines) {
            if (line.contains("augment-stmt ::= augment-keyword sep augment-arg-str optsep")) {
                result.add(line);
                result.add("  LEFT_BRACE stmtsep");
                result.add("  // these stmts can appear in any order");
                result.add("<<anyOrder  [when-stmt]");
                result.add("  [status-stmt]");
                result.add("  [description-stmt]");
                result.add("  [reference-stmt]");
                result.add("  (data-def-stmt | case-stmt |");
                result.add("  action-stmt | notification-stmt |");
                result.add("  if-feature-stmt)*>>");
                result.add("  RIGHT_BRACE stmtsep");
                found = true;
            }
            if (found && line.equals("")) {
                found = false;
            }
            if (!found) {
                result.add(line);
            }
        }
        return result;
    }

    /**
     * Changes cardinality of data-def-stmt for input and output statements based on the RFC statements description table.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> changeInputOutputCardinality(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean found = false;
        for (String line : lines) {
            if (line.contains("output-stmt ::=") || line.contains("input-stmt ::=")) {
                found = true;
            }
            if (found && line.contains("data-def-stmt")) {
                line = "  data-def-stmt*>>";
                found = false;
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Swap first two statements in type-body-stmts because numerical-restrictions
     * can have only range-stmt inside, but when there is fraction-digits stmt after range-stmt,
     * it doesn't recognize it as a decimal64-restriction.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> changeOrderOfTypeBodyStmt(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean found = false;
        for (String line : lines) {
            if (line.contains("type-body-stmts ::=")) {
                found = true;
                line = "type-body-stmts ::= decimal64-specification |";
            } else if (found && line.contains("decimal64-specification")) {
                found = false;
                line = "  numerical-restrictions |";
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Changed list-stmt according to cardinality in rfc
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> changeListCardinality(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean found = false;
        for (String line : lines) {
            if (line.contains("list-stmt ::=")) {
                found = true;
            }
            if (found && line.contains("data-def-stmt+")) {
                line = "  data-def-stmt*";
                found = false;
            }
            result.add(line);
        }
        return result;
    }
}
