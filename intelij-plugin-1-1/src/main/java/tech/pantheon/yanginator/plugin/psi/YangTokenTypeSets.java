/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

public interface YangTokenTypeSets {
    IElementType LINE_COMMENT = new YangElementType("YANG_LINE_COMMENT");
    IElementType BLOCK_COMMENT = new YangElementType("YANG_BLOCK_COMMENT");
    TokenSet STRINGS = TokenSet.create(YangTypes.YANG_ALPHA);
 }