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
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class YangCurlyBraceFoldingManager extends FoldingBuilderEx implements DumbAware {

    private static final String CODE_BLOCK_PLACEHOLDER_TEXT = "{ ... }";
    private static final int NEXT_AVAILABLE_INDEX_NOT_FOUND = -1;

    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(
            @NotNull final PsiElement root, @NotNull final Document document, final boolean initialRun) {

        final List<CurlyBraceDocumentPositionType> curlyBracesPositions;
        List<FoldingDescriptor> descriptors = new ArrayList<>();
        curlyBracesPositions = this.getSortedCurlyBracePositionTypesFromDocument(document);

        if (curlyBracesPositions.isEmpty()) {
            return YangFoldingManagerUtil.EMPTY_FOLDING_DESCRIPTORS;
        }
        if (this.leftBracesCount(curlyBracesPositions) == this.rightBracesCount(curlyBracesPositions)) {
            descriptors = this.getDescriptorsFromCurlyBracePositions(curlyBracesPositions, root);
        }
        return descriptors.toArray(new FoldingDescriptor[0]);
    }

    private long rightBracesCount(final List<CurlyBraceDocumentPositionType> curlyBracesPositions) {
        return this.curlyBracesCount(curlyBracesPositions, CurlyBraceDocumentPositionType::isRight);
    }

    private long curlyBracesCount(
            final List<CurlyBraceDocumentPositionType> curlyBracesPositions,
            final Predicate<CurlyBraceDocumentPositionType> filter
    ) {
        return curlyBracesPositions.stream()
                .filter(filter)
                .count();
    }

    private long leftBracesCount(final List<CurlyBraceDocumentPositionType> curlyBracesPositions) {
        return this.curlyBracesCount(curlyBracesPositions, CurlyBraceDocumentPositionType::isLeft);

    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull final ASTNode astNode) {
        return CODE_BLOCK_PLACEHOLDER_TEXT;
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull final ASTNode astNode) {
        return false;
    }

    private List<FoldingDescriptor> getDescriptorsFromCurlyBracePositions
            (final List<CurlyBraceDocumentPositionType> curlyInput, final PsiElement root) {
        final List<FoldingDescriptor> foldingDescriptors = new ArrayList<>();
        boolean found;

        do {
            found = this.assignDescriptorsFromDocumentPositionTypes(curlyInput, root, foldingDescriptors);

        } while (found);
        return foldingDescriptors;
    }

    private boolean assignDescriptorsFromDocumentPositionTypes(
            final List<CurlyBraceDocumentPositionType> curlyInput,
            final PsiElement root,
            final List<FoldingDescriptor> foldingDescriptors) {
        var found = false;
        for (int currentIndex = 0; currentIndex < curlyInput.size(); currentIndex++) {
            currentIndex = this.findNextNotPairedIndex(curlyInput, currentIndex);
            final int indexOfPaired = this.findPairedIndex(curlyInput, currentIndex);

            if (indexOfPaired == NEXT_AVAILABLE_INDEX_NOT_FOUND) {
                break;
            }
            if (this.areCurlyBracesLeftAndRight(curlyInput, currentIndex, indexOfPaired)) {
                found = true;
                YangFoldingManagerUtil.setFoldingDescriptors
                        (root, foldingDescriptors, curlyInput.get(currentIndex), curlyInput.get(indexOfPaired));
            } else if (this.areCurlyBracesLeftAndRight(curlyInput, indexOfPaired, currentIndex)) {
                YangFoldingManagerUtil.setFoldingDescriptors
                        (root, foldingDescriptors, curlyInput.get(indexOfPaired), curlyInput.get(currentIndex));
                found = true;
            }

        }
        return found;
    }

    private int findPairedIndex(final List<CurlyBraceDocumentPositionType> curlyInput, final int currentIndex) {
        final int indexOfPaired;

        // for effectivity algorithm searches above or below index
        if (curlyInput.get(currentIndex).getBraceType() == CurlyBraceStringEnum.LEFT) {
            indexOfPaired = this.getBelowAvailableIndex(curlyInput, currentIndex);
        } else {
            indexOfPaired = this.getAboveAvailableIndex(curlyInput, currentIndex);
        }
        return indexOfPaired;
    }


    private int getAboveAvailableIndex(final List<CurlyBraceDocumentPositionType> curlyInput, final int searchFrom) {
        return this.searchAvailableIndex(curlyInput, searchFrom, i -> i - 1);
    }

    private int getBelowAvailableIndex(final List<CurlyBraceDocumentPositionType> curlyInput, final int searchFrom) {
        return this.searchAvailableIndex(curlyInput, searchFrom, i -> i + 1);
    }

    private int searchAvailableIndex(
            final List<CurlyBraceDocumentPositionType> curlyInput,
            final int searchFrom,
            final Function<Integer, Integer> supplier) {
        int pairIndex = supplier.apply(searchFrom);

        while (pairIndex != searchFrom) {
            // can occur when all elements are paired
            if (pairIndex >= curlyInput.size()) {
                return NEXT_AVAILABLE_INDEX_NOT_FOUND;
            }
            if (!curlyInput.get(pairIndex).isPaired()) {
                return pairIndex;
            }
            if (supplier.apply(0) > 0) {
                pairIndex = curlyInput.size() - 1 == pairIndex ? 0 : supplier.apply(pairIndex);
            } else {
                pairIndex = 0 == pairIndex ? curlyInput.size() : supplier.apply(pairIndex);
            }

        }
        return NEXT_AVAILABLE_INDEX_NOT_FOUND;
    }

    private int findNextNotPairedIndex(final List<CurlyBraceDocumentPositionType> curlyInput, int searchFrom) {
        while (curlyInput.get(searchFrom).isPaired()) {
            if ((searchFrom + 1) == curlyInput.size()) {
                break;
            }
            searchFrom++;

        }
        return searchFrom;
    }

    @NotNull
    private List<CurlyBraceDocumentPositionType> getSortedCurlyBracePositionTypesFromDocument(final Document document) {
        List<CurlyBraceDocumentPositionType> bracesPositions
                = this.findBracePositionsInDocument(document, CurlyBraceStringEnum.LEFT);
        final int leftBracesCount = bracesPositions.size();

        bracesPositions.addAll(this.findBracePositionsInDocument(document, CurlyBraceStringEnum.RIGHT));
        if (leftBracesCount != (bracesPositions.size() - leftBracesCount)) return Collections.emptyList();
        bracesPositions = bracesPositions.stream()
                .sorted(Comparator.comparing(CurlyBraceDocumentPositionType::getOffset))
                .collect(Collectors.toList());
        return bracesPositions;
    }


    private List<CurlyBraceDocumentPositionType> findBracePositionsInDocument(
            final Document document, final CurlyBraceStringEnum curlyBraceType) {
        return YangFoldingManagerUtil.findTextPositionsInDocumentIgnoringCommentsAndStrings(
                document,
                curlyBraceType.getStringValue(),
                i -> new CurlyBraceDocumentPositionType(i, curlyBraceType));
    }

    private boolean areCurlyBracesLeftAndRight(
            final List<CurlyBraceDocumentPositionType> curlyInput, final int firstIndex, final int secondIndex) {
        return curlyInput.get(firstIndex).isLeft() && curlyInput.get(secondIndex).isRight();
    }
}
