// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangMinValueArg;
import tech.pantheon.yanginator.plugin.psi.YangMinValueArgStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangMinValueArgStrImpl extends YangNamedElementImpl implements YangMinValueArgStr {

  public YangMinValueArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitMinValueArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangMinValueArg getMinValueArg() {
    return findNotNullChildByClass(YangMinValueArg.class);
  }

}
