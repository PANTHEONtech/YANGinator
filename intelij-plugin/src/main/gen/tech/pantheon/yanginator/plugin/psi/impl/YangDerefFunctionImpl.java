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
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangDerefFunction;
import tech.pantheon.yanginator.plugin.psi.YangDerefKeyword;
import tech.pantheon.yanginator.plugin.psi.YangFalseKeyword;
import tech.pantheon.yanginator.plugin.psi.YangFunctionBodyEnd;
import tech.pantheon.yanginator.plugin.psi.YangFunctionBodyNode;
import tech.pantheon.yanginator.plugin.psi.YangFunctionBodyStart;
import tech.pantheon.yanginator.plugin.psi.YangPathArg;
import tech.pantheon.yanginator.plugin.psi.YangSchemaNodeid;
import tech.pantheon.yanginator.plugin.psi.YangStringSplitter;
import tech.pantheon.yanginator.plugin.psi.YangTrueKeyword;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_EQUALS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_FORWARD_SLASH;

public class YangDerefFunctionImpl extends YangNamedElementImpl implements YangDerefFunction {

    public YangDerefFunctionImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitDerefFunction(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public YangDerefKeyword getDerefKeyword() {
        return findNotNullChildByClass(YangDerefKeyword.class);
    }

    @Override
    @Nullable
    public YangFalseKeyword getFalseKeyword() {
        return findChildByClass(YangFalseKeyword.class);
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

    @Override
    @Nullable
    public YangPathArg getPathArg() {
        return findChildByClass(YangPathArg.class);
    }

    @Override
    @Nullable
    public YangSchemaNodeid getSchemaNodeid() {
        return findChildByClass(YangSchemaNodeid.class);
    }

    @Override
    @NotNull
    public List<YangStringSplitter> getStringSplitterList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStringSplitter.class);
    }

    @Override
    @Nullable
    public YangTrueKeyword getTrueKeyword() {
        return findChildByClass(YangTrueKeyword.class);
    }

    @Override
    @Nullable
    public PsiElement getEquals() {
        return findChildByType(YANG_EQUALS);
    }

    @Override
    @Nullable
    public PsiElement getForwardSlash() {
        return findChildByType(YANG_FORWARD_SLASH);
    }

}
