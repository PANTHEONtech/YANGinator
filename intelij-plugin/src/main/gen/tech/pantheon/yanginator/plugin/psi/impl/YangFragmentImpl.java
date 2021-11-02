// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangFragment;
import tech.pantheon.yanginator.plugin.psi.YangQuery;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangFragmentImpl extends YangNamedElementImpl implements YangFragment {

  public YangFragmentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitFragment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangQuery getQuery() {
    return findNotNullChildByClass(YangQuery.class);
  }

}
