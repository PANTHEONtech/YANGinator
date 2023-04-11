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
    private static boolean recursionLimited = false;

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
        //get all leafs defined in the parent and check if each key leaf is defined in it
        // if there is a uses statement, include each leaf from its grouping too
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
            int limitRecursion = 0;
            IncludeLeafFromUses(element.getParent(), holder, config, keys, limitRecursion);
            /*
        }

        if (element.getParent() instanceof YangListStmt) {
            for (PsiElement sibling : element.getParent().getChildren()) {

                if (sibling instanceof YangLeafStmt && ((YangLeafStmt) sibling).getIdentifierArgStr() != null) {
                    String leafKey = ((YangLeafStmt) sibling).getIdentifierArgStr().getText().replaceAll("\"", "");
                    if (leafs.contains(leafKey)) {
                        holder.newAnnotation(HighlightSeverity.ERROR, String.format("Too many %s leafs.", key))
                                .range(element)
                                .create();
                    } else {
                        leafs.add(leafKey);
                    }
                    if (keys.contains(leafKey)) {
                        for (PsiElement child : sibling.getChildren()) {
                            if (child instanceof YangConfigStmt && ((YangConfigStmt) child).getConfigArgStr() != null) {

                            }
                        }
                    }
                }
                if (sibling instanceof YangDataDefStmt) {
                    YangUsesStmt[] usesStmts = YangUtil.findAllChildrenOfType(sibling, YangUsesStmt.class);
                    String[] includedFileNames = YangUtil.getIncludedSubmoduleNames(element);
                    for (YangUsesStmt usesStmt : usesStmts) {
                        if (usesStmt.getIdentifierRefArgStr() != null) {
                            YangIdentifierRef identifierRef = usesStmt.getIdentifierRefArgStr().getIdentifierRefArg().getIdentifierRef();
                            List<YangGroupingStmt> groupings = new ArrayList<>();
                            if (identifierRef.getPrefix() == null) {
                                //search only in this file and its included submodules
                                List<String> fileNames = new ArrayList<>();
                                fileNames.add(usesStmt.getContainingFile().getName());
                                if (includedFileNames != null) {
                                    fileNames.addAll(List.of(includedFileNames));
                                }
                                groupings.addAll(YangUtil.findIdentifierLiterals(usesStmt.getProject(), identifierRef.getIdentifier().getText(), usesStmt, fileNames));
                            } else {
                                //get file and search for its groupings
                                String name = getLinkedFileName(identifierRef.getPrefix().getText(), element);
                                if (name != null) {
                                    groupings.addAll(YangUtil.findIdentifierLiterals(usesStmt.getProject(), identifierRef.getIdentifier().getText(), usesStmt, List.of(name)));
                                }
                            }
                            for (PsiElement grouping : groupings) {
                                leafs.addAll(YangUtil.findAllChildrenOfTypeAsList(grouping, YangLeafStmt.class, 0).stream().map(
                                        leaf -> {
                                            if (leaf.getIdentifierArgStr() != null) {
                                                String leafName = leaf.getIdentifierArgStr().getText().replaceAll("\"", "");
                                                if (leafs.contains(leafName)) {
                                                    holder.newAnnotation(HighlightSeverity.ERROR, String.format("Included %s leaf is already defined.", leafName))
                                                            .range(usesStmt)
                                                            .create();
                                                }
                                                return (leafName);
                                            } else {
                                                return null;
                                            }
                                        }
                                ).collect(Collectors.toList()));
                            }
                        }
                    }
                }
            }
*/
            if (!keys.isEmpty()) {
                for (String k : keys) {
                    if (recursionLimited) {
                        holder.newAnnotation(HighlightSeverity.WARNING, String.format("Missing %s leaf, searching through linked yang files is limited.", k))
                                .range(element)
                                .create();
                    } else {
                        holder.newAnnotation(HighlightSeverity.ERROR, String.format("Missing %s leaf.", k))
                                .range(element)
                                .create();
                    }
                }
            }
        }
    }

    private static void IncludeLeafFromUses(@NotNull PsiElement element, @NotNull AnnotationHolder holder, String config, List<String> keys, int limitRecursion) {
        YangUsesStmt[] usesStmts = YangUtil.findAllChildrenOfType(element, YangUsesStmt.class);
        if (usesStmts != null) {
            List<String> fileNames = new ArrayList<>();
            for (YangUsesStmt usesStmt : usesStmts) {
                if (usesStmt.getIdentifierRefArgStr() != null) {
                    YangPrefix prefix = usesStmt.getIdentifierRefArgStr().getIdentifierRefArg().getIdentifierRef().getPrefix();
                    String groupingName = usesStmt.getIdentifierRefArgStr().getIdentifierRefArg().getIdentifierRef().getIdentifier().getText();
                    List<YangGroupingStmt> groupings = null;
                    if (prefix != null) {
                        //has prefix
                        //find exact file
                        String fileName = YangUtil.getLinkedFileName(prefix.getText(), usesStmt);
                        if (fileName != null) {
                            groupings = YangUtil.findIdentifierLiterals(element.getProject(), groupingName, usesStmt, Collections.singletonList(fileName));
                        }
                    } else {
                        //does not have prefix
                        //search through opened and included files
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
                                        configCheck(element, holder, config, keys, leafStmt, leafArg);
                                    }
                                }
                            }
                            if (!keys.isEmpty()) {
                                if (++limitRecursion <= 3) {
                                    IncludeLeafFromUses(groupingStmt, holder, config, keys, limitRecursion);
                                } else {
                                    recursionLimited = true;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

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
