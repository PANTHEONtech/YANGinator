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
import tech.pantheon.yanginator.plugin.psi.YangAugmentStmt;
import tech.pantheon.yanginator.plugin.psi.YangBodyStmts;
import tech.pantheon.yanginator.plugin.psi.YangDataDefStmt;
import tech.pantheon.yanginator.plugin.psi.YangDeviationStmt;
import tech.pantheon.yanginator.plugin.psi.YangExtensionStmt;
import tech.pantheon.yanginator.plugin.psi.YangFeatureStmt;
import tech.pantheon.yanginator.plugin.psi.YangGroupingStmt;
import tech.pantheon.yanginator.plugin.psi.YangIdentityStmt;
import tech.pantheon.yanginator.plugin.psi.YangNotificationStmt;
import tech.pantheon.yanginator.plugin.psi.YangRpcStmt;
import tech.pantheon.yanginator.plugin.psi.YangTypedefStmt;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangBodyStmtsImpl extends YangNamedElementImpl implements YangBodyStmts {

  public YangBodyStmtsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitBodyStmts(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangAugmentStmt> getAugmentStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangAugmentStmt.class);
  }

  @Override
  @NotNull
  public List<YangDataDefStmt> getDataDefStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangDataDefStmt.class);
  }

  @Override
  @NotNull
  public List<YangDeviationStmt> getDeviationStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangDeviationStmt.class);
  }

  @Override
  @NotNull
  public List<YangExtensionStmt> getExtensionStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangExtensionStmt.class);
  }

  @Override
  @NotNull
  public List<YangFeatureStmt> getFeatureStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangFeatureStmt.class);
  }

  @Override
  @NotNull
  public List<YangGroupingStmt> getGroupingStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangGroupingStmt.class);
  }

  @Override
  @NotNull
  public List<YangIdentityStmt> getIdentityStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangIdentityStmt.class);
  }

  @Override
  @NotNull
  public List<YangNotificationStmt> getNotificationStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangNotificationStmt.class);
  }

  @Override
  @NotNull
  public List<YangRpcStmt> getRpcStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangRpcStmt.class);
  }

  @Override
  @NotNull
  public List<YangTypedefStmt> getTypedefStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangTypedefStmt.class);
  }

}
