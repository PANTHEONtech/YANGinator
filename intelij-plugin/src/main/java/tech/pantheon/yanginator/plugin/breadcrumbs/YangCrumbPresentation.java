package tech.pantheon.yanginator.plugin.breadcrumbs;

import com.intellij.ui.JBColor;
import com.intellij.xml.breadcrumbs.CrumbPresentation;

import java.awt.Color;

public class YangCrumbPresentation extends CrumbPresentation {
    private final JBColor color;

    public YangCrumbPresentation(JBColor color) {
        this.color = color;
    }

    @Override
    public Color getBackgroundColor(boolean b, boolean b1, boolean b2) {
        return color;
    }
}
