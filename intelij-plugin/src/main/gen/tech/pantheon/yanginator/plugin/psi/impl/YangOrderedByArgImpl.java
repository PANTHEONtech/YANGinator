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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangOrderedByArg;
import tech.pantheon.yanginator.plugin.psi.YangSystemKeyword;
import tech.pantheon.yanginator.plugin.psi.YangUserKeyword;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangOrderedByArgImpl extends YangNamedElementImpl implements YangOrderedByArg {

    public YangOrderedByArgImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitOrderedByArg(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public YangSystemKeyword getSystemKeyword() {
        return findChildByClass(YangSystemKeyword.class);
    }

    @Override
    @Nullable
    public YangUserKeyword getUserKeyword() {
        return findChildByClass(YangUserKeyword.class);
    }

}
