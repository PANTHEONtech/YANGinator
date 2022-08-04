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

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.*;
import tech.pantheon.yanginator.plugin.psi.*;

public class YangSubmoduleStmtImpl extends YangYangStmtImpl implements YangSubmoduleStmt {

  public YangSubmoduleStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitSubmoduleStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangBodyStmts getBodyStmts() {
    return findChildByClass(YangBodyStmts.class);
  }

  @Override
  @Nullable
  public YangIdentifierArgStr getIdentifierArgStr() {
    return findChildByClass(YangIdentifierArgStr.class);
  }

  @Override
  @Nullable
  public YangLinkageStmts getLinkageStmts() {
    return findChildByClass(YangLinkageStmts.class);
  }

  @Override
  @Nullable
  public YangMetaStmts getMetaStmts() {
    return findChildByClass(YangMetaStmts.class);
  }

  @Override
  @NotNull
  public List<YangOptsep> getOptsepList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangOptsep.class);
  }

  @Override
  @NotNull
  public List<YangRevisionStmt> getRevisionStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangRevisionStmt.class);
  }

  @Override
  @Nullable
  public YangSep getSep() {
    return findChildByClass(YangSep.class);
  }

  @Override
  @Nullable
  public YangStmtsep getStmtsep() {
    return findChildByClass(YangStmtsep.class);
  }

  @Override
  @Nullable
  public YangSubmoduleHeaderStmts getSubmoduleHeaderStmts() {
    return findChildByClass(YangSubmoduleHeaderStmts.class);
  }

  @Override
  @NotNull
  public YangSubmoduleKeyword getSubmoduleKeyword() {
    return findNotNullChildByClass(YangSubmoduleKeyword.class);
  }

  @Override
  @Nullable
  public PsiElement getLeftBrace() {
    return findChildByType(YANG_LEFT_BRACE);
  }

  @Override
  @Nullable
  public PsiElement getRightBrace() {
    return findChildByType(YANG_RIGHT_BRACE);
  }

}
