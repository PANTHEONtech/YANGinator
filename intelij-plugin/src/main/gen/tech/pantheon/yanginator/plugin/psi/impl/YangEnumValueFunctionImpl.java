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
import tech.pantheon.yanginator.plugin.psi.YangEnumValueFunction;
import tech.pantheon.yanginator.plugin.psi.YangEnumValueKeyword;
import tech.pantheon.yanginator.plugin.psi.YangFunctionBodyEnd;
import tech.pantheon.yanginator.plugin.psi.YangFunctionBodyNode;
import tech.pantheon.yanginator.plugin.psi.YangFunctionBodyStart;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangEnumValueFunctionImpl extends YangNamedElementImpl implements YangEnumValueFunction {

    public YangEnumValueFunctionImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitEnumValueFunction(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public YangEnumValueKeyword getEnumValueKeyword() {
        return findNotNullChildByClass(YangEnumValueKeyword.class);
    }

    @Override
    @NotNull
    public YangFunctionBodyEnd getFunctionBodyEnd() {
        return findNotNullChildByClass(YangFunctionBodyEnd.class);
    }

    @Override
    @NotNull
    public YangFunctionBodyNode getFunctionBodyNode() {
        return findNotNullChildByClass(YangFunctionBodyNode.class);
    }

    @Override
    @NotNull
    public YangFunctionBodyStart getFunctionBodyStart() {
        return findNotNullChildByClass(YangFunctionBodyStart.class);
    }

}
