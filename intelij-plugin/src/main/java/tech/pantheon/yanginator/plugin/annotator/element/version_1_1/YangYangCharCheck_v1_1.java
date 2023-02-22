/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.annotator.element.version_1_1;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.annotator.element.AbstractYangStmtCheck;
import tech.pantheon.yanginator.plugin.psi.YangVchar;

import java.util.ArrayList;
import java.util.List;

public class YangYangCharCheck_v1_1 extends AbstractYangStmtCheck {
    private static final List<String> stringList = List.of("%xD800-DFFF",
            "%xFDD0-FDEF", "%xFFFE-FFFF", "%x1FFFE-1FFFF",
            "%x2FFFE-2FFFF", "%x3FFFE-3FFFF", "%x4FFFE-4FFFF",
            "%x5FFFE-5FFFF", "%x6FFFE-6FFFF", "%x7FFFE-7FFFF",
            "%x8FFFE-8FFFF", "%x9FFFE-9FFFF", "%xAFFFE-AFFFF",
            "%xBFFFE-BFFFF", "%xCFFFE-CFFFF", "%xDFFFE-DFFFF",
            "%xEFFFE-EFFFF", "%xFFFFE-FFFFF", "%x10FFFE-10FFFF");
    private static final List<Character> charList = stringsToChars(stringList);

    @Override
    public boolean isApplicable(@NotNull final PsiElement element) {
        return element instanceof YangVchar;
    }

    @Override
    public void performCheck(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder) {
        String text = element.getText();
        for (char c : text.toCharArray()) {
            boolean result = charList.parallelStream().anyMatch(character -> character.equals(c));
            if (result) {
                holder.newAnnotation(HighlightSeverity.ERROR, "Illegal character used")
                        .range(element.getFirstChild())
                        .create();
            }

        }
    }

    private static List<Character> stringsToChars(List<String> stringList) {
        List<Character> charList = new ArrayList<>();
        // 0xFFFD is for characters that can't be recognized by idea and are replaced by this value
        charList.add((char) 0xFFFD);
        for (String s : stringList) {
            String current = s.substring(2);
            String[] list = current.split("-");
            int low = Integer.decode("0x" + list[0]);
            int high = Integer.decode("0x" + list[1]);
            for (int j = low; j <= high; j++) {
                charList.add((char) j);
            }
        }
        return charList;
    }
}