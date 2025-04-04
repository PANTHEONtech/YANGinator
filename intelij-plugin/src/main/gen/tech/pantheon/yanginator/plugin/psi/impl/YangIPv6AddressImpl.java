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
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangH16;
import tech.pantheon.yanginator.plugin.psi.YangIPv6Address;
import tech.pantheon.yanginator.plugin.psi.YangLs32;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOUBLE_COLON;

public class YangIPv6AddressImpl extends YangNamedElementImpl implements YangIPv6Address {

    public YangIPv6AddressImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitIPv6Address(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<YangH16> getH16List() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangH16.class);
    }

    @Override
    @Nullable
    public YangLs32 getLs32() {
        return findChildByClass(YangLs32.class);
    }

    @Override
    @Nullable
    public PsiElement getDoubleColon() {
        return findChildByType(YANG_DOUBLE_COLON);
    }

}
