/*
 *
 *   Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.annotator.check;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ElementCheck {
    void check(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder,
               @NotNull final Class<? extends PsiElement> elementClass);

    void simpleCheck(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder,
                     @NotNull final Class<? extends PsiElement> elementClass);

    void checkMany(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder,
                   @NotNull final List<Class<?>> elementClasses);
}
