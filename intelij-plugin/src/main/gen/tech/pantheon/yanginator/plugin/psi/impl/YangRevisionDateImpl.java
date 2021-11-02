// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangDateArgStr;
import tech.pantheon.yanginator.plugin.psi.YangRevisionDate;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangRevisionDateImpl extends YangNamedElementImpl implements YangRevisionDate {

  public YangRevisionDateImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitRevisionDate(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangDateArgStr getDateArgStr() {
    return findNotNullChildByClass(YangDateArgStr.class);
  }

}
