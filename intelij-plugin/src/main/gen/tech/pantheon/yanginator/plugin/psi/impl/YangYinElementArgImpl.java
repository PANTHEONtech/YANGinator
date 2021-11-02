// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_FALSE_KEYWORD;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_TRUE_KEYWORD;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangYinElementArg;

public class YangYinElementArgImpl extends YangNamedElementImpl implements YangYinElementArg {

  public YangYinElementArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitYinElementArg(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getFalseKeyword() {
    return findChildByType(YANG_FALSE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getTrueKeyword() {
    return findChildByType(YANG_TRUE_KEYWORD);
  }

}
