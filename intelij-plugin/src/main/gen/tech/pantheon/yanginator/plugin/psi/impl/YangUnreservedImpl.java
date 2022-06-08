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
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangDigit;
import tech.pantheon.yanginator.plugin.psi.YangUnreserved;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ALPHA;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ALPHANUMERICAL_ALPHA_FIRST;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ALPHANUMERICAL_DIGIT_FIRST;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DASH;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DATE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DIGITS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOT;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_FRACTIONS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_TILDE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_UNDERSCORE;

public class YangUnreservedImpl extends YangNamedElementImpl implements YangUnreserved {

    public YangUnreservedImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitUnreserved(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public YangDigit getDigit() {
        return findChildByClass(YangDigit.class);
    }

    @Override
    @Nullable
    public PsiElement getAlpha() {
        return findChildByType(YANG_ALPHA);
    }

    @Override
    @Nullable
    public PsiElement getAlphanumericalAlphaFirst() {
        return findChildByType(YANG_ALPHANUMERICAL_ALPHA_FIRST);
    }

    @Override
    @Nullable
    public PsiElement getAlphanumericalDigitFirst() {
        return findChildByType(YANG_ALPHANUMERICAL_DIGIT_FIRST);
    }

    @Override
    @Nullable
    public PsiElement getDash() {
        return findChildByType(YANG_DASH);
    }

    @Override
    @Nullable
    public PsiElement getDate() {
        return findChildByType(YANG_DATE);
    }

    @Override
    @Nullable
    public PsiElement getDigits() {
        return findChildByType(YANG_DIGITS);
    }

    @Override
    @Nullable
    public PsiElement getDot() {
        return findChildByType(YANG_DOT);
    }

    @Override
    @Nullable
    public PsiElement getFractions() {
        return findChildByType(YANG_FRACTIONS);
    }

    @Override
    @Nullable
    public PsiElement getTilde() {
        return findChildByType(YANG_TILDE);
    }

    @Override
    @Nullable
    public PsiElement getUnderscore() {
        return findChildByType(YANG_UNDERSCORE);
    }

}
