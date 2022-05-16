/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangDecimalValue;
import tech.pantheon.yanginator.plugin.psi.YangIntegerValue;
import tech.pantheon.yanginator.plugin.psi.YangMaxKeyword;
import tech.pantheon.yanginator.plugin.psi.YangMinKeyword;
import tech.pantheon.yanginator.plugin.psi.YangRangeBoundary;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangRangeBoundaryImpl extends YangNamedElementImpl implements YangRangeBoundary {

  public YangRangeBoundaryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitRangeBoundary(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangDecimalValue getDecimalValue() {
    return findChildByClass(YangDecimalValue.class);
  }

  @Override
  @Nullable
  public YangIntegerValue getIntegerValue() {
    return findChildByClass(YangIntegerValue.class);
  }

  @Override
  @Nullable
  public YangMaxKeyword getMaxKeyword() {
    return findChildByClass(YangMaxKeyword.class);
  }

  @Override
  @Nullable
  public YangMinKeyword getMinKeyword() {
    return findChildByClass(YangMinKeyword.class);
  }

}
