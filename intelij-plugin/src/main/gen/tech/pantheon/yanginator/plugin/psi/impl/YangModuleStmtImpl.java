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
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangBodyStmts;
import tech.pantheon.yanginator.plugin.psi.YangComment;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierArgStr;
import tech.pantheon.yanginator.plugin.psi.YangLineBreak;
import tech.pantheon.yanginator.plugin.psi.YangLinkageStmts;
import tech.pantheon.yanginator.plugin.psi.YangMetaStmts;
import tech.pantheon.yanginator.plugin.psi.YangModuleHeaderStmts;
import tech.pantheon.yanginator.plugin.psi.YangModuleKeyword;
import tech.pantheon.yanginator.plugin.psi.YangModuleStmt;
import tech.pantheon.yanginator.plugin.psi.YangRevisionStmt;
import tech.pantheon.yanginator.plugin.psi.YangUnknownStatement;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangWsp;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_BRACE;

public class YangModuleStmtImpl extends YangYangStmtImpl implements YangModuleStmt {

    public YangModuleStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitModuleStmt(this);
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
    @Nullable
    public YangBodyStmts getBodyStmts() {
        return findChildByClass(YangBodyStmts.class);
    }

    @Override
    @NotNull
    public List<YangComment> getCommentList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangComment.class);
    }

    @Override
    @Nullable
    public YangIdentifierArgStr getIdentifierArgStr() {
        return findChildByClass(YangIdentifierArgStr.class);
    }

    @Override
    @NotNull
    public List<YangLineBreak> getLineBreakList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangLineBreak.class);
    }

    @Override
    @Nullable
    public YangLinkageStmts getLinkageStmts() {
        return findChildByClass(YangLinkageStmts.class);
    }

    @Override
    @Nullable
    public YangMetaStmts getMetaStmts() {
        return findChildByClass(YangMetaStmts.class);
    }

    @Override
    @Nullable
    public YangModuleHeaderStmts getModuleHeaderStmts() {
        return findChildByClass(YangModuleHeaderStmts.class);
    }

    @Override
    @NotNull
    public YangModuleKeyword getModuleKeyword() {
        return findNotNullChildByClass(YangModuleKeyword.class);
    }

    @Override
    @NotNull
    public List<YangRevisionStmt> getRevisionStmtList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangRevisionStmt.class);
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

}
