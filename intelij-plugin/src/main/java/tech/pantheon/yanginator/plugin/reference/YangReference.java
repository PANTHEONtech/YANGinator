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

import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangFileReference;
import tech.pantheon.yanginator.plugin.psi.YangImportStmt;
import tech.pantheon.yanginator.plugin.psi.YangIncludeStmt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static tech.pantheon.yanginator.plugin.reference.YangUtil.getVirtualFiles;

public class YangReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private final String identifierKeyword;
    private final String prefix;

    public YangReference(@NotNull final PsiElement element, final TextRange rangeInElement) {
        super(element, rangeInElement);
        String identifier = element.getText().substring(rangeInElement.getStartOffset(), rangeInElement.getEndOffset());
        if (identifier.split(":").length > 1) {
            this.prefix = identifier.split(":")[0];
            this.identifierKeyword = identifier.split(":")[1];
        } else {
            this.prefix = "";
            this.identifierKeyword = identifier;
        }
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(final boolean incompleteCode) {
        ArrayList<String> fileNames = new ArrayList<>();
        final List<ResolveResult> results = new ArrayList<>();
        if (myElement instanceof YangIncludeStmt || myElement instanceof YangImportStmt) {
            fileNames.add(Objects.requireNonNull(((YangGeneratedReferenceType) myElement).getIdentifierRefArgStr()).getText() + ".yang");
        } else if (myElement instanceof YangFileReference) {
            Collection<VirtualFile> virtualFiles = getVirtualFiles(myElement.getProject(), myElement, Collections.singletonList(identifierKeyword));
            if (virtualFiles.size() > 0) {
                PsiFile yangFile = PsiManager.getInstance(myElement.getProject()).findFile((VirtualFile) virtualFiles.toArray()[0]);
                if (yangFile != null) {
                    results.add(new PsiElementResolveResult(yangFile));
                    return results.toArray(new ResolveResult[0]);
                }
            }
        } else {
            fileNames = resolveImports();
        }
        final List<PsiElement> declarations
                = YangUtil.findIdentifierLiterals(this.myElement.getProject(), this.identifierKeyword, myElement, fileNames);

        for (final PsiElement declaration : declarations) {
            results.add(new PsiElementResolveResult(declaration));
        }
        return results.toArray(new ResolveResult[0]);
    }

    @Override
    public @Nullable PsiElement resolve() {
        final ResolveResult[] resolveResults = this.multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }


    /**
     * This method finds all imports and includes from the opened yang and returns names of imported and included
     * yang files if the referenced element has no prefix ,or it returns the imported yang file with the same prefix.
     */
    @NotNull
    private ArrayList<String> resolveImports() {
        ArrayList<String> fileNames = new ArrayList<>();
        if (prefix.isEmpty()) {
            String[] includedSubmoduleNames = YangUtil.getIncludedSubmoduleNames(myElement.getContainingFile());
            if (includedSubmoduleNames != null) {
                fileNames.addAll(List.of(includedSubmoduleNames));
            }
            fileNames.add(myElement.getContainingFile().getName());
        } else {
            String fileName = YangUtil.getLinkedFileName(prefix, myElement);
            if (fileName != null) {
                fileNames.add(fileName);
            }
        }
        return fileNames;
    }
}