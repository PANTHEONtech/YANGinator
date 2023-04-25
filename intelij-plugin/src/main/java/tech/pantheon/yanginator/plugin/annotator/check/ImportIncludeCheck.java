/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.annotator.check;

import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import tech.pantheon.yanginator.plugin.psi.impl.YangFileReferenceImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangImportKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIncludeKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangModuleStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSubmoduleStmtImpl;

import java.util.Objects;

public class ImportIncludeCheck {
    public static boolean checkImpInc(PsiElement element, String fileName) {
        boolean found;
        found = checkFolder(element.getContainingFile().getContainingDirectory(), element, fileName);
        if (!found)
            found = checkParentFolder(element.getContainingFile().getContainingDirectory(), element, fileName, 0, 10);
        return found;
    }

    /*
    Method checks given files for imported module or included submodule
    File must have the same name as module or submodule
     */
    private static boolean checkFiles(PsiFile[] files, PsiElement element, String fileName) {
        String elementName = element.getChildren()[2].getText();
        for (PsiFile file : files) {
            if (file.getName().equals(fileName)) {
                if ((file.getFirstChild() instanceof YangModuleStmtImpl ||
                        file.getFirstChild() instanceof YangSubmoduleStmtImpl) &&
                        Objects.equals(file.getFirstChild().getFirstChild().getText(), getElementType(element))) {
                    if (Objects.equals(file.getFirstChild().getChildren()[2].getText(), elementName)) {
                        return true;
                    }
                } else if (file.getFirstChild() instanceof YangFileReferenceImpl) {
                    if (checkImpInc(element, file.getFirstChild().getText())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
    Method check all folders in parent directory of given folder excluding given folder
     */
    private static boolean checkParentFolder(PsiDirectory folder, PsiElement element, String fileName, int level, int maxLevel) {
        PsiDirectory parentFolder = folder.getParentDirectory();
        if (parentFolder == null || !parentFolder.getVirtualFile().getPath().contains(element.getProject().getName()))
            return false;
        if (checkFiles(parentFolder.getFiles(), element, fileName))
            return true;
        for (PsiDirectory subFolder : parentFolder.getSubdirectories()) {
            if (subFolder != folder) {
                if (checkFolder(subFolder, element, fileName))
                    return true;
            }
        }
        if (maxLevel > level)
            return checkParentFolder(parentFolder, element, fileName, level + 1, maxLevel);
        return false;
    }

    /*
    Method check files in given folder and all subfolders
     */
    private static boolean checkFolder(PsiDirectory folder, PsiElement element, String fileName) {
        if (checkFiles(folder.getFiles(), element, fileName))
            return true;
        for (PsiDirectory subFolder : folder.getSubdirectories()) {
            if (checkFolder(subFolder, element, fileName))
                return true;
        }
        return false;
    }

    private static String getElementType(PsiElement element) {
        if (element.getChildren()[0] instanceof YangImportKeywordImpl)
            return "module";
        if (element.getChildren()[0] instanceof YangIncludeKeywordImpl)
            return "submodule";
        return "";
    }
}
