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
import tech.pantheon.yanginator.plugin.psi.YangGenDelims;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_AT_SIGN;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_CLOSED_BRACKET;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_COLON;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_FORWARD_SLASH;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_HASH;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_OPEN_BRACKET;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_QUESTION_MARK;

public class YangGenDelimsImpl extends YangNamedElementImpl implements YangGenDelims {

    public YangGenDelimsImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitGenDelims(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) {
            accept((YangVisitor) visitor);
        } else {
            super.accept(visitor);
        }
    }

    @Override
    @Nullable
    public PsiElement getAtSign() {
        return findChildByType(YANG_AT_SIGN);
    }

    @Override
    @Nullable
    public PsiElement getClosedBracket() {
        return findChildByType(YANG_CLOSED_BRACKET);
    }

    @Override
    @Nullable
    public PsiElement getColon() {
        return findChildByType(YANG_COLON);
    }

    @Override
    @Nullable
    public PsiElement getForwardSlash() {
        return findChildByType(YANG_FORWARD_SLASH);
    }

    @Override
    @Nullable
    public PsiElement getHash() {
        return findChildByType(YANG_HASH);
    }

    @Override
    @Nullable
    public PsiElement getOpenBracket() {
        return findChildByType(YANG_OPEN_BRACKET);
    }

    @Override
    @Nullable
    public PsiElement getQuestionMark() {
        return findChildByType(YANG_QUESTION_MARK);
    }

}
