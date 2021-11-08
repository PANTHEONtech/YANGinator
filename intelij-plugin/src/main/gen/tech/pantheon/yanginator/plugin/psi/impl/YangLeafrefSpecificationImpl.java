// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangLeafrefSpecification;
import tech.pantheon.yanginator.plugin.psi.YangLeafrefSpecificationBody;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangLeafrefSpecificationImpl extends YangNamedElementImpl implements YangLeafrefSpecification {

  public YangLeafrefSpecificationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitLeafrefSpecification(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangLeafrefSpecificationBody> getLeafrefSpecificationBodyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangLeafrefSpecificationBody.class);
  }

}
