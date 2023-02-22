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
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangFragment;
import tech.pantheon.yanginator.plugin.psi.YangQuery;
import tech.pantheon.yanginator.plugin.psi.YangRelativePart;
import tech.pantheon.yanginator.plugin.psi.YangRelativeRef;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_HASH;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_QUESTION_MARK;

public class YangRelativeRefImpl extends YangNamedElementImpl implements YangRelativeRef {

    public YangRelativeRefImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitRelativeRef(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public YangFragment getFragment() {
        return findChildByClass(YangFragment.class);
    }

    @Override
    @Nullable
    public YangQuery getQuery() {
        return findChildByClass(YangQuery.class);
    }

    @Override
    @NotNull
    public YangRelativePart getRelativePart() {
        return findNotNullChildByClass(YangRelativePart.class);
    }

    @Override
    @Nullable
    public PsiElement getHash() {
        return findChildByType(YANG_HASH);
    }

    @Override
    @Nullable
    public PsiElement getQuestionMark() {
        return findChildByType(YANG_QUESTION_MARK);
    }

}
