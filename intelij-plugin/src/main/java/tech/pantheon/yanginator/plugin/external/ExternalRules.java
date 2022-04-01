/*
 *
 *   Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.external;

import com.intellij.lang.PsiBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.intellij.lang.parser.GeneratedParserUtilBase.*;

public class ExternalRules {

    /**
     * First loop will go from first statement(word) to last, second loop will try to match every single item
     * from parsers with the statement,
     * if the item matches but offset does not change that means that the parsed word was optional. if we match optional word
     * we save it to HashSet and try parsing it later. if it does match and offset moves that mean that it was parsed, so we
     * can remove it.
     * see more in /yanginator/plugin/external/AnyOrderRuleTutorial.md
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
        Set<Parser> optionalParserHolder = new HashSet<>();
        //enter the section to match
        PsiBuilder.Marker marker = enter_section_(psiBuilder);

        for (int i = 0; i < parsers.length; i++) {
            result = false;
            for (int j = 0; j < parsersHolder.size(); j++) {
                int oldOffset = psiBuilder.getCurrentOffset();
                //try parsing item
                result = parsersHolder.get(j).parse(psiBuilder, level + 1);
                if (i == j && result) {
                    individualParserResults[i] = true;
                }
                int newOffset = psiBuilder.getCurrentOffset();
                //optional or not optional
                if (result && (oldOffset == newOffset)) {
                    optionalParserHolder.add(parsers[j]);
                    //try parsing optional
                    for (Parser item : optionalParserHolder) {
                        oldOffset = psiBuilder.getCurrentOffset();
                        result = item.parse(psiBuilder, level + 1);
                        if (result && oldOffset != newOffset) {
                            //remove optional item if it was parsed
                            optionalParserHolder.remove(item);
                            individualParserResults[i] = true;
                            //no need to loop futher, the item has been parsed
                            break;
                        } else {
                            result = false;
                        }
                    }
                }
                if (result) {
                    individualParserResults[j] = true;
                    //no need to loop futher, the item has been parsed
                    break;
                }
            }
            //move to next element and try matching it
            level += 1;
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
     * For loop extracts hex ranges with characters that are forbidden and add those characters into charList,
     * in addition char with hex code 0xFFFD is added manually even though it's not forbidden. This is because
     * idea can't recognize some characters from forbidden ranges and replace them with this value.
     * Second for loop extracts current yang-string from original text into variable text.
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
        final List<Character> charList = new ArrayList<>();
        final Set<Character> separators = new HashSet<>(Set.of('\n', '\r', ' ', '\t'));

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
        PsiBuilder.Marker marker = enter_section_(psiBuilder);
        String text = "";
        for (int i = psiBuilder.getCurrentOffset(); i < psiBuilder.getOriginalText().length(); i++) {
            if (separators.contains(psiBuilder.getOriginalText().charAt(i))) {
                text = psiBuilder.getOriginalText().subSequence(psiBuilder.getCurrentOffset(), i).toString();
                break;
            }
        }
        for (char c : text.toCharArray()) {
            boolean result = charList.parallelStream().anyMatch(character -> character == c);
            if (result) {
                exit_section_(psiBuilder, marker, null, false);
                return false;
            }
        }
        parser.parse(psiBuilder, level);
        exit_section_(psiBuilder, marker, null, true);
        return true;
    }

    /**
     * For loop extracts hex ranges with characters that are forbidden and add those characters into charList,
     * in addition char with hex code 0xFFFD is added manually even though it's not forbidden. This is because
     * idea can't recognize some characters from forbidden ranges and replace them with this value.
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
        final List<Character> charList = new ArrayList<>();
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
        PsiBuilder.Marker marker = enter_section_(psiBuilder);
        boolean result = charList.parallelStream().anyMatch(character -> consumeToken(psiBuilder, "" + character));
        parser.parse(psiBuilder, level);
        if (result) {
            exit_section_(psiBuilder, marker, null, false);
            return false;
        }
        exit_section_(psiBuilder, marker, null, true);
        return true;
    }
}
