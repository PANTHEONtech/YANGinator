/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

package tech.pantheon.yanginator.parser.generator;

import java.util.ArrayList;
import java.util.List;

public class FlexerToken {
    private final String name;
    private final String lexerValue;
    private  List<String> values;
    private final boolean lexerOnly;

    public FlexerToken(final String name, final String lexerValue, final boolean lexerOnly){
        this.name = name;
        this.lexerValue = lexerValue;
        this.values = new ArrayList<>();
        this.lexerOnly = lexerOnly;
    }
    public void replaceValues(List<String> values){
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public String getLexerValue() {
        return lexerValue;
    }

    public boolean isLexerOnly() {
        return lexerOnly;
    }

    public void addValue(String value){
        this.values.add(value);
    }
    public List<String> getValues() {
        List<String> copy = values;
        return copy;
    }
}
