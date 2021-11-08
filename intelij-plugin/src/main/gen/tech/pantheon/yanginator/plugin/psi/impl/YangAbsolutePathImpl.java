// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangAbsolutePath;
import tech.pantheon.yanginator.plugin.psi.YangNodeIdentifier;
import tech.pantheon.yanginator.plugin.psi.YangPathPredicate;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangAbsolutePathImpl extends YangNamedElementImpl implements YangAbsolutePath {

  public YangAbsolutePathImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitAbsolutePath(this);
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
  public List<YangPathPredicate> getPathPredicateList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangPathPredicate.class);
  }

}
