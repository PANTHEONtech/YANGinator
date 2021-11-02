// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangStatusArg;
import tech.pantheon.yanginator.plugin.psi.YangStatusArgStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangStatusArgStrImpl extends YangNamedElementImpl implements YangStatusArgStr {

  public YangStatusArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitStatusArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangStatusArg getStatusArg() {
    return findNotNullChildByClass(YangStatusArg.class);
  }

}
