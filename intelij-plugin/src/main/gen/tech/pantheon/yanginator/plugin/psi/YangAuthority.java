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
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface YangAuthority extends YangNamedElement {

    @NotNull
    YangHost getHost();

    @Nullable
    YangPort getPort();

    @Nullable
    YangUserinfo getUserinfo();

    @Nullable
    PsiElement getAtSign();

    @Nullable
    PsiElement getColon();

}
