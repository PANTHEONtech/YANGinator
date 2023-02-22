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
package tech.pantheon.yanginator.plugin.highlighter.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.highlighter.psi.YangStmt;
import tech.pantheon.yanginator.plugin.highlighter.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.highlighter.psi.YangWsp;
import tech.pantheon.yanginator.plugin.psi.impl.YangNamedElementImpl;

import java.util.List;

import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_IDENTIFIER;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_SEMICOLON;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_STRING;

public class YangStmtImpl extends YangNamedElementImpl implements YangStmt {

    public YangStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitStmt(this);
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
    public PsiElement getHIdentifier() {
        return findNotNullChildByType(YANG_H_IDENTIFIER);
    }

    @Override
    @NotNull
    public PsiElement getHSemicolon() {
        return findNotNullChildByType(YANG_H_SEMICOLON);
    }

    @Override
    @NotNull
    public PsiElement getHString() {
        return findNotNullChildByType(YANG_H_STRING);
    }

}
