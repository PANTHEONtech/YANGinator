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
import tech.pantheon.yanginator.plugin.reference.YangGeneratedReferenceTypeImpl;
import tech.pantheon.yanginator.plugin.psi.*;

public class YangTypeStmtImpl extends YangGeneratedReferenceTypeImpl implements YangTypeStmt {

  public YangTypeStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitTypeStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangIdentifierRefArgStr getIdentifierRefArgStr() {
    return findChildByClass(YangIdentifierRefArgStr.class);
  }

  @Override
  @Nullable
  public YangOptsep getOptsep() {
    return findChildByClass(YangOptsep.class);
  }

  @Override
  @Nullable
  public YangSep getSep() {
    return findChildByClass(YangSep.class);
  }

  @Override
  @NotNull
  public List<YangStmtsep> getStmtsepList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStmtsep.class);
  }

  @Override
  @Nullable
  public YangTypeBodyStmts getTypeBodyStmts() {
    return findChildByClass(YangTypeBodyStmts.class);
  }

  @Override
  @NotNull
  public YangTypeKeyword getTypeKeyword() {
    return findNotNullChildByClass(YangTypeKeyword.class);
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

  @Override
  @Nullable
  public PsiElement getSemicolon() {
    return findChildByType(YANG_SEMICOLON);
  }

}
