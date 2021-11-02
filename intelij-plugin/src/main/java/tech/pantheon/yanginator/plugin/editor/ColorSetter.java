/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.editor;

import com.intellij.openapi.editor.ElementColorProvider;
import com.intellij.psi.PsiElement;
import java.awt.Color;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
