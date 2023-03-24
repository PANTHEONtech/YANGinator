/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangComchar extends YangNamedElement {

    @Nullable
    YangDoubleForwardSlash getDoubleForwardSlash();

    @NotNull
    List<YangWsp> getWspList();

    @NotNull
    List<YangComment> getCommentList();

    @NotNull
    List<YangLineBreak> getLineBreakList();

    @Nullable
    PsiElement getAlpha();

    @Nullable
    PsiElement getAlphanumericalAlphaFirst();

    @Nullable
    PsiElement getAlphanumericalDigitFirst();

    @Nullable
    PsiElement getAmpersand();

    @Nullable
    PsiElement getApostrophe();

    @Nullable
    PsiElement getAtSign();

    @Nullable
    PsiElement getBackSlash();

    @Nullable
    PsiElement getCarriageReturn();

    @Nullable
    PsiElement getChars();

    @Nullable
    PsiElement getCircumflexAccent();

    @Nullable
    PsiElement getClosedBracket();

    @Nullable
    PsiElement getColon();

    @Nullable
    PsiElement getComma();

    @Nullable
    PsiElement getDash();

    @Nullable
    PsiElement getDate();

    @Nullable
    PsiElement getDigits();

    @Nullable
    PsiElement getDollarSign();

    @Nullable
    PsiElement getDot();

    @Nullable
    PsiElement getDoubleColon();

    @Nullable
    PsiElement getDoubleDot();

    @Nullable
    PsiElement getDoubleQuote();

    @Nullable
    PsiElement getEight();

    @Nullable
    PsiElement getEquals();

    @Nullable
    PsiElement getEscapes();

    @Nullable
    PsiElement getExclamationMark();

    @Nullable
    PsiElement getFive();

    @Nullable
    PsiElement getForwardSlash();

    @Nullable
    PsiElement getFour();

    @Nullable
    PsiElement getFractions();

    @Nullable
    PsiElement getGraveAccent();

    @Nullable
    PsiElement getGreaterThanSign();

    @Nullable
    PsiElement getHash();

    @Nullable
    PsiElement getIpv4();

    @Nullable
    PsiElement getLeftBrace();

    @Nullable
    PsiElement getLeftParenthesis();

    @Nullable
    PsiElement getLessThanSign();

    @Nullable
    PsiElement getLinefeed();

    @Nullable
    PsiElement getNine();

    @Nullable
    PsiElement getOne();

    @Nullable
    PsiElement getOpenBracket();

    @Nullable
    PsiElement getParentFolder();

    @Nullable
    PsiElement getPercentSign();

    @Nullable
    PsiElement getPipe();

    @Nullable
    PsiElement getPlusSign();

    @Nullable
    PsiElement getQuestionMark();

    @Nullable
    PsiElement getRightBrace();

    @Nullable
    PsiElement getRightParenthesis();

    @Nullable
    PsiElement getSemicolon();

    @Nullable
    PsiElement getSeven();

    @Nullable
    PsiElement getSingleQuote();

    @Nullable
    PsiElement getSix();

    @Nullable
    PsiElement getSpace();

    @Nullable
    PsiElement getTab();

    @Nullable
    PsiElement getThree();

    @Nullable
    PsiElement getTilde();

    @Nullable
    PsiElement getTwo();

    @Nullable
    PsiElement getUnderscore();

    @Nullable
    PsiElement getZero();

    @Nullable
    PsiElement getZeros();

}
