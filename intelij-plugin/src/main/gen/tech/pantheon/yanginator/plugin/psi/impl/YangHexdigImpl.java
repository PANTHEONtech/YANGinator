// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangDigit;
import tech.pantheon.yanginator.plugin.psi.YangHexdig;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangHexdigImpl extends YangNamedElementImpl implements YangHexdig {

  public YangHexdigImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitHexdig(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangDigit getDigit() {
    return findChildByClass(YangDigit.class);
  }

}
