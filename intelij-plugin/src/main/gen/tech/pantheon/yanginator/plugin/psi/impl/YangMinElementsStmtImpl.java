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
import tech.pantheon.yanginator.plugin.psi.YangMinElementsKeyword;
import tech.pantheon.yanginator.plugin.psi.YangMinElementsStmt;
import tech.pantheon.yanginator.plugin.psi.YangMinValueArgStr;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtend;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangMinElementsStmtImpl extends YangYangStmtImpl implements YangMinElementsStmt {

    public YangMinElementsStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitMinElementsStmt(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public YangMinElementsKeyword getMinElementsKeyword() {
        return findNotNullChildByClass(YangMinElementsKeyword.class);
    }

    @Override
    @NotNull
    public YangMinValueArgStr getMinValueArgStr() {
        return findNotNullChildByClass(YangMinValueArgStr.class);
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

}
