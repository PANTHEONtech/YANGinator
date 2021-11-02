// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangIntegerValueStr;
import tech.pantheon.yanginator.plugin.psi.YangNonNegativeIntegerValue;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangIntegerValueStrImpl extends YangNamedElementImpl implements YangIntegerValueStr {

  public YangIntegerValueStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitIntegerValueStr(this);
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