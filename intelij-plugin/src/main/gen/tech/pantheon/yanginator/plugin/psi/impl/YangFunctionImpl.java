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
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangBitIsSetFunction;
import tech.pantheon.yanginator.plugin.psi.YangDerefFunction;
import tech.pantheon.yanginator.plugin.psi.YangDerivedFromFunction;
import tech.pantheon.yanginator.plugin.psi.YangDerivedFromOrSelfFunction;
import tech.pantheon.yanginator.plugin.psi.YangEnumValueFunction;
import tech.pantheon.yanginator.plugin.psi.YangFunction;
import tech.pantheon.yanginator.plugin.psi.YangRematchFunction;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangFunctionImpl extends YangNamedElementImpl implements YangFunction {

    public YangFunctionImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitFunction(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<YangBitIsSetFunction> getBitIsSetFunctionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangBitIsSetFunction.class);
    }

    @Override
    @NotNull
    public List<YangDerefFunction> getDerefFunctionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangDerefFunction.class);
    }

    @Override
    @NotNull
    public List<YangDerivedFromFunction> getDerivedFromFunctionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangDerivedFromFunction.class);
    }

    @Override
    @NotNull
    public List<YangDerivedFromOrSelfFunction> getDerivedFromOrSelfFunctionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangDerivedFromOrSelfFunction.class);
    }

    @Override
    @NotNull
    public List<YangEnumValueFunction> getEnumValueFunctionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangEnumValueFunction.class);
    }

    @Override
    @NotNull
    public List<YangRematchFunction> getRematchFunctionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangRematchFunction.class);
    }

}
