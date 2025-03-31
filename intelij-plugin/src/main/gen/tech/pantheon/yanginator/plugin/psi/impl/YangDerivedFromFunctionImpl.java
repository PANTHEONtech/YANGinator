/*
 *
 *   Copyright (c) 2021-2025 PANTHEON.tech, s.r.o. All rights reserved.
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
import tech.pantheon.yanginator.plugin.psi.YangDerivedFromFunction;
import tech.pantheon.yanginator.plugin.psi.YangDerivedFromKeyword;
import tech.pantheon.yanginator.plugin.psi.YangFunctionBodyNodeIdentity;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangDerivedFromFunctionImpl extends YangNamedElementImpl implements YangDerivedFromFunction {

    public YangDerivedFromFunctionImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitDerivedFromFunction(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public YangDerivedFromKeyword getDerivedFromKeyword() {
        return findNotNullChildByClass(YangDerivedFromKeyword.class);
    }

    @Override
    @NotNull
    public YangFunctionBodyNodeIdentity getFunctionBodyNodeIdentity() {
        return findNotNullChildByClass(YangFunctionBodyNodeIdentity.class);
    }

}
