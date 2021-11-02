// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_MAX_KEYWORD;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_MIN_KEYWORD;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangDecimalValue;
import tech.pantheon.yanginator.plugin.psi.YangIntegerValue;
import tech.pantheon.yanginator.plugin.psi.YangRangeBoundary;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangRangeBoundaryImpl extends YangNamedElementImpl implements YangRangeBoundary {

  public YangRangeBoundaryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitRangeBoundary(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangDecimalValue getDecimalValue() {
    return findChildByClass(YangDecimalValue.class);
  }

  @Override
  @Nullable
  public YangIntegerValue getIntegerValue() {
    return findChildByClass(YangIntegerValue.class);
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
