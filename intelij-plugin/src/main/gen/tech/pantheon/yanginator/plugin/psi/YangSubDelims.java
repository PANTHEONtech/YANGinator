/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface YangSubDelims extends YangNamedElement {

    @Nullable
    PsiElement getAmpersand();

    @Nullable
    PsiElement getAsterisk();

    @Nullable
    PsiElement getComma();

    @Nullable
    PsiElement getDollarSign();

    @Nullable
    PsiElement getEquals();

    @Nullable
    PsiElement getExclamationMark();

    @Nullable
    PsiElement getLeftParenthesis();

    @Nullable
    PsiElement getPlusSign();

    @Nullable
    PsiElement getRightParenthesis();

    @Nullable
    PsiElement getSingleQuote();

}
