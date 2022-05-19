/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface YangModuleStmt extends YangYangStmt {

  @NotNull
  YangBodyStmts getBodyStmts();

  @NotNull
  YangIdentifierArgStr getIdentifierArgStr();

  @NotNull
  YangLinkageStmts getLinkageStmts();

  @NotNull
  YangMetaStmts getMetaStmts();

  @NotNull
  YangModuleHeaderStmts getModuleHeaderStmts();

  @NotNull
  YangModuleKeyword getModuleKeyword();

  @NotNull
  List<YangOptsep> getOptsepList();

  @NotNull
  YangRevisionStmts getRevisionStmts();

  @NotNull
  YangSep getSep();

  @NotNull
  YangStmtsep getStmtsep();

  @NotNull
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getRightBrace();

}
