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
import tech.pantheon.yanginator.plugin.psi.YangDquote;
import tech.pantheon.yanginator.plugin.psi.YangQuotedXpathFunction;
import tech.pantheon.yanginator.plugin.psi.YangSquote;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangXPathFunction;

import java.util.List;

public class YangQuotedXpathFunctionImpl extends YangNamedElementImpl implements YangQuotedXpathFunction {

    public YangQuotedXpathFunctionImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitQuotedXpathFunction(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<YangDquote> getDquoteList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangDquote.class);
    }

    @Override
    @NotNull
    public List<YangSquote> getSquoteList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangSquote.class);
    }

    @Override
    @NotNull
    public List<YangXPathFunction> getXPathFunctionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangXPathFunction.class);
    }

}
