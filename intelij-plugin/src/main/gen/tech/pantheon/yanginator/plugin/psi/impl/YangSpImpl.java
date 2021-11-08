// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangSp;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SPACE;

public class YangSpImpl extends YangNamedElementImpl implements YangSp {

  public YangSpImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitSp(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getSpace() {
    return findNotNullChildByType(YANG_SPACE);
  }

}
