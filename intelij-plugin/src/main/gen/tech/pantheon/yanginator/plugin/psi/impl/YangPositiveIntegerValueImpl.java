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
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangDigit;
import tech.pantheon.yanginator.plugin.psi.YangNonZeroDigit;
import tech.pantheon.yanginator.plugin.psi.YangPositiveIntegerValue;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DIGITS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_FRACTIONS;

public class YangPositiveIntegerValueImpl extends YangNamedElementImpl implements YangPositiveIntegerValue {

  public YangPositiveIntegerValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPositiveIntegerValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangDigit> getDigitList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangDigit.class);
  }

  @Override
  @Nullable
  public YangNonZeroDigit getNonZeroDigit() {
    return findChildByClass(YangNonZeroDigit.class);
  }

  @Override
  @Nullable
  public PsiElement getDigits() {
    return findChildByType(YANG_DIGITS);
  }

  @Override
  @Nullable
  public PsiElement getFractions() {
    return findChildByType(YANG_FRACTIONS);
  }

}
