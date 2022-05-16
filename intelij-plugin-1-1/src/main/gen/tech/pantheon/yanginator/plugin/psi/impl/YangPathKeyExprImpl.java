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
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangCurrentFunctionInvocation;
import tech.pantheon.yanginator.plugin.psi.YangPathKeyExpr;
import tech.pantheon.yanginator.plugin.psi.YangRelPathKeyexpr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangWsp;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_FORWARD_SLASH;

public class YangPathKeyExprImpl extends YangNamedElementImpl implements YangPathKeyExpr {

  public YangPathKeyExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPathKeyExpr(this);
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
  public YangCurrentFunctionInvocation getCurrentFunctionInvocation() {
    return findNotNullChildByClass(YangCurrentFunctionInvocation.class);
  }

  @Override
  @NotNull
  public YangRelPathKeyexpr getRelPathKeyexpr() {
    return findNotNullChildByClass(YangRelPathKeyexpr.class);
  }

  @Override
  @NotNull
  public PsiElement getForwardSlash() {
    return findNotNullChildByType(YANG_FORWARD_SLASH);
  }

}
