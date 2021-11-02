// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangFractionDigitsArg;
import tech.pantheon.yanginator.plugin.psi.YangFractionDigitsArgStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangFractionDigitsArgStrImpl extends YangNamedElementImpl implements YangFractionDigitsArgStr {

  public YangFractionDigitsArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitFractionDigitsArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangFractionDigitsArg getFractionDigitsArg() {
    return findNotNullChildByClass(YangFractionDigitsArg.class);
  }

}
