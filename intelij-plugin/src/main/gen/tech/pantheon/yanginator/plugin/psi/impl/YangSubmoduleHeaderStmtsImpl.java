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
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangStmtsep;
import tech.pantheon.yanginator.plugin.psi.YangSubmoduleHeaderStmts;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangYangStmt;

import java.util.List;

public class YangSubmoduleHeaderStmtsImpl extends YangNamedElementImpl implements YangSubmoduleHeaderStmts {

    public YangSubmoduleHeaderStmtsImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitSubmoduleHeaderStmts(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<YangStmtsep> getStmtsepList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStmtsep.class);
    }

    @Override
    @NotNull
    public List<YangYangStmt> getYangStmtList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangYangStmt.class);
    }

}
