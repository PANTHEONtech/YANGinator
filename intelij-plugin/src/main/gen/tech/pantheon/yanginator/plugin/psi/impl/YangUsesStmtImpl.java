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
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierRefArgStr;
import tech.pantheon.yanginator.plugin.psi.YangOptsep;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtsep;
import tech.pantheon.yanginator.plugin.psi.YangUsesKeyword;
import tech.pantheon.yanginator.plugin.psi.YangUsesStmt;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.reference.YangGeneratedReferenceTypeImpl;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SEMICOLON;

public class YangUsesStmtImpl extends YangGeneratedReferenceTypeImpl implements YangUsesStmt {

    public YangUsesStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitUsesStmt(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public YangIdentifierRefArgStr getIdentifierRefArgStr() {
        return findNotNullChildByClass(YangIdentifierRefArgStr.class);
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
    public YangUsesKeyword getUsesKeyword() {
        return findNotNullChildByClass(YangUsesKeyword.class);
    }

    @Override
    @Nullable
    public PsiElement getLeftBrace() {
        return findChildByType(YANG_LEFT_BRACE);
    }

    @Override
    @Nullable
    public PsiElement getRightBrace() {
        return findChildByType(YANG_RIGHT_BRACE);
    }

    @Override
    @Nullable
    public PsiElement getSemicolon() {
        return findChildByType(YANG_SEMICOLON);
    }

}
