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
import tech.pantheon.yanginator.plugin.psi.YangIdentifier;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierRef;
import tech.pantheon.yanginator.plugin.psi.YangPrefix;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_COLON;

public class YangIdentifierRefImpl extends YangNamedElementImpl implements YangIdentifierRef {

    public YangIdentifierRefImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitIdentifierRef(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public YangIdentifier getIdentifier() {
        return findNotNullChildByClass(YangIdentifier.class);
    }

    @Override
    @Nullable
    public YangPrefix getPrefix() {
        return findChildByClass(YangPrefix.class);
    }

    @Override
    @Nullable
    public PsiElement getColon() {
        return findChildByType(YANG_COLON);
    }

}
