// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangPrefixArgQuoted;
import tech.pantheon.yanginator.plugin.psi.YangPrefixQuoted;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangPrefixArgQuotedImpl extends YangNamedElementImpl implements YangPrefixArgQuoted {

  public YangPrefixArgQuotedImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPrefixArgQuoted(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangPrefixQuoted getPrefixQuoted() {
    return findNotNullChildByClass(YangPrefixQuoted.class);
  }

}
