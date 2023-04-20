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
import tech.pantheon.yanginator.plugin.psi.impl.YangImportKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIncludeKeywordImpl;

import java.util.Objects;

public class ImportIncludeCheck {
    public static boolean checkImpInc(PsiElement element) {
        boolean found;
        found = checkFolder(element.getContainingFile().getContainingDirectory(), element);
        if (!found)
            found = checkParentFolder(element.getContainingFile().getContainingDirectory(), element, 0, 10);
        return found;
    }

    /*
    Method checks given files for imported module or included submodule
    File must have the same name as module or submodule
     */
    private static boolean checkFiles(PsiFile[] files, PsiElement element) {
        String elementName = element.getChildren()[2].getText();
        for (PsiFile file : files) {
            if (file.getName().equals(elementName + ".yang") || (file.getName().contains(elementName + "@") && file.getName().endsWith(".yang"))) {
                if (Objects.equals(file.getFirstChild().getFirstChild().getText(), getElementType(element))) {
                    if (Objects.equals(file.getFirstChild().getChildren()[2].getText(), elementName)) {
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
    private static boolean checkParentFolder(PsiDirectory folder, PsiElement element, int level, int maxLevel) {
        PsiDirectory parentFolder = folder.getParentDirectory();
        if (parentFolder == null || !parentFolder.getVirtualFile().getPath().contains(element.getProject().getName()))
            return false;
        if (checkFiles(parentFolder.getFiles(), element))
            return true;
        for (PsiDirectory subFolder : parentFolder.getSubdirectories()) {
            if (subFolder != folder) {
                if (checkFolder(subFolder, element))
                    return true;
            }
        }
        if (maxLevel > level)
            return checkParentFolder(parentFolder, element, level + 1, maxLevel);
        return false;
    }

    /*
    Method check files in given folder and all subfolders
     */
    private static boolean checkFolder(PsiDirectory folder, PsiElement element) {
        if (checkFiles(folder.getFiles(), element))
            return true;
        for (PsiDirectory subFolder : folder.getSubdirectories()) {
            if (checkFolder(subFolder, element))
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
