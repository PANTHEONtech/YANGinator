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
import tech.pantheon.yanginator.plugin.psi.YangSubmoduleHeaderStmts;
import tech.pantheon.yanginator.plugin.psi.YangSubmoduleStmt;

public class YangSubmoduleStmtCheck extends AbstractYangStmtCheck {
    @Override
    public boolean isApplicable(@NotNull PsiElement element) {
        return element instanceof YangSubmoduleStmt;
    }

    @Override
    public void performCheck(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        minOne.simpleCheck(element, holder, YangSubmoduleHeaderStmts.class);
    }
}
