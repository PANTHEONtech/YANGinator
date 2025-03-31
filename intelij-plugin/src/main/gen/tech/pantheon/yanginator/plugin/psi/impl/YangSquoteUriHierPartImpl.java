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
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangDoubleForwardSlash;
import tech.pantheon.yanginator.plugin.psi.YangPathEmpty;
import tech.pantheon.yanginator.plugin.psi.YangSquoteUriAuthority;
import tech.pantheon.yanginator.plugin.psi.YangSquoteUriHierPart;
import tech.pantheon.yanginator.plugin.psi.YangSquoteUriPathAbempty;
import tech.pantheon.yanginator.plugin.psi.YangSquoteUriPathAbsolute;
import tech.pantheon.yanginator.plugin.psi.YangSquoteUriPathRootless;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangSquoteUriHierPartImpl extends YangNamedElementImpl implements YangSquoteUriHierPart {

    public YangSquoteUriHierPartImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitSquoteUriHierPart(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public YangDoubleForwardSlash getDoubleForwardSlash() {
        return findChildByClass(YangDoubleForwardSlash.class);
    }

    @Override
    @Nullable
    public YangSquoteUriAuthority getSquoteUriAuthority() {
        return findChildByClass(YangSquoteUriAuthority.class);
    }

    @Override
    @Nullable
    public YangSquoteUriPathAbempty getSquoteUriPathAbempty() {
        return findChildByClass(YangSquoteUriPathAbempty.class);
    }

    @Override
    @Nullable
    public YangSquoteUriPathAbsolute getSquoteUriPathAbsolute() {
        return findChildByClass(YangSquoteUriPathAbsolute.class);
    }

    @Override
    @Nullable
    public YangSquoteUriPathRootless getSquoteUriPathRootless() {
        return findChildByClass(YangSquoteUriPathRootless.class);
    }

    @Override
    @Nullable
    public YangPathEmpty getPathEmpty() {
        return findChildByClass(YangPathEmpty.class);
    }

}
