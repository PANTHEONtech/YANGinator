// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_BLOCK_COMMENT_END;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_H_A;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_H_BLOCK_COMMENT;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_H_DATE_ARG;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_H_EXTENSION_IDENTIFIER;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_H_FS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_H_IDENTIFIER;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_H_NOT_STRING;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_H_SINGLE_LINE_COMMENT;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_H_STRING;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_H_WHITE_SPACE;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangHighlighterTokens;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangHighlighterTokensImpl extends YangNamedElementImpl implements YangHighlighterTokens {

  public YangHighlighterTokensImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitHighlighterTokens(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getBlockCommentEnd() {
    return findChildByType(YANG_BLOCK_COMMENT_END);
  }

  @Override
  @Nullable
  public PsiElement getHA() {
    return findChildByType(YANG_H_A);
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
  public PsiElement getHFs() {
    return findChildByType(YANG_H_FS);
  }

  @Override
  @Nullable
  public PsiElement getHIdentifier() {
    return findChildByType(YANG_H_IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getHNotString() {
    return findChildByType(YANG_H_NOT_STRING);
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

  @Override
  @Nullable
  public PsiElement getHWhiteSpace() {
    return findChildByType(YANG_H_WHITE_SPACE);
  }

}
