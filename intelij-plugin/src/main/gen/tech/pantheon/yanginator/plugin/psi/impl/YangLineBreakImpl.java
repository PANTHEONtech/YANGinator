// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangCrlf;
import tech.pantheon.yanginator.plugin.psi.YangLf;
import tech.pantheon.yanginator.plugin.psi.YangLineBreak;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangLineBreakImpl extends YangNamedElementImpl implements YangLineBreak {

  public YangLineBreakImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitLineBreak(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangCrlf getCrlf() {
    return findChildByClass(YangCrlf.class);
  }

  @Override
  @Nullable
  public YangLf getLf() {
    return findChildByClass(YangLf.class);
  }

}
