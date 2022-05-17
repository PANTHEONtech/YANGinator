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
                line = line.substring(0, line.indexOf("string")-1) + " string | ( DOUBLE_QUOTE string DOUBLE_QUOTE )" + line.substring(line.indexOf("string") + 6);
            }
            result.add(line);
        }

        return  result;
    }
}
