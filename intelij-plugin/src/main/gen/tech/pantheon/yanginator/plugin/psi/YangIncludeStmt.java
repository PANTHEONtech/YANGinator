/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
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
import tech.pantheon.yanginator.plugin.reference.YangGeneratedReferenceType;

import java.util.List;

public interface YangIncludeStmt extends YangGeneratedReferenceType {

    @NotNull
    List<YangWsp> getWspList();

    @NotNull
    List<YangComment> getCommentList();

    @Nullable
    YangIdentifierRefArgStr getIdentifierRefArgStr();

    @NotNull
    YangIncludeKeyword getIncludeKeyword();

    @NotNull
    List<YangLineBreak> getLineBreakList();

    @NotNull
    List<YangUnknownStatement> getUnknownStatementList();

    @Nullable
    PsiElement getLeftBrace();

    @Nullable
    PsiElement getRightBrace();

    @Nullable
    PsiElement getSemicolon();

}
