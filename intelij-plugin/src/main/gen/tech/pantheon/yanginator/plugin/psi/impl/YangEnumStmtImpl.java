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
import tech.pantheon.yanginator.plugin.psi.YangEnumKeyword;
import tech.pantheon.yanginator.plugin.psi.YangEnumStmt;
import tech.pantheon.yanginator.plugin.psi.YangOptsep;
import tech.pantheon.yanginator.plugin.psi.YangQuotedString;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtsep;
import tech.pantheon.yanginator.plugin.psi.YangString;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SEMICOLON;

public class YangEnumStmtImpl extends YangYangStmtImpl implements YangEnumStmt {

    public YangEnumStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitEnumStmt(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public YangEnumKeyword getEnumKeyword() {
        return findNotNullChildByClass(YangEnumKeyword.class);
    }

    @Override
    @Nullable
    public YangOptsep getOptsep() {
        return findChildByClass(YangOptsep.class);
    }

    @Override
    @Nullable
    public YangQuotedString getQuotedString() {
        return findChildByClass(YangQuotedString.class);
    }

    @Override
    @Nullable
    public YangSep getSep() {
        return findChildByClass(YangSep.class);
    }

    @Override
    @NotNull
    public List<YangStmtsep> getStmtsepList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStmtsep.class);
    }

    @Override
    @Nullable
    public YangString getString() {
        return findChildByClass(YangString.class);
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
