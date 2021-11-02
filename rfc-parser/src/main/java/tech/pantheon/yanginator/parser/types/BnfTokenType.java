/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.parser.types;


public class BnfTokenType {

    private final String stringValue;

    private final String name;

    public BnfTokenType(final String stringValue, final String name) {
        this.stringValue = stringValue;
        this.name = name;
    }

    public String getStringValue() {
        return "\"".concat(this.stringValue).concat("\"");

    }

    public String getBnfValue() {
        return this.name;
    }

    public String getCharacterValue() {
        return this.stringValue;
    }
}
