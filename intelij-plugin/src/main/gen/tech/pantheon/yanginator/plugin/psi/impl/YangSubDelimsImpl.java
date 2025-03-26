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
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangSubDelims;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_AMPERSAND;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ASTERISK;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_COMMA;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOLLAR_SIGN;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_EQUALS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_EXCLAMATION_MARK;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_PARENTHESIS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_PLUS_SIGN;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_PARENTHESIS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SINGLE_QUOTE;

public class YangSubDelimsImpl extends YangNamedElementImpl implements YangSubDelims {

    public YangSubDelimsImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitSubDelims(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public PsiElement getAmpersand() {
        return findChildByType(YANG_AMPERSAND);
    }

    @Override
    @Nullable
    public PsiElement getAsterisk() {
        return findChildByType(YANG_ASTERISK);
    }

    @Override
    @Nullable
    public PsiElement getComma() {
        return findChildByType(YANG_COMMA);
    }

    @Override
    @Nullable
    public PsiElement getDollarSign() {
        return findChildByType(YANG_DOLLAR_SIGN);
    }

    @Override
    @Nullable
    public PsiElement getEquals() {
        return findChildByType(YANG_EQUALS);
    }

    @Override
    @Nullable
    public PsiElement getExclamationMark() {
        return findChildByType(YANG_EXCLAMATION_MARK);
    }

    @Override
    @Nullable
    public PsiElement getLeftParenthesis() {
        return findChildByType(YANG_LEFT_PARENTHESIS);
    }

    @Override
    @Nullable
    public PsiElement getPlusSign() {
        return findChildByType(YANG_PLUS_SIGN);
    }

    @Override
    @Nullable
    public PsiElement getRightParenthesis() {
        return findChildByType(YANG_RIGHT_PARENTHESIS);
    }

    @Override
    @Nullable
    public PsiElement getSingleQuote() {
        return findChildByType(YANG_SINGLE_QUOTE);
    }

}
