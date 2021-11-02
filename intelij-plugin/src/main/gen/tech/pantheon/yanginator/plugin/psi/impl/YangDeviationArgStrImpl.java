// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangDeviationArg;
import tech.pantheon.yanginator.plugin.psi.YangDeviationArgStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangDeviationArgStrImpl extends YangNamedElementImpl implements YangDeviationArgStr {

  public YangDeviationArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitDeviationArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangDeviationArg getDeviationArg() {
    return findNotNullChildByClass(YangDeviationArg.class);
  }

}
