/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.reference;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.ArrayUtil;
import com.intellij.util.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.YangFileType;
import tech.pantheon.yanginator.plugin.psi.YangBaseStmt;
import tech.pantheon.yanginator.plugin.psi.YangGroupingStmt;
import tech.pantheon.yanginator.plugin.psi.YangIdentityStmt;
import tech.pantheon.yanginator.plugin.psi.YangImportStmt;
import tech.pantheon.yanginator.plugin.psi.YangIncludeStmt;
import tech.pantheon.yanginator.plugin.psi.YangModuleHeaderStmts;
import tech.pantheon.yanginator.plugin.psi.YangModuleStmt;
import tech.pantheon.yanginator.plugin.psi.YangPrefixStmt;
import tech.pantheon.yanginator.plugin.psi.YangSubmoduleStmt;
import tech.pantheon.yanginator.plugin.psi.YangTypedefStmt;
import tech.pantheon.yanginator.plugin.psi.YangUsesKeyword;
import tech.pantheon.yanginator.plugin.psi.YangUsesStmt;
import tech.pantheon.yanginator.plugin.psi.impl.YangFileReferenceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class YangUtil {

    @NotNull
    public static <T extends PsiElement> List<T> findAllChildrenOfTypeAsList(@Nullable PsiElement element,
                                                                             @NotNull Class<T> aClass, int depth) {
        if (element == null || depth > 3) {
            return Collections.emptyList();
        }
        List<T> result = null;
        PsiElement child = element.getFirstChild();
        while (child != null) {
            if (aClass.isInstance(child)) {
                if (result == null) {
                    result = new SmartList<>();
                }
                result.add(aClass.cast(child));
            }
            List<T> subResult = findAllChildrenOfTypeAsList(child, aClass, depth + 1);
            if (!subResult.isEmpty()) {
                if (result == null) {
                    result = new SmartList<>();
                }
                result.addAll(subResult);
            }
            child = child.getNextSibling();
        }
        return result == null ? Collections.emptyList() : result;
    }

    public static <T extends PsiElement> List<T> findIdentifierLiterals(Project project, String identifierKeyword,
                                                                        PsiElement genericElement, List<String> fileNames) {
        List<T> result = null;
        Collection<VirtualFile> virtualFiles = getVirtualFiles(project, genericElement, fileNames);
        for (VirtualFile virtualFile : virtualFiles) {
            PsiFile yangFile = PsiManager.getInstance(project).findFile(virtualFile);
            if (yangFile != null) {
                T[] literals = YangUtil.findAllChildrenOfType(yangFile, getClassType(genericElement));
                if (literals != null) {
                    for (T literal : literals) {
                        String valueOfLiteral;
                        YangReferencedStatement referencedStatement = (YangReferencedStatement) literal;
                        valueOfLiteral = getStmtArgText(referencedStatement);
                        if (identifierKeyword.equals(valueOfLiteral)) {
                            if (result == null) {
                                result = new ArrayList<>();
                            }
                            result.add(literal);
                        }
                    }
                } else if (yangFile.getFirstChild() instanceof YangFileReferenceImpl) {
                    result = findIdentifierLiterals(project, identifierKeyword, genericElement, Collections.singletonList(yangFile.getFirstChild().getText()));
                }
            }
        }
        return result != null ? result : Collections.emptyList();
    }

    @NotNull
    static Collection<VirtualFile> getVirtualFiles(Project project, PsiElement genericElement, List<String> fileNames) {
        String path = genericElement.getContainingFile().getVirtualFile().getParent().getPath();
        Collection<VirtualFile> foundFilesByName = null;
        Collection<VirtualFile> foundFilesByPath = null;
        if (fileNames.size() == 1) {
            foundFilesByName = FilenameIndex.getVirtualFilesByName(fileNames.get(0), GlobalSearchScope.allScope(project));
        } else {
            foundFilesByName = FileTypeIndex.getFiles(YangFileType.INSTANCE, GlobalSearchScope.allScope(project)).stream()
                    .filter(file -> fileNames.contains(file.getName()))
                    .collect(Collectors.toList());
        }
        foundFilesByPath = foundFilesByName.stream()
                .filter(file -> file.getPath().contains(path))
                .collect(Collectors.toList());
        return foundFilesByPath.size() > 0 ? foundFilesByPath : foundFilesByName;
    }

    public static String getStmtArgText(YangReferencedStatement referencedStatement) {
        return Objects.requireNonNull(referencedStatement.getIdentifierArgStr().getIdentifierArg()).getText();
    }

    public static String getStmtRefArgText(YangReferencedStatement referencedStatement) {
        return Objects.requireNonNull(referencedStatement.getIdentifierRefArgStr().getIdentifierRefArg()).getText();
    }

    @SuppressWarnings("unchecked")
    public static <T extends PsiElement> Class<T> getClassType(Object genericElement) {
        var classType = (Class<T>) YangTypedefStmt.class;
        if (genericElement instanceof YangBaseStmt) {
            classType = (Class<T>) YangIdentityStmt.class;
        } else if (genericElement instanceof YangUsesStmt || genericElement instanceof YangUsesKeyword) {
            classType = (Class<T>) YangGroupingStmt.class;
        } else if (genericElement instanceof YangImportStmt) {
            classType = (Class<T>) YangModuleStmt.class;
        } else if (genericElement instanceof YangIncludeStmt) {
            classType = (Class<T>) YangSubmoduleStmt.class;
        }
        return classType;
    }

    public static <T extends PsiElement> T[] findAllChildrenOfType(@Nullable PsiElement element,
                                                                   @NotNull Class<T> aClass) {
        if (element == null) {
            return null;
        }
        List<T> result = findAllChildrenOfTypeAsList(element, aClass, 0);
        return result.isEmpty() ? null : ArrayUtil.toObjectArray(result, aClass);
    }

    public static String getLinkedFileName(String prefix, PsiElement element) {
        PsiFile actualFile = element.getContainingFile();
        //same file prefix?
        if (YangUtil.findAllChildrenOfTypeAsList(actualFile, YangPrefixStmt.class, 1).stream().anyMatch(prefixStmt -> {
            if (prefixStmt.getParent() instanceof YangModuleHeaderStmts) {
                return (prefixStmt.getPrefixArgStr() != null && prefixStmt.getPrefixArgStr().getText().replace("\"", "").equals(prefix));
            }
            return false;
        })) {
            return actualFile.getName();
        }

        //imported
        YangImportStmt[] importStmts = YangUtil.findAllChildrenOfType(actualFile, YangImportStmt.class);
        if (importStmts != null) {
            String[] imports = Arrays.stream(importStmts).filter(
                    importStmt -> {
                        return Arrays.stream(YangUtil.findAllChildrenOfType(importStmt, YangPrefixStmt.class)).anyMatch(prefixStmt -> {
                            if (prefixStmt.getPrefixArgStr() != null) {
                                return prefixStmt.getPrefixArgStr().getText().replace("\"", "").equals(prefix);
                            }
                            return false;
                        });
                    }
            ).map(YangUtil::getStmtRefArgText).toArray(String[]::new);
            if (imports.length == 1) {
                return imports[0] + ".yang";
            }
        }

        //included
        YangIncludeStmt[] includeStmts = findAllChildrenOfType(actualFile, YangIncludeStmt.class);
        if (includeStmts != null) {
            String[] includes = Arrays.stream(includeStmts).filter(
                    includeStmt -> {
                        return Arrays.stream(YangUtil.findAllChildrenOfType(includeStmt, YangPrefixStmt.class)).anyMatch(prefixStmt -> {
                            if (prefixStmt.getPrefixArgStr() != null) {
                                return prefixStmt.getPrefixArgStr().getText().replace("\"", "").equals(prefix);
                            }
                            return false;
                        });
                    }
            ).map(YangUtil::getStmtRefArgText).toArray(String[]::new);
            if (includes.length == 1) {
                return includes[0] + ".yang";
            }
        }
        return null;
    }

    public static String[] getIncludedSubmoduleNames(PsiElement element) {
        String[] fileNames = null;
        YangIncludeStmt[] includeStmts = findAllChildrenOfType(element, YangIncludeStmt.class);
        if (includeStmts != null) {
            fileNames = Arrays.stream(includeStmts).map(YangUtil::getStmtRefArgText)
                    .map(identifier -> {
                        return identifier + ".yang";
                    }).toArray(String[]::new);
        }
        return fileNames;
    }
}
