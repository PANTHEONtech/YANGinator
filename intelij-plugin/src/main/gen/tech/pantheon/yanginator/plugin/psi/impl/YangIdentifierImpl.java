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
import tech.pantheon.yanginator.plugin.psi.YangAndKeyword;
import tech.pantheon.yanginator.plugin.psi.YangDigit;
import tech.pantheon.yanginator.plugin.psi.YangIdentifier;
import tech.pantheon.yanginator.plugin.psi.YangNotKeyword;
import tech.pantheon.yanginator.plugin.psi.YangOrKeyword;
import tech.pantheon.yanginator.plugin.psi.YangStringSplitter;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangIdentifierImpl extends YangNamedElementImpl implements YangIdentifier {

    public YangIdentifierImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitIdentifier(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<YangDigit> getDigitList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangDigit.class);
    }

    @Override
    @NotNull
    public List<YangAndKeyword> getAndKeywordList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangAndKeyword.class);
    }

    @Override
    @NotNull
    public List<YangNotKeyword> getNotKeywordList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangNotKeyword.class);
    }

    @Override
    @NotNull
    public List<YangOrKeyword> getOrKeywordList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangOrKeyword.class);
    }

    @Override
    @NotNull
    public List<YangStringSplitter> getStringSplitterList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStringSplitter.class);
    }

}
