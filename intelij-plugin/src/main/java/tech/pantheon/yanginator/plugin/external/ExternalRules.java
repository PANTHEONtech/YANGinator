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
     * @param b           Psi builder
     * @param l           Level, by increasing it we move to the next element
     * @param listOfItems list of items to try parsing and matching
     * @return return true if all items are matched BUT does not check for duplicates
     */

    public static boolean anyOrder(PsiBuilder b, int l, Parser... listOfItems) {
        if (!recursion_guard_(b, l, "rule")) return false;
        boolean r;
        //create new array of booleans with length of items that we want to match
        boolean[] booleanList = new boolean[listOfItems.length];
        //create list out of listOfItems array, so we can remove items that were already matched
        List<Parser> list = new ArrayList<>(List.of(listOfItems));
        Set<Parser> optionalParsed = new HashSet<>();
        //enter the section to match
        PsiBuilder.Marker m = enter_section_(b);

        for (int i = 0; i < listOfItems.length; i++) {
            r = false;
            for (int j = 0; j < list.size(); j++) {
                int oldOffset = b.getCurrentOffset();
                //try parsing item
                r = list.get(j).parse(b, l + 1);
                if (i == j && r) {
                    booleanList[i] = true;
                }
                int newOffset = b.getCurrentOffset();
                //optional or not optional
                if (r && (oldOffset == newOffset)) {
                    optionalParsed.add(listOfItems[j]);
                    //try parsing optional
                    for (Parser item : optionalParsed) {
                        oldOffset = b.getCurrentOffset();
                        r = item.parse(b, l + 1);
                        if (r && oldOffset != newOffset) {
                            //remove optional item if it was parsed
                            optionalParsed.remove(item);
                            booleanList[i] = true;
                            //no need to loop futher, the item has been parsed
                            break;
                        } else {
                            r = false;
                        }
                    }
                }
                if (r) {
                    booleanList[j] = true;
                    //no need to loop futher, the item has been parsed
                    break;
                }
            }
            //move to next element and try matching it
            l += 1;
        }
        exit_section_(b, m, null, areAllTrue(booleanList));
        return areAllTrue(booleanList);
    }

    private static boolean areAllTrue(boolean[] array) {
        //simple method to find if all elements are true
        for (boolean b : array) if (!b) return false;
        return true;
    }

}
