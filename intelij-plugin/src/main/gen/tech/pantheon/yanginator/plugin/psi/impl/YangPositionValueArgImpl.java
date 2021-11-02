// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangNonNegativeIntegerValue;
import tech.pantheon.yanginator.plugin.psi.YangPositionValueArg;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangPositionValueArgImpl extends YangNamedElementImpl implements YangPositionValueArg {

  public YangPositionValueArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPositionValueArg(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangNonNegativeIntegerValue getNonNegativeIntegerValue() {
    return findNotNullChildByClass(YangNonNegativeIntegerValue.class);
  }

}
