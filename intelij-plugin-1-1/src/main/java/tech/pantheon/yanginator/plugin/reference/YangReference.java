/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

package tech.pantheon.yanginator.plugin.reference;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class YangReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private final String identifierKeyword;
    private static Object genericElement;

    public YangReference(@NotNull final PsiElement element, final TextRange rangeInElement) {
        super(element, rangeInElement);
        this.identifierKeyword = element.getText().substring(rangeInElement.getStartOffset(), rangeInElement.getEndOffset());
        genericElement = element;
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(final boolean incompleteCode) {
        final List<PsiElement> declarations
                = YangUtil.findIdentifierLiterals(this.myElement.getProject(), this.identifierKeyword, genericElement);
        final List<ResolveResult> results = new ArrayList<>();

        for (final PsiElement declaration : declarations) {
            results.add(new PsiElementResolveResult(declaration));
        }
        return results.toArray(new ResolveResult[0]);
    }

    @Override
    public @Nullable PsiElement resolve() {
        final ResolveResult[] resolveResults = this.multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }
}

