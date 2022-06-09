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
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangNamespaceKeyword;
import tech.pantheon.yanginator.plugin.psi.YangNamespaceStmt;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtend;
import tech.pantheon.yanginator.plugin.psi.YangUriStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangNamespaceStmtImpl extends YangYangStmtImpl implements YangNamespaceStmt {

    public YangNamespaceStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitNamespaceStmt(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public YangNamespaceKeyword getNamespaceKeyword() {
        return findNotNullChildByClass(YangNamespaceKeyword.class);
    }

    @Override
    @NotNull
    public YangSep getSep() {
        return findNotNullChildByClass(YangSep.class);
    }

    @Override
    @NotNull
    public YangStmtend getStmtend() {
        return findNotNullChildByClass(YangStmtend.class);
    }

    @Override
    @NotNull
    public YangUriStr getUriStr() {
        return findNotNullChildByClass(YangUriStr.class);
    }

}
