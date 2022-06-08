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
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangAugmentArgStr;
import tech.pantheon.yanginator.plugin.psi.YangAugmentKeyword;
import tech.pantheon.yanginator.plugin.psi.YangAugmentStmt;
import tech.pantheon.yanginator.plugin.psi.YangOptsep;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtsep;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_BRACE;

public class YangAugmentStmtImpl extends YangYangStmtImpl implements YangAugmentStmt {

    public YangAugmentStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitAugmentStmt(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public YangAugmentArgStr getAugmentArgStr() {
        return findNotNullChildByClass(YangAugmentArgStr.class);
    }

    @Override
    @NotNull
    public YangAugmentKeyword getAugmentKeyword() {
        return findNotNullChildByClass(YangAugmentKeyword.class);
    }

    @Override
    @NotNull
    public YangOptsep getOptsep() {
        return findNotNullChildByClass(YangOptsep.class);
    }

    @Override
    @NotNull
    public YangSep getSep() {
        return findNotNullChildByClass(YangSep.class);
    }

    @Override
    @NotNull
    public List<YangStmtsep> getStmtsepList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStmtsep.class);
    }

    @Override
    @NotNull
    public PsiElement getLeftBrace() {
        return findNotNullChildByType(YANG_LEFT_BRACE);
    }

    @Override
    @NotNull
    public PsiElement getRightBrace() {
        return findNotNullChildByType(YANG_RIGHT_BRACE);
    }

}
