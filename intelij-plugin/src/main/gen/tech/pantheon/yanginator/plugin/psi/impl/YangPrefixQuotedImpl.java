// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierQuoted;
import tech.pantheon.yanginator.plugin.psi.YangPrefixQuoted;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangPrefixQuotedImpl extends YangNamedElementImpl implements YangPrefixQuoted {

  public YangPrefixQuotedImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPrefixQuoted(this);
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
