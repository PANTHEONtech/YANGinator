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
import tech.pantheon.yanginator.plugin.psi.YangConfigStmt;
import tech.pantheon.yanginator.plugin.psi.YangGroupingStmt;
import tech.pantheon.yanginator.plugin.psi.YangKeyStmt;
import tech.pantheon.yanginator.plugin.psi.YangLeafStmt;
import tech.pantheon.yanginator.plugin.psi.YangPrefix;
import tech.pantheon.yanginator.plugin.psi.YangUsesStmt;
import tech.pantheon.yanginator.plugin.reference.YangUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class YangKeyStmtCheck extends AbstractYangStmtCheck {
    @Override
    public boolean isApplicable(@NotNull PsiElement element) {
        return element instanceof YangKeyStmt;
    }

    @Override
    public void performCheck(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        String key;
        String config = "";
        List<String> keys = new ArrayList<>();

        //add each key argument leaf to a list and check for duplicity
        if (((YangKeyStmt) element).getKeyArgStr() != null) {
            key = ((YangKeyStmt) element).getKeyArgStr().getText().replaceAll("\\s+", " ").replaceAll("\"", "");
            String[] allKeys = key.split(" ");
            for (String k : allKeys) {
                if (!keys.contains(k)) {
                    keys.add(k);
                } else {
                    holder.newAnnotation(HighlightSeverity.ERROR, String.format("More than one %s leaf in key argument.", k))
                            .range(element)
                            .create();
                }
            }
        }

        //get all leafs defined in the parent and check its config
        YangLeafStmt[] parentLeafStmts = YangUtil.findAllChildrenOfType(element.getParent(), YangLeafStmt.class);
        YangConfigStmt[] parentConfigStmt = YangUtil.findAllChildrenOfType(element.getParent(), YangConfigStmt.class);
        if (parentConfigStmt != null && parentConfigStmt.length == 1) {
            if (parentConfigStmt[0].getConfigArgStr() != null) {
                config = parentConfigStmt[0].getConfigArgStr().getText().replaceAll("\"", "");
            }
        }
        if (parentLeafStmts != null) {
            for (YangLeafStmt leafStmt : parentLeafStmts) {
                if (leafStmt.getIdentifierArgStr() != null) {
                    String leafArg = leafStmt.getIdentifierArgStr().getText().replaceAll("\"", "");
                    configCheck(element, holder, config, keys, leafStmt, leafArg);
                }
            }
        }
        if (!keys.isEmpty()) {

            //recursive search for leaf through uses statements
            IncludeLeafFromUses(element.getParent(), holder, config, keys, element);

            if (!keys.isEmpty()) {
                for (String k : keys) {
                    holder.newAnnotation(HighlightSeverity.ERROR, String.format("Missing %s leaf.", k))
                            .range(element)
                            .create();
                }
            }
        }
    }

    /**
     * This method finds leaf statements that are imported/included by uses statements inside passed element.
     * Stops when there are no more undefined key leaf arguments.
     *
     * @param element        PsiElement which should be searched.
     * @param holder         AnnotationHolder used for throwing warnings/errors.
     * @param config         Config definition of list statement. If undefined = Empty
     * @param keys           List of names defined as key leaf arguments
     * @param keyStmt        Used to get proper text range for annotator errors and warnings.
     */
    private static void IncludeLeafFromUses(@NotNull PsiElement element, @NotNull AnnotationHolder holder, String config, List<String> keys, PsiElement keyStmt) {
        YangUsesStmt[] usesStmts = YangUtil.findAllChildrenOfType(element, YangUsesStmt.class);
        if (usesStmts != null) {
            List<String> fileNames = new ArrayList<>();
            for (YangUsesStmt usesStmt : usesStmts) {
                if (usesStmt.getIdentifierRefArgStr() != null) {
                    YangPrefix prefix = usesStmt.getIdentifierRefArgStr().getIdentifierRefArg().getIdentifierRef().getPrefix();
                    String groupingName = usesStmt.getIdentifierRefArgStr().getIdentifierRefArg().getIdentifierRef().getIdentifier().getText();
                    List<YangGroupingStmt> groupings = null;
                    if (prefix != null) {
                        String fileName = YangUtil.getLinkedFileName(prefix.getText(), usesStmt);
                        if (fileName != null) {
                            groupings = YangUtil.findIdentifierLiterals(element.getProject(), groupingName, usesStmt, Collections.singletonList(fileName));
                        }
                    } else {
                        fileNames.add(element.getContainingFile().getName());
                        String[] includedYangNames = YangUtil.getIncludedSubmoduleNames(element.getContainingFile());
                        if (includedYangNames != null) {
                            fileNames.addAll(List.of(includedYangNames));
                        }
                        groupings = YangUtil.findIdentifierLiterals(element.getProject(), groupingName, usesStmt, fileNames);
                    }
                    if (groupings != null && !groupings.isEmpty()) {
                        for (YangGroupingStmt groupingStmt : groupings) {
                            YangLeafStmt[] leafStmts = YangUtil.findAllChildrenOfType(groupingStmt, YangLeafStmt.class);
                            if (leafStmts != null) {
                                for (YangLeafStmt leafStmt : leafStmts) {
                                    if (leafStmt.getIdentifierArgStr() != null) {
                                        String leafArg = leafStmt.getIdentifierArgStr().getText().replaceAll("\"", "");
                                        configCheck(keyStmt, holder, config, keys, leafStmt, leafArg);
                                    }
                                }
                            }
                            if (!keys.isEmpty()) {
                                IncludeLeafFromUses(groupingStmt, holder, config, keys, keyStmt);
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * If the leaf statement passed is defined as a key leaf argument, it is removed from the list of keys.
     * Checks if the config definitions of leaf statement and list statement are the same.
     */
    private static void configCheck(@NotNull PsiElement element, @NotNull AnnotationHolder holder, String config, List<String> keys, YangLeafStmt leafStmt, String leafArg) {
        if (keys.contains(leafArg)) {
            keys.remove(leafArg);
            if (!config.isEmpty()) {
                YangConfigStmt[] leafConfig = YangUtil.findAllChildrenOfType(leafStmt, YangConfigStmt.class);
                if (leafConfig != null && leafConfig.length == 1) {
                    if (leafConfig[0].getConfigArgStr() != null) {
                        String leafConfigArg = leafConfig[0].getConfigArgStr().getText().replaceAll("\"", "");
                        if (!leafConfigArg.equals(config)) {
                            holder.newAnnotation(HighlightSeverity.ERROR, String.format("Bad config in %s leaf.", leafArg))
                                    .range(element)
                                    .create();
                        }
                    }
                }
            }
        }
    }
}
