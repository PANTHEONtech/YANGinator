// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangAbsoluteSchemaNodeid;
import tech.pantheon.yanginator.plugin.psi.YangDescendantSchemaNodeid;
import tech.pantheon.yanginator.plugin.psi.YangSchemaNodeid;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangSchemaNodeidImpl extends YangNamedElementImpl implements YangSchemaNodeid {

  public YangSchemaNodeidImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitSchemaNodeid(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangAbsoluteSchemaNodeid getAbsoluteSchemaNodeid() {
    return findChildByClass(YangAbsoluteSchemaNodeid.class);
  }

  @Override
  @Nullable
  public YangDescendantSchemaNodeid getDescendantSchemaNodeid() {
    return findChildByClass(YangDescendantSchemaNodeid.class);
  }

}
