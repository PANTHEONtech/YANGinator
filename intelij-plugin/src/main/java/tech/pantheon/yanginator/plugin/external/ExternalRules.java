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

import static com.intellij.lang.parser.GeneratedParserUtilBase.enter_section_;
import static com.intellij.lang.parser.GeneratedParserUtilBase.exit_section_;
import static com.intellij.lang.parser.GeneratedParserUtilBase.recursion_guard_;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase.Parser;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
