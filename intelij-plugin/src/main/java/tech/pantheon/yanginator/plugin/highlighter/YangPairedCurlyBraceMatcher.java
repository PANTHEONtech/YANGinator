/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.highlighter;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes;
import tech.pantheon.yanginator.plugin.psi.YangTokenTypeSets;

public class YangPairedCurlyBraceMatcher implements PairedBraceMatcher {
    private static final BracePair[] BRACE_PAIRS = {
            new BracePair(YangTypes.YANG_H_LEFT_BRACE, YangTypes.YANG_H_RIGHT_BRACE, true)
    };

    @NotNull
    @Override
    public BracePair[] getPairs() {
        return BRACE_PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return !YangTokenTypeSets.STRINGS.contains(contextType);
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
