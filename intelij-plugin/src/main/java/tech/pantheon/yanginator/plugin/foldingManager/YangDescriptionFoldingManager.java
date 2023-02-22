/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.foldingManager;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.DumbAware;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**/

public class YangDescriptionFoldingManager extends FoldingBuilderEx implements DumbAware {

    private static final String DESCRIPTION_PLACEHOLDER_TEXT = "\"...\"";
    private static final String QUOTATION_MARK = "\"";

    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(
            @NotNull final PsiElement root, @NotNull final Document document, final boolean initialRun) {
        final List<DocumentPositionType> quotationMarkPositions;
        quotationMarkPositions = YangFoldingManagerUtil.findDoubleQuotePositionsInDocument(
                document, QUOTATION_MARK, DocumentPositionType::new);

        if (quotationMarkPositions.isEmpty()) {
            return YangFoldingManagerUtil.EMPTY_FOLDING_DESCRIPTORS;
        }
        final List<FoldingDescriptor> descriptors =
                this.getDescriptorsFromQuoteMarkPositions(quotationMarkPositions, root);
        return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
    }

    @Override
    public @Nullable
    String getPlaceholderText(@NotNull final ASTNode astNode) {
        return DESCRIPTION_PLACEHOLDER_TEXT;
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull final ASTNode astNode) {
        return false;
    }

    private List<FoldingDescriptor> getDescriptorsFromQuoteMarkPositions(
            final List<DocumentPositionType> quotationMarkPositions, final PsiElement root) {
        if (quotationMarkPositions.size() % 2 == 1) return Collections.emptyList();

        final List<FoldingDescriptor> output = new ArrayList<>();

        for (int idx = 0; idx < quotationMarkPositions.size(); idx = this.nextFoldingDescriptorStartIndex(idx)) {
            YangFoldingManagerUtil.setFoldingDescriptors
                    (root, output, quotationMarkPositions.get(idx), quotationMarkPositions.get(idx + 1));

        }
        return output;
    }

    private int nextFoldingDescriptorStartIndex(final int idx) {
        // string consists of two " so every second index is start of descriptor
        return idx + 2;
    }
}
