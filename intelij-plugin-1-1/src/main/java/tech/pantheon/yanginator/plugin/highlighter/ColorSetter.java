/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

package tech.pantheon.yanginator.plugin.highlighter;

import com.intellij.openapi.editor.ElementColorProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class ColorSetter implements ElementColorProvider {
    @Override
    public @Nullable Color getColorFrom(@NotNull PsiElement psiElement) {
        System.out.println(psiElement);
        return Color.PINK;
    }

    @Override
    public void setColorTo(@NotNull PsiElement psiElement, @NotNull Color color) {

    }
}
