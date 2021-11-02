// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangCr;
import tech.pantheon.yanginator.plugin.psi.YangCrlf;
import tech.pantheon.yanginator.plugin.psi.YangLf;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangCrlfImpl extends YangNamedElementImpl implements YangCrlf {

  public YangCrlfImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitCrlf(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangCr getCr() {
    return findNotNullChildByClass(YangCr.class);
  }

  @Override
  @NotNull
  public YangLf getLf() {
    return findNotNullChildByClass(YangLf.class);
  }

}
