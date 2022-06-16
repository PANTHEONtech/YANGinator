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
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtend;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangYangVersionArgStr;
import tech.pantheon.yanginator.plugin.psi.YangYangVersionKeyword;
import tech.pantheon.yanginator.plugin.psi.YangYangVersionStmt;

public class YangYangVersionStmtImpl extends YangYangStmtImpl implements YangYangVersionStmt {

    public YangYangVersionStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitYangVersionStmt(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public YangSep getSep() {
        return findChildByClass(YangSep.class);
    }

    @Override
    @Nullable
    public YangStmtend getStmtend() {
        return findChildByClass(YangStmtend.class);
    }

    @Override
    @Nullable
    public YangYangVersionArgStr getYangVersionArgStr() {
        return findChildByClass(YangYangVersionArgStr.class);
    }

    @Override
    @NotNull
    public YangYangVersionKeyword getYangVersionKeyword() {
        return findNotNullChildByClass(YangYangVersionKeyword.class);
    }

}
