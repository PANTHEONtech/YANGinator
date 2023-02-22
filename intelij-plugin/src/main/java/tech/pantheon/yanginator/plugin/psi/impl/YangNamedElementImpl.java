/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangNamedElement;

public abstract class YangNamedElementImpl extends ASTWrapperPsiElement implements YangNamedElement {
    public YangNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
