/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

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
