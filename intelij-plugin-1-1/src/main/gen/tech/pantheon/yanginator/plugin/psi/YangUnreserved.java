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

public interface YangUnreserved extends YangNamedElement {

    @Nullable
    YangDigit getDigit();

    @Nullable
    PsiElement getAlpha();

    @Nullable
    PsiElement getDash();

    @Nullable
    PsiElement getDot();

    @Nullable
    PsiElement getTilde();

    @Nullable
    PsiElement getUnderscore();

}
