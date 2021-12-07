// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangStringRestrictions;
import tech.pantheon.yanginator.plugin.psi.YangStringRestrictionsBody;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangStringRestrictionsImpl extends YangNamedElementImpl implements YangStringRestrictions {

  public YangStringRestrictionsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitStringRestrictions(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangStringRestrictionsBody> getStringRestrictionsBodyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStringRestrictionsBody.class);
  }

}
