/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.annotator.element;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangPrefix;
import tech.pantheon.yanginator.plugin.psi.YangPrefixArg;
import tech.pantheon.yanginator.plugin.psi.YangPrefixStmt;

import java.util.List;
import java.util.stream.Collectors;

import static tech.pantheon.yanginator.plugin.reference.YangUtil.findAllChildrenOfTypeAsList;


public class YangPrefixStmtCheck extends AbstractYangStmtCheck {
    @Override
    public boolean isApplicable(@NotNull final PsiElement element) {
        return element instanceof YangPrefix;
    }

    @Override
    public void performCheck(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder) {
        List<String> prefixes = findAllChildrenOfTypeAsList(element.getContainingFile(), YangPrefixStmt.class, 0)
                .stream().map(prefix -> findAllChildrenOfTypeAsList(prefix, YangPrefixArg.class, 0).get(0).getText()).collect(Collectors.toList());
        String elementText = element.getText();
        if (elementText.contains("+")) {     //remove string splitter
            elementText = elementText.replaceAll("\"[ +\\n]*\"", "");
        }
        if (!prefixes.contains(elementText)) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Prefix \"" + elementText + "\" is not declared.")
                    .range(element)
                    .create();
        }
    }
}
