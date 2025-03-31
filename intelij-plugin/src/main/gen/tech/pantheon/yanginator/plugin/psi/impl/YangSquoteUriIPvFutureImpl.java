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
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangSquoteUriIPvFuture;
import tech.pantheon.yanginator.plugin.psi.YangSquoteUriSubDelims;
import tech.pantheon.yanginator.plugin.psi.YangUnreserved;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOT;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_VERSION;

public class YangSquoteUriIPvFutureImpl extends YangNamedElementImpl implements YangSquoteUriIPvFuture {

    public YangSquoteUriIPvFutureImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitSquoteUriIPvFuture(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<YangSquoteUriSubDelims> getSquoteUriSubDelimsList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangSquoteUriSubDelims.class);
    }

    @Override
    @NotNull
    public List<YangUnreserved> getUnreservedList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangUnreserved.class);
    }

    @Override
    @NotNull
    public PsiElement getDot() {
        return findNotNullChildByType(YANG_DOT);
    }

    @Override
    @NotNull
    public PsiElement getVersion() {
        return findNotNullChildByType(YANG_VERSION);
    }

}
