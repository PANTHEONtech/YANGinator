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

import com.google.common.io.BaseEncoding;
import tech.pantheon.yanginator.parser.types.BnfTokenType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GrammarKitRFCUtils {

    private static final BnfTokenType PIPE = new BnfTokenType("|", "PIPE");
    private static final String BNFEqual = "::=";
    private static final String ABNF_COMMENT_START = ";;";
    private static final Pattern ASTERISK_MULTIPLIER_PATTERN = Pattern.compile("(?<oldOperatorGroup>\\*\\()");
    private static final Pattern DIGIT_ASTERISK_MULTIPLIER_PATTERN = Pattern.compile("(?<oldOperatorGroup>1\\*\\()");
    private static final Pattern WORD_MULTIPLIER_ASTERISK = Pattern.compile(".*(?<wordSelect>\\*[\\w\\-]+).*");
    private static final Pattern WORD_MULTIPLIER_DIGIT_ASTERISK = Pattern.compile(".*(?<wordSelect>1\\*[\\w\\-]+).*");
    private static final Pattern STRING_RULE_PATTERN = Pattern.compile(".*(?<statementStart>(<[\\s+\\w].*))$");
    private static final Pattern HEXADECIMAL_PATTERN = Pattern.compile("(?<hexadecimal>(%x\\d{1,2}\\w))");
    private static final Pattern HEXADECIMAL_RANGE_PATTERN = Pattern.compile("(?<hexadecimalRange>(%x\\d{1,2}\\w-\\d{1,2}\\w))");
    private static final Map<String, String> SPECIAL_CHARACTER = Map.of(
            "%x0D", "\"\\r\"",
            "%x09", "\"\\t\"",
            "%x0A", "\"\\n\"",
            "%x22", "\"\\\"\"",
            "%x5C", "\\");

    /**
     * Replaces each occurrence of an abnfTokens in provided list with a bnfTokens.
     * Gathers one or more calls for {@link #replaceBnfToken} method.
     *
     * @param lines the list of strings in which token will be replaced.
     * @return the list of strings in which abnfTokens were replaced by bnfTokens.
     */
    public static List<String> replaceAllAbnfTokens(final List<String> lines) {
        List<String> result;
        result = replaceBnfToken(lines, "=", BNFEqual);
        result = replaceBnfToken(result, "/", PIPE.getCharacterValue());
        result = replaceBnfToken(result, ABNF_COMMENT_START, "//");
        result = replaceBnfToken(result, " ; ", "// ");

        return result;
    }

    /**
     * Replaces each occurrence of an abnfToken in provided list with a bnfToken.
     *
     * @param lines     the list of strings in which token will be replaced.
     * @param abnfToken the character to be replaced.
     * @param bnfToken  the replacement.
     * @return the list of strings in which abnfTokens were replaced by bnfTokens.
     */
    private static List<String> replaceBnfToken(final List<String> lines, final String abnfToken, final String bnfToken) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("\"" + abnfToken + "\"")) {
                line = line.replaceAll(" " + abnfToken, " " + bnfToken);
            } else {
                line = line.replaceAll(abnfToken, bnfToken);
            }
            result.add(line);
        }

        return result;
    }

    /**
     * Returns a list of strings with all leading, trailing and inner line whitespaces
     * replaced so that the returned list if formatted accordingly to .bnf convention.
     *
     * @param lines the list of strings in which excess whitespaces will be removed.
     * @return the list of strings with excess whitespaces removed.
     */
    public static List<String> deleteWhitespaces(final List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains(BNFEqual)) {
                result.add(line.replaceAll("\\s{2,}", " "));
            } else {
                result.add(line.replaceAll("\\s{2,}", "  "));
            }
        }

        return result;
    }

    /**
     * Removes each occurrence of abnf operator (for example "*" or "1*") placed in front of
     * parentheses "*(...)" or brackets "1*[...]" using {@link #removeOperator}.
     * After removal, bnf operator is added to correct position using {@link #addOperator}
     * accordingly to the structure of given bnf rule.
     *
     * @param lines       the list of strings in which operator will be replaced.
     * @param oldOperator abnf operator which will be replaced.
     * @param replacement bnf operator used as a replacement for abnf operator.
     * @return the list of strings in which abnf operator was removed and bnf operator is used instead.
     */
    public static List<String> trimAndAppendOperator(final List<String> lines, final String oldOperator, final String replacement) {
        Pattern multiplierRegex = null;
        if (oldOperator.equals("*")) {
            multiplierRegex = ASTERISK_MULTIPLIER_PATTERN;
        } else if (oldOperator.equals("1*")) {
            multiplierRegex = DIGIT_ASTERISK_MULTIPLIER_PATTERN;
        }

        String concatenatedLines = String.join("\n", lines);
        Matcher matcher = Objects.requireNonNull(multiplierRegex).matcher(concatenatedLines);
        int newOperatorIndex;
        int oldOperatorIndex;
        while (matcher.find()) {
            String originalOperator = matcher.group("oldOperatorGroup");
            oldOperatorIndex = matcher.start("oldOperatorGroup");
            int stringCrawler = oldOperatorIndex;
            int openingParentheses = 0;
            int closingParentheses = 0;
            int parenthesesDiff = -1;
            while (parenthesesDiff != 0) {
                stringCrawler++;
                if (stringCrawler > concatenatedLines.length()) {
                    break;
                }

                if (concatenatedLines.charAt(stringCrawler) == '(') {
                    openingParentheses++;
                } else if (concatenatedLines.charAt(stringCrawler) == (')') && openingParentheses != 0) {
                    closingParentheses++;
                    newOperatorIndex = stringCrawler;
                    parenthesesDiff = openingParentheses - closingParentheses;
                    if (parenthesesDiff == 0) {
                        concatenatedLines = addOperator(concatenatedLines, replacement, newOperatorIndex);
                        concatenatedLines = removeOperator(concatenatedLines, originalOperator, oldOperatorIndex);
                        stringCrawler = oldOperatorIndex;
                    }
                }
            }
            matcher = multiplierRegex.matcher(concatenatedLines);
        }

        return List.of(concatenatedLines.split("\n"));
    }

    /**
     * Removes the operator at specified position in provided string.
     *
     * @param line     the string in which an operator will be deleted.
     * @param operator the operator to delete.
     * @param position the beginning index of operator, inclusive.
     * @return the string in which specified operator is deleted from given position.
     */
    private static String removeOperator(String line, String operator, int position) {
        StringBuilder sb = new StringBuilder(line);
        sb.delete(position, position + operator.length() - 1);
        return sb.toString();
    }

    /**
     * Adds the operator at specified position in provided string.
     *
     * @param line     the line to which an operator is added.
     * @param operator the operator to add.
     * @param position the index to which the operator is added.
     * @return the string in which specified operator is added to given position.
     */
    private static String addOperator(String line, String operator, int position) {
        StringBuilder sb = new StringBuilder(line);
        sb.insert(position + 1, operator);
        return sb.toString();
    }

    /**
     * Removes each occurrence of abnf operator (for example "*" or "1*") placed in front of
     * a string (for example "*WSP", "1*DIGIT") using {@link #removeOperator}.
     * After removal, bnf operator is added to correct position using {@link #addOperator}
     * accordingly to the structure of given bnf rule.
     *
     * @param lines       the list of strings in which operator will be replaced.
     * @param oldOperator abnf operator which will be replaced.
     * @return the list of strings in which abnf operator was removed and bnf operator is used instead.
     */
    public static List<String> replaceAsterWord(final List<String> lines, String oldOperator) {
        Pattern asteriskRegex = null;
        String replacement = "";
        if (oldOperator.equals("*")) {
            asteriskRegex = WORD_MULTIPLIER_ASTERISK;
            replacement = "*";
        } else if (oldOperator.equals("1*")) {
            asteriskRegex = WORD_MULTIPLIER_DIGIT_ASTERISK;
            replacement = "+";
        }

        List<String> result = new ArrayList<>();
        for (String line : lines) {
            Matcher matcher = Objects.requireNonNull(asteriskRegex).matcher(line.trim());
            while (matcher.matches()) {
                String oldWord = matcher.group("wordSelect");
                String newWord = oldWord.replace(oldOperator, "");
                newWord = newWord.concat(replacement);
                line = line.replace(oldWord, newWord);
                matcher = asteriskRegex.matcher(line.trim());
            }
            result.add(line);
        }

        return result;
    }

    /**
     * Returns a list of string in which string rules are modified. Each string rule
     * in provided list contains commentaries enclosed in angle brackets ("<...>").
     * These commentaries are replaced by actual rules.
     *
     * @param lines the list of strings in which string rules are to be replaced.
     * @return the list of strings with string rules replaced.
     */
    public static List<String> rewriteStringRules(final List<String> lines) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String firstLineOfRule = lines.get(i);
            Matcher matcher = STRING_RULE_PATTERN.matcher(firstLineOfRule.trim());
            if (matcher.matches()) {
                String originalString = matcher.group("statementStart");
                String quotes = "\"\\\"\"";
                String secondLineOfRule = lines.get(i + 1);
                if (secondLineOfRule.contains("-arg")) {
                    secondLineOfRule = secondLineOfRule.trim().replace(">", quotes);
                    String replacement = "";
                    firstLineOfRule = firstLineOfRule.replace(originalString, replacement.concat(quotes).concat(" " + secondLineOfRule));
                } else {
                    firstLineOfRule = firstLineOfRule
                            .replace("<", "//")
                            .concat(" " + secondLineOfRule.trim())
                            .replace(">", "");
                }
                i++;
            }
            result.add(firstLineOfRule);
        }

        return result;
    }

    /**
     * Replaces each occurrence of a hexadecimal range of values with corresponding characters.
     *
     * @param lines the list of strings in which range of hexadecimal values will be replaced.
     * @return the list of strings in which range of hexadecimal values are replaced by characters.
     */
    public static List<String> replaceHexadecimalRange(List<String> lines) {
        List<String> result = new ArrayList<>();

        for (String line : lines) {
            Matcher matcher = HEXADECIMAL_RANGE_PATTERN.matcher(line.trim());
            while (matcher.find()) {
                String originalHexDef = matcher.group("hexadecimalRange").trim();
                String originalHexDefWithZero = originalHexDef.trim().replaceAll("%", "0");
                String hexLowerBoundaryString = originalHexDefWithZero.substring(0, 4);
                int hexLowerBoundary = Integer.decode(hexLowerBoundaryString);
                int hexUpperBoundary = Integer.parseInt(originalHexDefWithZero.substring(5), 16);
                int hex = hexLowerBoundary;
                StringBuilder replacement = new StringBuilder();
                while (hex <= hexUpperBoundary) {
                    if (hex == 34 || hex == 92) {
                        replacement.append("'").append((char) hex).append("' |");
                    } else {
                        replacement.append(" \"").append((char) hex).append("\" |");
                    }
                    hex++;
                }
                replacement = new StringBuilder(replacement.substring(0, replacement.length() - 2));
                line = line.replace(originalHexDef, replacement.toString());

            }
            result.add(line);
        }

        return result;
    }

    /**
     * Replaces each occurrence of single hexadecimal value with corresponding character.
     *
     * @param lines the list of strings in which hexadecimal values will be replaced.
     * @return the list of strings in which hexadecimal values are replaced by characters.
     */
    public static List<String> replaceHexadecimal(List<String> lines) {
        List<String> result = new ArrayList<>();

        for (String line : lines) {
            Matcher matcher = HEXADECIMAL_PATTERN.matcher(line.trim());
            while (matcher.find()) {
                String originalHexDef = matcher.group("hexadecimal").trim();
                if (isSpecialCharacter(originalHexDef)) {
                    String replacement = transformSpecialChars(originalHexDef);
                    line = line.replace(originalHexDef, replacement);
                } else {
                    String hex = originalHexDef.substring(2).toLowerCase();
                    if (hex.length() == 2) {
                        String replacement = new String(BaseEncoding.base16().lowerCase().decode(hex));
                        line = line.replace(originalHexDef, "\"" + replacement + "\"");
                    }
                }
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Returns {@code true} if the string is hexadecimal representation
     * of: '\r', '\t', '\n', '"', or '\'.
     *
     * @param originalHexDef the string with hexadecimal value
     * @return {@code true} if given string equals to specified hexadecimal values, {@code false} otherwise
     */
    private static boolean isSpecialCharacter(final String originalHexDef) {
        return SPECIAL_CHARACTER.containsKey(originalHexDef);
    }

    /**
     * Transforms hexadecimal value of given string into its string representation
     * if the string is equal to: '\r', '\t', '\n', '"', or '\'.
     *
     * @param originalHexDef the string with hexadecimal value
     * @return the string representation of given hexadecimal value
     */
    private static String transformSpecialChars(final String originalHexDef) {
        return SPECIAL_CHARACTER.get(originalHexDef);
    }
}
