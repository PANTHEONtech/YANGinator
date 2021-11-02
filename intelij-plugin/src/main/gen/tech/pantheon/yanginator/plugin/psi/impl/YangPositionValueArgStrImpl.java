// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangPositionValueArg;
import tech.pantheon.yanginator.plugin.psi.YangPositionValueArgStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangPositionValueArgStrImpl extends YangNamedElementImpl implements YangPositionValueArgStr {

  public YangPositionValueArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPositionValueArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangPositionValueArg getPositionValueArg() {
    return findNotNullChildByClass(YangPositionValueArg.class);
  }

}
