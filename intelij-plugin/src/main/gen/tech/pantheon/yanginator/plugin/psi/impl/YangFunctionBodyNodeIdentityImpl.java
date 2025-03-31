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
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangFunctionBodyEnd;
import tech.pantheon.yanginator.plugin.psi.YangFunctionBodyIdentity;
import tech.pantheon.yanginator.plugin.psi.YangFunctionBodyNode;
import tech.pantheon.yanginator.plugin.psi.YangFunctionBodyNodeIdentity;
import tech.pantheon.yanginator.plugin.psi.YangFunctionBodyStart;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangWsp;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_COMMA;

public class YangFunctionBodyNodeIdentityImpl extends YangNamedElementImpl implements YangFunctionBodyNodeIdentity {

    public YangFunctionBodyNodeIdentityImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitFunctionBodyNodeIdentity(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<YangWsp> getWspList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangWsp.class);
    }

    @Override
    @NotNull
    public YangFunctionBodyEnd getFunctionBodyEnd() {
        return findNotNullChildByClass(YangFunctionBodyEnd.class);
    }

    @Override
    @NotNull
    public YangFunctionBodyIdentity getFunctionBodyIdentity() {
        return findNotNullChildByClass(YangFunctionBodyIdentity.class);
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

    @Override
    @NotNull
    public PsiElement getComma() {
        return findNotNullChildByType(YANG_COMMA);
    }

}
