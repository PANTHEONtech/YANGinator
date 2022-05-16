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
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtend;
import tech.pantheon.yanginator.plugin.psi.YangUniqueArgStr;
import tech.pantheon.yanginator.plugin.psi.YangUniqueKeyword;
import tech.pantheon.yanginator.plugin.psi.YangUniqueStmt;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangUniqueStmtImpl extends YangNamedElementImpl implements YangUniqueStmt {

  public YangUniqueStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitUniqueStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangSep getSep() {
    return findNotNullChildByClass(YangSep.class);
  }

  @Override
  @NotNull
  public YangStmtend getStmtend() {
    return findNotNullChildByClass(YangStmtend.class);
  }

  @Override
  @NotNull
  public YangUniqueArgStr getUniqueArgStr() {
    return findNotNullChildByClass(YangUniqueArgStr.class);
  }

  @Override
  @NotNull
  public YangUniqueKeyword getUniqueKeyword() {
    return findNotNullChildByClass(YangUniqueKeyword.class);
  }

}
