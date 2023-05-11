/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.injection;

import com.intellij.lang.injection.MultiHostInjector;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.XsdRegExpParserDefinition;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangIndentableQuotedString;
import tech.pantheon.yanginator.plugin.psi.YangPatternBody;
import tech.pantheon.yanginator.plugin.psi.YangQuotedString;

import java.util.List;

public class RegExpToYangInjector implements MultiHostInjector {
    @Override
    public void getLanguagesToInject(@NotNull MultiHostRegistrar registrar, @NotNull PsiElement context) {
        if (context instanceof YangQuotedString &&
                context.getParent() instanceof YangIndentableQuotedString &&
                context.getParent().getParent() instanceof YangPatternBody) {
            registrar.startInjecting(XsdRegExpParserDefinition.LANGUAGE)
                    .addPlace(null, null, (PsiLanguageInjectionHost) context, new TextRange(context.getStartOffsetInParent() + 1, context.getStartOffsetInParent() + context.getTextLength() - 1))
                    .doneInjecting();
        }
    }

    @Override
    public @NotNull List<? extends Class<? extends PsiElement>> elementsToInjectIn() {
        return List.of(YangQuotedString.class);
    }
}
