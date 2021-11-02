/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
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
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.ArrayUtil;
import com.intellij.util.SmartList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.YangFileType;
import tech.pantheon.yanginator.plugin.psi.YangBaseStmt;
import tech.pantheon.yanginator.plugin.psi.YangFile;
import tech.pantheon.yanginator.plugin.psi.YangGroupingStmt;
import tech.pantheon.yanginator.plugin.psi.YangIdentityStmt;
import tech.pantheon.yanginator.plugin.psi.YangTypedefStmt;
import tech.pantheon.yanginator.plugin.psi.YangUsesStmt;

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
            } else {
                List<T> subResult = findAllChildrenOfTypeAsList(child, aClass, depth + 1);
                if (!subResult.isEmpty()) {
                    if (result == null) {
                        result = new SmartList<>();
                    }
                    result.addAll(subResult);
                }
            }
            child = child.getNextSibling();
        }
        return result == null ? Collections.emptyList() : result;
    }

    public static <T extends PsiElement> List<T> findIdentifierLiterals(Project project, String identifierKeyword,
                                                                        Object genericElement) {
        List<T> result = null;
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(YangFileType.INSTANCE, GlobalSearchScope.allScope(project));

        for (VirtualFile virtualFile : virtualFiles) {
            YangFile yangFile = (YangFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (yangFile != null) {
                T[] literals = YangUtil.findAllChildrenOfType(yangFile, getClassType(genericElement));
                if (literals != null) {
                    for (T literal : literals) {
                        String valueOfLiteral;
                        YangReferencedStatement referencedStatement = (YangReferencedStatement) literal;
                        valueOfLiteral = Objects.requireNonNull(referencedStatement.getIdentifierArgQuoted()).getText();
                        if (identifierKeyword.equals(valueOfLiteral)) {
                            if (result == null) {
                                result = new ArrayList<>();
                            }
                            result.add(literal);
                        }
                    }
                }
            }
        }
        return result != null ? result : Collections.emptyList();
    }

    @SuppressWarnings("unchecked")
    private static <T extends PsiElement> Class<T> getClassType(Object genericElement) {
        var classType = (Class<T>) YangTypedefStmt.class;
        if (genericElement instanceof YangBaseStmt) {
            classType = (Class<T>) YangIdentityStmt.class;
        } else if (genericElement instanceof YangUsesStmt) {
            classType = (Class<T>) YangGroupingStmt.class;
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

}
