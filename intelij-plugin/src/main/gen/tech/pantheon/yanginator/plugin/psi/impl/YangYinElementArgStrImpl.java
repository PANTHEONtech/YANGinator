// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangYinElementArg;
import tech.pantheon.yanginator.plugin.psi.YangYinElementArgStr;

public class YangYinElementArgStrImpl extends YangNamedElementImpl implements YangYinElementArgStr {

  public YangYinElementArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitYinElementArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangYinElementArg getYinElementArg() {
    return findNotNullChildByClass(YangYinElementArg.class);
  }

}
