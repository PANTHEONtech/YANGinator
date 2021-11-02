// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangIdentifier;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierArg;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangIdentifierArgImpl extends YangNamedElementImpl implements YangIdentifierArg {

  public YangIdentifierArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitIdentifierArg(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangIdentifier getIdentifier() {
    return findNotNullChildByClass(YangIdentifier.class);
  }

}
