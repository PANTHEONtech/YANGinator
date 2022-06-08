/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
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
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class YangCommentFoldingManager extends FoldingBuilderEx implements DumbAware {
    private static final String CODE_BLOCK_PLACEHOLDER_TEXT = "/*...*/";

    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(
            @NotNull final PsiElement root, @NotNull final Document document, final boolean quick) {
        final List<FoldingDescriptor> descriptors = new ArrayList<>();
        final Collection<PsiComment> comments =
                PsiTreeUtil.findChildrenOfType(root, PsiComment.class);
        for (final PsiComment comment : comments) {
            if (comment.getTokenType() == YangTypes.YANG_BLOCK_COMMENT) {
                descriptors.add(new FoldingDescriptor(comment.getNode(),
                        new TextRange(comment.getTextRange().getStartOffset(),
                                comment.getTextRange().getEndOffset())));
            }
        }
        return descriptors.toArray(new FoldingDescriptor[0]);
    }

    @Override
    public @Nullable String getPlaceholderText(@NotNull final ASTNode node) {
        return CODE_BLOCK_PLACEHOLDER_TEXT;
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull final ASTNode node) {
        return false;
    }
}
