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

import com.intellij.lang.injection.general.Injection;
import com.intellij.lang.injection.general.LanguageInjectionContributor;
import com.intellij.lang.injection.general.SimpleInjection;
import com.intellij.psi.PsiElement;
import org.intellij.lang.regexp.RegExpLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangPatternBody;
import tech.pantheon.yanginator.plugin.psi.YangQuotedString;

public class YangInjector implements LanguageInjectionContributor {
    @Override
    public @Nullable Injection getInjection(@NotNull PsiElement context) {
        if (context.getParent() instanceof YangPatternBody &&
                (context instanceof YangQuotedString)) {
            return new SimpleInjection(RegExpLanguage.INSTANCE, "", "", null);
        }
        return null;
    }
}
