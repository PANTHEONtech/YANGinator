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
    /**
     * Allows description-stmt to be double quoted.
     *
     * @param lines list of strings
     * @return list of strings
     */
    public static List<String> quoteDescription(List<String> lines){
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("description-stmt ::=")) {
                line = line + " | description-keyword sep quoted-string stmtend";
            }
            result.add(line);
        }

        return  result;
    }

    /**
     * Part of the definition is extracted to the separate statement to allow
     * annotator to check for duplicities. Doesn't change the logic of the grammar.
     *
     * @param lines list of strings
     * @return  list of strings
     */
    public static List<String> splitDeviationStmt(List<String> lines){
        List<String> result = new ArrayList<>();
        boolean found = false;
        for (String line : lines) {
            if (line.contains("deviation-stmt ::=")){
                result.add("deviation-stmt-body-args ::= deviate-not-supported-stmt |\n" +
                        "  (deviate-add-stmt |\n" +
                        "  deviate-replace-stmt |\n" +
                        "  deviate-delete-stmt)+");
                result.add("");
                found = true;
            }
            result.add(line);
            if (found && line.contains("deviate")){
                result.remove(line);
            }
            if (found && line.contains("RIGHT_BRACE")){
                result.remove(result.size()-1);
                result.add("  deviation-stmt-body-args>>");
                result.add(line);
                found = false;
            }

        }

        return result;
    }
}
