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
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangDecimalValue;
import tech.pantheon.yanginator.plugin.psi.YangIntegerValue;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangZeroIntegerValue;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOT;

public class YangDecimalValueImpl extends YangNamedElementImpl implements YangDecimalValue {

    public YangDecimalValueImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitDecimalValue(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public YangIntegerValue getIntegerValue() {
        return findNotNullChildByClass(YangIntegerValue.class);
    }

    @Override
    @NotNull
    public YangZeroIntegerValue getZeroIntegerValue() {
        return findNotNullChildByClass(YangZeroIntegerValue.class);
    }

    @Override
    @NotNull
    public PsiElement getDot() {
        return findNotNullChildByType(YANG_DOT);
    }

}
