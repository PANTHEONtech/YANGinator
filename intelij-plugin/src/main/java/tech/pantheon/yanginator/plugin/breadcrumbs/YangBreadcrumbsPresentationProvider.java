package tech.pantheon.yanginator.plugin.breadcrumbs;

import com.intellij.psi.PsiElement;
import com.intellij.ui.JBColor;
import com.intellij.xml.breadcrumbs.BreadcrumbsPresentationProvider;
import com.intellij.xml.breadcrumbs.CrumbPresentation;

public class YangBreadcrumbsPresentationProvider extends BreadcrumbsPresentationProvider {
    private final CrumbPresentation[] colors = {new YangCrumbPresentation(JBColor.BLUE),
            new YangCrumbPresentation(JBColor.GREEN),
            new YangCrumbPresentation(JBColor.RED)};

    @Override
    public CrumbPresentation[] getCrumbPresentations(PsiElement[] psiElements) {
        CrumbPresentation[] crumbPresentations = new CrumbPresentation[psiElements.length];
        for (int i = 0; i < psiElements.length; i++) {
            crumbPresentations[i] = colors[i % colors.length];
        }
        return crumbPresentations;
    }
}
