// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangIdentifier;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierQuoted;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangIdentifierImpl extends YangNamedElementImpl implements YangIdentifier {

  public YangIdentifierImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitIdentifier(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangIdentifierQuoted getIdentifierQuoted() {
    return findNotNullChildByClass(YangIdentifierQuoted.class);
  }

}
