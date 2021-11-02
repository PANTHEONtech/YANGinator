// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangAbsoluteSchemaNodeidQuoted;
import tech.pantheon.yanginator.plugin.psi.YangAugmentArgQuoted;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangAugmentArgQuotedImpl extends YangNamedElementImpl implements YangAugmentArgQuoted {

  public YangAugmentArgQuotedImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitAugmentArgQuoted(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangAbsoluteSchemaNodeidQuoted getAbsoluteSchemaNodeidQuoted() {
    return findNotNullChildByClass(YangAbsoluteSchemaNodeidQuoted.class);
  }

}
