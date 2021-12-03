/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.breadcrumbs;

import com.intellij.lang.Language;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.ui.breadcrumbs.BreadcrumbsProvider;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.YangLanguage;
import tech.pantheon.yanginator.plugin.psi.YangContainerStmt;
import tech.pantheon.yanginator.plugin.psi.YangGroupingStmt;
import tech.pantheon.yanginator.plugin.psi.YangListStmt;
import tech.pantheon.yanginator.plugin.psi.impl.YangIdentifierArgImpl;

import java.util.Objects;

public class YangBreadcrumbsProvider implements BreadcrumbsProvider {

    @Override
    public Language[] getLanguages() {
        return new Language[] { YangLanguage.INSTANCE };
    }

    @Override
    public boolean acceptElement(@NotNull PsiElement psiElement) {
        return psiElement instanceof YangListStmt
                || psiElement instanceof YangContainerStmt
                || psiElement instanceof YangGroupingStmt;
    }

    @NotNull
    @Override
    public String getElementInfo(@NotNull PsiElement psiElement) {
        return Objects.requireNonNull(PsiTreeUtil.findChildOfType(psiElement, YangIdentifierArgImpl.class)).getText();
    }
}
