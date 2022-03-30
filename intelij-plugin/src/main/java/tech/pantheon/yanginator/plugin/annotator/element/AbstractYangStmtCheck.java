/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.annotator.element;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.annotator.check.ElementCheck;
import tech.pantheon.yanginator.plugin.annotator.check.MaxOneElementCheck;
import tech.pantheon.yanginator.plugin.annotator.check.MinOneElementCheck;

public abstract class AbstractYangStmtCheck {
    protected final ElementCheck maxOne = new MaxOneElementCheck();
    protected final ElementCheck minOne = new MinOneElementCheck();

    abstract public boolean isApplicable(@NotNull final PsiElement element);

    abstract public void performCheck(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder);
}
