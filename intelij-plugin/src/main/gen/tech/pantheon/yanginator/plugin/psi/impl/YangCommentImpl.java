/*
 *
 *   Copyright (c) 2021-2025 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangBackslashQuote;
import tech.pantheon.yanginator.plugin.psi.YangBlockComment;
import tech.pantheon.yanginator.plugin.psi.YangComment;
import tech.pantheon.yanginator.plugin.psi.YangDoubleBackslash;
import tech.pantheon.yanginator.plugin.psi.YangDoubleForwardSlash;
import tech.pantheon.yanginator.plugin.psi.YangDquote;
import tech.pantheon.yanginator.plugin.psi.YangVchar;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangCommentImpl extends YangNamedElementImpl implements YangComment {

    public YangCommentImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitComment(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<YangBackslashQuote> getBackslashQuoteList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangBackslashQuote.class);
    }

    @Override
    @Nullable
    public YangBlockComment getBlockComment() {
        return findChildByClass(YangBlockComment.class);
    }

    @Override
    @NotNull
    public List<YangDoubleBackslash> getDoubleBackslashList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangDoubleBackslash.class);
    }

    @Override
    @Nullable
    public YangDoubleForwardSlash getDoubleForwardSlash() {
        return findChildByClass(YangDoubleForwardSlash.class);
    }

    @Override
    @NotNull
    public List<YangDquote> getDquoteList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangDquote.class);
    }

    @Override
    @NotNull
    public List<YangVchar> getVcharList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangVchar.class);
    }

}
