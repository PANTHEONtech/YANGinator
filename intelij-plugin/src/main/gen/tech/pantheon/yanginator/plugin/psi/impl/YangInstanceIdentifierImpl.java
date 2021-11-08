// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangInstanceIdentifier;
import tech.pantheon.yanginator.plugin.psi.YangNodeIdentifier;
import tech.pantheon.yanginator.plugin.psi.YangPredicate;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangInstanceIdentifierImpl extends YangNamedElementImpl implements YangInstanceIdentifier {

  public YangInstanceIdentifierImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitInstanceIdentifier(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangNodeIdentifier> getNodeIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangNodeIdentifier.class);
  }

  @Override
  @NotNull
  public List<YangPredicate> getPredicateList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangPredicate.class);
  }

}
