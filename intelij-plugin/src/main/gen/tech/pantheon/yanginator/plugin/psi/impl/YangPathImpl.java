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
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.*;

public class YangPathImpl extends YangNamedElementImpl implements YangPath {

  public YangPathImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPath(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangPathAbempty getPathAbempty() {
    return findChildByClass(YangPathAbempty.class);
  }

  @Override
  @Nullable
  public YangPathAbsolute getPathAbsolute() {
    return findChildByClass(YangPathAbsolute.class);
  }

  @Override
  @Nullable
  public YangPathEmpty getPathEmpty() {
    return findChildByClass(YangPathEmpty.class);
  }

  @Override
  @Nullable
  public YangPathNoscheme getPathNoscheme() {
    return findChildByClass(YangPathNoscheme.class);
  }

  @Override
  @Nullable
  public YangPathRootless getPathRootless() {
    return findChildByClass(YangPathRootless.class);
  }

}
