// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangComment;
import tech.pantheon.yanginator.plugin.psi.YangLineComment;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_BLOCK_COMMENT;

public class YangCommentImpl extends YangNamedElementImpl implements YangComment {

  public YangCommentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitComment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangLineComment getLineComment() {
    return findChildByClass(YangLineComment.class);
  }

  @Override
  @Nullable
  public PsiElement getBlockComment() {
    return findChildByType(YANG_BLOCK_COMMENT);
  }

}
