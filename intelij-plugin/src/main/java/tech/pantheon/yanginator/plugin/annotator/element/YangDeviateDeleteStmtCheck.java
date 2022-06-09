/*
 *
 *   Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
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
import tech.pantheon.yanginator.plugin.psi.YangDeviateDeleteStmt;
import tech.pantheon.yanginator.plugin.psi.YangUnitsStmt;

public class YangDeviateDeleteStmtCheck extends AbstractYangStmtCheck {
    @Override
    public boolean isApplicable(@NotNull final PsiElement element) {
        return element instanceof YangDeviateDeleteStmt;
    }

    @Override
    public void performCheck(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder) {
        maxOne.check(element, holder, YangUnitsStmt.class);
    }
}
