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
     * from listOfItems with the statement,
     * if the item matches but offset does not change that means that the parsed word was optional. if we match optional word
     * we save it to HashSet and try parsing it later. if it does match and offset moves that mean that it was parsed, so we
     * can remove it.
     * see more in /yanginator/plugin/external/AnyOrderRuleTutorial.md
     *
     * @param psiBuilder  Psi builder
     * @param level       Level, by increasing it we move to the next element
     * @param listOfItems list of items to try parsing and matching
     * @return return true if all items are matched BUT does not check for duplicates
     */

    public static boolean anyOrder(PsiBuilder psiBuilder, int level, Parser... listOfItems) {
        if (!recursion_guard_(psiBuilder, level, "rule")) return false;
        boolean parserResultBoolean;
        //create new array of booleans with length of items that we want to match
        boolean[] listOfBooleanResults = new boolean[listOfItems.length];
        //create list out of listOfItems array, so we can remove items that were already matched
        List<Parser> listOfItemsToParse = new ArrayList<>(List.of(listOfItems));
        Set<Parser> optionalParsed = new HashSet<>();
        //enter the section to match
        PsiBuilder.Marker marker = enter_section_(psiBuilder);

        for (int i = 0; i < listOfItems.length; i++) {
            parserResultBoolean = false;
            for (int j = 0; j < listOfItemsToParse.size(); j++) {
                int oldOffset = psiBuilder.getCurrentOffset();
                //try parsing item
                parserResultBoolean = listOfItemsToParse.get(j).parse(psiBuilder, level + 1);
                if (i == j && parserResultBoolean) {
                    listOfBooleanResults[i] = true;
                }
                int newOffset = psiBuilder.getCurrentOffset();
                //optional or not optional
                if (parserResultBoolean && (oldOffset == newOffset)) {
                    optionalParsed.add(listOfItems[j]);
                    //try parsing optional
                    for (Parser item : optionalParsed) {
                        oldOffset = psiBuilder.getCurrentOffset();
                        parserResultBoolean = item.parse(psiBuilder, level + 1);
                        if (parserResultBoolean && oldOffset != newOffset) {
                            //remove optional item if it was parsed
                            optionalParsed.remove(item);
                            listOfBooleanResults[i] = true;
                            //no need to loop futher, the item has been parsed
                            break;
                        } else {
                            parserResultBoolean = false;
                        }
                    }
                }
                if (parserResultBoolean) {
                    listOfBooleanResults[j] = true;
                    //no need to loop futher, the item has been parsed
                    break;
                }
            }
            //move to next element and try matching it
            level += 1;
        }
        exit_section_(psiBuilder, marker, null, areAllTrue(listOfBooleanResults));
        return areAllTrue(listOfBooleanResults);
    }

    private static boolean areAllTrue(boolean[] listOfBooleanResults) {
        //simple method to find if all elements are true
        for (boolean booleanList : listOfBooleanResults) if (!booleanList) return false;
        return true;
    }

}
