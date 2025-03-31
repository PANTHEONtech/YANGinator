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
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangIPv6Address;
import tech.pantheon.yanginator.plugin.psi.YangSquoteUriIPLiteral;
import tech.pantheon.yanginator.plugin.psi.YangSquoteUriIPvFuture;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_CLOSED_BRACKET;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_OPEN_BRACKET;

public class YangSquoteUriIPLiteralImpl extends YangNamedElementImpl implements YangSquoteUriIPLiteral {

    public YangSquoteUriIPLiteralImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitSquoteUriIPLiteral(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public YangIPv6Address getIPv6Address() {
        return findChildByClass(YangIPv6Address.class);
    }

    @Override
    @Nullable
    public YangSquoteUriIPvFuture getSquoteUriIPvFuture() {
        return findChildByClass(YangSquoteUriIPvFuture.class);
    }

    @Override
    @NotNull
    public PsiElement getClosedBracket() {
        return findNotNullChildByType(YANG_CLOSED_BRACKET);
    }

    @Override
    @NotNull
    public PsiElement getOpenBracket() {
        return findNotNullChildByType(YANG_OPEN_BRACKET);
    }

}
