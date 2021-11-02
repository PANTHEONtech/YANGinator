// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangAbsolutePath;
import tech.pantheon.yanginator.plugin.psi.YangDescendantPath;
import tech.pantheon.yanginator.plugin.psi.YangNodeIdentifier;
import tech.pantheon.yanginator.plugin.psi.YangPathPredicate;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangDescendantPathImpl extends YangNamedElementImpl implements YangDescendantPath {

  public YangDescendantPathImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitDescendantPath(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangAbsolutePath getAbsolutePath() {
    return findChildByClass(YangAbsolutePath.class);
  }

  @Override
  @NotNull
  public YangNodeIdentifier getNodeIdentifier() {
    return findNotNullChildByClass(YangNodeIdentifier.class);
  }

  @Override
  @NotNull
  public List<YangPathPredicate> getPathPredicateList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangPathPredicate.class);
  }

}
