/*
 *
 *   Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.annotator.element.version_1_1;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.annotator.element.AbstractYangStmtCheck;
import tech.pantheon.yanginator.plugin.psi.YangDoubleQuotedVchar;

import java.util.ArrayList;
import java.util.List;

public class YangDoubleQuotedStringCheck_v1_1 extends AbstractYangStmtCheck {
    @Override
    public boolean isApplicable(@NotNull final PsiElement element) {
        return element instanceof YangDoubleQuotedVchar;
    }

    @Override
    public void performCheck(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder) {
        List<String> escapes = new ArrayList<>(List.of("\\\\", "\\\"", "\\n", "\\t"));
        if (element.getText().contains("\\")) {
            int count = 0;
            for (String escape : escapes) {
                if (element.getText().contains(escape)) {
                    count++;
                }
            }
            if (count < 1) {
                holder.newAnnotation(HighlightSeverity.ERROR, "Not a valid escape in double-quoted string")
                        .range(element.getFirstChild())
                        .create();
            }
        }
    }
}