/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.annotator.check.version_1_0;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.annotator.check.ElementCheck;
import tech.pantheon.yanginator.plugin.annotator.check.ElementCheckUtils;

import java.util.Arrays;
import java.util.List;

public class MaxZeroElementCheck implements ElementCheck {
    @Override
    public void check(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder,
                      @NotNull final Class<? extends PsiElement> elementClass) {
        long childrenCount = 0;
        final PsiElement[] children = element.getChildren();
        for (PsiElement child : children) {
            childrenCount += Arrays.stream(child.getClass().getInterfaces()).filter(elementClass::equals).count();
            if (childrenCount > 0) {
                holder.newAnnotation(HighlightSeverity.ERROR, "Not allowed "
                                + ElementCheckUtils.translateClassName(elementClass) + " in yang version 1.0")
                        .range(child.getFirstChild())
                        .create();
                return;
            }
        }
    }

    @Override
    public void simpleCheck(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder,
                            @NotNull final Class<? extends PsiElement> elementClass) {
        long childrenCount = Arrays.stream(element.getChildren()).filter(elementClass::isInstance).count();
        if (childrenCount > 0) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Not allowed "
                            + ElementCheckUtils.translateClassName(elementClass))
                    .range(element.getFirstChild())
                    .create();
        }
    }


    public void checkMany(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder,
                          @NotNull final List<Class<?>> elementClasses) {
        long childrenCount = 0;
        final PsiElement[] children = element.getChildren();
        for (Class<?> c : elementClasses) {
            for (PsiElement ch : children) {
                childrenCount += Arrays.stream(ch.getChildren()).filter(c::isInstance).count();
            }
        }
        if (childrenCount > 0) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Not allowed "
                            + ElementCheckUtils.translateClassName(elementClasses.get(elementClasses.size() - 1)))
                    .range(element.getLastChild())
                    .create();
        }
    }
}
