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
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangComment;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierRefArg;
import tech.pantheon.yanginator.plugin.psi.YangIfFeatureExpr;
import tech.pantheon.yanginator.plugin.psi.YangIfFeatureFactor;
import tech.pantheon.yanginator.plugin.psi.YangLineBreak;
import tech.pantheon.yanginator.plugin.psi.YangNotKeyword;
import tech.pantheon.yanginator.plugin.psi.YangStringSplitter;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangWsp;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_PARENTHESIS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_PARENTHESIS;

public class YangIfFeatureFactorImpl extends YangNamedElementImpl implements YangIfFeatureFactor {

    public YangIfFeatureFactorImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitIfFeatureFactor(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<YangWsp> getWspList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangWsp.class);
    }

    @Override
    @NotNull
    public List<YangComment> getCommentList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangComment.class);
    }

    @Override
    @Nullable
    public YangIdentifierRefArg getIdentifierRefArg() {
        return findChildByClass(YangIdentifierRefArg.class);
    }

    @Override
    @Nullable
    public YangIfFeatureExpr getIfFeatureExpr() {
        return findChildByClass(YangIfFeatureExpr.class);
    }

    @Override
    @Nullable
    public YangIfFeatureFactor getIfFeatureFactor() {
        return findChildByClass(YangIfFeatureFactor.class);
    }

    @Override
    @NotNull
    public List<YangLineBreak> getLineBreakList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangLineBreak.class);
    }

    @Override
    @Nullable
    public YangNotKeyword getNotKeyword() {
        return findChildByClass(YangNotKeyword.class);
    }

    @Override
    @NotNull
    public List<YangStringSplitter> getStringSplitterList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStringSplitter.class);
    }

    @Override
    @Nullable
    public PsiElement getLeftParenthesis() {
        return findChildByType(YANG_LEFT_PARENTHESIS);
    }

    @Override
    @Nullable
    public PsiElement getRightParenthesis() {
        return findChildByType(YANG_RIGHT_PARENTHESIS);
    }

}
