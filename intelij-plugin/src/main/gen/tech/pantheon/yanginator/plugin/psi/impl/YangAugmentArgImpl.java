// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangAbsoluteSchemaNodeid;
import tech.pantheon.yanginator.plugin.psi.YangAugmentArg;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangAugmentArgImpl extends YangNamedElementImpl implements YangAugmentArg {

  public YangAugmentArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitAugmentArg(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangAbsoluteSchemaNodeid getAbsoluteSchemaNodeid() {
    return findNotNullChildByClass(YangAbsoluteSchemaNodeid.class);
  }

}
