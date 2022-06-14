/*
 *
 *   Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.foldingManager;

import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class YangFoldingManagerUtil {

    public static final FoldingDescriptor[] EMPTY_FOLDING_DESCRIPTORS = new FoldingDescriptor[0];
    public static final String SINGLE_QUOTE_STRING = "'";
    public static final String DOUBLE_QUOTE_STRING = "\"";
    public static final String SINGLE_LINE_COMMENT = "//";
    public static final String MULTI_LANE_COMMENT_START = "/*";
    public static final String MULTI_LANE_COMMENT_END = "*/";

    private YangFoldingManagerUtil() {
    }

    public static List<FoldingDescriptor> addElementToDescriptors(
            final List<FoldingDescriptor> descriptors,
            final PsiElement root,
            final int startOffset,
            final int endOffset) {
        descriptors.add(
                /* set to root in case of short term element error while writing code when element
                 does not exist but his body in root still does*/
                new FoldingDescriptor(root.getNode(),
                        new TextRange(startOffset,
                                endOffset)));
        return descriptors;
    }

    public static void setFoldingDescriptors(
            final PsiElement root,
            final List<FoldingDescriptor> output,
            final DocumentPositionType startItem,
            final DocumentPositionType endItem) {
        YangFoldingManagerUtil.addElementToDescriptors(
                output,
                root,
                startItem.getOffset(),
                endItem.getOffset() + 1);
        startItem.setAsPaired();
        endItem.setAsPaired();
    }

    public static <T extends DocumentPositionType> List<T> findDoubleQuotePositionsInDocument(
            final Document document,
            final String text,
            final Function<Integer, T> constructorApplier) {
        final List<T> positions = new ArrayList<>();
        final String documentText = document.getText();
        int position = 0;

        while (position >= 0 && position < documentText.length()) {
            if (documentText.startsWith(text, position)) {
                positions.add(constructorApplier.apply(position));
                position = skipString(position, documentText);
                if (position >= 0 && position < documentText.length()) {
                    positions.add(constructorApplier.apply(position));
                }
            } else {
                position = skipCommentsAndStrings(position, documentText);
            }
            position = position == -1 ? -1 : position + 1;
        }
        return positions;
    }

    public static <T extends DocumentPositionType> List<T> findTextPositionsInDocumentIgnoringCommentsAndStrings(
            final Document document,
            final String text,
            final Function<Integer, T> constructorApplier) {
        final List<T> positions = new ArrayList<>();
        final String documentText = document.getText();
        int position = 0;

        while (position >= 0 && position < documentText.length()) {
            if (documentText.startsWith(text, position)) {
                positions.add(constructorApplier.apply(position));
            } else {
                position = skipCommentsAndStrings(position, documentText);
            }
            position = position == -1 ? -1 : position + 1;
        }
        return positions;
    }

    private static int skipCommentsAndStrings(final int position, final String documentText) {
        if (documentText.startsWith(SINGLE_QUOTE_STRING, position)) {
            return documentText.indexOf(SINGLE_QUOTE_STRING, position + 1);
        } else if (documentText.startsWith(DOUBLE_QUOTE_STRING, position)) {
            return skipString(position, documentText);
        } else if (documentText.startsWith(SINGLE_LINE_COMMENT, position)) {
            return documentText.indexOf(System.lineSeparator(), position + 1);
        } else if (documentText.startsWith(MULTI_LANE_COMMENT_START, position)) {
            return documentText.indexOf(MULTI_LANE_COMMENT_END, position + 1);
        }
        return position;
    }

    private static int skipString(final int position, final String documentText) {
        int newPosition = documentText.indexOf(DOUBLE_QUOTE_STRING, position + 1);
        while (newPosition > 0 && documentText.charAt(newPosition - 1) == '\\') {
            newPosition = documentText.indexOf(DOUBLE_QUOTE_STRING, newPosition + 1);
        }
        return newPosition;
    }
}






