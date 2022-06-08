/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
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
        result = splitDeviationStmt(result);
        result = removeOptional(result);
        result = subDelimsAdjustment(result);
        additionalRules(result);
        result = quotedAugmentArg(result);
        result = quotedPath(result);
        result = quotedStringSplitter(result);
        result = revisionComment(result);
        result = revisionReplace(result);
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
        result = revisionComment(result);
        result = revisionReplace(result);
        result = adjustModuleAndSubmoduleStmt(result);
        return allowComments(result);
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
                "pattern-stmt ::=", "must-stmt ::="));
        for (String line : lines) {
            for (String stmt : stmts) {
                if (line.contains(stmt)) {
                    line = line.replace("string", "( quoted-string | string )");
                }
                if (line.contains("quoted-string ::=")) {
                    line = line.replace(" string", " quoted-vchar");
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
        lines.add("string-splitter ::= (SQUOTE optsep PLUS_SIGN optsep SQUOTE) | (DQUOTE optsep PLUS_SIGN optsep DQUOTE)");
        lines.add("");
        lines.add("quoted-path-arg ::= (DQUOTE path-arg (string-splitter path-arg)* DQUOTE) | (SQUOTE path-arg (string-splitter path-arg)* SQUOTE)");
        lines.add("");
        lines.add("quoted-vchar ::= (VCHAR | SEMICOLON | LEFT_BRACE | RIGHT_BRACE | TAB | LINEFEED sep | LINEFEED | CARRIAGE_RETURN)*");
        lines.add("");
        lines.add("VCHAR ::= (DATE | FRACTIONS | ZEROS | ALPHANUMERICAL_ALPHA_FIRST | ALPHANUMERICAL_DIGIT_FIRST | IPV4 | DIGITS | CHARS | APOSTROPHE | SPACE | EXCLAMATION_MARK | HASH | DOLLAR_SIGN | PERCENT_SIGN | AMPERSAND | SINGLE_QUOTE | LEFT_PARENTHESIS | RIGHT_PARENTHESIS | ASTERISK | PLUS_SIGN | COMMA | DASH | DOT | FORWARD_SLASH | DOUBLE_FORWARD_SLASH | ZERO | ONE | TWO | THREE | FOUR | FIVE | SIX | SEVEN | EIGHT | NINE | COLON |  LESS_THAN_SIGN | EQUALS | GREATER_THAN_SIGN | QUESTION_MARK | AT_SIGN | ALPHA | OPEN_BRACKET | BACK_SLASH | CLOSED_BRACKET | CIRCUMFLEX_ACCENT | UNDERSCORE | GRAVE_ACCENT | PIPE | TILDE | DOUBLE_DOT | DOUBLE_COLON | PARENT_FOLDER )");
    }

    /**
     * Path can be quoted according to validators.
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> quotedPath(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("path-arg-str ::=")) {
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
                line = "augment-arg-str ::= augment-arg | (DQUOTE augment-arg (string-splitter augment-arg)* DQUOTE)";
            }
            result.add(line);
        }
        return result;
    }

    private static List<String> quotedStringSplitter(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("quoted-string ::=")) {
                line = "quoted-string ::= (DQUOTE quoted-vchar (string-splitter quoted-vchar)* DQUOTE) | (SQUOTE quoted-vchar (string-splitter quoted-vchar)* SQUOTE)";
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
            result.add(line);
        }
        result.add("");
        result.add("comment ::= BLOCK_COMMENT | (DOUBLE_FORWARD_SLASH string )");
        return result;
    }

    /**
     * Comment revision statement to make revision optional
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> revisionComment(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("revision-stmts ::=")) {
                line = "//" + line;
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Changing revision statement in module and submodule to make revision optional
     * and Format correctly in Yang 1.1
     *
     * @param lines list of strings
     * @return list of strings
     */
    private static List<String> revisionReplace(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean tmp = false;
        for (String line : lines) {
            if (line.contains("module-stmt ::=") || line.contains("submodule-stmt ::=")) {
                tmp = true;
            }
            if (tmp && line.contains("revision-stmts")) {
                line = "  revision-stmt*";
                tmp = false;
            }
            result.add(line);
        }
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
                line = "linkage-stmts ::= (import-stmt | include-stmt)+ ";
            }
            if (tmp && (line.contains("<<anyOrder  import-stmt*"))) {
                line = " ";
            }
            if (tmp && (line.contains("include-stmt*"))) {
                line = " ";
            }
            if (tmp && (line.contains(">>"))) {
                line = " ";
                tmp = false;
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Changing meta statement body in BNF file to define that meta must contain
     * at least one statement to Format correctly in Yang 1.1
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
                line = "(organization-stmt |";
            }
            if (tmp && (line.contains("[contact-stmt]"))) {
                line = "   contact-stmt |";
            }
            if (tmp && (line.contains("[description-stmt]"))) {
                line = "  description-stmt |";
            }
            if (tmp && (line.contains("[reference-stmt]"))) {
                line = "  reference-stmt )+";
            }
            if (tmp && (line.contains(">>"))) {
                line = " ";
                tmp = false;
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
                line = "(ALPHA | DIGIT | DATE | ALPHANUMERICAL_ALPHA_FIRST | ALPHANUMERICAL_DIGIT_FIRST | FRACTIONS | DIGITS | UNDERSCORE | DASH | DOT)*";
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
            if (line.contains("yang ::=  (module-stmt | submodule-stmt)")) {
                result.add(line);
                result.add("");
                result.add("private tokens ::= BLOCK_COMMENT | ONE | TWO | THREE | FOUR | FIVE | SIX | SEVEN |");
                result.add(" EIGHT | NINE | DATE | FRACTIONS | ZEROS // do not change the order of tokens !");
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
}