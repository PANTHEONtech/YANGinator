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

public class YangModifierStmtImpl extends YangYangStmtImpl implements YangModifierStmt {

  public YangModifierStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitModifierStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangModifierArgStr getModifierArgStr() {
    return findChildByClass(YangModifierArgStr.class);
  }

  @Override
  @NotNull
  public YangModifierKeyword getModifierKeyword() {
    return findNotNullChildByClass(YangModifierKeyword.class);
  }

  @Override
  @Nullable
  public YangSep getSep() {
    return findChildByClass(YangSep.class);
  }

  @Override
  @Nullable
  public YangStmtend getStmtend() {
    return findChildByClass(YangStmtend.class);
  }

}
