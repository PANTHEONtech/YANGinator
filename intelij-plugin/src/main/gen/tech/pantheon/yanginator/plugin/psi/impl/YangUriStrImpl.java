// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangUri;
import tech.pantheon.yanginator.plugin.psi.YangUriStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangUriStrImpl extends YangNamedElementImpl implements YangUriStr {

  public YangUriStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitUriStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangUri getUri() {
    return findNotNullChildByClass(YangUri.class);
  }

}
