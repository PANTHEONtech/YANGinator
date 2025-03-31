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
import tech.pantheon.yanginator.plugin.psi.YangPort;
import tech.pantheon.yanginator.plugin.psi.YangSquoteUriAuthority;
import tech.pantheon.yanginator.plugin.psi.YangSquoteUriHost;
import tech.pantheon.yanginator.plugin.psi.YangSquoteUriUserinfo;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_AT_SIGN;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_COLON;

public class YangSquoteUriAuthorityImpl extends YangNamedElementImpl implements YangSquoteUriAuthority {

    public YangSquoteUriAuthorityImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitSquoteUriAuthority(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public YangSquoteUriHost getSquoteUriHost() {
        return findNotNullChildByClass(YangSquoteUriHost.class);
    }

    @Override
    @Nullable
    public YangSquoteUriUserinfo getSquoteUriUserinfo() {
        return findChildByClass(YangSquoteUriUserinfo.class);
    }

    @Override
    @Nullable
    public YangPort getPort() {
        return findChildByClass(YangPort.class);
    }

    @Override
    @Nullable
    public PsiElement getAtSign() {
        return findChildByType(YANG_AT_SIGN);
    }

    @Override
    @Nullable
    public PsiElement getColon() {
        return findChildByType(YANG_COLON);
    }

}
