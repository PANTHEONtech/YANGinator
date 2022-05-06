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

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.*;
import tech.pantheon.yanginator.plugin.psi.*;

public class YangModuleStmtImpl extends YangNamedElementImpl implements YangModuleStmt {

  public YangModuleStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitModuleStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangBodyStmts getBodyStmts() {
    return findNotNullChildByClass(YangBodyStmts.class);
  }

  @Override
  @NotNull
  public YangIdentifierArgStr getIdentifierArgStr() {
    return findNotNullChildByClass(YangIdentifierArgStr.class);
  }

  @Override
  @NotNull
  public YangLinkageStmts getLinkageStmts() {
    return findNotNullChildByClass(YangLinkageStmts.class);
  }

  @Override
  @NotNull
  public YangMetaStmts getMetaStmts() {
    return findNotNullChildByClass(YangMetaStmts.class);
  }

  @Override
  @NotNull
  public YangModuleHeaderStmts getModuleHeaderStmts() {
    return findNotNullChildByClass(YangModuleHeaderStmts.class);
  }

  @Override
  @NotNull
  public YangModuleKeyword getModuleKeyword() {
    return findNotNullChildByClass(YangModuleKeyword.class);
  }

  @Override
  @NotNull
  public List<YangOptsep> getOptsepList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangOptsep.class);
  }

  @Override
  @NotNull
  public YangRevisionStmts getRevisionStmts() {
    return findNotNullChildByClass(YangRevisionStmts.class);
  }

  @Override
  @NotNull
  public YangSep getSep() {
    return findNotNullChildByClass(YangSep.class);
  }

  @Override
  @NotNull
  public YangStmtsep getStmtsep() {
    return findNotNullChildByClass(YangStmtsep.class);
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
