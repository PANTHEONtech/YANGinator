/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.annotator.check;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class MinOneElementCheck implements ElementCheck {
    @Override
    public void check(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder,
                      @NotNull final Class<? extends PsiElement> elementClass) {
        long childrenCount = 0;
        final PsiElement[] children = element.getChildren();
        for (PsiElement child : children) {
            childrenCount += Arrays.stream(child.getClass().getInterfaces()).filter(elementClass::equals).count();
        }
        if (childrenCount < 1) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Missing " + ElementCheckUtils.translateClassName(elementClass))
                    .range(element.getLastChild())
                    .create();
        }
    }

    @Override
    public void simpleCheck(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder,
                            @NotNull final Class<? extends PsiElement> elementClass) {
        long childrenCount = Arrays.stream(element.getChildren()).filter(elementClass::isInstance).count();
        if (childrenCount < 1) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Missing " + ElementCheckUtils.translateClassName(elementClass))
                    .range(element.getLastChild())
                    .create();
        }
    }

    public void checkMany(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder,
                          @NotNull final List<Class<?>> elementClasses) {
        long childrenCount = 0;
        final PsiElement[] children = element.getChildren();
        for (Class<?> c : elementClasses) {
            for (PsiElement child : children) {
                childrenCount += Arrays.stream(child.getClass().getInterfaces()).filter(c::equals).count();
            }
        }
        if (childrenCount < 1) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Missing "
                            + ElementCheckUtils.translateClassName(elementClasses.get(elementClasses.size() - 1)))
                    .range(element.getLastChild())
                    .create();
        }
    }
}
