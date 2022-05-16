/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

package tech.pantheon.yanginator.plugin.lexer;

import com.intellij.lexer.FlexAdapter;

public class YangLexer extends FlexAdapter {
    public YangLexer() {
        super(new _YangLexer());
    }
}