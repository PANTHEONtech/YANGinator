/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */
package tech.pantheon.yanginator.parser.services;

import com.google.common.io.BaseEncoding;
import tech.pantheon.yanginator.parser.generator.FlexerToken;
import tech.pantheon.yanginator.parser.types.BnfTokenType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    private static final Pattern BRACKETS_UNQUOTED_PATTERN = Pattern.compile("[^\\\"](\\(|\\[|\\)|\\])|(\\(|\\[|\\)|\\])[^\\\"]");
    private static final Pattern BRACKETS_WITH_WHITESPACES = Pattern.compile(" (\\(|\\[|\\)|\\]) ");
    private static final Pattern LEXER_TOKENS_PATTERN = Pattern.compile("\\{[a-z]+[\\_]*[a-z]*(.[^\\}])*\\}");
    private static final Pattern MULTIPLIER_N_TO_M_TIMES = Pattern.compile("(?<doubleBoundedMultiplier>\\d\\*\\d[a-zA-Z]{1,})");
    public static final Pattern MULTIPLIER_ZERO_TO_N_TIMES = Pattern.compile("(?<nTimesMultiplier>\\*\\d\\(.*?\\))");
    public static final Pattern MULTIPLIER_N_TIMES_PARENTHESES = Pattern.compile("(?<nTimesMultiplier>(\\s[2-9]\\(.*?\\)))");
    public static final Pattern MULTIPLIER_N_TIMES_WORD = Pattern.compile("(?<nTimesMultiplier>\\s\\d[a-zA-Z]{1,})");
    private static final String LINE_DELIMITER = "%%%#@@#";
    private static final Map<String, String> SPECIAL_CHARACTER = Map.of(
            "%x0D", "\"\\r\"",
            "%x09", "\"\\t\"",
            "%x0A", "\"\\n\"",
            "%x22", "'\"'",
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
        result = replaceBnfToken(result, "%s", "");

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
            if (line.contains("\"" + abnfToken + "\"") || line.contains("\".." + abnfToken + "\"") || line.contains("\"" + abnfToken + abnfToken + "\"")) {
                line = line.replaceAll(" " + abnfToken, " " + bnfToken);
            } else {
                line = line.replaceAll(abnfToken, bnfToken);

            }
            result.add(line.stripTrailing());
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

        return Stream.of(concatenatedLines.split("\n")).map(String::stripTrailing).collect(Collectors.toList());
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
            result.add(line.stripTrailing());
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
                    String replacement = "";
                    if (secondLineOfRule.contains("<")) {
                        secondLineOfRule = secondLineOfRule.trim().replace("<", replacement);
                    }
                    secondLineOfRule = secondLineOfRule.trim().replace(">", quotes);
                    firstLineOfRule = firstLineOfRule.replace(originalString, replacement.concat(quotes).concat(" " + secondLineOfRule));
                } else {
                    firstLineOfRule = firstLineOfRule
                            .replace("<", "//")
                            .concat(" " + secondLineOfRule.trim())
                            .replace(">", "");
                }
                i++;
            }
            result.add(firstLineOfRule.stripTrailing());
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
                replacement.append("(");
                while (hex <= hexUpperBoundary) {
                    if (hex == 34 || hex == 92) {
                        replacement.append(" '").append((char) hex).append("' |");
                    } else {
                        replacement.append(" \"").append((char) hex).append("\" |");
                    }
                    hex++;
                }

                replacement = new StringBuilder(replacement.substring(0, replacement.length() - 2));
                replacement.append(" )");
                line = line.replace(originalHexDef, replacement.toString());

            }
            result.add(line.stripTrailing());
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
            result.add(line.stripTrailing());
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

    /**
     * Replaces each occurrence of a multiplier specifying min and max number of token repetition
     * inside a rule. Multiplier together with token will be replaced by expanded rule.
     *
     * @param lines the list of strings in which multiplied tokens will be expanded.
     * @return the list of strings in which multiplied tokens are expanded.
     */
    public static List<String> rewriteNtoMMultiplier(final List<String> lines) {
        List<String> result = new ArrayList<>();

        for (String line : lines) {
            Matcher matcher = MULTIPLIER_N_TO_M_TIMES.matcher(line.trim());
            if (matcher.find()) {
                String oldRule = matcher.group("doubleBoundedMultiplier").trim();
                int lowerBound = Integer.parseInt(String.valueOf(oldRule.charAt(0)));
                int upperBound = Integer.parseInt(String.valueOf(oldRule.charAt(2)));
                String ruleExcerptToRepeat = oldRule.substring(3);
                String newRule = "";
                while (lowerBound <= upperBound) {
                    for (int i = 1; i <= lowerBound; i++) {
                        if (i == 1) {
                            newRule = newRule.concat("(" + ruleExcerptToRepeat);
                        } else {
                            newRule = newRule.concat(" " + ruleExcerptToRepeat);
                        }

                        if ((i == lowerBound) && (lowerBound != upperBound)) {
                            newRule = newRule.concat(") | ");
                        }
                    }
                    lowerBound++;
                }
                newRule = newRule.concat(")");
                line = line.replace(oldRule, newRule);
            }
            result.add(line.stripTrailing());
        }

        return result;
    }

    private static String extractDefinition(String line) {
        return line.contains("::=") ? line.substring(line.indexOf("=") + 1) : line;
    }

    /**
     * Finds each occurrence of abnf simple-digit and zeto-to-N multiplier placed in front of
     * parentheses "3( h16 ":" )", "*3( h16 ":" )" or word "4DIGIT". Then, tokens in direct contact with
     * multiplier are expanded - written down as many times as the multiplier is saying.
     *
     * @param lines the list of strings in which multiplied tokens will be expanded.
     * @return the list of strings in which multiplied tokens are expanded.
     */
    public static List<String> rewriteDigitMultiplier(final List<String> lines, final Pattern typeOfToken) {
        List<String> result = new ArrayList<>();

        for (String line : lines) {
            Matcher matcher = typeOfToken.matcher(line.trim());
            while (matcher.find()) {
                String replacement = "";
                String originalString = matcher.group("nTimesMultiplier");
                String tokenToRepeat = originalString.substring(2);
                int multiplier = Integer.parseInt(String.valueOf(originalString.charAt(1)));
                if (typeOfToken.equals(MULTIPLIER_ZERO_TO_N_TIMES)) {
                    tokenToRepeat = tokenToRepeat
                            .replace(tokenToRepeat.charAt(0), '[')
                            .replace(tokenToRepeat.charAt(tokenToRepeat.length() - 1), ']');
                } else {
                    tokenToRepeat = " " + tokenToRepeat;
                }
                while (multiplier > 0) {
                    replacement = replacement.concat(tokenToRepeat);
                    multiplier--;
                }
                line = line.replace(originalString, replacement);
            }
            result.add(line.stripTrailing());
        }

        return result;
    }

    /**
     * Checks every String in the list if it contains substrings that need to be replaced
     * and replace them. It does not remove duplicates.
     *
     * @param lines  list of strings in which the words need to be replaced
     * @param tokens map containing strings that need to be replaced (key) and their replacements (value)
     * @return list of strings with replaced values
     */
    public static List<String> replaceTokens(List<String> lines, List<FlexerToken> tokens) {
        for (FlexerToken token : tokens) {
            if (!token.isLexerOnly()) {
                for (String value : token.getValues()) {
                    for (String line :
                            lines) {
                        String replacedLine = line.replace(value, token.getName());
                        lines.set(lines.indexOf(line), replacedLine);

                    }
                }
            }
        }
        return lines;
    }

    /**
     * Multiple changes added into the bnf grammar defined by its comments
     *
     * @param lines list of strings
     * @return list of strings
     */
    public static List<String> correctChanges(List<String> lines) {
        List<String> replacement = replaceWords(lines, "LETTER", null, "ALPHA");
        replacement = correctYangChar(replacement);
        replacement = commentDeprecatedDefinition(replacement, "ALPHA ::="); // alpha definition was replaced
        replacement = commentRules(replacement, "a string that matches the rule", "<");
        replacement = commentRules(replacement, "an unquoted string as returned by the scanner", "<");
        return xmlStartFor6020(replacement, "An identifier MUST NOT start with (('X'|'x') ('M'|'m') ('L'|'l'))");

    }

    /**
     * Checks every String in the list, if it contains @deprecatedDefinition it's put behind
     * two forward slashes.
     *
     * @param lines                list of strings containing the definition
     * @param deprecatedDefinition exact name of definition (including ::= at the end of it)
     * @return list of string with commented deprecated definition
     */
    private static List<String> commentDeprecatedDefinition(List<String> lines, String deprecatedDefinition) {
        List<String> result = new ArrayList<>();
        boolean found = false;
        for (String line : lines) {
            if (line.contains("::=")) {
                found = false;
            }
            if (line.contains(deprecatedDefinition)) {
                found = true;
            }
            if (found && !line.isBlank()) {
                line = "// " + line;
            }
            result.add(line);
        }
        return result;
    }


    /**
     * Method checks every line for special combination given as <code>wordToBeReplaced</code>, if the combination is found
     * and differs from @notIncludedCombination it's replaced by the <code>replacement</code>.
     *
     * @param lines               list of strings where the combination needs to be replaced
     * @param wordToBeReplaced    combination of tokens that needs to be replaced
     * @param excludedCombination combination that differs from the one that needs to be replaced but might be similar / null if there is no similar combination in bnf
     * @param replacement         replacement for the combination
     * @return list of strings with replaced combinations
     */
    public static List<String> replaceWords(List<String> lines, String wordToBeReplaced, String excludedCombination, String replacement) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains(" ::=")) {
                String mergedLine = line + LINE_DELIMITER;
                int i = 1;
                while (lines.indexOf(line) + i <= lines.size() - 1 && !lines.get(lines.indexOf(line) + i).contains("::=")) {
                    mergedLine += lines.get(lines.indexOf(line) + i) + LINE_DELIMITER; // merging multiple-lined definitions into 1 string
                    i++;
                }
                boolean emptyLine = false;
                if (lines.indexOf(line) + i - 1 < lines.size() && lines.get(lines.indexOf(line) + i - 1).isEmpty()) {
                    emptyLine = true;
                }
                Matcher matcher = BRACKETS_UNQUOTED_PATTERN.matcher(mergedLine);
                int index = 0;
                while (matcher.find()) { // adding whitespace before and after (,),[,] that are not double quoted
                    int startIndex = matcher.start();
                    if (matcher.group(1) != null) {
                        if (mergedLine.charAt(matcher.start() + index) != matcher.group(1).charAt(0)) {
                            startIndex = matcher.start() + 1;
                        }
                        mergedLine = mergedLine.substring(0, startIndex + index) + " " + matcher.group(1) + " " + mergedLine.substring(startIndex + index + 1);
                    } else if (matcher.group(2) != null) {
                        if (mergedLine.charAt(matcher.start() + index) != matcher.group(2).charAt(0)) {
                            startIndex = matcher.start() + 1;
                        }
                        mergedLine = mergedLine.substring(0, startIndex + index) + " " + matcher.group(2) + " " + mergedLine.substring(startIndex + index + 1);
                    }

                    index += 2;
                }
                if (excludedCombination != null) {
                    while (mergedLine.replace(LINE_DELIMITER, "").replace(" ", "").contains(wordToBeReplaced.replace(" ", ""))
                            && !mergedLine.replace(LINE_DELIMITER, "").replace(" ", "").contains(excludedCombination.replace(" ", ""))) {
                        mergedLine = uniqueCombination(mergedLine, wordToBeReplaced, replacement);
                        mergedLine = findDuplicates(mergedLine, replacement, replacement);

                    }
                } else if (mergedLine.replace(LINE_DELIMITER, "").replace(" ", "").contains(wordToBeReplaced.replace(" ", ""))) {
                    mergedLine = findDuplicates(mergedLine, wordToBeReplaced, replacement);
                }
                // removes additionally added whitespaces in while cycle above

                matcher = BRACKETS_WITH_WHITESPACES.matcher(mergedLine);
                index = 0;
                while (matcher.find()) {
                    mergedLine = mergedLine.substring(0, matcher.start() + index) + matcher.group(1) + mergedLine.substring(matcher.end() + index);
                    index -= 2;

                }
                String[] newLines = mergedLine.split(LINE_DELIMITER);
                for (String newLine : newLines) { // split string into lines before merging
                    if (!newLine.equals("")) {
                        result.add(newLine);
                    }
                }
                if (emptyLine) {
                    result.add("");
                }
            }
        }
        return result;
    }

    /**
     * Allocates the beginning and the end of substring that contains
     * <code>combinationToBeReplaced</code> and replace it by <code>replacement</code>
     *
     * @param mergedLine              string that contains <code>combinationToBeReplaced</code>
     * @param combinationToBeReplaced string that needs to be replaced
     * @param replacement             string that will replace <code>combinationToBeReplaced</code>
     * @return string
     */
    private static String uniqueCombination(String mergedLine, String combinationToBeReplaced, String replacement) {
        int index = mergedLine.replace(LINE_DELIMITER, "").replace(" ", "").indexOf(combinationToBeReplaced.replace(" ", ""));
        int extraDelim = 0;
        String stringWithWord = mergedLine.substring(index, index + combinationToBeReplaced.length());
        while (!stringWithWord.replace(LINE_DELIMITER, "").replace(" ", "").contains(combinationToBeReplaced.replace(" ", ""))) {
            extraDelim++;
            if (index + combinationToBeReplaced.length() + extraDelim > mergedLine.length() - 1) {
                break;
            }  // looking for the end of the combination that needs to be replaced
            stringWithWord = mergedLine.substring(index, index + combinationToBeReplaced.length() + extraDelim);
        }
        int spaces = 0;
        while (combinationToBeReplaced.length() > 1 && (stringWithWord.charAt(0) != combinationToBeReplaced.charAt(0) || stringWithWord.charAt(1) != combinationToBeReplaced.charAt(1))) {
            spaces++;
            stringWithWord = stringWithWord.substring(1); // looking for the beginning of the combination that needs to be repalced
        }

        index += spaces;
        return mergedLine.substring(0, index) +
                replacement +                               // replacing the part with combination with replacement
                mergedLine.substring(index + stringWithWord.length());

    }

    /**
     * Allocates the words that need to be replaced and brackets in the <code>line</code>
     * and calls the method for replacing the words
     *
     * @param line             string that contains <code>wordToBeReplaced</code>
     * @param wordToBeReplaced string that needs to be replaced
     * @param replacement      string that replaces the <code>wordToBeReplaced</code>
     * @return string
     */
    private static String findDuplicates(String line, String wordToBeReplaced, String replacement) {
        String newLine = "";
        final Map<Character, Character> brackets = new HashMap<>(Map.of('(', ')', '[', ']'));
        final List<String> words = new ArrayList<>(List.of(line.split(" ")));
        String[] replaced = new String[words.size()];
        List<Integer> positionsWithDuplicate = new ArrayList<>();
        List<Integer> positionsOpen = new ArrayList<>();
        List<Integer> positionsClosed = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {       // filling up lists with bracket positions and positions with duplicates
            for (char bracket : brackets.keySet()) {
                if (words.get(i).contains(bracket + "") && !words.get(i).contains("\"" + bracket + "\"")) {
                    positionsOpen.add(i);
                }
                if (words.get(i).contains(brackets.get(bracket) + "") && !words.get(i).contains("\"" + brackets.get(bracket) + "\"")) {
                    positionsClosed.add(i);
                }
            }
            if (words.get(i).contains(wordToBeReplaced)) {
                positionsWithDuplicate.add(i);
            }
            if (words.get(i).equals("") && i != 0 && i < words.size() - 1 && ((!words.get(i + 1).equals("") && (brackets.containsKey(words.get(i + 1).charAt(0)) || brackets.containsValue(words.get(i + 1).charAt(0)))) ||
                    (!words.get(i - 1).equals("") && (brackets.containsKey(words.get(i - 1).charAt(0)) || brackets.containsValue(words.get(i - 1).charAt(0)))))) {
                words.set(i, " ");
            }     // replacing empty string with whitespace if 1 of his neighbours contains element from brackets
        }
        if (!positionsOpen.isEmpty()) {
            for (int positionClosed : positionsClosed) {      // finds the position of the open bracket that is pair to the bracket that was closed
                int position = 0, lastValidPosition = 0, index = 0;
                while (position < positionClosed && index < positionsOpen.size()) {
                    lastValidPosition = position;
                    position = positionsOpen.get(index);
                    index++;
                }
                if (index == positionsOpen.size() && position < positionClosed) {
                    lastValidPosition = position;
                }
                replaceDuplicates(words, positionsWithDuplicate, replaced, lastValidPosition, positionClosed, wordToBeReplaced, replacement);
                positionsOpen.remove((Integer) lastValidPosition);
                int wordsInBrackets = 0;
                for (int i = lastValidPosition + 1; i <= positionClosed - 1; i++) {
                    if (!replaced[i].equals("") && !replaced[i].equals(" ")) {
                        wordsInBrackets++;
                    }
                }
                if (wordsInBrackets <= 1 && replaced[lastValidPosition].equals("(")) { //removes parenthesis if there is only 1 word in between
                    replaced[lastValidPosition] = "";
                    replaced[positionClosed] = "";
                }
            }
        }

        replaceDuplicates(words, positionsWithDuplicate, replaced, 0, words.size() - 1, wordToBeReplaced, replacement);
        for (String word : replaced) {
            if (!word.equals("")) {
                if (newLine.length() != 0 && newLine.charAt(newLine.length() - 1) == ' ' && word.equals(LINE_DELIMITER)) {
                    newLine = newLine.substring(0, newLine.length() - 1) + word;
                }
                newLine += word;
                if (!replaced[replaced.length - 1].equals(word) && !word.equals(" ")) {
                    newLine += " ";
                }
            }

        }

        return newLine;
    }

    /**
     * Replace <code>wordThatNeedToBeReplaced</code> with <code>replacement</code>
     * in the range from <code>min</code> to <code>max</code> in <code>words</code>
     * and rebuilds the string in the string array <code>replaced</code>. If there
     * are multiple occurrences of <code>duplicate</code> other duplicates will be
     * removed if the logic of current expression won't be changed by that.
     *
     * @param words                  list of strings
     * @param positionsWithDuplicate list of integers with indexes of duplicates
     * @param replaced               array of strings
     * @param min                    starting position in <code>words</code>
     * @param max                    ending position in <code>words</code>
     * @param duplicate              string that needs to be replaced
     * @param replacement            string that replaces the duplicate
     */
    private static void replaceDuplicates(List<String> words, List<Integer> positionsWithDuplicate, String[] replaced, int min, int max, String duplicate, String replacement) {
        final String USED_ELEMENT = "###%###";
        int counter = 0;
        for (int i = min; i <= max; i++) {
            if (positionsWithDuplicate.contains(i)) {
                counter++;
                if (!words.get(i).contains(USED_ELEMENT)) {
                    replaced[i] = words.get(i).replace(duplicate, replacement);
                }
                boolean before = false,
                        after = false;
                if (i < max - 1)  // checks for OR at position after current
                    after = words.get(i + 1).equals("|") || words.get(i).equals("|" + LINE_DELIMITER) || words.get(i).equals(LINE_DELIMITER + "|");
                if (i > min) // checks for OR at position before current
                    before = replaced[i - 1].equals("|") || replaced[i - 1].equals("|" + LINE_DELIMITER) || replaced[i - 1].equals(LINE_DELIMITER + "|");
                if (counter > 1 && (after || before)) {
                    if (!words.get(i).contains(USED_ELEMENT))
                        replaced[i] = words.get(i).replace(duplicate, "");  // current word is a duplicate, so it's replaced by empty string

                    words.set(i, USED_ELEMENT);
                    if (before) {
                        replaced[i - 1] = "";  // OR before duplicate is removed with duplicate
                    } else if (i < words.size() - 1) {
                        replaced[i + 1] = "";  // OR after duplicate is removed with duplicate
                        words.set(i + 1, USED_ELEMENT);
                        i++;
                    }

                }
                words.set(i, USED_ELEMENT);
                positionsWithDuplicate.remove((Integer) i);  // current position is removed from duplicates because have been already dealt with
            } else if (!words.get(i).equals(USED_ELEMENT)) {
                if (words.get(i).equals("") && i > 0) {
                    replaced[i] = replaced[i - 1];
                    replaced[i - 1] = words.get(i);
                } else replaced[i] = words.get(i);

                words.set(i, USED_ELEMENT);
            }
        }
    }

    /**
     * Method extract definition from comment and defines the rule
     *
     * @param lines     list of strings
     * @param comment   comment with definition
     * @param delimiter delimiter pointing at the beginning of definition in the comment
     * @return list of strings
     */
    private static List<String> commentRules(List<String> lines, String comment, String delimiter) {
        List<String> result = new ArrayList<>();

        for (String line : lines) {
            if (line.contains(comment)) {
                String rule = "";
                if (line.contains(delimiter)) {
                    rule = line.substring(line.lastIndexOf(delimiter) + 1);
                    Scanner sc = new Scanner(rule);
                    rule = sc.next();
                }
                if (comment.contains("scanner") && !line.contains(delimiter)) {
                    rule = "VCHAR*";
                }
                if (rule.equals("")) {
                    Scanner sc2 = new Scanner(line.substring(line.indexOf(comment) + comment.length()));
                    rule = sc2.next();
                }
                if (comment.contains("unquoted")) {
                    line = commentRulesUnquoted(line, rule);
                } else {
                    line = commentRulesDoubleQuoted(line, rule);
                }
            }

            result.add(line);
        }
        return result;
    }

    private static String commentRulesUnquoted(String line, String rule) {
        String lineBeginning = line.substring(0, line.indexOf("=") + 1);
        return lineBeginning + " " + rule + " " + line.substring(lineBeginning.length());
    }

    private static String commentRulesDoubleQuoted(String line, String rule) {
        String lineBeginning = line.substring(0, line.indexOf("=") + 1);
        return lineBeginning + " " + rule + " | ( DOUBLE_QUOTE " + rule + " DOUBLE_QUOTE )" + line.substring(lineBeginning.length());
    }

    /**
     * Replace double quotes at highlighter tokens with curly brackets
     *
     * @param lines list of strings with lexer
     * @return list of strings with lexer
     */
    public static List<String> replaceQuotes(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean initial = false;
        for (String line : lines) {
            if (line.contains("YYINITIAL")) {
                initial = true;
            }
            if (initial) {
                line = line.replaceFirst("\"", "{").replaceFirst("\"", "}");
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Removes H_ sign from highlighter tokens and transforms them into loverCase
     *
     * @param lines list of strings
     * @return list of strings with transformed highlighter tokens
     */
    public static List<String> transformH_Tokens(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {

            if (line.contains("{H_")) {
                line = line.replaceFirst("\\{H_", "{");
                line = line.substring(0, line.indexOf("return")).toLowerCase() + line.substring(line.indexOf("return"));
            }
            if (line.contains("_H_")) line = line.replace("_H_", "_");
            result.add(line);
        }
        return result;
    }

    /**
     * Adds transformed highlighter tokens into list of FlexerTokens
     *
     * @param lines  list of strings
     * @param tokens list of FlexerTokens
     */
    public static void addTransformedTokens(List<String> lines, List<FlexerToken> tokens) {
        for (String line : lines) {
            Matcher matcher = LEXER_TOKENS_PATTERN.matcher(line);
            if (matcher.find()) {
                String lexerValue = matcher.group().substring(1, matcher.group().length() - 1);
                if (lexerValue.contains("keyword")){ lexerValue = lexerValue.substring(0,lexerValue.indexOf("_"));}
                tokens.add(new FlexerToken(matcher.group().substring(1, matcher.group().length() - 1), "\"" + lexerValue + "\"", true));
            }
        }

    }

    /**
     * Adds additional information at the beginning of the list with bnf grammar
     *
     * @param lines list of strings with bnf grammar
     * @param paths list of strings with additional information for bnf grammar
     * @return list of strings
     */
    public static List<String> addHeader(List<String> lines, List<String> paths) {
        List<String> result = new ArrayList<>(paths);
        result.add("");
        result.addAll(lines);
        return result;
    }


    /**
     * Tokens used in the bnf grammar are added into lexer file
     * at correct place
     *
     * @param lines  list of strings with generated lexer
     * @param tokens list of FlexerTokens
     * @return list of strings with added tokens
     */
    public static List<String> addTokensIntoLexer(List<String> lines, List<FlexerToken> tokens) {
        List<String> result = new ArrayList<>();
        boolean unicode = false;
        for (String line : lines) {
            if (line.contains("unicode")) unicode = true;
            if (!line.contains("WHITE_SPACE")) {
                result.add(line);
            }
            if (unicode) {
                result.add("");
                for (FlexerToken token : tokens) {
                    String tokenLine = token.getName() + " = " + token.getLexerValue();

                    result.add(tokenLine);
                }
            }
            unicode = false;
        }
        return result;
    }

    /**
     * Combine 2 lists with bnf grammar into 1, marking the beginning of 2nd list.
     * Second list ist added at the end of first list.
     *
     * @param list1 list of strings
     * @param list2 list of strings
     * @param name  name of 2nd list used in mark at the beginning of 2nd list
     * @return combined list of strings
     */
    public static List<String> combineLists(List<String> list1, List<String> list2, String name) {
        if (list1.equals(list2)) return list1;
        List<String> result = new ArrayList<>(list1);
        String start = "//////////////////////////////\n" +
                "//\n" +
                "// " + name + "\n" +
                "//\n" +
                "//////////////////////////////";
        result.add(start);
        result.add("");
        result.addAll(list2);

        return result;
    }

    /**
     * Adds negated definition from comment in parentheses at
     * the beginning of the definition 1 row under the comment
     *
     * @param lines   list of strings containing comment
     * @param comment string with additional negated definition in parentheses
     * @return
     */
    private static List<String> xmlStartFor6020(List<String> lines, String comment) {
        List<String> result = new ArrayList<>();
        boolean containsXMLComment = false;
        for (String line : lines) {
            String lineBeginning = "", definition, newLine;
            if (line.contains("=")) lineBeginning = line.substring(0, line.indexOf("=") + 1);
            definition = extractDefinition(line);
            newLine = definition;
            if (containsXMLComment) {
                newLine = "!" + comment.substring(comment.indexOf("(")) + definition;
            }
            containsXMLComment = line.contains(comment);
            result.add(lineBeginning + newLine);
        }
        return result;
    }


    /**
     * Method adds anyOrder external rule at the correct places in the list
     * marked by comments.
     *
     * @param lines list of Strings that needs anyOrder external rule
     * @return list of Strings with anyOrder external rule added
     */
    public static List<String> addAnyOrder(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean anyOrder = false, firstLine = false;
        for (String line : lines) {
            int index = result.size();
            if (anyOrder && firstLine) {
                line = "<<anyOrder" + line;
                firstLine = false;
            }
            if (index != lines.size() - 1 && anyOrder &&
                    (lines.get(index + 1).contains("::=")
                            || lines.get(index + 1).contains("RIGHT_BRACE"))) {
                line += ">>";
                anyOrder = false;
            }
            if (line.contains("can appear in any order")) {
                anyOrder = true;
                firstLine = true;
            }
            result.add(line);
        }
        return result;
    }

    private static List<String> correctYangChar(List<String> lines) {
        List<String> result = new ArrayList<>();
        boolean comment = false;
        for (String line : lines) {
            if (line.isBlank()) comment = false;
            if (comment) line = "// " + line;
            if (line.contains("yang-char ::=")) {
                line = line.substring(0, line.indexOf("=") + 1) + " ( ALPHA | DIGIT ) //" + line.substring(line.indexOf("=") + 1);
                comment = true;
            }
            result.add(line);
        }
        return result;
    }

    /**
     * Method finds the lines for yang-char in original abnf grammar
     * and extract ranges with forbidden characters from it.
     *
     * @param abnf list of Strings with original abnf grammar
     * @return list of Strings with extracted ranges for yang-char
     */

    public static List<String> extractRangesFromABNF(List<String> abnf) {
        List<String> ranges = new ArrayList<>();
        boolean atChar = false;
        for (String line : abnf) {
            if (line.isBlank()) atChar = false;
            if (atChar) {
                String range = line.substring(line.indexOf(";"));
                ranges.add(range.substring(range.indexOf("%")));
            }
            if (line.contains("yang-char =")) atChar = true;
        }
        return ranges;
    }

    /**
     * Method adds external rule checkString to yang-string definition.
     *
     * @param lines  list of Strings containing yang-string definition
     * @param ranges list of Strings containing ranges with forbidden characters
     * @return list of Strings with added external rule checkString
     */
    public static List<String> addCheckString(List<String> lines, List<String> ranges) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("yang-string ::=")) {
                line = line.substring(0, line.indexOf("=") + 1) + "<<checkString" + line.substring(line.indexOf("=") + 1);
                for (String range : ranges) {
                    line += " \"" + range + "\"";
                    if (ranges.indexOf(range) % 3 == 0) line += "\n";
                }
                line += ">>";
            }
            result.add(line);
        }
        return result;
    }
}