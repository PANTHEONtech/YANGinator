/*
 *
 *   Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.parser.generator;

public class Extension {
    private final String statement, extension, implementation;
    private final String pin;

    public Extension(final String statement, final String pin, final String extension, final String implementation){
        this.statement = statement;
        this.extension = extension;
        this. implementation = implementation;
        this.pin = pin;
    }

    public String getStatement() {
        return statement;
    }

    public String getExtension() {
        return extension;
    }

    public String getImplementation() {
        return implementation;
    }

    public String getPin() {
        return pin;
    }
}
