/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.highlighter.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.*;
import tech.pantheon.yanginator.plugin.psi.impl.YangNamedElementImpl;
import tech.pantheon.yanginator.plugin.highlighter.psi.*;

public class YangDummyImpl extends YangNamedElementImpl implements YangDummy {

  public YangDummyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitDummy(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangWsp> getWspList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangWsp.class);
  }

  @Override
  @NotNull
  public PsiElement getHIdentifier() {
    return findNotNullChildByType(YANG_H_IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getHString() {
    return findChildByType(YANG_H_STRING);
  }

}
