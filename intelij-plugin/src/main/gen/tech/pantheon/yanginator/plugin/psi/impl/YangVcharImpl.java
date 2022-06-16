/*
 *
 *   Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangVchar;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ALPHA;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ALPHANUMERICAL_ALPHA_FIRST;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ALPHANUMERICAL_DIGIT_FIRST;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_AMPERSAND;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_APOSTROPHE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ASTERISK;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_AT_SIGN;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_BACK_SLASH;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_CHARS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_CIRCUMFLEX_ACCENT;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_CLOSED_BRACKET;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_COLON;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_COMMA;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DASH;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DATE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DIGITS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOLLAR_SIGN;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOT;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOUBLE_COLON;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOUBLE_DOT;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOUBLE_FORWARD_SLASH;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_EIGHT;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_EQUALS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_EXCLAMATION_MARK;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_FIVE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_FORWARD_SLASH;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_FOUR;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_FRACTIONS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_GRAVE_ACCENT;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_GREATER_THAN_SIGN;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_HASH;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_IPV4;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_PARENTHESIS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LESS_THAN_SIGN;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_NINE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ONE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_OPEN_BRACKET;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_PARENT_FOLDER;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_PERCENT_SIGN;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_PIPE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_PLUS_SIGN;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_QUESTION_MARK;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_PARENTHESIS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SEVEN;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SIX;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SPACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_THREE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_TILDE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_TWO;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_UNDERSCORE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ZERO;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ZEROS;

public class YangVcharImpl extends YangNamedElementImpl implements YangVchar {

    public YangVcharImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitVchar(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public PsiElement getAlpha() {
        return findChildByType(YANG_ALPHA);
    }

    @Override
    @Nullable
    public PsiElement getAlphanumericalAlphaFirst() {
        return findChildByType(YANG_ALPHANUMERICAL_ALPHA_FIRST);
    }

    @Override
    @Nullable
    public PsiElement getAlphanumericalDigitFirst() {
        return findChildByType(YANG_ALPHANUMERICAL_DIGIT_FIRST);
    }

    @Override
    @Nullable
    public PsiElement getAmpersand() {
        return findChildByType(YANG_AMPERSAND);
    }

    @Override
    @Nullable
    public PsiElement getApostrophe() {
        return findChildByType(YANG_APOSTROPHE);
    }

    @Override
    @Nullable
    public PsiElement getAsterisk() {
        return findChildByType(YANG_ASTERISK);
    }

    @Override
    @Nullable
    public PsiElement getAtSign() {
        return findChildByType(YANG_AT_SIGN);
    }

    @Override
    @Nullable
    public PsiElement getBackSlash() {
        return findChildByType(YANG_BACK_SLASH);
    }

    @Override
    @Nullable
    public PsiElement getChars() {
        return findChildByType(YANG_CHARS);
    }

    @Override
    @Nullable
    public PsiElement getCircumflexAccent() {
        return findChildByType(YANG_CIRCUMFLEX_ACCENT);
    }

    @Override
    @Nullable
    public PsiElement getClosedBracket() {
        return findChildByType(YANG_CLOSED_BRACKET);
    }

    @Override
    @Nullable
    public PsiElement getColon() {
        return findChildByType(YANG_COLON);
    }

    @Override
    @Nullable
    public PsiElement getComma() {
        return findChildByType(YANG_COMMA);
    }

    @Override
    @Nullable
    public PsiElement getDash() {
        return findChildByType(YANG_DASH);
    }

    @Override
    @Nullable
    public PsiElement getDate() {
        return findChildByType(YANG_DATE);
    }

    @Override
    @Nullable
    public PsiElement getDigits() {
        return findChildByType(YANG_DIGITS);
    }

    @Override
    @Nullable
    public PsiElement getDollarSign() {
        return findChildByType(YANG_DOLLAR_SIGN);
    }

    @Override
    @Nullable
    public PsiElement getDot() {
        return findChildByType(YANG_DOT);
    }

    @Override
    @Nullable
    public PsiElement getDoubleColon() {
        return findChildByType(YANG_DOUBLE_COLON);
    }

    @Override
    @Nullable
    public PsiElement getDoubleDot() {
        return findChildByType(YANG_DOUBLE_DOT);
    }

    @Override
    @Nullable
    public PsiElement getDoubleForwardSlash() {
        return findChildByType(YANG_DOUBLE_FORWARD_SLASH);
    }

    @Override
    @Nullable
    public PsiElement getEight() {
        return findChildByType(YANG_EIGHT);
    }

    @Override
    @Nullable
    public PsiElement getEquals() {
        return findChildByType(YANG_EQUALS);
    }

    @Override
    @Nullable
    public PsiElement getExclamationMark() {
        return findChildByType(YANG_EXCLAMATION_MARK);
    }

    @Override
    @Nullable
    public PsiElement getFive() {
        return findChildByType(YANG_FIVE);
    }

    @Override
    @Nullable
    public PsiElement getForwardSlash() {
        return findChildByType(YANG_FORWARD_SLASH);
    }

    @Override
    @Nullable
    public PsiElement getFour() {
        return findChildByType(YANG_FOUR);
    }

    @Override
    @Nullable
    public PsiElement getFractions() {
        return findChildByType(YANG_FRACTIONS);
    }

    @Override
    @Nullable
    public PsiElement getGraveAccent() {
        return findChildByType(YANG_GRAVE_ACCENT);
    }

    @Override
    @Nullable
    public PsiElement getGreaterThanSign() {
        return findChildByType(YANG_GREATER_THAN_SIGN);
    }

    @Override
    @Nullable
    public PsiElement getHash() {
        return findChildByType(YANG_HASH);
    }

    @Override
    @Nullable
    public PsiElement getIpv4() {
        return findChildByType(YANG_IPV4);
    }

    @Override
    @Nullable
    public PsiElement getLeftParenthesis() {
        return findChildByType(YANG_LEFT_PARENTHESIS);
    }

    @Override
    @Nullable
    public PsiElement getLessThanSign() {
        return findChildByType(YANG_LESS_THAN_SIGN);
    }

    @Override
    @Nullable
    public PsiElement getNine() {
        return findChildByType(YANG_NINE);
    }

    @Override
    @Nullable
    public PsiElement getOne() {
        return findChildByType(YANG_ONE);
    }

    @Override
    @Nullable
    public PsiElement getOpenBracket() {
        return findChildByType(YANG_OPEN_BRACKET);
    }

    @Override
    @Nullable
    public PsiElement getParentFolder() {
        return findChildByType(YANG_PARENT_FOLDER);
    }

    @Override
    @Nullable
    public PsiElement getPercentSign() {
        return findChildByType(YANG_PERCENT_SIGN);
    }

    @Override
    @Nullable
    public PsiElement getPipe() {
        return findChildByType(YANG_PIPE);
    }

    @Override
    @Nullable
    public PsiElement getPlusSign() {
        return findChildByType(YANG_PLUS_SIGN);
    }

    @Override
    @Nullable
    public PsiElement getQuestionMark() {
        return findChildByType(YANG_QUESTION_MARK);
    }

    @Override
    @Nullable
    public PsiElement getRightParenthesis() {
        return findChildByType(YANG_RIGHT_PARENTHESIS);
    }

    @Override
    @Nullable
    public PsiElement getSeven() {
        return findChildByType(YANG_SEVEN);
    }

    @Override
    @Nullable
    public PsiElement getSix() {
        return findChildByType(YANG_SIX);
    }

    @Override
    @Nullable
    public PsiElement getSpace() {
        return findChildByType(YANG_SPACE);
    }

    @Override
    @Nullable
    public PsiElement getThree() {
        return findChildByType(YANG_THREE);
    }

    @Override
    @Nullable
    public PsiElement getTilde() {
        return findChildByType(YANG_TILDE);
    }

    @Override
    @Nullable
    public PsiElement getTwo() {
        return findChildByType(YANG_TWO);
    }

    @Override
    @Nullable
    public PsiElement getUnderscore() {
        return findChildByType(YANG_UNDERSCORE);
    }

    @Override
    @Nullable
    public PsiElement getZero() {
        return findChildByType(YANG_ZERO);
    }

    @Override
    @Nullable
    public PsiElement getZeros() {
        return findChildByType(YANG_ZEROS);
    }

}
