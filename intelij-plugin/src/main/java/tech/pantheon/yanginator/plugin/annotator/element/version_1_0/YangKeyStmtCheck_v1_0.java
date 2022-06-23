/*
 *
 *   Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.annotator.element.version_1_0;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.annotator.element.AbstractYangStmtCheck;
import tech.pantheon.yanginator.plugin.psi.YangKeyArgStr;
import tech.pantheon.yanginator.plugin.psi.YangKeyStmt;

public class YangKeyStmtCheck_v1_0 extends AbstractYangStmtCheck {
    @Override
    public boolean isApplicable(@NotNull final PsiElement element) {
        return element instanceof YangKeyStmt;
    }

    @Override
    public void performCheck(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder) {
        for (PsiElement child : element.getChildren()) {
            if (child instanceof YangKeyArgStr) {
                if (child.getText().equals("when") || child.getText().equals("\"when\"") ||
                        child.getText().equals("if-feature") || child.getText().equals("\"if-feature\"")) {
                    holder.newAnnotation(HighlightSeverity.ERROR, "When/if-feature not allowed as key argument")
                            .range(element.getFirstChild())
                            .create();
                }
            }
        }
    }
}