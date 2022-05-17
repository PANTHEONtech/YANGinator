/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
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
import tech.pantheon.yanginator.plugin.psi.YangDecOctet;
import tech.pantheon.yanginator.plugin.psi.YangDigit;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_FOUR;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ONE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_POSITIVE_NUMBER;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_THREE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ZERO;

public class YangDecOctetImpl extends YangNamedElementImpl implements YangDecOctet {

  public YangDecOctetImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitDecOctet(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangDigit getDigit() {
    return findChildByClass(YangDigit.class);
  }

  @Override
  @Nullable
  public PsiElement getFour() {
    return findChildByType(YANG_FOUR);
  }

  @Override
  @Nullable
  public PsiElement getOne() {
    return findChildByType(YANG_ONE);
  }

  @Override
  @Nullable
  public PsiElement getPositiveNumber() {
    return findChildByType(YANG_POSITIVE_NUMBER);
  }

  @Override
  @Nullable
  public PsiElement getThree() {
    return findChildByType(YANG_THREE);
  }

  @Override
  @Nullable
  public PsiElement getZero() {
    return findChildByType(YANG_ZERO);
  }

}
