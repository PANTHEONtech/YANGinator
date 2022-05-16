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
import tech.pantheon.yanginator.plugin.psi.YangHtab;
import tech.pantheon.yanginator.plugin.psi.YangSp;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangWsp;

public class YangWspImpl extends YangNamedElementImpl implements YangWsp {

  public YangWspImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitWsp(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangHtab getHtab() {
    return findChildByClass(YangHtab.class);
  }

  @Override
  @Nullable
  public YangSp getSp() {
    return findChildByClass(YangSp.class);
  }

}
