// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangLengthBoundary;
import tech.pantheon.yanginator.plugin.psi.YangNonNegativeIntegerValue;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_MAX_KEYWORD;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_MIN_KEYWORD;

public class YangLengthBoundaryImpl extends YangNamedElementImpl implements YangLengthBoundary {

  public YangLengthBoundaryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitLengthBoundary(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangNonNegativeIntegerValue getNonNegativeIntegerValue() {
    return findChildByClass(YangNonNegativeIntegerValue.class);
  }

  @Override
  @Nullable
  public PsiElement getMaxKeyword() {
    return findChildByType(YANG_MAX_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getMinKeyword() {
    return findChildByType(YANG_MIN_KEYWORD);
  }

}
