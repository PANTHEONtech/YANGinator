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
import tech.pantheon.yanginator.plugin.psi.YangErrorMessageKeyword;
import tech.pantheon.yanginator.plugin.psi.YangErrorMessageStmt;
import tech.pantheon.yanginator.plugin.psi.YangQuotedString;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtend;
import tech.pantheon.yanginator.plugin.psi.YangString;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangErrorMessageStmtImpl extends YangYangStmtImpl implements YangErrorMessageStmt {

    public YangErrorMessageStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitErrorMessageStmt(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public YangErrorMessageKeyword getErrorMessageKeyword() {
        return findNotNullChildByClass(YangErrorMessageKeyword.class);
    }

    @Override
    @Nullable
    public YangQuotedString getQuotedString() {
        return findChildByClass(YangQuotedString.class);
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
    @Nullable
    public YangString getString() {
        return findChildByClass(YangString.class);
    }

}
