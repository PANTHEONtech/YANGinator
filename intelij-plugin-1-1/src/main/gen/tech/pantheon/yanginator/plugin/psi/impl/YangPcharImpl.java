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
import tech.pantheon.yanginator.plugin.psi.YangPchar;
import tech.pantheon.yanginator.plugin.psi.YangPctEncoded;
import tech.pantheon.yanginator.plugin.psi.YangSubDelims;
import tech.pantheon.yanginator.plugin.psi.YangUnreserved;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_AT_SIGN;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_COLON;

public class YangPcharImpl extends YangNamedElementImpl implements YangPchar {

  public YangPcharImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPchar(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangPctEncoded getPctEncoded() {
    return findChildByClass(YangPctEncoded.class);
  }

  @Override
  @Nullable
  public YangSubDelims getSubDelims() {
    return findChildByClass(YangSubDelims.class);
  }

  @Override
  @Nullable
  public YangUnreserved getUnreserved() {
    return findChildByClass(YangUnreserved.class);
  }

  @Override
  @Nullable
  public PsiElement getAtSign() {
    return findChildByType(YANG_AT_SIGN);
  }

  @Override
  @Nullable
  public PsiElement getColon() {
    return findChildByType(YANG_COLON);
  }

}
