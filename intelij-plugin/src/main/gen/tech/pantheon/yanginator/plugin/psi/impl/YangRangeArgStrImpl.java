// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangRangeArg;
import tech.pantheon.yanginator.plugin.psi.YangRangeArgStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangRangeArgStrImpl extends YangNamedElementImpl implements YangRangeArgStr {

  public YangRangeArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitRangeArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangRangeArg getRangeArg() {
    return findNotNullChildByClass(YangRangeArg.class);
  }

}
