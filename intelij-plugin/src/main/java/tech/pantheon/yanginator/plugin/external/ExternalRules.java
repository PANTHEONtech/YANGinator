/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.external;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.intellij.lang.parser.GeneratedParserUtilBase.consumeToken;
import static com.intellij.lang.parser.GeneratedParserUtilBase.enter_section_;
import static com.intellij.lang.parser.GeneratedParserUtilBase.exit_section_;
import static com.intellij.lang.parser.GeneratedParserUtilBase.recursion_guard_;
import static tech.pantheon.yanginator.plugin.parser.YangParser.yang_keyword;
import static tech.pantheon.yanginator.plugin.parser.YangParser.yang_stmt;


public class ExternalRules {

    /**
     * First for loop will find and parse all optional statements, so they will not be treated as missing
     * when the parsing ends.
     * The while loop parses every statement possible for the current block, the offset changed after parsing.
     * It makes sure that all mandatory statements are present.
     *
     * @param psiBuilder Psi builder
     * @param level      Level, by increasing it we move to the next element
     * @param parsers    list of items to try parsing and matching
     * @return return true if all items are matched BUT does not check for duplicates
     */

    public static boolean anyOrder(PsiBuilder psiBuilder, int level, Parser... parsers) {
        if (!recursion_guard_(psiBuilder, level, "rule")) return false;
        boolean result;
        //create new array of booleans with length of items that we want to match
        boolean[] individualParserResults = new boolean[parsers.length];
        //create list out of parsers array, so we can remove items that were already matched
        List<Parser> parsersHolder = new ArrayList<>(List.of(parsers));
        //enter the section to match
        PsiBuilder.Marker marker = enter_section_(psiBuilder);
        //find and parse all optional statements
        for (int i = 0; i < parsersHolder.size(); i++) {
            result = parsersHolder.get(i).parse(psiBuilder, level + 1);
            if (result)
                individualParserResults[i] = true;
        }
        int oldOffset = psiBuilder.getCurrentOffset();
        int newOffset = oldOffset;
        boolean parsing = true;
        while (parsing) {
            parsing = false;
            oldOffset = psiBuilder.getCurrentOffset();
            for (int i = 0; i < parsersHolder.size(); i++) {
                result = parsersHolder.get(i).parse(psiBuilder, level + 1);
                newOffset = psiBuilder.getCurrentOffset();
                if (result && (oldOffset != newOffset)) {
                    individualParserResults[i] = true;
                    break;
                }
            }
            if (oldOffset != newOffset) {
                parsing = true;
                level += 1;
            }
        }
        exit_section_(psiBuilder, marker, null, unanimousResults(individualParserResults));
        return unanimousResults(individualParserResults);
    }

    private static boolean unanimousResults(boolean[] listOfBooleanResults) {
        //simple method to find if all elements are true
        for (boolean booleanList : listOfBooleanResults) {
            if (!booleanList) return false;
        }
        return true;
    }

    /**
     * First for loop extracts current yang-string from original text into variable text.
     * Last for loop compares string characters with forbidden characters and stops at 1st match.
     *
     * @param psiBuilder Psi builder
     * @param level      Level
     * @param parser     parser for parsing current string
     * @param strings    list of strings containing forbidden ranges for character
     * @return return true if forbidden range doesn't contain any character of this string
     */
    public static boolean checkString(PsiBuilder psiBuilder, int level, Parser parser, String... strings) {
        if (!recursion_guard_(psiBuilder, level, "rule")) return false;
        final List<String> stringList = new ArrayList<>(List.of(strings));
        final List<Character> charList = stringsToChars(stringList);
        PsiBuilder.Marker marker = enter_section_(psiBuilder);
        String text = "";
        for (int i = psiBuilder.getCurrentOffset(); i < psiBuilder.getOriginalText().length(); i++) {
            if (psiBuilder.getOriginalText().charAt(i) == ';' || psiBuilder.getOriginalText().charAt(i) == '"') {
                text = psiBuilder.getOriginalText().subSequence(psiBuilder.getCurrentOffset(), i).toString();
                break;
            }
        }
        for (char c : text.toCharArray()) {
            boolean result = charList.parallelStream().anyMatch(character -> character.equals(c));
            if (result) {
                psiBuilder.advanceLexer();
                parser.parse(psiBuilder, level);
                exit_section_(psiBuilder, marker, null, false);
                return false;
            }

        }
        parser.parse(psiBuilder, level);
        exit_section_(psiBuilder, marker, null, true);
        return true;
    }

    /**
     * Compares character with every forbidden character in @charList.
     *
     * @param psiBuilder Psi builder
     * @param level      Level
     * @param parser     parser for parsing current character
     * @param strings    list of strings containing forbidden ranges for character
     * @return return true if forbidden range doesn't contains current character
     */

    public static boolean checkChar(PsiBuilder psiBuilder, int level, Parser parser, String... strings) {
        if (!recursion_guard_(psiBuilder, level, "rule")) return false;
        final List<String> stringList = new ArrayList<>(List.of(strings));
        final List<Character> charList = stringsToChars(stringList);
        PsiBuilder.Marker marker = enter_section_(psiBuilder);
        boolean result = charList.parallelStream().anyMatch(character -> consumeToken(psiBuilder, String.valueOf(character)));
        parser.parse(psiBuilder, level);
        if (result) {
            exit_section_(psiBuilder, marker, null, false);
            return false;
        }
        exit_section_(psiBuilder, marker, null, true);
        return true;
    }

    /**
     * For loop extracts hex ranges with characters that are forbidden and add those characters into charList,
     * in addition char with hex code 0xFFFD is added manually even though it's not forbidden. This is because
     * idea can't recognize some characters from forbidden ranges and replace them with this value.
     *
     * @param stringList list of strings with hex ranges for forbidden characters
     * @return List<Character> charList with forbidden characters
     */
    private static List<Character> stringsToChars(List<String> stringList) {
        List<Character> charList = new ArrayList<>();
        // 0xFFFD is for characters that can't be recognized by idea and are replaced by this value
        charList.add((char) 0xFFFD);
        for (String s : stringList) {
            String current = s.substring(2);
            String[] list = current.split("-");
            int low = Integer.decode("0x" + list[0]);
            int high = Integer.decode("0x" + list[1]);
            for (int j = low; j <= high; j++) {
                charList.add((char) j);
            }
        }
        return charList;
    }

    /**
     * Method is called after start of block comment is found,
     * in while loop next token is checked, and if end of block comment is found, loop ends
     * otherwise token is consumed and loop continues with next token
     *
     * @param psiBuilder Psi builder
     * @param level      Level of element
     * @return return true if end of block comment is found
     */
    public static boolean blockComment(PsiBuilder psiBuilder, int level) {
        if (!recursion_guard_(psiBuilder, level, "rule")) return false;
        PsiBuilder.Marker marker = enter_section_(psiBuilder);
        while (true) {
            String token = psiBuilder.getTokenText();
            if (Objects.equals(token, "*") &&
                    psiBuilder.getOriginalText().charAt(psiBuilder.getCurrentOffset() + 1) == '/' ||
                    token == null) {
                break;
            }
            consumeToken(psiBuilder, token);
        }
        exit_section_(psiBuilder, marker, null, true);
        return true;
    }

    /**
     * This method is used to find out if the element is an incomplete keyword.
     * <p>
     *     It calls yang_keyword parser method to find out if the string should be
     *     counted as complete keyword. If it is, this method returns false and
     *     does not consume this string.
     * </p>
     * <p>
     *     If the string is not a completed keyword, this method consumes this string,
     *     creates an error message at the end of the string and returns true.
     * </p>
     * @param psiBuilder Psi builder
     * @param level Level of element
     * @return true if the element is an incomplete keyword
     *         false if the element is a complete keyword
     */
    public static boolean dummyElement(PsiBuilder psiBuilder, int level) {
        if (!recursion_guard_(psiBuilder, level, "rule")) return false;
        PsiBuilder.Marker marker = enter_section_(psiBuilder);
        String token = psiBuilder.getTokenText();
        String errorMessage = "Incomplete yang statement.";
        boolean result = false;
        if (yang_keyword(psiBuilder, level)) {
            exit_section_(psiBuilder, marker, null, false);
            return false;
        }

        if (token != null && token.matches("\\s?+[a-zA-Z]+\\s?+")) {
            consumeToken(psiBuilder, token);
            result = true;
            psiBuilder.error(errorMessage);
        }
        exit_section_(psiBuilder, marker, null, result);
        return result;
    }
}
