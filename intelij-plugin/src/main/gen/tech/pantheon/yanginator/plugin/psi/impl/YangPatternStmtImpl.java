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
import tech.pantheon.yanginator.plugin.psi.YangPatternBody;
import tech.pantheon.yanginator.plugin.psi.YangPatternKeyword;
import tech.pantheon.yanginator.plugin.psi.YangPatternStmt;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangPatternStmtImpl extends YangYangStmtImpl implements YangPatternStmt {

    public YangPatternStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitPatternStmt(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public YangPatternBody getPatternBody() {
        return findNotNullChildByClass(YangPatternBody.class);
    }

    @Override
    @NotNull
    public YangPatternKeyword getPatternKeyword() {
        return findNotNullChildByClass(YangPatternKeyword.class);
    }

    @Override
    @NotNull
    public YangSep getSep() {
        return findNotNullChildByClass(YangSep.class);
    }

}
