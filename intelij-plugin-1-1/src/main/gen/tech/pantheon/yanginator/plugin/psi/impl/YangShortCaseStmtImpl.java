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
import tech.pantheon.yanginator.plugin.psi.YangAnydataStmt;
import tech.pantheon.yanginator.plugin.psi.YangAnyxmlStmt;
import tech.pantheon.yanginator.plugin.psi.YangChoiceStmt;
import tech.pantheon.yanginator.plugin.psi.YangContainerStmt;
import tech.pantheon.yanginator.plugin.psi.YangLeafListStmt;
import tech.pantheon.yanginator.plugin.psi.YangLeafStmt;
import tech.pantheon.yanginator.plugin.psi.YangListStmt;
import tech.pantheon.yanginator.plugin.psi.YangShortCaseStmt;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangShortCaseStmtImpl extends YangNamedElementImpl implements YangShortCaseStmt {

  public YangShortCaseStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitShortCaseStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangAnydataStmt getAnydataStmt() {
    return findChildByClass(YangAnydataStmt.class);
  }

  @Override
  @Nullable
  public YangAnyxmlStmt getAnyxmlStmt() {
    return findChildByClass(YangAnyxmlStmt.class);
  }

  @Override
  @Nullable
  public YangChoiceStmt getChoiceStmt() {
    return findChildByClass(YangChoiceStmt.class);
  }

  @Override
  @Nullable
  public YangContainerStmt getContainerStmt() {
    return findChildByClass(YangContainerStmt.class);
  }

  @Override
  @Nullable
  public YangLeafListStmt getLeafListStmt() {
    return findChildByClass(YangLeafListStmt.class);
  }

  @Override
  @Nullable
  public YangLeafStmt getLeafStmt() {
    return findChildByClass(YangLeafStmt.class);
  }

  @Override
  @Nullable
  public YangListStmt getListStmt() {
    return findChildByClass(YangListStmt.class);
  }

}
