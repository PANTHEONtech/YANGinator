/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.breadcrumbs;

import com.intellij.psi.PsiElement;
import com.intellij.ui.JBColor;
import com.intellij.xml.breadcrumbs.BreadcrumbsPresentationProvider;
import com.intellij.xml.breadcrumbs.CrumbPresentation;

public class YangBreadcrumbsPresentationProvider extends BreadcrumbsPresentationProvider {
    private static final CrumbPresentation[] COLORS = {
            new YangCrumbPresentation(JBColor.BLUE),
            new YangCrumbPresentation(JBColor.GREEN),
            new YangCrumbPresentation(JBColor.RED)};

    @Override
    public CrumbPresentation[] getCrumbPresentations(PsiElement[] psiElements) {
        CrumbPresentation[] crumbPresentations = new CrumbPresentation[psiElements.length];
        for (int i = 0; i < psiElements.length; i++) {
            crumbPresentations[i] = COLORS[i % COLORS.length];
        }
        return crumbPresentations;
    }
}
