/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
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
import tech.pantheon.yanginator.plugin.psi.YangLengthBoundary;
import tech.pantheon.yanginator.plugin.psi.YangMaxKeyword;
import tech.pantheon.yanginator.plugin.psi.YangMinKeyword;
import tech.pantheon.yanginator.plugin.psi.YangNonNegativeIntegerValue;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangLengthBoundaryImpl extends YangNamedElementImpl implements YangLengthBoundary {

    public YangLengthBoundaryImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitLengthBoundary(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public YangMaxKeyword getMaxKeyword() {
        return findChildByClass(YangMaxKeyword.class);
    }

    @Override
    @Nullable
    public YangMinKeyword getMinKeyword() {
        return findChildByClass(YangMinKeyword.class);
    }

    @Override
    @Nullable
    public YangNonNegativeIntegerValue getNonNegativeIntegerValue() {
        return findChildByClass(YangNonNegativeIntegerValue.class);
    }

}
