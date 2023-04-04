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
import tech.pantheon.yanginator.plugin.annotator.check.ElementCheckUtils;
import tech.pantheon.yanginator.plugin.psi.YangConfigStmt;
import tech.pantheon.yanginator.plugin.psi.YangKeyStmt;
import tech.pantheon.yanginator.plugin.psi.YangLeafStmt;
import tech.pantheon.yanginator.plugin.psi.YangListStmt;

import java.util.ArrayList;
import java.util.List;

public class YangKeyStmtCheck extends AbstractYangStmtCheck{
    @Override
    public boolean isApplicable(@NotNull PsiElement element) {
        return element instanceof YangKeyStmt;
    }

    @Override
    public void performCheck(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        String key = "";
        String config = "";
        List<String> keys = new ArrayList<>();
        List<String> leafs = new ArrayList<>();
        if (((YangKeyStmt)element).getKeyArgStr()!= null){
            key = ((YangKeyStmt)element).getKeyArgStr().getText().replaceAll("\"", "");
            keys = List.of(key.split(" "));
        }
        if (element.getParent() instanceof YangListStmt){
            for (PsiElement sibling : element.getParent().getChildren()){
                if (sibling instanceof YangConfigStmt && ((YangConfigStmt)sibling).getConfigArgStr() != null){
                    config = ((YangConfigStmt)sibling).getConfigArgStr().getText().replaceAll("\"", "");
                }
                if (sibling instanceof YangLeafStmt && ((YangLeafStmt) sibling).getIdentifierArgStr()!=null){
                        String leafKey = ((YangLeafStmt) sibling).getIdentifierArgStr().getText().replaceAll("\"", "");
                        if (leafs.contains(leafKey)){
                            holder.newAnnotation(HighlightSeverity.ERROR, String.format("Too many %s leafs.",key))
                                    .range(element)
                                    .create();
                        }else {
                            leafs.add(leafKey);
                        }
                        if (keys.contains(leafKey)){
                            for (PsiElement child : sibling.getChildren()){
                                if (child instanceof YangConfigStmt && ((YangConfigStmt)child).getConfigArgStr()!=null){
                                    String leafConfig = ((YangConfigStmt)child).getConfigArgStr().getText().replaceAll("\"", "");
                                    if (!leafConfig.equals(config)){
                                        holder.newAnnotation(HighlightSeverity.ERROR, String.format("Bad config in %s leaf.",leafKey))
                                                .range(element)
                                                .create();
                                    }
                                }
                            }
                        }
                }
            }
            for (String k : keys){
                if (!leafs.contains(k)){
                    holder.newAnnotation(HighlightSeverity.ERROR, String.format("Missing %s leaf.",k))
                            .range(element)
                            .create();
                }
            }
        }
    }
}
