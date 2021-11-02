/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.completion;

import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorPopUp.POP_UP;

import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiTreeChangeEvent;
import com.intellij.psi.PsiTreeChangeListener;
import com.intellij.psi.util.PsiEditorUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class YangPsiTreeChangeListener implements PsiTreeChangeListener {

    @Override
    public void childrenChanged(@NotNull PsiTreeChangeEvent event) {
        PsiElement prevPsiElement = getPrevPsiElement(event);
        if (event.getFile() != null) {
            if (PsiEditorUtil.findEditor(event.getFile().getNode().getPsi()) != null) {
                POP_UP.setPrefixMatcher(prevPsiElement == null ? "" : prevPsiElement.getText());
            }
        }
    }

    @Nullable
    private PsiElement getPrevPsiElement(@NotNull PsiTreeChangeEvent event) {
        PsiElement currentPsiElement = getCurrentPsiElement(event);
        if (event.getFile() != null) {
            return event.getFile().getNode().getPsi()
                    .findElementAt(getOffsetOfCaret(event) - (currentPsiElement == null ? 1 : currentPsiElement.getTextLength()));
        }
        return null;
    }

    @Nullable
    private PsiElement getCurrentPsiElement(@NotNull PsiTreeChangeEvent event) {
        if (event.getFile() != null) {
            if (event.getFile().getNode() != null) {
                return event.getFile().getNode().getPsi().findElementAt(getOffsetOfCaret(event));
            }
        }
        return null;
    }

    private int getOffsetOfCaret(@NotNull PsiTreeChangeEvent event) {
        if (event.getFile() != null) {
            Editor editor = PsiEditorUtil.findEditor(event.getFile().getNode().getPsi());
            if (editor != null) {
                return editor.getCaretModel().getCurrentCaret().getOffset();
            }
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
