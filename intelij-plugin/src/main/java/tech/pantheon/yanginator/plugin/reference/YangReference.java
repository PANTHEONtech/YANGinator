/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.reference;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.formatter.YangFormatterUtils;
import tech.pantheon.yanginator.plugin.psi.YangTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class YangReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private final String identifierKeyword;
    private final String prefix;
    private static Object genericElement;

    public YangReference(@NotNull final PsiElement element, final TextRange rangeInElement) {
        super(element, rangeInElement);
        String identifier = element.getText().substring(rangeInElement.getStartOffset(), rangeInElement.getEndOffset());
        if (identifier.split(":").length > 1) {
            this.prefix = identifier.split(":")[0];
            this.identifierKeyword = identifier.split(":")[1];
        } else {
            this.prefix = "";
            this.identifierKeyword = identifier;
        }
        genericElement = element;
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(final boolean incompleteCode) {
        ArrayList<String> fileNames = new ArrayList<>();
        if (prefix.isEmpty()) {
            fileNames.add(myElement.getContainingFile().getName());
        } else {
            fileNames.addAll(resolveImports());
        }
        final List<PsiElement> declarations
                = YangUtil.findIdentifierLiterals(this.myElement.getProject(), this.identifierKeyword, genericElement, fileNames);
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

    @NotNull
    private ArrayList<String> resolveImports() {
        ArrayList<String> fileNames= new ArrayList<>();
        ASTNode linkageElements = myElement.getContainingFile().getNode().findChildByType(YangFormatterUtils.BEFORE_MODULE_SET).findChildByType(YangTypes.YANG_LINKAGE_STMTS);
        if (linkageElements != null) {
            for (ASTNode link : linkageElements.getChildren(null)) {
                String file = Objects.requireNonNull(link.findChildByType(YangTypes.YANG_IDENTIFIER_ARG_STR)).getText();
                fileNames.add(file + ".yang");
            }
        }
        return fileNames;
    }
}

