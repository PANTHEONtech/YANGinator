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
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangOptsep;
import tech.pantheon.yanginator.plugin.psi.YangRangeArg;
import tech.pantheon.yanginator.plugin.psi.YangRangePart;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangRangeArgImpl extends YangNamedElementImpl implements YangRangeArg {

    public YangRangeArgImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitRangeArg(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<YangOptsep> getOptsepList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangOptsep.class);
    }

    @Override
    @NotNull
    public List<YangRangePart> getRangePartList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangRangePart.class);
    }

}
