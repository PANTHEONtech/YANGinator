/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

package tech.pantheon.yanginator.plugin.completion;

import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiTreeChangeEvent;
import com.intellij.psi.PsiTreeChangeListener;
import com.intellij.psi.util.PsiEditorUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorPopUp.POP_UP;

public class YangPsiTreeChangeListener implements PsiTreeChangeListener {

    @Override
    public void childrenChanged(@NotNull PsiTreeChangeEvent event) {
        if (event.getFile() == null
                || event.getFile().getNode() == null
                || event.getFile().getNode().getPsi() == null){
            return;
        }
        PsiElement prevPsiElement = getPrevPsiElement(event.getFile().getNode().getPsi());
        if (PsiEditorUtil.findEditor(event.getFile().getNode().getPsi()) != null) {
            POP_UP.setPrefixMatcher(prevPsiElement == null ? "" : prevPsiElement.getText());
        }
    }

    @Nullable
    private PsiElement getPrevPsiElement(@NotNull PsiElement element) {
        PsiElement currentPsiElement = getCurrentPsiElement(element);
        int elementLength = currentPsiElement == null ? 1 : currentPsiElement.getTextLength();
        return element.findElementAt(getOffsetOfCaret(element) - elementLength);
    }

    @Nullable
    private PsiElement getCurrentPsiElement(@NotNull PsiElement element) {
        return element.findElementAt(getOffsetOfCaret(element));
    }

    private int getOffsetOfCaret(@NotNull PsiElement element) {
        Editor editor = PsiEditorUtil.findEditor(element);
        if (editor != null) {
            return editor.getCaretModel().getCurrentCaret().getOffset();
        }
        return 0;
    }

    @Override
    public void beforeChildAddition(@NotNull PsiTreeChangeEvent event) {
    }

    @Override
    public void beforeChildRemoval(@NotNull PsiTreeChangeEvent event) {
    }

    @Override
    public void beforeChildReplacement(@NotNull PsiTreeChangeEvent event) {
    }

    @Override
    public void beforeChildMovement(@NotNull PsiTreeChangeEvent event) {
    }

    @Override
    public void beforeChildrenChange(@NotNull PsiTreeChangeEvent event) {
    }

    @Override
    public void beforePropertyChange(@NotNull PsiTreeChangeEvent event) {
    }

    @Override
    public void childAdded(@NotNull PsiTreeChangeEvent event) {
    }

    @Override
    public void childRemoved(@NotNull PsiTreeChangeEvent event) {
    }

    @Override
    public void childReplaced(@NotNull PsiTreeChangeEvent event) {
    }

    @Override
    public void childMoved(@NotNull PsiTreeChangeEvent event) {
    }

    @Override
    public void propertyChanged(@NotNull PsiTreeChangeEvent event) {
    }
}
