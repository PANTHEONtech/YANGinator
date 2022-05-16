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
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangIfFeatureExpr;
import tech.pantheon.yanginator.plugin.psi.YangIfFeatureTerm;
import tech.pantheon.yanginator.plugin.psi.YangOrKeyword;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangIfFeatureExprImpl extends YangNamedElementImpl implements YangIfFeatureExpr {

  public YangIfFeatureExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitIfFeatureExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangIfFeatureExpr getIfFeatureExpr() {
    return findChildByClass(YangIfFeatureExpr.class);
  }

  @Override
  @NotNull
  public YangIfFeatureTerm getIfFeatureTerm() {
    return findNotNullChildByClass(YangIfFeatureTerm.class);
  }

  @Override
  @Nullable
  public YangOrKeyword getOrKeyword() {
    return findChildByClass(YangOrKeyword.class);
  }

  @Override
  @NotNull
  public List<YangSep> getSepList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangSep.class);
  }

}
