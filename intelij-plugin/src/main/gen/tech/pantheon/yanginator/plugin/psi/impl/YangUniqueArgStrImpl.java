// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangUniqueArg;
import tech.pantheon.yanginator.plugin.psi.YangUniqueArgStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangUniqueArgStrImpl extends YangNamedElementImpl implements YangUniqueArgStr {

  public YangUniqueArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitUniqueArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangUniqueArg getUniqueArg() {
    return findNotNullChildByClass(YangUniqueArg.class);
  }

}
