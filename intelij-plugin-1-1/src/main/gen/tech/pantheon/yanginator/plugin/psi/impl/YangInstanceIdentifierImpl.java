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
import tech.pantheon.yanginator.plugin.psi.YangInstanceIdentifier;
import tech.pantheon.yanginator.plugin.psi.YangKeyPredicate;
import tech.pantheon.yanginator.plugin.psi.YangLeafListPredicate;
import tech.pantheon.yanginator.plugin.psi.YangNodeIdentifier;
import tech.pantheon.yanginator.plugin.psi.YangPos;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangInstanceIdentifierImpl extends YangNamedElementImpl implements YangInstanceIdentifier {

    public YangInstanceIdentifierImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitInstanceIdentifier(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<YangKeyPredicate> getKeyPredicateList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangKeyPredicate.class);
    }

    @Override
    @NotNull
    public List<YangLeafListPredicate> getLeafListPredicateList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangLeafListPredicate.class);
    }

    @Override
    @NotNull
    public List<YangNodeIdentifier> getNodeIdentifierList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangNodeIdentifier.class);
    }

    @Override
    @NotNull
    public List<YangPos> getPosList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangPos.class);
    }

}
