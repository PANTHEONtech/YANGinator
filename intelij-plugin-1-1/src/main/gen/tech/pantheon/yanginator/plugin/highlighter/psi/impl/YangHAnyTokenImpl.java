/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.highlighter.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.highlighter.psi.YangHAnyToken;
import tech.pantheon.yanginator.plugin.highlighter.psi.YangHIdentifierLiteral;
import tech.pantheon.yanginator.plugin.highlighter.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.impl.YangNamedElementImpl;

import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_BLOCK_COMMENT;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_DATE_ARG;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_EXTENSION_IDENTIFIER;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_IDENTIFIER;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_SEMICOLON;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_SINGLE_LINE_COMMENT;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_STRING;

public class YangHAnyTokenImpl extends YangNamedElementImpl implements YangHAnyToken {

  public YangHAnyTokenImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitHAnyToken(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangHIdentifierLiteral getHIdentifierLiteral() {
    return findChildByClass(YangHIdentifierLiteral.class);
  }

  @Override
  @Nullable
  public PsiElement getHBlockComment() {
    return findChildByType(YANG_H_BLOCK_COMMENT);
  }

  @Override
  @Nullable
  public PsiElement getHDateArg() {
    return findChildByType(YANG_H_DATE_ARG);
  }

  @Override
  @Nullable
  public PsiElement getHExtensionIdentifier() {
    return findChildByType(YANG_H_EXTENSION_IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getHIdentifier() {
    return findChildByType(YANG_H_IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getHSemicolon() {
    return findChildByType(YANG_H_SEMICOLON);
  }

  @Override
  @Nullable
  public PsiElement getHSingleLineComment() {
    return findChildByType(YANG_H_SINGLE_LINE_COMMENT);
  }

  @Override
  @Nullable
  public PsiElement getHString() {
    return findChildByType(YANG_H_STRING);
  }

}
