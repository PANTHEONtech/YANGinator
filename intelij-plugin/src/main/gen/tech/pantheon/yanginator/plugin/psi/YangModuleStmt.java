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
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangModuleStmt extends YangYangStmt {

    @Nullable
    YangBodyStmts getBodyStmts();

    @Nullable
    YangIdentifierArgStr getIdentifierArgStr();

    @Nullable
    YangLinkageStmts getLinkageStmts();

    @Nullable
    YangMetaStmts getMetaStmts();

    @Nullable
    YangModuleHeaderStmts getModuleHeaderStmts();

    @NotNull
    YangModuleKeyword getModuleKeyword();

    @NotNull
    List<YangOptsep> getOptsepList();

    @NotNull
    List<YangRevisionStmt> getRevisionStmtList();

    @Nullable
    YangSep getSep();

    @Nullable
    YangStmtsep getStmtsep();

    @Nullable
    PsiElement getLeftBrace();

    @Nullable
    PsiElement getRightBrace();

}
