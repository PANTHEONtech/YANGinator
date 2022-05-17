/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.reference;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierArgStr;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierRefArgStr;
import tech.pantheon.yanginator.plugin.psi.impl.YangNamedElementImpl;

public abstract class YangGeneratedReferenceTypeImpl extends YangNamedElementImpl implements YangReferencedStatement {

    public YangGeneratedReferenceTypeImpl(@NotNull final ASTNode node) {
        super(node);
    }

    @NotNull
    @Override
    public PsiReference [] getReferences() {
        return ReferenceProvidersRegistry.getReferencesFromProviders(this);
    }

    @Override
    @NotNull
    public YangIdentifierArgStr getIdentifierArgStr() {
        return null;
    }

    @Override
    @NotNull
    public YangIdentifierRefArgStr getIdentifierRefArgStr() {
        return null;
    }

}
