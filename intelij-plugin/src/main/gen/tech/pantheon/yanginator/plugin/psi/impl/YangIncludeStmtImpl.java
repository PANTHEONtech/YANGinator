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
import tech.pantheon.yanginator.plugin.psi.YangIdentifierRefArgStr;
import tech.pantheon.yanginator.plugin.psi.YangIncludeKeyword;
import tech.pantheon.yanginator.plugin.psi.YangIncludeStmt;
import tech.pantheon.yanginator.plugin.psi.YangLineBreak;
import tech.pantheon.yanginator.plugin.psi.YangUnknownStatement;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangWsp;
import tech.pantheon.yanginator.plugin.reference.YangGeneratedReferenceTypeImpl;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SEMICOLON;

public class YangIncludeStmtImpl extends YangGeneratedReferenceTypeImpl implements YangIncludeStmt {

    public YangIncludeStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitIncludeStmt(this);
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
    public YangIdentifierRefArgStr getIdentifierRefArgStr() {
        return findChildByClass(YangIdentifierRefArgStr.class);
    }

    @Override
    @NotNull
    public YangIncludeKeyword getIncludeKeyword() {
        return findNotNullChildByClass(YangIncludeKeyword.class);
    }

    @Override
    @NotNull
    public List<YangLineBreak> getLineBreakList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangLineBreak.class);
    }

    @Override
    @NotNull
    public List<YangUnknownStatement> getUnknownStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangUnknownStatement.class);
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
