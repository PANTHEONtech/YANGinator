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
import tech.pantheon.yanginator.plugin.psi.YangScheme;
import tech.pantheon.yanginator.plugin.psi.YangSquoteUri;
import tech.pantheon.yanginator.plugin.psi.YangSquoteUriHierPart;
import tech.pantheon.yanginator.plugin.psi.YangSquoteUriQuery;
import tech.pantheon.yanginator.plugin.psi.YangSquoteUrifragment;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_COLON;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_HASH;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_QUESTION_MARK;

public class YangSquoteUriImpl extends YangNamedElementImpl implements YangSquoteUri {

    public YangSquoteUriImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitSquoteUri(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public YangSquoteUriHierPart getSquoteUriHierPart() {
        return findNotNullChildByClass(YangSquoteUriHierPart.class);
    }

    @Override
    @Nullable
    public YangSquoteUriQuery getSquoteUriQuery() {
        return findChildByClass(YangSquoteUriQuery.class);
    }

    @Override
    @Nullable
    public YangSquoteUrifragment getSquoteUrifragment() {
        return findChildByClass(YangSquoteUrifragment.class);
    }

    @Override
    @NotNull
    public YangScheme getScheme() {
        return findNotNullChildByClass(YangScheme.class);
    }

    @Override
    @NotNull
    public PsiElement getColon() {
        return findNotNullChildByType(YANG_COLON);
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
