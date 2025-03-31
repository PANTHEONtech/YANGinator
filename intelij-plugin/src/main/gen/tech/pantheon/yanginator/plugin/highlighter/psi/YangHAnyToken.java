/*
 *
 *   Copyright (c) 2021-2025 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.highlighter.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangNamedElement;

public interface YangHAnyToken extends YangNamedElement {

    @Nullable
    YangHIdentifierLiteral getHIdentifierLiteral();

    @Nullable
    PsiElement getHBlockComment();

    @Nullable
    PsiElement getHDateArg();

    @Nullable
    PsiElement getHExtensionIdentifier();

    @Nullable
    PsiElement getHIdentifier();

    @Nullable
    PsiElement getHSemicolon();

    @Nullable
    PsiElement getHSingleLineComment();

    @Nullable
    PsiElement getHString();

}
