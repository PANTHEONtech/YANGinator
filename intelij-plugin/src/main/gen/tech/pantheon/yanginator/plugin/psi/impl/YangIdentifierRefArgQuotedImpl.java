// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierRefArg;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierRefArgQuoted;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangIdentifierRefArgQuotedImpl extends YangNamedElementImpl implements YangIdentifierRefArgQuoted {

  public YangIdentifierRefArgQuotedImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitIdentifierRefArgQuoted(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangIdentifierRefArg getIdentifierRefArg() {
    return findNotNullChildByClass(YangIdentifierRefArg.class);
  }

}
