// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangMaxValueArg;
import tech.pantheon.yanginator.plugin.psi.YangMaxValueArgStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangMaxValueArgStrImpl extends YangNamedElementImpl implements YangMaxValueArgStr {

  public YangMaxValueArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitMaxValueArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangMaxValueArg getMaxValueArg() {
    return findNotNullChildByClass(YangMaxValueArg.class);
  }

}
