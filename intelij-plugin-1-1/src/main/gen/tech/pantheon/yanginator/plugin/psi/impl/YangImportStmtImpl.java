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
import tech.pantheon.yanginator.plugin.psi.YangIdentifierArgStr;
import tech.pantheon.yanginator.plugin.psi.YangImportKeyword;
import tech.pantheon.yanginator.plugin.psi.YangImportStmt;
import tech.pantheon.yanginator.plugin.psi.YangOptsep;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtsep;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_BRACE;

public class YangImportStmtImpl extends YangNamedElementImpl implements YangImportStmt {

  public YangImportStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitImportStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangIdentifierArgStr getIdentifierArgStr() {
    return findNotNullChildByClass(YangIdentifierArgStr.class);
  }

  @Override
  @NotNull
  public YangImportKeyword getImportKeyword() {
    return findNotNullChildByClass(YangImportKeyword.class);
  }

  @Override
  @NotNull
  public YangOptsep getOptsep() {
    return findNotNullChildByClass(YangOptsep.class);
  }

  @Override
  @NotNull
  public YangSep getSep() {
    return findNotNullChildByClass(YangSep.class);
  }

  @Override
  @NotNull
  public List<YangStmtsep> getStmtsepList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStmtsep.class);
  }

  @Override
  @NotNull
  public PsiElement getLeftBrace() {
    return findNotNullChildByType(YANG_LEFT_BRACE);
  }

  @Override
  @NotNull
  public PsiElement getRightBrace() {
    return findNotNullChildByType(YANG_RIGHT_BRACE);
  }

}
