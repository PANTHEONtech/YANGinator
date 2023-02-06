/*
 *
 *   Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.reference;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceContributor;
import com.intellij.psi.PsiReferenceProvider;
import com.intellij.psi.PsiReferenceRegistrar;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangBaseStmt;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierRef;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierRefArg;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierRefArgStr;
import tech.pantheon.yanginator.plugin.psi.YangNamedElement;
import tech.pantheon.yanginator.plugin.psi.YangTypeStmt;
import tech.pantheon.yanginator.plugin.psi.YangUsesStmt;

import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.IDENTITYREF_STR;

public class YangReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull final PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(YangNamedElement.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference[] getReferencesByElement(@NotNull final PsiElement element,
                                                                 @NotNull final ProcessingContext context) {
                        if (element instanceof YangBaseStmt) {
                            final YangBaseStmt baseStmt = (YangBaseStmt) element;
                            final String value = YangReferenceContributor.this.getIdentifierOf(baseStmt);
                            return YangReferenceContributor.this.getYangReference(element, baseStmt, value);
                        } else if (element instanceof YangUsesStmt) {
                            final YangUsesStmt usesStmt = (YangUsesStmt) element;
                            final String value = YangReferenceContributor.this.getIdentifierOf(usesStmt);
                            return YangReferenceContributor.this.getYangReference(element, usesStmt, value);
                        } else if (element instanceof YangTypeStmt) {
                            final YangTypeStmt typeStmt = (YangTypeStmt) element;
                            final String value = YangReferenceContributor.this.getIdentifierOf(typeStmt);
                            if (!value.equals(IDENTITYREF_STR)) {
                                return YangReferenceContributor.this.getYangReference(element, typeStmt, value);
                            }
                        }
                        return PsiReference.EMPTY_ARRAY;
                    }
                });
    }

    @NotNull
    private String getIdentifierOf(final YangReferencedStatement stmt) {
        YangIdentifierRefArgStr yangIdentifierRefArgStr = stmt.getIdentifierRefArgStr();
        YangIdentifierRefArg yangIdentifierRefArg = yangIdentifierRefArgStr == null ?
                null
                : yangIdentifierRefArgStr.getIdentifierRefArg();
        YangIdentifierRef yangIdentifierRef = yangIdentifierRefArg == null ?
                null
                : yangIdentifierRefArg.getIdentifierRef();

        String result = yangIdentifierRef == null ? "" : yangIdentifierRef.getText();
        return result == null ? "" : result;
    }

    @NotNull
    private PsiReference[] getYangReference(@NotNull final PsiElement element, final YangNamedElement stmt, final String value) {
        final int valueIndex = stmt.getText().indexOf(value);
        return valueIndex >= 0
                ? new PsiReference[]{new YangReference(element, new TextRange(valueIndex, valueIndex + value.length()))}
                : null;
    }
}
