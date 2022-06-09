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
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangDigit;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_EIGHT;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_FIVE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_FOUR;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_NINE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ONE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SEVEN;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SIX;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_THREE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_TWO;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ZERO;

public class YangDigitImpl extends YangNamedElementImpl implements YangDigit {

    public YangDigitImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitDigit(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public PsiElement getEight() {
        return findChildByType(YANG_EIGHT);
    }

    @Override
    @Nullable
    public PsiElement getFive() {
        return findChildByType(YANG_FIVE);
    }

    @Override
    @Nullable
    public PsiElement getFour() {
        return findChildByType(YANG_FOUR);
    }

    @Override
    @Nullable
    public PsiElement getNine() {
        return findChildByType(YANG_NINE);
    }

    @Override
    @Nullable
    public PsiElement getOne() {
        return findChildByType(YANG_ONE);
    }

    @Override
    @Nullable
    public PsiElement getSeven() {
        return findChildByType(YANG_SEVEN);
    }

    @Override
    @Nullable
    public PsiElement getSix() {
        return findChildByType(YANG_SIX);
    }

    @Override
    @Nullable
    public PsiElement getThree() {
        return findChildByType(YANG_THREE);
    }

    @Override
    @Nullable
    public PsiElement getTwo() {
        return findChildByType(YANG_TWO);
    }

    @Override
    @Nullable
    public PsiElement getZero() {
        return findChildByType(YANG_ZERO);
    }

}
