/*
 *
 *  Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.*;
import tech.pantheon.yanginator.plugin.psi.*;

public class YangVcharImpl extends YangNamedElementImpl implements YangVchar {

  public YangVcharImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitVchar(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
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
