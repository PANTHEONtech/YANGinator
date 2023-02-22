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
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangBaseStmt;
import tech.pantheon.yanginator.plugin.psi.YangGroupingStmt;
import tech.pantheon.yanginator.plugin.psi.YangIdentityStmt;
import tech.pantheon.yanginator.plugin.psi.YangTypeStmt;
import tech.pantheon.yanginator.plugin.psi.YangTypedefStmt;
import tech.pantheon.yanginator.plugin.psi.YangUsesStmt;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangYangStmt;

public class YangYangStmtImpl extends YangNamedElementImpl implements YangYangStmt {

    public YangYangStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitYangStmt(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public YangBaseStmt getBaseStmt() {
        return findChildByClass(YangBaseStmt.class);
    }

    @Override
    @Nullable
    public YangGroupingStmt getGroupingStmt() {
        return findChildByClass(YangGroupingStmt.class);
    }

    @Override
    @Nullable
    public YangIdentityStmt getIdentityStmt() {
        return findChildByClass(YangIdentityStmt.class);
    }

    @Override
    @Nullable
    public YangTypeStmt getTypeStmt() {
        return findChildByClass(YangTypeStmt.class);
    }

    @Override
    @Nullable
    public YangTypedefStmt getTypedefStmt() {
        return findChildByClass(YangTypedefStmt.class);
    }

    @Override
    @Nullable
    public YangUsesStmt getUsesStmt() {
        return findChildByClass(YangUsesStmt.class);
    }

}
