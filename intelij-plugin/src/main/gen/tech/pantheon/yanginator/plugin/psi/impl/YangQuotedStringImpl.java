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
import tech.pantheon.yanginator.plugin.injection.impl.YangLanguageInjectionHostImpl;
import tech.pantheon.yanginator.plugin.psi.YangDoubleQuotedVchar;
import tech.pantheon.yanginator.plugin.psi.YangDquote;
import tech.pantheon.yanginator.plugin.psi.YangQuotedString;
import tech.pantheon.yanginator.plugin.psi.YangQuotedVchar;
import tech.pantheon.yanginator.plugin.psi.YangSquote;
import tech.pantheon.yanginator.plugin.psi.YangStringSplitter;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangQuotedStringImpl extends YangLanguageInjectionHostImpl implements YangQuotedString {

    public YangQuotedStringImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitQuotedString(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<YangDquote> getDquoteList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangDquote.class);
    }

    @Override
    @NotNull
    public List<YangSquote> getSquoteList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangSquote.class);
    }

    @Override
    @NotNull
    public List<YangDoubleQuotedVchar> getDoubleQuotedVcharList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangDoubleQuotedVchar.class);
    }

    @Override
    @NotNull
    public List<YangQuotedVchar> getQuotedVcharList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangQuotedVchar.class);
    }

    @Override
    @NotNull
    public List<YangStringSplitter> getStringSplitterList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStringSplitter.class);
    }

}
