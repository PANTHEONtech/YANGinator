// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangDescendantSchemaNodeid;
import tech.pantheon.yanginator.plugin.psi.YangRefineArg;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangRefineArgImpl extends YangNamedElementImpl implements YangRefineArg {

  public YangRefineArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitRefineArg(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangDescendantSchemaNodeid getDescendantSchemaNodeid() {
    return findNotNullChildByClass(YangDescendantSchemaNodeid.class);
  }

}
