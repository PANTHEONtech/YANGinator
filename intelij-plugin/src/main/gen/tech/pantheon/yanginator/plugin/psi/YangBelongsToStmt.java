/*
 *
 *   Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface YangBelongsToStmt extends YangYangStmt {

    @NotNull
    YangBelongsToKeyword getBelongsToKeyword();

    @NotNull
    YangIdentifierArgStr getIdentifierArgStr();

    @NotNull
    YangOptsep getOptsep();

    @NotNull
    YangPrefixStmt getPrefixStmt();

    @NotNull
    YangSep getSep();

    @NotNull
    List<YangStmtsep> getStmtsepList();

    @NotNull
    PsiElement getLeftBrace();

    @NotNull
    PsiElement getRightBrace();

}
